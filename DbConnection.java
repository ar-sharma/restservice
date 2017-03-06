package restservice.databse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
public static Connection connectToDatabase() {
		
		Connection conn=null;
		 try{
		     
		      Class.forName("com.mysql.jdbc.Driver");

		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","1234");
		
		     
		 }
		 
		 catch(SQLException se){
		      
		      se.printStackTrace();
		   }catch(Exception e){
		     
		      e.printStackTrace();
		   }
		return conn;
		  
	}

}
