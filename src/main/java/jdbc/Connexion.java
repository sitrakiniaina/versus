package jdbc;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;


public class Connexion 
{
	private static Connection connex = null;
	
	
        public static Connection getConnection() throws Exception
	{ 
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://ec2-54-243-55-1.compute-1.amazonaws.com:5432/d5ocrmtn3mcgf?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
            Connection conn = DriverManager.getConnection(url, "mholelodpwokpc", "f5b5c73d8337495ff08bd1a33c76ed276f602e788ac8df247a8f815609dbab90");
            return conn;
	}
        /*public static Connection getConnection() throws Exception{
            URI dbUri = new URI(System.getenv("DATABASE_URL"));
            String user = dbUri.getUserInfo().split(":")[0];
            String pass = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ":" + dbUri.getPort() + dbUri.getPath();
            return DriverManager.getConnection(dbUrl,user,pass);
        }*/
        /*public static Connection getConnection() throws Exception
	{
		if(Connexion.connex==null || (Connexion.connex!=null && Connexion.connex.isClosed()))
		{
			Class.forName("org.postgresql.Driver");
	        connex = DriverManager.getConnection("jdbc:postgresql://localhost:5432/POSTVERSUS", "postgres", "herinihaja");
		}
		return Connexion.connex;
	}*/
}
