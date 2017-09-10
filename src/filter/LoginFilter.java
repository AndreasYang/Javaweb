package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import student.pojo.Student;
import vo.Admin;

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		String requestPath = uri.substring(uri.lastIndexOf("/")+1, uri.length());
		if (requestPath.equals("Login.jsp") 
				|| requestPath.equals("Login")
				||requestPath.equals("checkImg")) {
			chain.doFilter(request, response);
		}else {
			HttpSession session = req.getSession();
			Admin admin = (Admin) session.getAttribute("admin");
			if (admin == null) {
				resp.sendRedirect(req.getContextPath() + "/jsp/Login.jsp");
				return;
			} else {
				chain.doFilter(request, response);
			} 
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
