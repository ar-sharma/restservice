package restservice.databse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import restservice.model.User;



public class DbDelete {

	public ArrayList<User> deleteMessage(String name) {
		
		 ArrayList<User> userList=new ArrayList<User>();
		Statement stmt=null;
		try{
			
	      Connection connection=DbConnection.connectToDatabase();

		  System.out.println("Creating statement...");
	      stmt = connection.createStatement();
	      String sql;
	      String sql2;
	      sql = "DELETE from user WHERE name='"+name+"'";
	      sql2 = "DELETE from user1 WHERE name='"+name+"'";
	      stmt.executeUpdate(sql);
	      stmt.executeUpdate(sql2);
	      
	      String sql1;
	      sql1 = "SELECT * FROM user";
	      ResultSet rs = stmt.executeQuery(sql1);

	      
	      while(rs.next()) {
	    	  
	         User user = new User();
	         
	        user.setId(rs.getInt("id"));
	        user.setName(rs.getString("name"));
	        user.setTask(rs.getInt("task"));
	         userList.add(user);
	      }
	      
	    }
	      catch(SQLException se){
	        
	        se.printStackTrace();
	     }catch(Exception e){
	       
	        e.printStackTrace();
	     }
		
		return userList;
	}

}
