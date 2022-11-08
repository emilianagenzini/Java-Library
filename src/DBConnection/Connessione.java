package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Connessione {
	 
    private static Connection conn = null;
     
    private Connessione() {}

    public static Connection connect() {
         if(conn == null) {
        
       try {
    	   Class.forName("org.postgresql.Driver");
           System.out.println("Caricamento Driver...");
       }
       catch(ClassNotFoundException e) {
			System.err.println("Errore caricamento Driver: "+e.getMessage());
	   } 
       String url = "jdbc:postgresql:Progetto-OO-BD" ;
  	   String user = "postgres";
       String pwd = "laika";
       /* conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            catch (SQLException e) {
            System.out.println(e.getMessage()); */
       try {
			conn = DriverManager.getConnection(url,user,pwd);
			System.out.println("Connessione avvenuta...");
		}
		catch(SQLException sql) {
			System.err.println("Errore connessione: " + sql.getMessage());
		}
	}
       
       return conn;
    }


     
}

