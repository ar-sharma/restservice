package restservice.databse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import restservice.model.User1;

public class DbAcessWithName {

	public User1 dbAccess(String name) {
		
		User1 user1 = new User1();
		
		Statement stmt = null;
		
		try {
			
			Connection connection = DbConnection.connectToDatabase();
			
			System.out.println("Creating statement");
			
			stmt = connection.createStatement();
			String sql;
			sql = "Select * from user where name='"+name+"'";
			ResultSet rs = stmt.executeQuery(sql);
			
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
}
