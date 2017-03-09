package restservice.main;

import java.util.Properties;

import javax.servlet.Servlet;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

import restservice.config.GetPropertyValues;
import restservice.databse.DbConnection;
import restservice.resources.WatchResource;

public class RestServer {
	
	final static Logger logger = Logger.getLogger(RestServer.class);
	
   public static void main(String[] args) throws Exception {
	   
	   String fileName="";
	   if(args[0].equals("-c") && args[1]!=null){fileName = args[1];}
	  
	    new DbConnection(fileName);
	    
	    GetPropertyValues property = new GetPropertyValues();
	    Properties prop = property.getPropValues(fileName);
	   
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		
		//Server server = new Server(7070);
		Server server = new Server(Integer.parseInt(prop.getProperty("port")));
		server.setHandler(context);
		
		ServletHolder jerseyServlet = context.addServlet((Class<? extends Servlet>) ServletContainer.class, "/*");
		jerseyServlet.setInitOrder(0);
		
		//jerseyServlet.setInitParameter("jersey.config.server.provider.classnames", WatchResource.class.getCanonicalName());
		jerseyServlet.setInitParameter(prop.getProperty("initParamName"), WatchResource.class.getCanonicalName());
		
	   
		try {
			server.start();
			
			logger.info("Info message");
			
			server.join();
		} finally {
			server.destroy();
		}
	}

}
