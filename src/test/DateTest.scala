package test

import java.sql.Date
import org.joda.time.DateTime

import entities.Tables._
import entities.Tables.profile.simple._

object DateTest {
  def main(args: Array[String]) {
    val now = new Date(DateTime.now().getMillis())
    println(now)
    val startDate = new Date(new DateTime(now.getYear() + 1900, 9, 1, 0, 0, 0).getMillis())
    println(startDate)

    val url = "jdbc:mysql://localhost:3306/school?user=root&password=toor"
    val db = Database.forURL(url, driver = "com.mysql.jdbc.Driver")
    db.withTransaction { implicit session =>
    	println(Scholaryear.list().take(1))
    }
  }
}