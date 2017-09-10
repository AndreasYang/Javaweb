package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


public class LoginServlet extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String maxOnline = config.getInitParameter("maxOnline");
		System.out.println("maxOnline:"+maxOnline);
	}
}
