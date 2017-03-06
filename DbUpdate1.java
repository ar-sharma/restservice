package restservice.databse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUpdate1 {

public String updatingDb(String name) {
		String t = null;
		Statement stmt=null;
		try{
			
	      Connection connection=DbConnection.connectToDatabase();
	      

		  System.out.println("Creating statement...");
	      stmt = connection.createStatement();
	      String sql1;
	      String sql2;
	      java.util.Date date1=new java.util.Date();
          
          java.sql.Timestamp sqlTime1=new java.sql.Timestamp(date1.getTime());
	      sql1 = "UPDATE user1 SET end='"+sqlTime1+"' where name='"+name+"'";
	      sql2 = " SELECT TIMESTAMPDIFF(SECOND, start, end) as diff from user1 where name='"+name+"'";
	       
	      int rowsUpdated =  stmt.executeUpdate(sql1);
	      if (rowsUpdated > 0) {
	          System.out.println("An existing user was updated successfully!");
	      }
	      
	    ResultSet rs= stmt.executeQuery(sql2);
	   boolean a=rs.first();
	   System.out.println(a);
	     t = rs.getString("diff");
	    System.out.println(t);
	   
	    } catch(SQLException se){
	        
	        se.printStackTrace();
	     }catch(Exception e){
	       
	        e.printStackTrace();
	     }
		return t;
		
	}
}
