import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;


public class HelloWorld extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {	
    	
    	System.out.println(req.getRealPath("/")+"/index.jsp");
		resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }

    public static void main(String[] args) throws Exception{
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
//        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        context.setContextPath("/");
//        server.setHandler(context);
//        context.addServlet(new ServletHolder(new HelloWorld()),"/*");

		final URL warUrl = new File("web.xml").toURI().toURL();
		final String warUrlString = warUrl.toExternalForm();
		WebAppContext context = new WebAppContext(warUrlString, "/");
		context.setResourceBase("");
//		context.setWelcomeFiles(new String[]{"/index.jsp"});
		ServletHandler servletHandler = new ServletHandler();
		servletHandler.addServletWithMapping(new ServletHolder(new HelloWorld()),"/login");
		servletHandler.addServletWithMapping(new ServletHolder(new HelloWorld2()),"/loginSub");
		context.setServletHandler(servletHandler);
        server.setHandler(context);
        
		server.start();
        server.join();   
    }
}