// import org.sql2o.*;

// public class DB {
//  public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_saalon", "moringa", "options");
// }

import org.sql2o.*;
import java.net.URI;
import java.net.URISyntaxException;
public class DB {
    private static URI dbUri;
    public static Sql2o sql2o;
    static {

        try {
            if (System.getenv("DATABASE_URL") == null) {
                dbUri = new URI("postgres://stgdvqrtkcidbh:426ae5ca78a83d4202bdb66d5d56afb3f0c2a9905626ecd5978329e95389316b@ec2-50-17-227-28.compute-1.amazonaws.com:5432/ddi8f6pdq87uf7@localhost:5432/hair_salon");
            } else {
                dbUri = new URI(System.getenv("DATABASE_URL"));
            }
            int port = dbUri.getPort();
            String host = dbUri.getHost();
            String path = dbUri.getPath();
            String username = (dbUri.getUserInfo() == null) ? null : dbUri.getUserInfo().split(":")[0];
            String password = (dbUri.getUserInfo() == null) ? null : dbUri.getUserInfo().split(":")[1];
            sql2o = new Sql2o("jdbc:postgresql://" + host + ":" + port + path, username, password);
        } catch (URISyntaxException e ) {

        }
    }
}
