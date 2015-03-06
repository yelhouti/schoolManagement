package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Test {
	public void test1() {
		System.out.println("toto");
	}
	
	public String getToto(){
		return "toto";
	}
}


//val url = "jdbc:mysql://localhost:3306/school?user=root&password=toor"
//val db = Database.forURL(url, driver = "com.mysql.jdbc.Driver")
//
//
//def login(){
//  db.withTransaction { implicit session =>
//  	    println(Student.list)
//  }
//  userId=1
//}
