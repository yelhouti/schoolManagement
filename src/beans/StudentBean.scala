package beans

import entities.Tables._
import entities.Tables.profile.simple._
import javax.faces.bean.RequestScoped
import javax.faces.bean.ManagedBean
import entities.Tables
import scala.collection.immutable.List
import scala.collection.JavaConversions

@RequestScoped
@ManagedBean
class StudentBean {
  val url = "jdbc:mysql://localhost:3306/school?user=root&password=toor"
  val db = Database.forURL(url, driver = "com.mysql.jdbc.Driver")

  // Using generated code. Our Build.sbt makes sure they are generated before compilation.
  def getAllStudents(): List[StudentRow] = {
    db.withTransaction { implicit session =>
      return Student.list
    }
  }
  
    def getAllClasses(): List[ClasseRow] = {
    db.withTransaction { implicit session =>
      //println(Classe.list())
      return Classe.list
    }
  }
  
  def myList():List[Integer]={List(1,2,3)}
}