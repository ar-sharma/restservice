package restservice.databse;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;



public class TaskThread extends Thread {
	
	String name;
	public TaskThread(){}
	public TaskThread (String name) {
		this.name = name;
	}
	boolean run = true;

    public void run() {

        Random rnd = new Random();
       

        try {
        	
            while(run == true) {

                // ..
                // Do whatever a client does ..
                // ..

                Integer sleepTime = rnd.nextInt(50000);

             Thread.sleep(sleepTime);

               Statement stmt = null;
               Connection connection=DbConnection.connectToDatabase();
     	      

     		  System.out.println("Creating statement1...");
     	      stmt = connection.createStatement();
     	      String sql;
     	      String sql2;
     	     
     	      sql = "UPDATE user1 SET task='2' where name='"+name+"'";
     	      sql2 = "UPDATE user SET task='2' where name='"+name+"'";
     	   int rowsUpdated1 = stmt.executeUpdate(sql);
     	   int rowsUpdated2 = stmt.executeUpdate(sql2);
     	    
     	    if (rowsUpdated1>0 && rowsUpdated2>0) {
     	    	run = false;
     	    }
            }

        } catch(InterruptedException v) {
            System.out.println(v);
        } catch (SQLException e) {
			
			e.printStackTrace();
		}
    } 
	
}
