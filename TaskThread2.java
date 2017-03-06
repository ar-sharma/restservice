/**package restservice.databse;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class TaskThread2 extends Thread {

	String name;
	public TaskThread2(){}
	public TaskThread2 (String name) {
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
     	      

     		  System.out.println("Creating statement2...");
     	      stmt = connection.createStatement();
     	      String sql;
     	      String sql2;
     	     
     	      sql = "UPDATE user1 SET task='0' where name='"+name+"'";
     	      sql2 = "UPDATE user SET task='0' where name='"+name+"'";
     	     stmt.executeUpdate(sql);
     	     stmt.executeUpdate(sql2);
            }

        } catch(InterruptedException v) {
            System.out.println(v);
        } catch (SQLException e) {
			
			e.printStackTrace();
		}
    } 
	
	
}
*/