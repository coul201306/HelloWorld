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



public class HelloWorld2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		String username = req.getParameter("username");
		String psw = req.getParameter("password");
		if(username!=null&&psw!=null&&username.equalsIgnoreCase("admin")&&psw.equalsIgnoreCase("123456")){
			resp.getWriter().print("login success!\n");
		}else{
			resp.getWriter().print("login failed!\n");
		}
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    	doGet(req,resp);
    }
}