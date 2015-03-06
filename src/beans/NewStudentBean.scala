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
import java.sql.Date
import org.joda.time.DateTime
import enums.ServiceTG

@RequestScoped
@ManagedBean
class NewStudentBean {

  @BeanProperty
  @NotNull(message = "Veillez saisir le numero de l'étudiant")
  var studentId: Integer = null

  @BeanProperty
  @NotNull(message = "Veillez saisir le nom")
  var nom: String = null

  @NotNull(message = "Veillez saisir le prenom")
  @BeanProperty var prenom: String = null

  @BeanProperty
  @NotNull(message = "Veillez choisir le classe")
  var classeId: Integer = null

  @NotNull(message = "Veillez selectionner les services de transport et gardes")
  @BeanProperty var serviceTG: Integer = null

  @NotNull(message = "Veillez choisir l'année scolaire")
  @BeanProperty var scholarYearId: Integer = currentScholarYearId

  //@ManagedProperty(value="#{SessionBean}")
  val sessionBean = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sessionBean").asInstanceOf[SessionBean]

  val url = "jdbc:mysql://localhost:3306/school?user=root&password=toor"
  val db = Database.forURL(url, driver = "com.mysql.jdbc.Driver")

  def register() {
	  println(studentId, nom, prenom, classeId, serviceTG, scholarYearId)
    try {
      db.withTransaction { implicit session =>
        Student += StudentRow(studentId, nom, prenom)
        Feedetails += FeedetailsRow(studentId, 1, scholarYearId, serviceTG, Option(null), 0, 0) //1=start From Inscription
        StudentClasse += StudentClasseRow(studentId, classeId, scholarYearId)
      }
    } catch {
      case t: Exception => {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur pendant l'ajout de l'élève ", t.getMessage()))
        t.printStackTrace()

      }
    }
  }

  val scholarYearsList = {
    db.withTransaction { implicit session => Scholaryear.list }
  }

  val classeList = {
    db.withTransaction { implicit session => Classe.list }
  }

  val serviceTGList = ServiceTG.values

  val currentScholarYearId: Integer = {
    db.withTransaction { implicit session =>
      try {
        val startYear = if (DateTime.now().getMonthOfYear() < 8) DateTime.now().getYear() - 1 else DateTime.now().getYear()
        Scholaryear.filter(_.startyear === startYear).first.id
      } catch {
        case t => null
      }
    }
  }
}