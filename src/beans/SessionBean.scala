package beans

import entities.Tables._
import entities.Tables.profile.simple._
import javax.faces.bean.SessionScoped
import javax.faces.bean.ManagedBean
import scala.beans.BeanProperty

@SessionScoped
@ManagedBean
class SessionBean{
  @BeanProperty var userId:Integer=null
}