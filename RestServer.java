package restservice.main;

import javax.servlet.Servlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

import restservice.resources.WatchResource;



public class RestServer {
	
public static void main(String[] args) throws Exception {
		
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		
		Server server = new Server(7070);
		server.setHandler(context);
		
		ServletHolder jerseyServlet = context.addServlet((Class<? extends Servlet>) ServletContainer.class, "/*");
		jerseyServlet.setInitOrder(0);
		
		jerseyServlet.setInitParameter("jersey.config.server.provider.classnames", WatchResource.class.getCanonicalName());
		
		try {
			server.start();
			server.join();
		} finally {
			server.destroy();
		}
	}

}
