package entities
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = scala.slick.driver.MySQLDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: scala.slick.driver.JdbcProfile
  import profile.simple._
  import scala.slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import scala.slick.jdbc.{GetResult => GR}
  
  /** DDL for all tables. Call .create to execute. */
  lazy val ddl = Classe.ddl ++ Cycle.ddl ++ Feedetails.ddl ++ Feetype.ddl ++ Level.ddl ++ Levelfees.ddl ++ Payedfee.ddl ++ Phone.ddl ++ Scholaryear.ddl ++ Student.ddl ++ StudentClasse.ddl ++ User.ddl
  
  /** Entity class storing rows of table Classe
   *  @param id Database column id AutoInc, PrimaryKey
   *  @param name Database column name 
   *  @param levelId Database column Level_id  */
  case class ClasseRow(id: Int, name: String, levelId: Int)
  /** GetResult implicit for fetching ClasseRow objects using plain SQL queries */
  implicit def GetResultClasseRow(implicit e0: GR[Int], e1: GR[String]): GR[ClasseRow] = GR{
    prs => import prs._
    ClasseRow.tupled((<<[Int], <<[String], <<[Int]))
  }
  /** Table description of table classe. Objects of this class serve as prototypes for rows in queries. */
  class Classe(tag: Tag) extends Table[ClasseRow](tag, "classe") {
    def * = (id, name, levelId) <> (ClasseRow.tupled, ClasseRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, name.?, levelId.?).shaped.<>({r=>import r._; _1.map(_=> ClasseRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name  */
    val name: Column[String] = column[String]("name")
    /** Database column Level_id  */
    val levelId: Column[Int] = column[Int]("Level_id")
    
    /** Foreign key referencing Level (database name fk_Classe_Level1) */
    lazy val levelFk = foreignKey("fk_Classe_Level1", levelId, Level)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    
    /** Uniqueness Index over (name) (database name name_UNIQUE) */
    val index1 = index("name_UNIQUE", name, unique=true)
  }
  /** Collection-like TableQuery object for table Classe */
  lazy val Classe = new TableQuery(tag => new Classe(tag))
  
  /** Entity class storing rows of table Cycle
   *  @param id Database column id AutoInc, PrimaryKey
   *  @param name Database column name  */
  case class CycleRow(id: Int, name: String)
  /** GetResult implicit for fetching CycleRow objects using plain SQL queries */
  implicit def GetResultCycleRow(implicit e0: GR[Int], e1: GR[String]): GR[CycleRow] = GR{
    prs => import prs._
    CycleRow.tupled((<<[Int], <<[String]))
  }
  /** Table description of table cycle. Objects of this class serve as prototypes for rows in queries. */
  class Cycle(tag: Tag) extends Table[CycleRow](tag, "cycle") {
    def * = (id, name) <> (CycleRow.tupled, CycleRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, name.?).shaped.<>({r=>import r._; _1.map(_=> CycleRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name  */
    val name: Column[String] = column[String]("name")
  }
  /** Collection-like TableQuery object for table Cycle */
  lazy val Cycle = new TableQuery(tag => new Cycle(tag))
  
  /** Entity class storing rows of table Feedetails
   *  @param studentId Database column Student_id 
   *  @param startFeetypeId Database column start_FeeType_id 
   *  @param scholaryearId Database column ScholarYear_id 
   *  @param servicetg Database column serviceTG 
   *  @param comment Database column comment 
   *  @param monthlyreduction Database column monthlyReduction Default(0)
   *  @param annualreduction Database column annualReduction Default(0) */
  case class FeedetailsRow(studentId: Int, startFeetypeId: Int, scholaryearId: Int, servicetg: Int, comment: Option[String], monthlyreduction: Int = 0, annualreduction: Int = 0)
  /** GetResult implicit for fetching FeedetailsRow objects using plain SQL queries */
  implicit def GetResultFeedetailsRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[FeedetailsRow] = GR{
    prs => import prs._
    FeedetailsRow.tupled((<<[Int], <<[Int], <<[Int], <<[Int], <<?[String], <<[Int], <<[Int]))
  }
  /** Table description of table feedetails. Objects of this class serve as prototypes for rows in queries. */
  class Feedetails(tag: Tag) extends Table[FeedetailsRow](tag, "feedetails") {
    def * = (studentId, startFeetypeId, scholaryearId, servicetg, comment, monthlyreduction, annualreduction) <> (FeedetailsRow.tupled, FeedetailsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (studentId.?, startFeetypeId.?, scholaryearId.?, servicetg.?, comment, monthlyreduction.?, annualreduction.?).shaped.<>({r=>import r._; _1.map(_=> FeedetailsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column Student_id  */
    val studentId: Column[Int] = column[Int]("Student_id")
    /** Database column start_FeeType_id  */
    val startFeetypeId: Column[Int] = column[Int]("start_FeeType_id")
    /** Database column ScholarYear_id  */
    val scholaryearId: Column[Int] = column[Int]("ScholarYear_id")
    /** Database column serviceTG  */
    val servicetg: Column[Int] = column[Int]("serviceTG")
    /** Database column comment  */
    val comment: Column[Option[String]] = column[Option[String]]("comment")
    /** Database column monthlyReduction Default(0) */
    val monthlyreduction: Column[Int] = column[Int]("monthlyReduction", O.Default(0))
    /** Database column annualReduction Default(0) */
    val annualreduction: Column[Int] = column[Int]("annualReduction", O.Default(0))
    
    /** Primary key of Feedetails (database name feedetails_PK) */
    val pk = primaryKey("feedetails_PK", (studentId, startFeetypeId, scholaryearId))
    
    /** Foreign key referencing Feetype (database name fk_FeeDetails_FeeType1) */
    lazy val feetypeFk = foreignKey("fk_FeeDetails_FeeType1", startFeetypeId, Feetype)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Scholaryear (database name fk_FeeDetails_ScholarYear1) */
    lazy val scholaryearFk = foreignKey("fk_FeeDetails_ScholarYear1", scholaryearId, Scholaryear)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Student (database name fk_FeeDetails_Student1) */
    lazy val studentFk = foreignKey("fk_FeeDetails_Student1", studentId, Student)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Feedetails */
  lazy val Feedetails = new TableQuery(tag => new Feedetails(tag))
  
  /** Entity class storing rows of table Feetype
   *  @param id Database column id AutoInc, PrimaryKey
   *  @param name Database column name 
   *  @param monthly Database column monthly  */
  case class FeetypeRow(id: Int, name: String, monthly: Boolean)
  /** GetResult implicit for fetching FeetypeRow objects using plain SQL queries */
  implicit def GetResultFeetypeRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Boolean]): GR[FeetypeRow] = GR{
    prs => import prs._
    FeetypeRow.tupled((<<[Int], <<[String], <<[Boolean]))
  }
  /** Table description of table feetype. Objects of this class serve as prototypes for rows in queries. */
  class Feetype(tag: Tag) extends Table[FeetypeRow](tag, "feetype") {
    def * = (id, name, monthly) <> (FeetypeRow.tupled, FeetypeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, name.?, monthly.?).shaped.<>({r=>import r._; _1.map(_=> FeetypeRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name  */
    val name: Column[String] = column[String]("name")
    /** Database column monthly  */
    val monthly: Column[Boolean] = column[Boolean]("monthly")
  }
  /** Collection-like TableQuery object for table Feetype */
  lazy val Feetype = new TableQuery(tag => new Feetype(tag))
  
  /** Entity class storing rows of table Level
   *  @param id Database column id AutoInc, PrimaryKey
   *  @param name Database column name 
   *  @param cycleId Database column Cycle_id  */
  case class LevelRow(id: Int, name: String, cycleId: Int)
  /** GetResult implicit for fetching LevelRow objects using plain SQL queries */
  implicit def GetResultLevelRow(implicit e0: GR[Int], e1: GR[String]): GR[LevelRow] = GR{
    prs => import prs._
    LevelRow.tupled((<<[Int], <<[String], <<[Int]))
  }
  /** Table description of table level. Objects of this class serve as prototypes for rows in queries. */
  class Level(tag: Tag) extends Table[LevelRow](tag, "level") {
    def * = (id, name, cycleId) <> (LevelRow.tupled, LevelRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, name.?, cycleId.?).shaped.<>({r=>import r._; _1.map(_=> LevelRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column name  */
    val name: Column[String] = column[String]("name")
    /** Database column Cycle_id  */
    val cycleId: Column[Int] = column[Int]("Cycle_id")
    
    /** Foreign key referencing Cycle (database name fk_Level_Cycle1) */
    lazy val cycleFk = foreignKey("fk_Level_Cycle1", cycleId, Cycle)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Level */
  lazy val Level = new TableQuery(tag => new Level(tag))
  
  /** Entity class storing rows of table Levelfees
   *  @param scholaryearId Database column ScholarYear_id 
   *  @param levelId Database column Level_id 
   *  @param registration Database column registration 
   *  @param insurance Database column insurance 
   *  @param monthly Database column monthly 
   *  @param transport Database column transport  */
  case class LevelfeesRow(scholaryearId: Int, levelId: Int, registration: Int, insurance: Int, monthly: Int, transport: Int)
  /** GetResult implicit for fetching LevelfeesRow objects using plain SQL queries */
  implicit def GetResultLevelfeesRow(implicit e0: GR[Int]): GR[LevelfeesRow] = GR{
    prs => import prs._
    LevelfeesRow.tupled((<<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table levelfees. Objects of this class serve as prototypes for rows in queries. */
  class Levelfees(tag: Tag) extends Table[LevelfeesRow](tag, "levelfees") {
    def * = (scholaryearId, levelId, registration, insurance, monthly, transport) <> (LevelfeesRow.tupled, LevelfeesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (scholaryearId.?, levelId.?, registration.?, insurance.?, monthly.?, transport.?).shaped.<>({r=>import r._; _1.map(_=> LevelfeesRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column ScholarYear_id  */
    val scholaryearId: Column[Int] = column[Int]("ScholarYear_id")
    /** Database column Level_id  */
    val levelId: Column[Int] = column[Int]("Level_id")
    /** Database column registration  */
    val registration: Column[Int] = column[Int]("registration")
    /** Database column insurance  */
    val insurance: Column[Int] = column[Int]("insurance")
    /** Database column monthly  */
    val monthly: Column[Int] = column[Int]("monthly")
    /** Database column transport  */
    val transport: Column[Int] = column[Int]("transport")
    
    /** Primary key of Levelfees (database name levelfees_PK) */
    val pk = primaryKey("levelfees_PK", (scholaryearId, levelId))
    
    /** Foreign key referencing Level (database name fk_LevelFees_Level1) */
    lazy val levelFk = foreignKey("fk_LevelFees_Level1", levelId, Level)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Scholaryear (database name fk_LevelFees_ScholarYear1) */
    lazy val scholaryearFk = foreignKey("fk_LevelFees_ScholarYear1", scholaryearId, Scholaryear)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Levelfees */
  lazy val Levelfees = new TableQuery(tag => new Levelfees(tag))
  
  /** Entity class storing rows of table Payedfee
   *  @param studentId Database column Student_id 
   *  @param feetypeId Database column FeeType_id 
   *  @param scholaryearId Database column ScholarYear_id 
   *  @param amount Database column amount 
   *  @param payementdate Database column payementDate  */
  case class PayedfeeRow(studentId: Int, feetypeId: Int, scholaryearId: Int, amount: Int, payementdate: java.sql.Date)
  /** GetResult implicit for fetching PayedfeeRow objects using plain SQL queries */
  implicit def GetResultPayedfeeRow(implicit e0: GR[Int], e1: GR[java.sql.Date]): GR[PayedfeeRow] = GR{
    prs => import prs._
    PayedfeeRow.tupled((<<[Int], <<[Int], <<[Int], <<[Int], <<[java.sql.Date]))
  }
  /** Table description of table payedfee. Objects of this class serve as prototypes for rows in queries. */
  class Payedfee(tag: Tag) extends Table[PayedfeeRow](tag, "payedfee") {
    def * = (studentId, feetypeId, scholaryearId, amount, payementdate) <> (PayedfeeRow.tupled, PayedfeeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (studentId.?, feetypeId.?, scholaryearId.?, amount.?, payementdate.?).shaped.<>({r=>import r._; _1.map(_=> PayedfeeRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column Student_id  */
    val studentId: Column[Int] = column[Int]("Student_id")
    /** Database column FeeType_id  */
    val feetypeId: Column[Int] = column[Int]("FeeType_id")
    /** Database column ScholarYear_id  */
    val scholaryearId: Column[Int] = column[Int]("ScholarYear_id")
    /** Database column amount  */
    val amount: Column[Int] = column[Int]("amount")
    /** Database column payementDate  */
    val payementdate: Column[java.sql.Date] = column[java.sql.Date]("payementDate")
    
    /** Primary key of Payedfee (database name payedfee_PK) */
    val pk = primaryKey("payedfee_PK", (studentId, feetypeId, scholaryearId))
    
    /** Foreign key referencing Feetype (database name fk_PayedFee_FeeType1) */
    lazy val feetypeFk = foreignKey("fk_PayedFee_FeeType1", feetypeId, Feetype)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Scholaryear (database name fk_PayedFee_ScholarYear1) */
    lazy val scholaryearFk = foreignKey("fk_PayedFee_ScholarYear1", scholaryearId, Scholaryear)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Student (database name fk_PayedFee_Student1) */
    lazy val studentFk = foreignKey("fk_PayedFee_Student1", studentId, Student)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Payedfee */
  lazy val Payedfee = new TableQuery(tag => new Payedfee(tag))
  
  /** Entity class storing rows of table Phone
   *  @param studentId Database column Student_id 
   *  @param number Database column number 
   *  @param owner Database column owner  */
  case class PhoneRow(studentId: Int, number: String, owner: String)
  /** GetResult implicit for fetching PhoneRow objects using plain SQL queries */
  implicit def GetResultPhoneRow(implicit e0: GR[Int], e1: GR[String]): GR[PhoneRow] = GR{
    prs => import prs._
    PhoneRow.tupled((<<[Int], <<[String], <<[String]))
  }
  /** Table description of table phone. Objects of this class serve as prototypes for rows in queries. */
  class Phone(tag: Tag) extends Table[PhoneRow](tag, "phone") {
    def * = (studentId, number, owner) <> (PhoneRow.tupled, PhoneRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (studentId.?, number.?, owner.?).shaped.<>({r=>import r._; _1.map(_=> PhoneRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column Student_id  */
    val studentId: Column[Int] = column[Int]("Student_id")
    /** Database column number  */
    val number: Column[String] = column[String]("number")
    /** Database column owner  */
    val owner: Column[String] = column[String]("owner")
    
    /** Foreign key referencing Student (database name fk_Phone_Student1) */
    lazy val studentFk = foreignKey("fk_Phone_Student1", studentId, Student)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table Phone */
  lazy val Phone = new TableQuery(tag => new Phone(tag))
  
  /** Entity class storing rows of table Scholaryear
   *  @param id Database column id AutoInc, PrimaryKey
   *  @param startyear Database column startYear  */
  case class ScholaryearRow(id: Int, startyear: Int)
  /** GetResult implicit for fetching ScholaryearRow objects using plain SQL queries */
  implicit def GetResultScholaryearRow(implicit e0: GR[Int]): GR[ScholaryearRow] = GR{
    prs => import prs._
    ScholaryearRow.tupled((<<[Int], <<[Int]))
  }
  /** Table description of table scholaryear. Objects of this class serve as prototypes for rows in queries. */
  class Scholaryear(tag: Tag) extends Table[ScholaryearRow](tag, "scholaryear") {
    def * = (id, startyear) <> (ScholaryearRow.tupled, ScholaryearRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, startyear.?).shaped.<>({r=>import r._; _1.map(_=> ScholaryearRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column startYear  */
    val startyear: Column[Int] = column[Int]("startYear")
  }
  /** Collection-like TableQuery object for table Scholaryear */
  lazy val Scholaryear = new TableQuery(tag => new Scholaryear(tag))
  
  /** Entity class storing rows of table Student
   *  @param id Database column id PrimaryKey
   *  @param firstname Database column firstName 
   *  @param lastname Database column lastName  */
  case class StudentRow(id: Int, firstname: String, lastname: String)
  /** GetResult implicit for fetching StudentRow objects using plain SQL queries */
  implicit def GetResultStudentRow(implicit e0: GR[Int], e1: GR[String]): GR[StudentRow] = GR{
    prs => import prs._
    StudentRow.tupled((<<[Int], <<[String], <<[String]))
  }
  /** Table description of table student. Objects of this class serve as prototypes for rows in queries. */
  class Student(tag: Tag) extends Table[StudentRow](tag, "student") {
    def * = (id, firstname, lastname) <> (StudentRow.tupled, StudentRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, firstname.?, lastname.?).shaped.<>({r=>import r._; _1.map(_=> StudentRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.PrimaryKey)
    /** Database column firstName  */
    val firstname: Column[String] = column[String]("firstName")
    /** Database column lastName  */
    val lastname: Column[String] = column[String]("lastName")
  }
  /** Collection-like TableQuery object for table Student */
  lazy val Student = new TableQuery(tag => new Student(tag))
  
  /** Entity class storing rows of table StudentClasse
   *  @param studentId Database column Student_id 
   *  @param scholaryearId Database column ScholarYear_id 
   *  @param classeId Database column Classe_id  */
  case class StudentClasseRow(studentId: Int, scholaryearId: Int, classeId: Int)
  /** GetResult implicit for fetching StudentClasseRow objects using plain SQL queries */
  implicit def GetResultStudentClasseRow(implicit e0: GR[Int]): GR[StudentClasseRow] = GR{
    prs => import prs._
    StudentClasseRow.tupled((<<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table student_classe. Objects of this class serve as prototypes for rows in queries. */
  class StudentClasse(tag: Tag) extends Table[StudentClasseRow](tag, "student_classe") {
    def * = (studentId, scholaryearId, classeId) <> (StudentClasseRow.tupled, StudentClasseRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (studentId.?, scholaryearId.?, classeId.?).shaped.<>({r=>import r._; _1.map(_=> StudentClasseRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column Student_id  */
    val studentId: Column[Int] = column[Int]("Student_id")
    /** Database column ScholarYear_id  */
    val scholaryearId: Column[Int] = column[Int]("ScholarYear_id")
    /** Database column Classe_id  */
    val classeId: Column[Int] = column[Int]("Classe_id")
    
    /** Primary key of StudentClasse (database name student_classe_PK) */
    val pk = primaryKey("student_classe_PK", (studentId, scholaryearId, classeId))
    
    /** Foreign key referencing Classe (database name fk_Student_Classe_Classe1) */
    lazy val classeFk = foreignKey("fk_Student_Classe_Classe1", classeId, Classe)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Scholaryear (database name fk_Student_Classe_ScholarYear1) */
    lazy val scholaryearFk = foreignKey("fk_Student_Classe_ScholarYear1", scholaryearId, Scholaryear)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
    /** Foreign key referencing Student (database name fk_Student_Classe_Student1) */
    lazy val studentFk = foreignKey("fk_Student_Classe_Student1", studentId, Student)(r => r.id, onUpdate=ForeignKeyAction.NoAction, onDelete=ForeignKeyAction.NoAction)
  }
  /** Collection-like TableQuery object for table StudentClasse */
  lazy val StudentClasse = new TableQuery(tag => new StudentClasse(tag))
  
  /** Entity class storing rows of table User
   *  @param id Database column id AutoInc, PrimaryKey
   *  @param username Database column username 
   *  @param password Database column password 
   *  @param salt Database column salt  */
  case class UserRow(id: Int, username: String, password: String, salt: String)
  /** GetResult implicit for fetching UserRow objects using plain SQL queries */
  implicit def GetResultUserRow(implicit e0: GR[Int], e1: GR[String]): GR[UserRow] = GR{
    prs => import prs._
    UserRow.tupled((<<[Int], <<[String], <<[String], <<[String]))
  }
  /** Table description of table user. Objects of this class serve as prototypes for rows in queries. */
  class User(tag: Tag) extends Table[UserRow](tag, "user") {
    def * = (id, username, password, salt) <> (UserRow.tupled, UserRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, username.?, password.?, salt.?).shaped.<>({r=>import r._; _1.map(_=> UserRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column username  */
    val username: Column[String] = column[String]("username")
    /** Database column password  */
    val password: Column[String] = column[String]("password")
    /** Database column salt  */
    val salt: Column[String] = column[String]("salt")
    
    /** Uniqueness Index over (username) (database name username_UNIQUE) */
    val index1 = index("username_UNIQUE", username, unique=true)
  }
  /** Collection-like TableQuery object for table User */
  lazy val User = new TableQuery(tag => new User(tag))
}