package entities
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object OldTables extends {
  val profile = scala.slick.driver.MySQLDriver
} with OldTables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait OldTables {
  val profile: scala.slick.driver.JdbcProfile
  import profile.simple._
  import scala.slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import scala.slick.jdbc.{GetResult => GR}
  
  /** DDL for all tables. Call .create to execute. */
  lazy val ddl = SchoolClasses.ddl ++ SchoolEleves.ddl ++ SchoolSituations.ddl ++ SchoolUsers.ddl ++ Situation07april2014122342.ddl ++ Situation09july2014160905.ddl ++ Situation11july2014173737.ddl ++ Situation13december2013170325.ddl ++ Situation13february2014100442.ddl ++ Situation28august2014130405.ddl ++ Situation29october2013103413.ddl ++ Situation29october2013103414.ddl ++ Situation29october2013184824.ddl
  
  /** Entity class storing rows of table SchoolClasses
   *  @param id Database column ID AutoInc, PrimaryKey
   *  @param nom Database column nom 
   *  @param inscription Database column inscription 
   *  @param assurance Database column assurance 
   *  @param mensualite Database column mensualite 
   *  @param transport Database column transport 
   *  @param nombreEleves Database column nombre_eleves  */
  case class SchoolClassesRow(id: Int, nom: String, inscription: Int, assurance: Int, mensualite: Int, transport: Int, nombreEleves: Int)
  /** GetResult implicit for fetching SchoolClassesRow objects using plain SQL queries */
  implicit def GetResultSchoolClassesRow(implicit e0: GR[Int], e1: GR[String]): GR[SchoolClassesRow] = GR{
    prs => import prs._
    SchoolClassesRow.tupled((<<[Int], <<[String], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table school_classes. Objects of this class serve as prototypes for rows in queries. */
  class SchoolClasses(tag: Tag) extends Table[SchoolClassesRow](tag, "school_classes") {
    def * = (id, nom, inscription, assurance, mensualite, transport, nombreEleves) <> (SchoolClassesRow.tupled, SchoolClassesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, nom.?, inscription.?, assurance.?, mensualite.?, transport.?, nombreEleves.?).shaped.<>({r=>import r._; _1.map(_=> SchoolClassesRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column ID AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("ID", O.AutoInc, O.PrimaryKey)
    /** Database column nom  */
    val nom: Column[String] = column[String]("nom")
    /** Database column inscription  */
    val inscription: Column[Int] = column[Int]("inscription")
    /** Database column assurance  */
    val assurance: Column[Int] = column[Int]("assurance")
    /** Database column mensualite  */
    val mensualite: Column[Int] = column[Int]("mensualite")
    /** Database column transport  */
    val transport: Column[Int] = column[Int]("transport")
    /** Database column nombre_eleves  */
    val nombreEleves: Column[Int] = column[Int]("nombre_eleves")
  }
  /** Collection-like TableQuery object for table SchoolClasses */
  lazy val SchoolClasses = new TableQuery(tag => new SchoolClasses(tag))
  
  /** Entity class storing rows of table SchoolEleves
   *  @param id Database column id AutoInc, PrimaryKey
   *  @param nom Database column nom 
   *  @param prenom Database column prenom 
   *  @param classe Database column classe 
   *  @param transport Database column transport 
   *  @param mensualite Database column mensualite 
   *  @param rabais Database column rabais 
   *  @param inscription Database column inscription 
   *  @param septembre Database column septembre 
   *  @param octobre Database column octobre 
   *  @param novembre Database column novembre 
   *  @param decembre Database column decembre 
   *  @param janvier Database column janvier 
   *  @param fevrier Database column fevrier 
   *  @param mars Database column mars 
   *  @param avril Database column avril 
   *  @param mai Database column mai 
   *  @param juin Database column juin  */
  case class SchoolElevesRow(id: Int, nom: String, prenom: String, classe: String, transport: Boolean, mensualite: Int, rabais: Int, inscription: Int, septembre: Int, octobre: Int, novembre: Int, decembre: Int, janvier: Int, fevrier: Int, mars: Int, avril: Int, mai: Int, juin: Int)
  /** GetResult implicit for fetching SchoolElevesRow objects using plain SQL queries */
  implicit def GetResultSchoolElevesRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Boolean]): GR[SchoolElevesRow] = GR{
    prs => import prs._
    SchoolElevesRow.tupled((<<[Int], <<[String], <<[String], <<[String], <<[Boolean], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table school_eleves. Objects of this class serve as prototypes for rows in queries. */
  class SchoolEleves(tag: Tag) extends Table[SchoolElevesRow](tag, "school_eleves") {
    def * = (id, nom, prenom, classe, transport, mensualite, rabais, inscription, septembre, octobre, novembre, decembre, janvier, fevrier, mars, avril, mai, juin) <> (SchoolElevesRow.tupled, SchoolElevesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, nom.?, prenom.?, classe.?, transport.?, mensualite.?, rabais.?, inscription.?, septembre.?, octobre.?, novembre.?, decembre.?, janvier.?, fevrier.?, mars.?, avril.?, mai.?, juin.?).shaped.<>({r=>import r._; _1.map(_=> SchoolElevesRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get, _16.get, _17.get, _18.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column nom  */
    val nom: Column[String] = column[String]("nom")
    /** Database column prenom  */
    val prenom: Column[String] = column[String]("prenom")
    /** Database column classe  */
    val classe: Column[String] = column[String]("classe")
    /** Database column transport  */
    val transport: Column[Boolean] = column[Boolean]("transport")
    /** Database column mensualite  */
    val mensualite: Column[Int] = column[Int]("mensualite")
    /** Database column rabais  */
    val rabais: Column[Int] = column[Int]("rabais")
    /** Database column inscription  */
    val inscription: Column[Int] = column[Int]("inscription")
    /** Database column septembre  */
    val septembre: Column[Int] = column[Int]("septembre")
    /** Database column octobre  */
    val octobre: Column[Int] = column[Int]("octobre")
    /** Database column novembre  */
    val novembre: Column[Int] = column[Int]("novembre")
    /** Database column decembre  */
    val decembre: Column[Int] = column[Int]("decembre")
    /** Database column janvier  */
    val janvier: Column[Int] = column[Int]("janvier")
    /** Database column fevrier  */
    val fevrier: Column[Int] = column[Int]("fevrier")
    /** Database column mars  */
    val mars: Column[Int] = column[Int]("mars")
    /** Database column avril  */
    val avril: Column[Int] = column[Int]("avril")
    /** Database column mai  */
    val mai: Column[Int] = column[Int]("mai")
    /** Database column juin  */
    val juin: Column[Int] = column[Int]("juin")
  }
  /** Collection-like TableQuery object for table SchoolEleves */
  lazy val SchoolEleves = new TableQuery(tag => new SchoolEleves(tag))
  
  /** Entity class storing rows of table SchoolSituations
   *  @param id Database column ID AutoInc, PrimaryKey
   *  @param nom Database column nom 
   *  @param date Database column date  */
  case class SchoolSituationsRow(id: Int, nom: String, date: java.sql.Timestamp)
  /** GetResult implicit for fetching SchoolSituationsRow objects using plain SQL queries */
  implicit def GetResultSchoolSituationsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[SchoolSituationsRow] = GR{
    prs => import prs._
    SchoolSituationsRow.tupled((<<[Int], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table school_situations. Objects of this class serve as prototypes for rows in queries. */
  class SchoolSituations(tag: Tag) extends Table[SchoolSituationsRow](tag, "school_situations") {
    def * = (id, nom, date) <> (SchoolSituationsRow.tupled, SchoolSituationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, nom.?, date.?).shaped.<>({r=>import r._; _1.map(_=> SchoolSituationsRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column ID AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("ID", O.AutoInc, O.PrimaryKey)
    /** Database column nom  */
    val nom: Column[String] = column[String]("nom")
    /** Database column date  */
    val date: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("date")
  }
  /** Collection-like TableQuery object for table SchoolSituations */
  lazy val SchoolSituations = new TableQuery(tag => new SchoolSituations(tag))
  
  /** Entity class storing rows of table SchoolUsers
   *  @param id Database column ID AutoInc, PrimaryKey
   *  @param username Database column username 
   *  @param password Database column password 
   *  @param status Database column status  */
  case class SchoolUsersRow(id: Int, username: String, password: String, status: String)
  /** GetResult implicit for fetching SchoolUsersRow objects using plain SQL queries */
  implicit def GetResultSchoolUsersRow(implicit e0: GR[Int], e1: GR[String]): GR[SchoolUsersRow] = GR{
    prs => import prs._
    SchoolUsersRow.tupled((<<[Int], <<[String], <<[String], <<[String]))
  }
  /** Table description of table school_users. Objects of this class serve as prototypes for rows in queries. */
  class SchoolUsers(tag: Tag) extends Table[SchoolUsersRow](tag, "school_users") {
    def * = (id, username, password, status) <> (SchoolUsersRow.tupled, SchoolUsersRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, username.?, password.?, status.?).shaped.<>({r=>import r._; _1.map(_=> SchoolUsersRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column ID AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("ID", O.AutoInc, O.PrimaryKey)
    /** Database column username  */
    val username: Column[String] = column[String]("username")
    /** Database column password  */
    val password: Column[String] = column[String]("password")
    /** Database column status  */
    val status: Column[String] = column[String]("status")
  }
  /** Collection-like TableQuery object for table SchoolUsers */
  lazy val SchoolUsers = new TableQuery(tag => new SchoolUsers(tag))
  
  /** Entity class storing rows of table Situation07april2014122342
   *  @param id Database column id AutoInc, PrimaryKey
   *  @param nom Database column nom 
   *  @param prenom Database column prenom 
   *  @param classe Database column classe 
   *  @param transport Database column transport 
   *  @param mensualite Database column mensualite 
   *  @param rabais Database column rabais 
   *  @param inscription Database column inscription 
   *  @param septembre Database column septembre 
   *  @param octobre Database column octobre 
   *  @param novembre Database column novembre 
   *  @param decembre Database column decembre 
   *  @param janvier Database column janvier 
   *  @param fevrier Database column fevrier 
   *  @param mars Database column mars 
   *  @param avril Database column avril 
   *  @param mai Database column mai 
   *  @param juin Database column juin  */
  case class Situation07april2014122342Row(id: Int, nom: String, prenom: String, classe: String, transport: Boolean, mensualite: Int, rabais: Int, inscription: Int, septembre: Int, octobre: Int, novembre: Int, decembre: Int, janvier: Int, fevrier: Int, mars: Int, avril: Int, mai: Int, juin: Int)
  /** GetResult implicit for fetching Situation07april2014122342Row objects using plain SQL queries */
  implicit def GetResultSituation07april2014122342Row(implicit e0: GR[Int], e1: GR[String], e2: GR[Boolean]): GR[Situation07april2014122342Row] = GR{
    prs => import prs._
    Situation07april2014122342Row.tupled((<<[Int], <<[String], <<[String], <<[String], <<[Boolean], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table situation_07april2014_122342. Objects of this class serve as prototypes for rows in queries. */
  class Situation07april2014122342(tag: Tag) extends Table[Situation07april2014122342Row](tag, "situation_07april2014_122342") {
    def * = (id, nom, prenom, classe, transport, mensualite, rabais, inscription, septembre, octobre, novembre, decembre, janvier, fevrier, mars, avril, mai, juin) <> (Situation07april2014122342Row.tupled, Situation07april2014122342Row.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, nom.?, prenom.?, classe.?, transport.?, mensualite.?, rabais.?, inscription.?, septembre.?, octobre.?, novembre.?, decembre.?, janvier.?, fevrier.?, mars.?, avril.?, mai.?, juin.?).shaped.<>({r=>import r._; _1.map(_=> Situation07april2014122342Row.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get, _16.get, _17.get, _18.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column nom  */
    val nom: Column[String] = column[String]("nom")
    /** Database column prenom  */
    val prenom: Column[String] = column[String]("prenom")
    /** Database column classe  */
    val classe: Column[String] = column[String]("classe")
    /** Database column transport  */
    val transport: Column[Boolean] = column[Boolean]("transport")
    /** Database column mensualite  */
    val mensualite: Column[Int] = column[Int]("mensualite")
    /** Database column rabais  */
    val rabais: Column[Int] = column[Int]("rabais")
    /** Database column inscription  */
    val inscription: Column[Int] = column[Int]("inscription")
    /** Database column septembre  */
    val septembre: Column[Int] = column[Int]("septembre")
    /** Database column octobre  */
    val octobre: Column[Int] = column[Int]("octobre")
    /** Database column novembre  */
    val novembre: Column[Int] = column[Int]("novembre")
    /** Database column decembre  */
    val decembre: Column[Int] = column[Int]("decembre")
    /** Database column janvier  */
    val janvier: Column[Int] = column[Int]("janvier")
    /** Database column fevrier  */
    val fevrier: Column[Int] = column[Int]("fevrier")
    /** Database column mars  */
    val mars: Column[Int] = column[Int]("mars")
    /** Database column avril  */
    val avril: Column[Int] = column[Int]("avril")
    /** Database column mai  */
    val mai: Column[Int] = column[Int]("mai")
    /** Database column juin  */
    val juin: Column[Int] = column[Int]("juin")
  }
  /** Collection-like TableQuery object for table Situation07april2014122342 */
  lazy val Situation07april2014122342 = new TableQuery(tag => new Situation07april2014122342(tag))
  
  /** Entity class storing rows of table Situation09july2014160905
   *  @param id Database column id AutoInc, PrimaryKey
   *  @param nom Database column nom 
   *  @param prenom Database column prenom 
   *  @param classe Database column classe 
   *  @param transport Database column transport 
   *  @param mensualite Database column mensualite 
   *  @param rabais Database column rabais 
   *  @param inscription Database column inscription 
   *  @param septembre Database column septembre 
   *  @param octobre Database column octobre 
   *  @param novembre Database column novembre 
   *  @param decembre Database column decembre 
   *  @param janvier Database column janvier 
   *  @param fevrier Database column fevrier 
   *  @param mars Database column mars 
   *  @param avril Database column avril 
   *  @param mai Database column mai 
   *  @param juin Database column juin  */
  case class Situation09july2014160905Row(id: Int, nom: String, prenom: String, classe: String, transport: Boolean, mensualite: Int, rabais: Int, inscription: Int, septembre: Int, octobre: Int, novembre: Int, decembre: Int, janvier: Int, fevrier: Int, mars: Int, avril: Int, mai: Int, juin: Int)
  /** GetResult implicit for fetching Situation09july2014160905Row objects using plain SQL queries */
  implicit def GetResultSituation09july2014160905Row(implicit e0: GR[Int], e1: GR[String], e2: GR[Boolean]): GR[Situation09july2014160905Row] = GR{
    prs => import prs._
    Situation09july2014160905Row.tupled((<<[Int], <<[String], <<[String], <<[String], <<[Boolean], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table situation_09july2014_160905. Objects of this class serve as prototypes for rows in queries. */
  class Situation09july2014160905(tag: Tag) extends Table[Situation09july2014160905Row](tag, "situation_09july2014_160905") {
    def * = (id, nom, prenom, classe, transport, mensualite, rabais, inscription, septembre, octobre, novembre, decembre, janvier, fevrier, mars, avril, mai, juin) <> (Situation09july2014160905Row.tupled, Situation09july2014160905Row.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, nom.?, prenom.?, classe.?, transport.?, mensualite.?, rabais.?, inscription.?, septembre.?, octobre.?, novembre.?, decembre.?, janvier.?, fevrier.?, mars.?, avril.?, mai.?, juin.?).shaped.<>({r=>import r._; _1.map(_=> Situation09july2014160905Row.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get, _16.get, _17.get, _18.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column nom  */
    val nom: Column[String] = column[String]("nom")
    /** Database column prenom  */
    val prenom: Column[String] = column[String]("prenom")
    /** Database column classe  */
    val classe: Column[String] = column[String]("classe")
    /** Database column transport  */
    val transport: Column[Boolean] = column[Boolean]("transport")
    /** Database column mensualite  */
    val mensualite: Column[Int] = column[Int]("mensualite")
    /** Database column rabais  */
    val rabais: Column[Int] = column[Int]("rabais")
    /** Database column inscription  */
    val inscription: Column[Int] = column[Int]("inscription")
    /** Database column septembre  */
    val septembre: Column[Int] = column[Int]("septembre")
    /** Database column octobre  */
    val octobre: Column[Int] = column[Int]("octobre")
    /** Database column novembre  */
    val novembre: Column[Int] = column[Int]("novembre")
    /** Database column decembre  */
    val decembre: Column[Int] = column[Int]("decembre")
    /** Database column janvier  */
    val janvier: Column[Int] = column[Int]("janvier")
    /** Database column fevrier  */
    val fevrier: Column[Int] = column[Int]("fevrier")
    /** Database column mars  */
    val mars: Column[Int] = column[Int]("mars")
    /** Database column avril  */
    val avril: Column[Int] = column[Int]("avril")
    /** Database column mai  */
    val mai: Column[Int] = column[Int]("mai")
    /** Database column juin  */
    val juin: Column[Int] = column[Int]("juin")
  }
  /** Collection-like TableQuery object for table Situation09july2014160905 */
  lazy val Situation09july2014160905 = new TableQuery(tag => new Situation09july2014160905(tag))
  
  /** Entity class storing rows of table Situation11july2014173737
   *  @param id Database column id AutoInc, PrimaryKey
   *  @param nom Database column nom 
   *  @param prenom Database column prenom 
   *  @param classe Database column classe 
   *  @param transport Database column transport 
   *  @param mensualite Database column mensualite 
   *  @param rabais Database column rabais 
   *  @param inscription Database column inscription 
   *  @param septembre Database column septembre 
   *  @param octobre Database column octobre 
   *  @param novembre Database column novembre 
   *  @param decembre Database column decembre 
   *  @param janvier Database column janvier 
   *  @param fevrier Database column fevrier 
   *  @param mars Database column mars 
   *  @param avril Database column avril 
   *  @param mai Database column mai 
   *  @param juin Database column juin  */
  case class Situation11july2014173737Row(id: Int, nom: String, prenom: String, classe: String, transport: Boolean, mensualite: Int, rabais: Int, inscription: Int, septembre: Int, octobre: Int, novembre: Int, decembre: Int, janvier: Int, fevrier: Int, mars: Int, avril: Int, mai: Int, juin: Int)
  /** GetResult implicit for fetching Situation11july2014173737Row objects using plain SQL queries */
  implicit def GetResultSituation11july2014173737Row(implicit e0: GR[Int], e1: GR[String], e2: GR[Boolean]): GR[Situation11july2014173737Row] = GR{
    prs => import prs._
    Situation11july2014173737Row.tupled((<<[Int], <<[String], <<[String], <<[String], <<[Boolean], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table situation_11july2014_173737. Objects of this class serve as prototypes for rows in queries. */
  class Situation11july2014173737(tag: Tag) extends Table[Situation11july2014173737Row](tag, "situation_11july2014_173737") {
    def * = (id, nom, prenom, classe, transport, mensualite, rabais, inscription, septembre, octobre, novembre, decembre, janvier, fevrier, mars, avril, mai, juin) <> (Situation11july2014173737Row.tupled, Situation11july2014173737Row.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, nom.?, prenom.?, classe.?, transport.?, mensualite.?, rabais.?, inscription.?, septembre.?, octobre.?, novembre.?, decembre.?, janvier.?, fevrier.?, mars.?, avril.?, mai.?, juin.?).shaped.<>({r=>import r._; _1.map(_=> Situation11july2014173737Row.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get, _16.get, _17.get, _18.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column nom  */
    val nom: Column[String] = column[String]("nom")
    /** Database column prenom  */
    val prenom: Column[String] = column[String]("prenom")
    /** Database column classe  */
    val classe: Column[String] = column[String]("classe")
    /** Database column transport  */
    val transport: Column[Boolean] = column[Boolean]("transport")
    /** Database column mensualite  */
    val mensualite: Column[Int] = column[Int]("mensualite")
    /** Database column rabais  */
    val rabais: Column[Int] = column[Int]("rabais")
    /** Database column inscription  */
    val inscription: Column[Int] = column[Int]("inscription")
    /** Database column septembre  */
    val septembre: Column[Int] = column[Int]("septembre")
    /** Database column octobre  */
    val octobre: Column[Int] = column[Int]("octobre")
    /** Database column novembre  */
    val novembre: Column[Int] = column[Int]("novembre")
    /** Database column decembre  */
    val decembre: Column[Int] = column[Int]("decembre")
    /** Database column janvier  */
    val janvier: Column[Int] = column[Int]("janvier")
    /** Database column fevrier  */
    val fevrier: Column[Int] = column[Int]("fevrier")
    /** Database column mars  */
    val mars: Column[Int] = column[Int]("mars")
    /** Database column avril  */
    val avril: Column[Int] = column[Int]("avril")
    /** Database column mai  */
    val mai: Column[Int] = column[Int]("mai")
    /** Database column juin  */
    val juin: Column[Int] = column[Int]("juin")
  }
  /** Collection-like TableQuery object for table Situation11july2014173737 */
  lazy val Situation11july2014173737 = new TableQuery(tag => new Situation11july2014173737(tag))
  
  /** Entity class storing rows of table Situation13december2013170325
   *  @param id Database column id AutoInc, PrimaryKey
   *  @param nom Database column nom 
   *  @param prenom Database column prenom 
   *  @param classe Database column classe 
   *  @param transport Database column transport 
   *  @param mensualite Database column mensualite 
   *  @param rabais Database column rabais 
   *  @param inscription Database column inscription 
   *  @param septembre Database column septembre 
   *  @param octobre Database column octobre 
   *  @param novembre Database column novembre 
   *  @param decembre Database column decembre 
   *  @param janvier Database column janvier 
   *  @param fevrier Database column fevrier 
   *  @param mars Database column mars 
   *  @param avril Database column avril 
   *  @param mai Database column mai 
   *  @param juin Database column juin  */
  case class Situation13december2013170325Row(id: Int, nom: String, prenom: String, classe: String, transport: Boolean, mensualite: Int, rabais: Int, inscription: Int, septembre: Int, octobre: Int, novembre: Int, decembre: Int, janvier: Int, fevrier: Int, mars: Int, avril: Int, mai: Int, juin: Int)
  /** GetResult implicit for fetching Situation13december2013170325Row objects using plain SQL queries */
  implicit def GetResultSituation13december2013170325Row(implicit e0: GR[Int], e1: GR[String], e2: GR[Boolean]): GR[Situation13december2013170325Row] = GR{
    prs => import prs._
    Situation13december2013170325Row.tupled((<<[Int], <<[String], <<[String], <<[String], <<[Boolean], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table situation_13december2013_170325. Objects of this class serve as prototypes for rows in queries. */
  class Situation13december2013170325(tag: Tag) extends Table[Situation13december2013170325Row](tag, "situation_13december2013_170325") {
    def * = (id, nom, prenom, classe, transport, mensualite, rabais, inscription, septembre, octobre, novembre, decembre, janvier, fevrier, mars, avril, mai, juin) <> (Situation13december2013170325Row.tupled, Situation13december2013170325Row.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, nom.?, prenom.?, classe.?, transport.?, mensualite.?, rabais.?, inscription.?, septembre.?, octobre.?, novembre.?, decembre.?, janvier.?, fevrier.?, mars.?, avril.?, mai.?, juin.?).shaped.<>({r=>import r._; _1.map(_=> Situation13december2013170325Row.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get, _16.get, _17.get, _18.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column nom  */
    val nom: Column[String] = column[String]("nom")
    /** Database column prenom  */
    val prenom: Column[String] = column[String]("prenom")
    /** Database column classe  */
    val classe: Column[String] = column[String]("classe")
    /** Database column transport  */
    val transport: Column[Boolean] = column[Boolean]("transport")
    /** Database column mensualite  */
    val mensualite: Column[Int] = column[Int]("mensualite")
    /** Database column rabais  */
    val rabais: Column[Int] = column[Int]("rabais")
    /** Database column inscription  */
    val inscription: Column[Int] = column[Int]("inscription")
    /** Database column septembre  */
    val septembre: Column[Int] = column[Int]("septembre")
    /** Database column octobre  */
    val octobre: Column[Int] = column[Int]("octobre")
    /** Database column novembre  */
    val novembre: Column[Int] = column[Int]("novembre")
    /** Database column decembre  */
    val decembre: Column[Int] = column[Int]("decembre")
    /** Database column janvier  */
    val janvier: Column[Int] = column[Int]("janvier")
    /** Database column fevrier  */
    val fevrier: Column[Int] = column[Int]("fevrier")
    /** Database column mars  */
    val mars: Column[Int] = column[Int]("mars")
    /** Database column avril  */
    val avril: Column[Int] = column[Int]("avril")
    /** Database column mai  */
    val mai: Column[Int] = column[Int]("mai")
    /** Database column juin  */
    val juin: Column[Int] = column[Int]("juin")
  }
  /** Collection-like TableQuery object for table Situation13december2013170325 */
  lazy val Situation13december2013170325 = new TableQuery(tag => new Situation13december2013170325(tag))
  
  /** Entity class storing rows of table Situation13february2014100442
   *  @param id Database column id AutoInc, PrimaryKey
   *  @param nom Database column nom 
   *  @param prenom Database column prenom 
   *  @param classe Database column classe 
   *  @param transport Database column transport 
   *  @param mensualite Database column mensualite 
   *  @param rabais Database column rabais 
   *  @param inscription Database column inscription 
   *  @param septembre Database column septembre 
   *  @param octobre Database column octobre 
   *  @param novembre Database column novembre 
   *  @param decembre Database column decembre 
   *  @param janvier Database column janvier 
   *  @param fevrier Database column fevrier 
   *  @param mars Database column mars 
   *  @param avril Database column avril 
   *  @param mai Database column mai 
   *  @param juin Database column juin  */
  case class Situation13february2014100442Row(id: Int, nom: String, prenom: String, classe: String, transport: Boolean, mensualite: Int, rabais: Int, inscription: Int, septembre: Int, octobre: Int, novembre: Int, decembre: Int, janvier: Int, fevrier: Int, mars: Int, avril: Int, mai: Int, juin: Int)
  /** GetResult implicit for fetching Situation13february2014100442Row objects using plain SQL queries */
  implicit def GetResultSituation13february2014100442Row(implicit e0: GR[Int], e1: GR[String], e2: GR[Boolean]): GR[Situation13february2014100442Row] = GR{
    prs => import prs._
    Situation13february2014100442Row.tupled((<<[Int], <<[String], <<[String], <<[String], <<[Boolean], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table situation_13february2014_100442. Objects of this class serve as prototypes for rows in queries. */
  class Situation13february2014100442(tag: Tag) extends Table[Situation13february2014100442Row](tag, "situation_13february2014_100442") {
    def * = (id, nom, prenom, classe, transport, mensualite, rabais, inscription, septembre, octobre, novembre, decembre, janvier, fevrier, mars, avril, mai, juin) <> (Situation13february2014100442Row.tupled, Situation13february2014100442Row.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, nom.?, prenom.?, classe.?, transport.?, mensualite.?, rabais.?, inscription.?, septembre.?, octobre.?, novembre.?, decembre.?, janvier.?, fevrier.?, mars.?, avril.?, mai.?, juin.?).shaped.<>({r=>import r._; _1.map(_=> Situation13february2014100442Row.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get, _16.get, _17.get, _18.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column nom  */
    val nom: Column[String] = column[String]("nom")
    /** Database column prenom  */
    val prenom: Column[String] = column[String]("prenom")
    /** Database column classe  */
    val classe: Column[String] = column[String]("classe")
    /** Database column transport  */
    val transport: Column[Boolean] = column[Boolean]("transport")
    /** Database column mensualite  */
    val mensualite: Column[Int] = column[Int]("mensualite")
    /** Database column rabais  */
    val rabais: Column[Int] = column[Int]("rabais")
    /** Database column inscription  */
    val inscription: Column[Int] = column[Int]("inscription")
    /** Database column septembre  */
    val septembre: Column[Int] = column[Int]("septembre")
    /** Database column octobre  */
    val octobre: Column[Int] = column[Int]("octobre")
    /** Database column novembre  */
    val novembre: Column[Int] = column[Int]("novembre")
    /** Database column decembre  */
    val decembre: Column[Int] = column[Int]("decembre")
    /** Database column janvier  */
    val janvier: Column[Int] = column[Int]("janvier")
    /** Database column fevrier  */
    val fevrier: Column[Int] = column[Int]("fevrier")
    /** Database column mars  */
    val mars: Column[Int] = column[Int]("mars")
    /** Database column avril  */
    val avril: Column[Int] = column[Int]("avril")
    /** Database column mai  */
    val mai: Column[Int] = column[Int]("mai")
    /** Database column juin  */
    val juin: Column[Int] = column[Int]("juin")
  }
  /** Collection-like TableQuery object for table Situation13february2014100442 */
  lazy val Situation13february2014100442 = new TableQuery(tag => new Situation13february2014100442(tag))
  
  /** Entity class storing rows of table Situation28august2014130405
   *  @param id Database column id AutoInc, PrimaryKey
   *  @param nom Database column nom 
   *  @param prenom Database column prenom 
   *  @param classe Database column classe 
   *  @param transport Database column transport 
   *  @param mensualite Database column mensualite 
   *  @param rabais Database column rabais 
   *  @param inscription Database column inscription 
   *  @param septembre Database column septembre 
   *  @param octobre Database column octobre 
   *  @param novembre Database column novembre 
   *  @param decembre Database column decembre 
   *  @param janvier Database column janvier 
   *  @param fevrier Database column fevrier 
   *  @param mars Database column mars 
   *  @param avril Database column avril 
   *  @param mai Database column mai 
   *  @param juin Database column juin  */
  case class Situation28august2014130405Row(id: Int, nom: String, prenom: String, classe: String, transport: Boolean, mensualite: Int, rabais: Int, inscription: Int, septembre: Int, octobre: Int, novembre: Int, decembre: Int, janvier: Int, fevrier: Int, mars: Int, avril: Int, mai: Int, juin: Int)
  /** GetResult implicit for fetching Situation28august2014130405Row objects using plain SQL queries */
  implicit def GetResultSituation28august2014130405Row(implicit e0: GR[Int], e1: GR[String], e2: GR[Boolean]): GR[Situation28august2014130405Row] = GR{
    prs => import prs._
    Situation28august2014130405Row.tupled((<<[Int], <<[String], <<[String], <<[String], <<[Boolean], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table situation_28august2014_130405. Objects of this class serve as prototypes for rows in queries. */
  class Situation28august2014130405(tag: Tag) extends Table[Situation28august2014130405Row](tag, "situation_28august2014_130405") {
    def * = (id, nom, prenom, classe, transport, mensualite, rabais, inscription, septembre, octobre, novembre, decembre, janvier, fevrier, mars, avril, mai, juin) <> (Situation28august2014130405Row.tupled, Situation28august2014130405Row.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, nom.?, prenom.?, classe.?, transport.?, mensualite.?, rabais.?, inscription.?, septembre.?, octobre.?, novembre.?, decembre.?, janvier.?, fevrier.?, mars.?, avril.?, mai.?, juin.?).shaped.<>({r=>import r._; _1.map(_=> Situation28august2014130405Row.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get, _16.get, _17.get, _18.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column nom  */
    val nom: Column[String] = column[String]("nom")
    /** Database column prenom  */
    val prenom: Column[String] = column[String]("prenom")
    /** Database column classe  */
    val classe: Column[String] = column[String]("classe")
    /** Database column transport  */
    val transport: Column[Boolean] = column[Boolean]("transport")
    /** Database column mensualite  */
    val mensualite: Column[Int] = column[Int]("mensualite")
    /** Database column rabais  */
    val rabais: Column[Int] = column[Int]("rabais")
    /** Database column inscription  */
    val inscription: Column[Int] = column[Int]("inscription")
    /** Database column septembre  */
    val septembre: Column[Int] = column[Int]("septembre")
    /** Database column octobre  */
    val octobre: Column[Int] = column[Int]("octobre")
    /** Database column novembre  */
    val novembre: Column[Int] = column[Int]("novembre")
    /** Database column decembre  */
    val decembre: Column[Int] = column[Int]("decembre")
    /** Database column janvier  */
    val janvier: Column[Int] = column[Int]("janvier")
    /** Database column fevrier  */
    val fevrier: Column[Int] = column[Int]("fevrier")
    /** Database column mars  */
    val mars: Column[Int] = column[Int]("mars")
    /** Database column avril  */
    val avril: Column[Int] = column[Int]("avril")
    /** Database column mai  */
    val mai: Column[Int] = column[Int]("mai")
    /** Database column juin  */
    val juin: Column[Int] = column[Int]("juin")
  }
  /** Collection-like TableQuery object for table Situation28august2014130405 */
  lazy val Situation28august2014130405 = new TableQuery(tag => new Situation28august2014130405(tag))
  
  /** Entity class storing rows of table Situation29october2013103413
   *  @param id Database column id AutoInc, PrimaryKey
   *  @param nom Database column nom 
   *  @param prenom Database column prenom 
   *  @param classe Database column classe 
   *  @param transport Database column transport 
   *  @param mensualite Database column mensualite 
   *  @param rabais Database column rabais 
   *  @param inscription Database column inscription 
   *  @param septembre Database column septembre 
   *  @param octobre Database column octobre 
   *  @param novembre Database column novembre 
   *  @param decembre Database column decembre 
   *  @param janvier Database column janvier 
   *  @param fevrier Database column fevrier 
   *  @param mars Database column mars 
   *  @param avril Database column avril 
   *  @param mai Database column mai 
   *  @param juin Database column juin  */
  case class Situation29october2013103413Row(id: Int, nom: String, prenom: String, classe: String, transport: Boolean, mensualite: Int, rabais: Int, inscription: Int, septembre: Int, octobre: Int, novembre: Int, decembre: Int, janvier: Int, fevrier: Int, mars: Int, avril: Int, mai: Int, juin: Int)
  /** GetResult implicit for fetching Situation29october2013103413Row objects using plain SQL queries */
  implicit def GetResultSituation29october2013103413Row(implicit e0: GR[Int], e1: GR[String], e2: GR[Boolean]): GR[Situation29october2013103413Row] = GR{
    prs => import prs._
    Situation29october2013103413Row.tupled((<<[Int], <<[String], <<[String], <<[String], <<[Boolean], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table situation_29october2013_103413. Objects of this class serve as prototypes for rows in queries. */
  class Situation29october2013103413(tag: Tag) extends Table[Situation29october2013103413Row](tag, "situation_29october2013_103413") {
    def * = (id, nom, prenom, classe, transport, mensualite, rabais, inscription, septembre, octobre, novembre, decembre, janvier, fevrier, mars, avril, mai, juin) <> (Situation29october2013103413Row.tupled, Situation29october2013103413Row.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, nom.?, prenom.?, classe.?, transport.?, mensualite.?, rabais.?, inscription.?, septembre.?, octobre.?, novembre.?, decembre.?, janvier.?, fevrier.?, mars.?, avril.?, mai.?, juin.?).shaped.<>({r=>import r._; _1.map(_=> Situation29october2013103413Row.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get, _16.get, _17.get, _18.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column nom  */
    val nom: Column[String] = column[String]("nom")
    /** Database column prenom  */
    val prenom: Column[String] = column[String]("prenom")
    /** Database column classe  */
    val classe: Column[String] = column[String]("classe")
    /** Database column transport  */
    val transport: Column[Boolean] = column[Boolean]("transport")
    /** Database column mensualite  */
    val mensualite: Column[Int] = column[Int]("mensualite")
    /** Database column rabais  */
    val rabais: Column[Int] = column[Int]("rabais")
    /** Database column inscription  */
    val inscription: Column[Int] = column[Int]("inscription")
    /** Database column septembre  */
    val septembre: Column[Int] = column[Int]("septembre")
    /** Database column octobre  */
    val octobre: Column[Int] = column[Int]("octobre")
    /** Database column novembre  */
    val novembre: Column[Int] = column[Int]("novembre")
    /** Database column decembre  */
    val decembre: Column[Int] = column[Int]("decembre")
    /** Database column janvier  */
    val janvier: Column[Int] = column[Int]("janvier")
    /** Database column fevrier  */
    val fevrier: Column[Int] = column[Int]("fevrier")
    /** Database column mars  */
    val mars: Column[Int] = column[Int]("mars")
    /** Database column avril  */
    val avril: Column[Int] = column[Int]("avril")
    /** Database column mai  */
    val mai: Column[Int] = column[Int]("mai")
    /** Database column juin  */
    val juin: Column[Int] = column[Int]("juin")
  }
  /** Collection-like TableQuery object for table Situation29october2013103413 */
  lazy val Situation29october2013103413 = new TableQuery(tag => new Situation29october2013103413(tag))
  
  /** Entity class storing rows of table Situation29october2013103414
   *  @param id Database column id AutoInc, PrimaryKey
   *  @param nom Database column nom 
   *  @param prenom Database column prenom 
   *  @param classe Database column classe 
   *  @param transport Database column transport 
   *  @param mensualite Database column mensualite 
   *  @param rabais Database column rabais 
   *  @param inscription Database column inscription 
   *  @param septembre Database column septembre 
   *  @param octobre Database column octobre 
   *  @param novembre Database column novembre 
   *  @param decembre Database column decembre 
   *  @param janvier Database column janvier 
   *  @param fevrier Database column fevrier 
   *  @param mars Database column mars 
   *  @param avril Database column avril 
   *  @param mai Database column mai 
   *  @param juin Database column juin  */
  case class Situation29october2013103414Row(id: Int, nom: String, prenom: String, classe: String, transport: Boolean, mensualite: Int, rabais: Int, inscription: Int, septembre: Int, octobre: Int, novembre: Int, decembre: Int, janvier: Int, fevrier: Int, mars: Int, avril: Int, mai: Int, juin: Int)
  /** GetResult implicit for fetching Situation29october2013103414Row objects using plain SQL queries */
  implicit def GetResultSituation29october2013103414Row(implicit e0: GR[Int], e1: GR[String], e2: GR[Boolean]): GR[Situation29october2013103414Row] = GR{
    prs => import prs._
    Situation29october2013103414Row.tupled((<<[Int], <<[String], <<[String], <<[String], <<[Boolean], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table situation_29october2013_103414. Objects of this class serve as prototypes for rows in queries. */
  class Situation29october2013103414(tag: Tag) extends Table[Situation29october2013103414Row](tag, "situation_29october2013_103414") {
    def * = (id, nom, prenom, classe, transport, mensualite, rabais, inscription, septembre, octobre, novembre, decembre, janvier, fevrier, mars, avril, mai, juin) <> (Situation29october2013103414Row.tupled, Situation29october2013103414Row.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, nom.?, prenom.?, classe.?, transport.?, mensualite.?, rabais.?, inscription.?, septembre.?, octobre.?, novembre.?, decembre.?, janvier.?, fevrier.?, mars.?, avril.?, mai.?, juin.?).shaped.<>({r=>import r._; _1.map(_=> Situation29october2013103414Row.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get, _16.get, _17.get, _18.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column nom  */
    val nom: Column[String] = column[String]("nom")
    /** Database column prenom  */
    val prenom: Column[String] = column[String]("prenom")
    /** Database column classe  */
    val classe: Column[String] = column[String]("classe")
    /** Database column transport  */
    val transport: Column[Boolean] = column[Boolean]("transport")
    /** Database column mensualite  */
    val mensualite: Column[Int] = column[Int]("mensualite")
    /** Database column rabais  */
    val rabais: Column[Int] = column[Int]("rabais")
    /** Database column inscription  */
    val inscription: Column[Int] = column[Int]("inscription")
    /** Database column septembre  */
    val septembre: Column[Int] = column[Int]("septembre")
    /** Database column octobre  */
    val octobre: Column[Int] = column[Int]("octobre")
    /** Database column novembre  */
    val novembre: Column[Int] = column[Int]("novembre")
    /** Database column decembre  */
    val decembre: Column[Int] = column[Int]("decembre")
    /** Database column janvier  */
    val janvier: Column[Int] = column[Int]("janvier")
    /** Database column fevrier  */
    val fevrier: Column[Int] = column[Int]("fevrier")
    /** Database column mars  */
    val mars: Column[Int] = column[Int]("mars")
    /** Database column avril  */
    val avril: Column[Int] = column[Int]("avril")
    /** Database column mai  */
    val mai: Column[Int] = column[Int]("mai")
    /** Database column juin  */
    val juin: Column[Int] = column[Int]("juin")
  }
  /** Collection-like TableQuery object for table Situation29october2013103414 */
  lazy val Situation29october2013103414 = new TableQuery(tag => new Situation29october2013103414(tag))
  
  /** Entity class storing rows of table Situation29october2013184824
   *  @param id Database column id AutoInc, PrimaryKey
   *  @param nom Database column nom 
   *  @param prenom Database column prenom 
   *  @param classe Database column classe 
   *  @param transport Database column transport 
   *  @param mensualite Database column mensualite 
   *  @param rabais Database column rabais 
   *  @param inscription Database column inscription 
   *  @param septembre Database column septembre 
   *  @param octobre Database column octobre 
   *  @param novembre Database column novembre 
   *  @param decembre Database column decembre 
   *  @param janvier Database column janvier 
   *  @param fevrier Database column fevrier 
   *  @param mars Database column mars 
   *  @param avril Database column avril 
   *  @param mai Database column mai 
   *  @param juin Database column juin  */
  case class Situation29october2013184824Row(id: Int, nom: String, prenom: String, classe: String, transport: Boolean, mensualite: Int, rabais: Int, inscription: Int, septembre: Int, octobre: Int, novembre: Int, decembre: Int, janvier: Int, fevrier: Int, mars: Int, avril: Int, mai: Int, juin: Int)
  /** GetResult implicit for fetching Situation29october2013184824Row objects using plain SQL queries */
  implicit def GetResultSituation29october2013184824Row(implicit e0: GR[Int], e1: GR[String], e2: GR[Boolean]): GR[Situation29october2013184824Row] = GR{
    prs => import prs._
    Situation29october2013184824Row.tupled((<<[Int], <<[String], <<[String], <<[String], <<[Boolean], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int]))
  }
  /** Table description of table situation_29october2013_184824. Objects of this class serve as prototypes for rows in queries. */
  class Situation29october2013184824(tag: Tag) extends Table[Situation29october2013184824Row](tag, "situation_29october2013_184824") {
    def * = (id, nom, prenom, classe, transport, mensualite, rabais, inscription, septembre, octobre, novembre, decembre, janvier, fevrier, mars, avril, mai, juin) <> (Situation29october2013184824Row.tupled, Situation29october2013184824Row.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (id.?, nom.?, prenom.?, classe.?, transport.?, mensualite.?, rabais.?, inscription.?, septembre.?, octobre.?, novembre.?, decembre.?, janvier.?, fevrier.?, mars.?, avril.?, mai.?, juin.?).shaped.<>({r=>import r._; _1.map(_=> Situation29october2013184824Row.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get, _16.get, _17.get, _18.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column id AutoInc, PrimaryKey */
    val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
    /** Database column nom  */
    val nom: Column[String] = column[String]("nom")
    /** Database column prenom  */
    val prenom: Column[String] = column[String]("prenom")
    /** Database column classe  */
    val classe: Column[String] = column[String]("classe")
    /** Database column transport  */
    val transport: Column[Boolean] = column[Boolean]("transport")
    /** Database column mensualite  */
    val mensualite: Column[Int] = column[Int]("mensualite")
    /** Database column rabais  */
    val rabais: Column[Int] = column[Int]("rabais")
    /** Database column inscription  */
    val inscription: Column[Int] = column[Int]("inscription")
    /** Database column septembre  */
    val septembre: Column[Int] = column[Int]("septembre")
    /** Database column octobre  */
    val octobre: Column[Int] = column[Int]("octobre")
    /** Database column novembre  */
    val novembre: Column[Int] = column[Int]("novembre")
    /** Database column decembre  */
    val decembre: Column[Int] = column[Int]("decembre")
    /** Database column janvier  */
    val janvier: Column[Int] = column[Int]("janvier")
    /** Database column fevrier  */
    val fevrier: Column[Int] = column[Int]("fevrier")
    /** Database column mars  */
    val mars: Column[Int] = column[Int]("mars")
    /** Database column avril  */
    val avril: Column[Int] = column[Int]("avril")
    /** Database column mai  */
    val mai: Column[Int] = column[Int]("mai")
    /** Database column juin  */
    val juin: Column[Int] = column[Int]("juin")
  }
  /** Collection-like TableQuery object for table Situation29october2013184824 */
  lazy val Situation29october2013184824 = new TableQuery(tag => new Situation29october2013184824(tag))
}