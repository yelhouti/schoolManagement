package init

import entities.Tables._
import entities.Tables.profile.simple._
import scala.slick.lifted.TableQuery
import java.util.Date

object InitDB {
  val url = "jdbc:mysql://localhost:3306/school?user=root&password=toor"
  val db = Database.forURL(url, driver = "com.mysql.jdbc.Driver")

  // Using generated code. Our Build.sbt makes sure they are generated before compilation.
  def main(args: Array[String]) {
    //test
    initDB
  }

  def initDB {
    db.withTransaction { implicit session =>
      Levelfees.delete
      //FeeTypes
      Feetype.delete
      Feetype += FeetypeRow(0, "Inscription", false)
      List("Septembre", "Octobre", "Novembre", "Decembre", "Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin").foreach { case x => Feetype += FeetypeRow(0, x, true) }

      Classe.delete
      Level.delete
      Cycle.delete

      //cycles
      val primaireId = Cycle.returning(Cycle.map(_.id)) += CycleRow(0, "Primaire")
      val collegeId = Cycle.returning(Cycle.map(_.id)) += CycleRow(0, "College")
      val lyceeID = Cycle.returning(Cycle.map(_.id)) += CycleRow(0, "Lycee")
      val cycleDesinscritId = Cycle.returning(Cycle.map(_.id)) += CycleRow(0, "Desinscrit")
      //for (c <- 'A' until 'C')

      //levels
      ((for (i <- (1 to 6)) yield ("CE" + i, primaireId)) ++: List(("1AC", collegeId), ("2AC", collegeId), ("3AC", collegeId), ("TC", lyceeID), ("1BAC", lyceeID), ("2BAC", lyceeID), ("Desinscrit", cycleDesinscritId))).foreach { case (lvl, cycl) => Level += LevelRow(0, lvl, cycl) }

      //classes
      val primaireClassesList = Level.filter(_.cycleId === primaireId).list.flatMap(l => List((l.name + "A", l.id), (l.name + "B", l.id), (l.name + "C", l.id)))
      val collegeClassesList = Level.filter(_.cycleId === collegeId).list.flatMap(l => List((l.name + "1", l.id), (l.name + "2", l.id)))

      val TCId = Level.filter(_.name === "TC").first.id
      val BAC1Id = Level.filter(_.name === "1BAC").first.id
      val BAC2Id = Level.filter(_.name === "2BAC").first.id
      val lvlDesinscitId = Level.filter(_.name === "Desinscrit").first.id
      (primaireClassesList ++: collegeClassesList ++: List(("TC1", TCId), ("TC2", TCId), ("1BAC SX", BAC1Id), ("1BAC SM", BAC1Id), ("2BAC SX", BAC2Id), ("2BAC SM", BAC2Id), ("Desinscrit", lvlDesinscitId))).foreach { case (cName, lId) => Classe += ClasseRow(0, cName, lId) }
      
      val actualYear = new Date(System.currentTimeMillis()).getYear()+1900
      //cuurentYear
      Scholaryear.delete
      val scholarYearId= Scholaryear.returning(Scholaryear.map(_.id)) += ScholaryearRow(0, actualYear)
      
      Level.list.foreach(l => {
        if (l.cycleId == primaireId) { //primaire
          Levelfees += LevelfeesRow(scholarYearId, l.id, 1200, 300, 800, 300)
        } else if (l.cycleId == collegeId) { //college
          Levelfees += LevelfeesRow(scholarYearId, l.id, 1200, 300, 800, 300)
        } else if (l.id == TCId) { //TC
          Levelfees += LevelfeesRow(scholarYearId, l.id, 1200, 300, 800, 300)
        } else if (l.id == BAC1Id) { //1BAC
          Levelfees += LevelfeesRow(scholarYearId, l.id, 1200, 300, 800, 300)
        } else if (l.id == BAC2Id) { //2BAC
          Levelfees += LevelfeesRow(scholarYearId, l.id, 1200, 300, 800, 300)
        }else if (l.id == lvlDesinscitId) { //Desinscrit
          Levelfees += LevelfeesRow(scholarYearId, l.id, 0, 0, 0, 0)
        }else {
          throw new NoSuchElementException()
        }
      })
      
    }
  }
}

//println(for(month <- List("Septembre", "Octobre", "Novembre", "Decembre", "Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin")) yield Feetype.returning(Feetype.map(_.id)) += FeetypeRow(0, month, true))