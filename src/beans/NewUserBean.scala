package beans

import scala.beans.BeanProperty
import javax.validation.constraints.NotNull
import entities.Tables._
import entities.Tables.profile.simple._
import scala.util.Random
import org.primefaces.util.Base64
import util.EncryptionHelper
import javax.faces.bean.ManagedBean
import javax.faces.bean.RequestScoped
import javax.faces.context.FacesContext
import javax.faces.application.FacesMessage

@RequestScoped
@ManagedBean
class NewUserBean {
  @BeanProperty
  @NotNull(message = "Veillez saisir votre identifiant")
  var username: String = ""

  @NotNull(message = "Veillez saisir votre mot de passe")
  @BeanProperty var password: String = ""

  def creatUser = {
    val url = "jdbc:mysql://localhost:3306/school?user=root&password=toor"
    val db = Database.forURL(url, driver = "com.mysql.jdbc.Driver")
    val bSalt = new Array[Byte](5);
    Random.nextBytes(bSalt);
    val salt = Base64.encodeToString(bSalt, false);

    db.withTransaction { implicit session =>
      try {
        User += UserRow(0, username, EncryptionHelper.hashPassword(password, salt), salt)
      } catch {
        case e => FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ajout echoué", e.getMessage()))
      }
    }

  }

}