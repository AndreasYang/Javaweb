package student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Admin;

public class Logout extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			Admin admin = (Admin) session.getAttribute("name");
			session.invalidate();
		}
		
		resp.sendRedirect(req.getContextPath() + "/jsp/Login.jsp");
	}
}
