package restservice.databse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import restservice.model.User;



public class DbAccess {

	 public ArrayList<User> accessingDatabase() throws SQLException {
	    	
		    ArrayList<User> empList=new ArrayList<User>();

			Statement stmt=null;
			try{
				
		      Connection connection=DbConnection.connectToDatabase();

			  System.out.println("Creating statement...");
		      stmt = connection.createStatement();
		      String sql;
		      sql = "SELECT * FROM user";
		      ResultSet rs = stmt.executeQuery(sql);

		      
		      while(rs.next()) {
		    	  
		         User user=new User();
		         
		         user.setId(rs.getInt("id"));
		         user.setName(rs.getString("name"));
		         user.setTask(rs.getInt("task"));
		         empList.add(user);
		         
		        
		         System.out.println(rs.getInt("id"));
		         System.out.println(rs.getInt("task"));
		       }
		      
		    } catch(SQLException se){
		        
		        se.printStackTrace();
		     }catch(Exception e){
		       
		        e.printStackTrace();
		     }
			
			return empList;
		 }
}
