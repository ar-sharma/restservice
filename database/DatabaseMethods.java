package restservice.databse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import restservice.model.User;
import restservice.model.User1;

public class DatabaseMethods {

	final static Logger logger = Logger.getLogger(DatabaseMethods.class);
	
	 Connection connection=DbConnection.connectToDatabase();
	 
	 
	 public ArrayList<User> accessingDatabase() throws SQLException {
	    	
		    ArrayList<User> empList=new ArrayList<User>();

			Statement stmt=null;
			try{
				
			  System.out.println("Creating statement...");
		      stmt = connection.createStatement();
		      String sql;
		      sql = "SELECT * FROM user";
		      ResultSet rs = stmt.executeQuery(sql);

		      logger.info("Accessing users");
		      System.out.println(logger.getAllAppenders());
		      
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
		        logger.error(se);
		     }catch(Exception e){
		       
		        e.printStackTrace();
		     }
			
			return empList;
		 }
	 
	 public User1 dbAccess(String name) {
			
			User1 user1 = new User1();
			
			Statement stmt = null;
			
			try {
				
				System.out.println("Creating statement");
				
				stmt = connection.createStatement();
				String sql;
				sql = "Select * from user where name='"+name+"'";
				ResultSet rs = stmt.executeQuery(sql);
				logger.info("Accessing users' task");
				
				while(rs.next()) {
					
					user1.setId(rs.getInt("id"));
					user1.setName(rs.getString("name"));
					user1.setTask(rs.getInt("task"));
					user1.setStart("null");
					user1.setEnd("null");
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return user1;
		}
	 
	 public void insertInDb(User user) {
			
			int id = user.getId();
			String name = user.getName();
			
			Statement stmt = null;
			
			try {
				System.out.println("Creating statement...");
				stmt = connection.createStatement();
				
				String sql;
				String sql1;
				
				java.util.Date date = new java.util.Date();
				java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
		          
			      sql = "insert into user values('"+id+"','"+name+"','1')";
			      sql1 = "insert into user1 values('"+id+"','"+name+"','1','"+sqlTime+"','"+sqlTime+"')";
			      stmt.executeUpdate(sql);
			      stmt.executeUpdate(sql1);
			      logger.info("Insert users");

			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	 
	 public void updatingDb(String name) {
			
			Statement stmt=null;
			try{
		      
			  System.out.println("Creating statement...");
		      stmt = connection.createStatement();
		      String sql;
		      java.util.Date date=new java.util.Date();
	          
	          java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
		      sql = "UPDATE user1 SET start='"+sqlTime+"' where name='"+name+"'";
		     
		      logger.info("Starting user task");
		       
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
	 
	 public String updatingDb1(String name) {
			String t = null;
			Statement stmt=null;
			try{
				
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
		    
		    logger.info("Ending user task");
		   
		    } catch(SQLException se){
		        
		        se.printStackTrace();
		     }catch(Exception e){
		       
		        e.printStackTrace();
		     }
			return t;
			
		}
	 
	 public ArrayList<User> deleteMessage(String name) {
			
		 ArrayList<User> userList=new ArrayList<User>();
		Statement stmt=null;
		try{
			

		  System.out.println("Creating statement...");
	      stmt = connection.createStatement();
	      String sql;
	      String sql2;
	      sql = "DELETE from user WHERE name='"+name+"'";
	      sql2 = "DELETE from user1 WHERE name='"+name+"'";
	      stmt.executeUpdate(sql);
	      stmt.executeUpdate(sql2);
	      
	      logger.info("Deleting users");
	      
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
