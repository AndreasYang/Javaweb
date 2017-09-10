package student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.service.IStudentService;
import student.service.StudentServiceImpl;
import vo.Admin;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String checkCode = req.getParameter("checkCode");
		String checkCodeSession = (String) req.getSession().getAttribute("checkCodeSession");
		if (checkCode == null) {
			resp.sendRedirect(req.getContextPath()+"/Login.jsp");
			return;
		}
		if (!checkCode.equalsIgnoreCase(checkCodeSession)) {
			resp.sendRedirect(req.getContextPath()+"/Login.jsp");
			
		}
		
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		IStudentService service = new StudentServiceImpl();
		Admin admin = service.findByNameAndPassword(name, password);
		if (admin != null) {
			HttpSession session = req.getSession();
			session.setAttribute("admin", admin);
			List<Admin> onlineAdminList = (List<Admin>) getServletContext().getAttribute("onlineAdminList");
			onlineAdminList.add(admin);
			resp.sendRedirect(req.getContextPath()+"/student?method=PageList");
		}else {
			resp.sendRedirect(req.getContextPath()+"/html/LoginFail.html");
		}
	}

}
