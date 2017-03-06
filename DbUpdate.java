package restservice.databse;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class DbUpdate {

public void updatingDb(String name) {
		
		Statement stmt=null;
		try{
			
	      Connection connection=DbConnection.connectToDatabase();
	      

		  System.out.println("Creating statement...");
	      stmt = connection.createStatement();
	      String sql;
	      java.util.Date date=new java.util.Date();
          
          java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
	      sql = "UPDATE user1 SET start='"+sqlTime+"' where name='"+name+"'";
	     
	       
	      int rowsUpdated =  stmt.executeUpdate(sql);
	      if (rowsUpdated > 0) {
	          System.out.println("An existing user was updated successfully!");
	      }
	    
	      
	    } catch(SQLException se){
	        
	        se.printStackTrace();
	     }catch(Exception e){
	       
	        e.printStackTrace();
	     }
		
	}
}
