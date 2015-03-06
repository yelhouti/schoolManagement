package util

import javax.el.{ELContext, ELResolver}
import java.beans.FeatureDescriptor
import java.lang.reflect.Method
import collection.JavaConversions._
import collection.mutable.HashSet
import scala.collection.JavaConversions
import scala.collection.immutable.List

/**
 *
 * @author Werner Punz (latest modification by $Author$)
 * @version $Revision$ $Date$
 *
 * A custom el resolver which needs to do following things
 * call the getters and setters of scala according to the scala convention of
 * attr() and attr_$eq(value)
 *
 * transform the incoming or outgoing lists, maps and arrays
 * from the scala maps an arrays to their java representations
 * (if needed, since the el works with introspection alone
 * it might work without the conversion)
 *
 * delegate the rest to the other el resolvers in the chain
 */

class ScalaELResolver extends ELResolver {

  def getCommonPropertyType(elContext: ELContext, o: AnyRef): Class[_] = {
    println("Scala el Resolver: getCommonPropertyType")
    o.getClass
  }

  def getFeatureDescriptors(elContext: ELContext, base: AnyRef): java.util.Iterator[FeatureDescriptor] = {
//	println("Scala el Resolver: getFeatureDescriptors")
//    if (!base.isInstanceOf[scala.ScalaObject]) {
//      //no scala object we forward it to another el
//      //resolver
//      null
//    } else {
//      val ret = new HashSet[FeatureDescriptor]
//      //We have to iterate over all properties of the base and return it
//      //as feature descriptor instance
//      val methods: Array[Method] = base.getClass().getMethods
//      val alreadyProcessed = new HashSet[String]
//      for (method <- methods if (!alreadyProcessed.contains(method.getName.replaceAll("\\_eq\\$", "")))) {
//        //note every attribute of a scala object
//        //is set as protected or private
//        //with two encapsulating functions
//        var methodName: String = method.getName.replaceAll("\\_\\$eq", "")
//        alreadyProcessed += methodName
//        //TODO we probably have to work the return values in
//        ret += makeDescriptor(methodName, methodName, base.getClass)
//      }
//
//      asJavaSet[FeatureDescriptor](ret).iterator
//    }
    if(base.isInstanceOf[List[Any]]){
    	null//getFeatureDescriptors(elContext, JavaConversions.asJavaList(base))
    }else{
      null
    }

  }

  /**
   * backported from myfaces
   */
  private def makeDescriptor(name: String, description: String,
                             objectType: Class[_]): FeatureDescriptor = {
    println("Scala el Resolver: makeDescriptor")
    val fd = new FeatureDescriptor()
    fd.setValue(ELResolver.RESOLVABLE_AT_DESIGN_TIME, true)
    fd.setValue(ELResolver.TYPE, objectType)
    fd.setName(name)
    fd.setDisplayName(name)
    fd.setShortDescription(description)
    fd.setExpert(false)
    fd.setHidden(false)
    fd.setPreferred(true)
    fd
  }

  def getType(elContext: ELContext, base: AnyRef, prop: AnyRef): Class[_] = {
    println("Scala el Resolver: getType")
    if (base == null || !base.isInstanceOf[scala.ScalaObject]) null
    else if (base != null && prop == null) null
    else {
      var methods = ReflectUtil.getAllMethods(base.getClass(), prop.asInstanceOf[String], 0)
      if(methods != null && methods.size > 0) {
        elContext.setPropertyResolved(true)
        methods.iterator.next.getReturnType
      } else {
        //lets delegate the analysis into the subsequent sections of the chain
        null
      }
    }
  }

  override def getValue(elContext: ELContext, base: AnyRef, 
                        prop: AnyRef): AnyRef = {
    println(s"SimpleElResolver: getValue: Entering: $base.$prop")
    println("Scala el Resolver: getValue")
    if (base == null) {
      null
    } else {
      println(prop);
      val method = base.getClass.getDeclaredMethod(prop.toString)
      if (method != null) {
        val res = method.invoke(base)
        if (res.isInstanceOf[Iterable[_]]) {
          val iter = res.asInstanceOf[Iterable[_]]
          println("getValue: Wrapping as Java iterable")
          //elContext.setPropertyResolved(true)
          JavaConversions.asJavaIterable(iter)
        } else {
          null
        }
      } else {
        null
      }
    }
  }

  def isReadOnly(elContext: ELContext, base: AnyRef, prop: AnyRef): Boolean = {
    println("Scala el Resolver: isReadOnly")
    if (!(base != null && base.isInstanceOf[scala.ScalaObject])) {
      true
    } else {
      def methodName: String = prop.asInstanceOf[String]
      def setterName = methodName + "_$eq"
      if (base.getClass.getMethod(setterName) != null) {
        elContext.setPropertyResolved(true)
        false
      } else {
        val m: Method = base.getClass.getMethod(methodName)
        val paramTypes = m.getParameterTypes
        val ret = !(paramTypes != null && paramTypes.length > 0)
        elContext.setPropertyResolved(true)
        ret
      }
    }
  }

  def setValue(elContext: ELContext, base: AnyRef, prop: AnyRef, value: AnyRef) {
    println("Scala el Resolver: setValue")
    if (base != null && base.isInstanceOf[scala.ScalaObject]) {
      def methodName: String = prop.asInstanceOf[String]
      def setterName = methodName + "_$eq"
      val setMethod = ReflectUtil.getAllMethods(base.getClass(), methodName, 1)
      val setterMethod = ReflectUtil.getAllMethods(base.getClass(), setterName, 1)


      if (setMethod != null && setMethod.size > 0) {
        val transformedValue = getValueType(setMethod.iterator.next, value)
        ReflectUtil.executeMethod(base, methodName, transformedValue)
        elContext.setPropertyResolved(true)
      } else if (setterMethod != null && setterMethod.size > 0) {
        val transformedValue = getValueType(setterMethod.iterator.next, value)
        ReflectUtil.executeMethod(base, setterName, transformedValue)
        elContext.setPropertyResolved(true)
      }

    }
  }

  def getValueType(method: Method, theVal: AnyRef): AnyRef = {
    println("Scala el Resolver: get value type")
    if (!theVal.isInstanceOf[String]) {
      theVal
    } else {
      val strVal = theVal.asInstanceOf[String]
      val paramTypes: Array[Class[_]] = method.getParameterTypes()
      val initParam = paramTypes.apply(0)
      if (initParam == classOf[String]) {
        theVal
      } else if (initParam == classOf[Int]) {
        strVal.toInt.asInstanceOf[AnyRef]
      } else if (initParam == classOf[Long]) {
        strVal.toLong.asInstanceOf[AnyRef]
      } else if (initParam == classOf[Float]) {
        strVal.toFloat.asInstanceOf[AnyRef]
      } else if (initParam == classOf[Double]) {
        strVal.toDouble.asInstanceOf[AnyRef]
      } else if (initParam == classOf[Boolean]) {
        strVal.toBoolean.asInstanceOf[AnyRef]
      } else if (initParam == classOf[Byte]) {
        strVal.toByte.asInstanceOf[AnyRef]
      } else if (initParam == classOf[Char]) {
        strVal.toCharArray.apply(0).asInstanceOf[AnyRef]
      } else {
        theVal
      }
    }
  }
}