package restservice.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import restservice.databse.TaskThread;
//import restservice.databse.TaskThread2;
import restservice.model.User;
import restservice.model.User1;
import restservice.services.WatchService;

@Path("/user")
public class WatchResource {
	
	WatchService watchService = new WatchService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUser() throws SQLException {
		
		return watchService.getAllUsers();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addUser(User user) throws SQLException {
		 watchService.addUser(user);
		 return "User Created";
	}
	
	@GET
	@Path("/{userName}")
	@Produces(MediaType.APPLICATION_JSON)
	public User1 getUser(@PathParam("userName") String name) throws SQLException {
		TaskThread taskThread = new TaskThread(name);
		//TaskThread2 taskThread2 = new TaskThread2(name);
		taskThread.start();
		//taskThread2.start();
		return watchService.getUser(name);
		
	}
	
	@PUT
	@Path("/{userName}/start")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateUser(@PathParam("userName") String name) throws SQLException {
		watchService.updateUser(name);
	}
	
	@PUT
	@Path("/{userName}/end")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateUser1(@PathParam("userName") String name) throws SQLException {
		return "TimeDiffOfServer="+ watchService.updateUser1(name);
	} 
	
	@DELETE
	@Path("/{userName}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> deleteUser(@PathParam("userName") String name) throws SQLException{
		return watchService.removeUser(name);
	}

}
