package init

import entities.OldTables._
import entities.OldTables.profile.simple._
import scala.slick.lifted.TableQuery
import java.util.Date

object InitOldProject {
  // Using generated code. Our Build.sbt makes sure they are generated before compilation.
  def main(args: Array[String]) {
    //test
    initDB
  }
  val url = "jdbc:mysql://localhost:3306/school_db?user=root"
  val db = Database.forURL(url, driver = "com.mysql.jdbc.Driver")

  def initDB {
    db.withTransaction { implicit session =>
        //FeeTypes
//      SchoolClasses+=SchoolClassesRow(0,"3AC3",0,0,0,0,0)
//      val classesList=List(("CE1A","CE2A"),("CE1B","CE2B"),("CE1C","CE2C"),("CE2A","CE3A"),("CE2B","CE3B"),("CE2C","CE3C"),("CE3A","CE4A"),("CE3B","CE4B"),("CE3C","CE4C"),("CE4A","CE5A"),("CE4B","CE5B"),("CE4C","CE5C"),("CE5A","CE6A"),("CE5B","CE6B"),("CE5C","CE6C"),("CE6A","1AC1"),("CE6B","1AC2"),("CE6C","1AC3"),("1AC1","2AC1"),("1AC2","2AC2"),("1AC3","2AC3"),("2AC1","3AC1"),("2AC2","3AC2"),("2AC3","3AC3"),("3AC1","TC1"),("3AC2","TC1"),("TC1","1BAC"),("1BAC","2BAC"),("2BAC","désinscrit"))
//      classesList.reverse.foreach(classeTpl=>SchoolEleves.filter(_.classe===classeTpl._1).map(_.classe).update(classeTpl._2))
//        val q = for { e <- SchoolEleves } yield (e.rabais, e.inscription, e.septembre, e.octobre, e.novembre, e.decembre, e.janvier, e.fevrier, e.mars, e.avril, e.mai, e.juin)
//        q.update(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
//        SchoolClasses.filter(_.nom.startsWith("CE")).map(c=>(c.inscription,c.assurance,c.mensualite,c.transport)).update(800,200,850,350)
//        SchoolClasses.filter(_.nom.like("_AC_", ' ')).map(c=>(c.inscription,c.assurance,c.mensualite,c.transport)).update(1300,200,1300,350)
//        SchoolClasses.filter(_.nom===("TC1")).map(c=>(c.inscription,c.assurance,c.mensualite,c.transport)).update(1800,200,1500,350)//1800 1500
//        SchoolClasses.filter(_.nom===("1BAC")).map(c=>(c.inscription,c.assurance,c.mensualite,c.transport)).update(2000,200,1700,350)//2000 1700
//        SchoolClasses.filter(_.nom===("2BAC")).map(c=>(c.inscription,c.assurance,c.mensualite,c.transport)).update(2000,200,1700,350)
//      //delete desinscrit
//      SchoolEleves.filter(_.classe==="désinscrit").delete
//      
//      SchoolEleves.filter(_.classe==="dÃ©sinscrits").delete
//      SchoolEleves.foreach(e=> {
//        SchoolEleves.filter(_.id===e.id).map(_.mensualite).update({
//          val classe=SchoolClasses.filter(_.nom===e.classe).first
//          if (e.transport) classe.mensualite+classe.transport
//          else classe.mensualite})
//        }
//      )
      //update nbr elve
//      SchoolClasses.foreach(c=>{
//        SchoolClasses.filter(_.id===c.id).map(_.nombreEleves).update(SchoolEleves.filter(_.classe===c.nom).list.size)
//      })
      SchoolSituations.delete
        
        //SchoolEleves.filter(_.classe.startsWith("CE")).map(_.)
    }
  }
}

//println(for(month <- List("Septembre", "Octobre", "Novembre", "Decembre", "Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin")) yield Feetype.returning(Feetype.map(_.id)) += FeetypeRow(0, month, true))