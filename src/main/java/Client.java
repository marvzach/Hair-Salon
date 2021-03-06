import java.util.List;
import org.sql2o.*;

public class Client {
  private int id;
  private String name;
  private int stylistId;

  public Client(String name, int stylistId) {
    this.name = name;
    this.stylistId = stylistId;
  }

  public String getName(){
    return name;
  }

  public int getId() {
    return id;
  }

  public int getStylistId() {
    return stylistId;
  }
  @Override
  public boolean equals(Object anotherClient) {
    if(!(anotherClient instanceof Client)){
      return false;
    }else {
      Client newClient = (Client) anotherClient;
      return this.getName().equals(newClient.getName()) &&
      this.getId() == newClient.getId() &&
      this.getStylistId() == newClient.getStylistId();
    }
  }
  public static List <Client> all(){
    String sql = "SELECT id, name, stylistId FROM clients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

  public void save(){
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (name, stylistId) VALUES (:name, :stylistId)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("stylistId", this.stylistId)
      .executeUpdate()
      .getKey();
    }
  }

  public static Client find (int id){
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE id=:id";
      Client client = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Client.class);
      return client;
    }
  }

  public void update(String name) {
   try(Connection con = DB.sql2o.open()) {
     String sql = "UPDATE clients SET name = :name WHERE id = :id";
     con.createQuery(sql)
     .addParameter("name", name)
     .addParameter("id", id)
     .executeUpdate();
   }
 }

}
