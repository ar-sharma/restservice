package restservice.databse;

import java.sql.Connection;
import java.sql.Statement;



import restservice.model.User;

public class DbInsert {

	public void insertInDb(User user) {
		
		int id = user.getId();
		String name = user.getName();
		
		Statement stmt = null;
		
		try {
			
			Connection connection = DbConnection.connectToDatabase();
			
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

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
