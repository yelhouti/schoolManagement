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

@RequestScoped
@ManagedBean
class LoginBean{

  @BeanProperty
  @NotNull(message = "Veillez saisir votre identifiant")
  var username: String = ""

  @NotNull(message = "Veillez saisir votre mot de passe")
  @BeanProperty var password: String = ""

  //@ManagedProperty(value="#{SessionBean}")
  val sessionBean=FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("sessionBean").asInstanceOf[SessionBean]

  val url = "jdbc:mysql://localhost:3306/school?user=root&password=toor"
  val db = Database.forURL(url, driver = "com.mysql.jdbc.Driver")

  def login() {
    db.withTransaction { implicit session =>
      try {
        val user = User.filter(_.username === username).first
        if (EncryptionHelper.hashPassword(password, user.salt).equals(user.password)) {
          sessionBean.userId = user.id
          FacesContext
            .getCurrentInstance()
            .getExternalContext()
            .redirect(
              FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
                + "/admin/testLogin.xhtml")
        } else {
          throw new NoSuchElementException
        }
      } catch {
        case e: NoSuchElementException => {
          val msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "identifiant ou mot de passe incorrect");
          FacesContext.getCurrentInstance().addMessage(null, msg);
        }
      }

    }
  }
}