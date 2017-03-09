package restservice.databse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import restservice.config.GetPropertyValues;

public class DbConnection {
	
static String fileName="";

public	DbConnection(){}

public DbConnection(String fileName){DbConnection.fileName=fileName;}
	
public static Connection connectToDatabase() {
	Connection conn=null;
	
	try{	
	GetPropertyValues property = new GetPropertyValues();
	Properties prop = property.getPropValues(fileName);
		 
		 try{
		     
		     // Class.forName("com.mysql.jdbc.Driver");
		      Class.forName(prop.getProperty("className"));

		      System.out.println("Connecting to database...");
		     // conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","1234");
		      conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("password"));
		//System.out.println(prop.getProperty("port"));
		     
		 }
		 
		 catch(SQLException se){
		      
		      se.printStackTrace();
		   }catch(Exception e){
		     
		      e.printStackTrace();
		   }
		
	}catch(IOException ie){ie.printStackTrace();}
	
	return conn;
	}

}
