package restservice.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restservice.databse.DatabaseMethods;
import restservice.model.User;
import restservice.model.User1;

public class WatchService {

	DatabaseMethods dbm = new DatabaseMethods();
	
	public List<User> getAllUsers() throws SQLException {
		//DbAccess db = new DbAccess();
		
		return new ArrayList<User>(dbm.accessingDatabase());
	}
	
	public void addUser(User user) throws SQLException {
		//DbAccess da = new DbAccess();
		ArrayList<User> list=dbm.accessingDatabase();
		user.setId(list.size()+1);
		//DbInsert di = new DbInsert();
		dbm.insertInDb(user);
	}
	
	public User1 getUser(String name) throws SQLException {
		
		//DbAcessWithName dbi = new DbAcessWithName();
		User1 usr = dbm.dbAccess(name);
		return usr;
	}
	
	public void updateUser(String name) throws SQLException {
		
		//DbUpdate du = new DbUpdate();
		dbm.updatingDb(name);
	}
	
	public String updateUser1(String name) throws SQLException {
		
		//DbUpdate1 du = new DbUpdate1();
		return dbm.updatingDb1(name);
	} 
	
	public ArrayList<User> removeUser(String name) throws SQLException{
		//DbDelete dd=new DbDelete();
		return dbm.deleteMessage(name);
		
	}
}
