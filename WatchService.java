package restservice.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import restservice.databse.DbAccess;
import restservice.databse.DbAcessWithName;
import restservice.databse.DbDelete;
import restservice.databse.DbInsert;
import restservice.databse.DbUpdate;
import restservice.databse.DbUpdate1;
import restservice.model.User;
import restservice.model.User1;

public class WatchService {

	public List<User> getAllUsers() throws SQLException {
		DbAccess db = new DbAccess();
		return new ArrayList<User>(db.accessingDatabase());
	}
	
	public void addUser(User user) throws SQLException {
		DbAccess da = new DbAccess();
		ArrayList<User> list=da.accessingDatabase();
		user.setId(list.size()+1);
		DbInsert di = new DbInsert();
		di.insertInDb(user);
	}
	
	public User1 getUser(String name) throws SQLException {
		
		DbAcessWithName dbi = new DbAcessWithName();
		User1 usr = dbi.dbAccess(name);
		return usr;
	}
	
	public void updateUser(String name) throws SQLException {
		
		DbUpdate du = new DbUpdate();
		du.updatingDb(name);
	}
	
	public String updateUser1(String name) throws SQLException {
		
		DbUpdate1 du = new DbUpdate1();
		return du.updatingDb(name);
	} 
	
	public ArrayList<User> removeUser(String name) throws SQLException{
		DbDelete dd=new DbDelete();
		return dd.deleteMessage(name);
		
	}
}
