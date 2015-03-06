package beans

import javax.faces.bean.ManagedBean
import javax.faces.bean.RequestScoped
import scala.beans.BeanProperty
import javax.validation.constraints.NotNull
import entities.Tables._
import entities.Tables.profile.simple._
import javax.faces.application.FacesMessage
import javax.faces.context.FacesContext
import util.EncryptionHelper
import util.EncryptionHelper
import javax.faces.bean.ManagedProperty
import javax.annotation.PostConstruct
import org.primefaces.event.CellEditEvent

@RequestScoped
@ManagedBean
class PayementsBean {

  //@ManagedProperty(value="#{SessionBean}")
  val sessionBean = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sessionBean").asInstanceOf[SessionBean]

  val url = "jdbc:mysql://localhost:3306/school?user=root&password=toor"
  val db = Database.forURL(url, driver = "com.mysql.jdbc.Driver")

  var scholarYearId: Int = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("scholarYearId").asInstanceOf[Int]

  val feeTypes: List[FeetypeRow] = db.withTransaction { implicit session => Feetype.list }
  
  var payements:List[PayedfeeRow]=List()
  var feeAmountRowList: List[TableRow] = List(new TableRow())
  
  @PostConstruct
  def updateStudentAndYear = {
    db.withTransaction { implicit session =>
      try {
          payements= Payedfee.filter(_.scholaryearId === scholarYearId).list
          //feeAmountRowList = payements.groupBy(p=>(p.studentId,p.feetypeId)).toList.map(x=>(x._1._1,x._1._2,x._2.map(_.amount).reduce(_+_)))     //groupBy(._feeTypeId).list.map(new TableRow(studentId, student.firstname, student.lastname, classeName , payementsToFeeTypeAmountList(payements) ))
      } catch {
        case t: NoSuchElementException =>//TODO add message no such student t.printStackTrace() 
      }

    }
  }

  def payementsToFeeTypeAmountList(payementsList: List[PayedfeeRow]): List[Int] = payementsList.groupBy(_.feetypeId).toList.map(x => (x._2.map(_.amount).reduce(_ + _)))

  def addPayement(event: CellEditEvent) = {
    println(event.getSource())
    //    db.withTransaction { implicit session =>
    //        event.getSource()
    //        
    //    }
  }

  class TableRow(id: Int, firstName: String, lastName: String, classeName: String , fees: List[Int] ) {
    def this() { this(0, "", "", "" ,List[Int]() ) }
  }
}