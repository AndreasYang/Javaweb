package student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import student.pojo.Student;
import student.service.IStudentService;
import student.service.StudentServiceImpl;
import vo.Admin;
import vo.PageBean;
import vo.SearchCondition;

public class StudentServlet extends BaseServlet {

	IStudentService studentService = new StudentServiceImpl();

	/*
	 * @Override protected void service(HttpServletRequest req,
	 * HttpServletResponse resp) throws ServletException, IOException { String
	 * servletPath = req.getServletPath(); System.out.println(servletPath);
	 * 
	 * // 获得HttpSession HttpSession session = req.getSession(); String userName
	 * = (String) session.getAttribute("userName"); if (userName == null) {
	 * resp.sendRedirect(req.getContextPath()+"/html/Login.html"); return; }
	 * 
	 * if("/AddStudent.do".equals(servletPath)){ AddStudent(req, resp); }else if
	 * ("/FindAllStudents.do".equals(servletPath)) { FindAllStudents(req, resp);
	 * }else if ("/UpdateStudent.do".equals(servletPath)) { UpdateStudent(req,
	 * resp); }else if ("/FindByName.do".equals(servletPath)) { FindByName(req,
	 * resp); }else if ("/DeleteByName.do".equals(servletPath)) {
	 * DeleteByName(req, resp); }else if
	 * ("/ToUpdateStudent.do".equals(servletPath)) { ToUpdateStudent(req, resp);
	 * } }
	 */

	private void ToUpdateStudent(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String searchname = req.getParameter("searchname");
		IStudentService service = new StudentServiceImpl();
		List<Student> list = service.findByName(searchname);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/jsp/updateStudent.jsp").forward(req, resp);

	}

	private void DeleteByName(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name = req.getParameter("name");
		IStudentService service = new StudentServiceImpl();

		service.deleteByName(name);

		resp.sendRedirect(req.getContextPath() + "/student?method=PageList");
	}

	private void FindByName(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String searchname = req.getParameter("searchname");

		IStudentService service = new StudentServiceImpl();
		List<Student> list = service.findByName(searchname);

		req.setAttribute("list", list);
		req.getRequestDispatcher("/jsp/findAllStudents.jsp").forward(req, resp);
		/*
		 * resp.setContentType("text/html;charset=utf-8"); PrintWriter
		 * printWriter = resp.getWriter(); printWriter.println(
		 * "<a href='/Java1707web/html/add_Student.html'>添加<a/>");
		 * printWriter.println("<table border='1px' cellspacing='0'>");
		 * printWriter.println("<tr>"); printWriter.println("<td>id</td>");
		 * printWriter.println("<td>Number</td>");
		 * printWriter.println("<td>Name</td>");
		 * printWriter.println("<td>Age</td>");
		 * printWriter.println("<td>Gender</td>");
		 * printWriter.println("<td>Address</td>");
		 * printWriter.println("</tr>"); for(Student student : list){
		 * printWriter.println("<tr>"); printWriter.println("    <td>" +
		 * student.getId() + "</td>"); printWriter.println("	 <td>" +
		 * student.getNumber()+"</td>"); printWriter.println("    <td>" +
		 * student.getName() + "</td>"); printWriter.println("    <td>" +
		 * student.getAge() + "</td>"); printWriter.println("    <td>" +
		 * student.getGender() + "</td>"); printWriter.println("    <td>" +
		 * student.getAddress() + "</td>"); printWriter.println("</tr>");
		 * 
		 * } printWriter.println("</table>");
		 * 
		 * printWriter.close();
		 */
	}

	private void UpdateStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String number = req.getParameter("number");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String address = req.getParameter("address");
		String searchname = req.getParameter("name");

		Student student = new Student(Integer.parseInt(number), name, gender, Integer.parseInt(age), address,
				searchname);
		IStudentService service = new StudentServiceImpl();

		service.update(student);

		resp.sendRedirect(req.getContextPath() + "/student?method=PageList");
	}

	private void FindAllStudents(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		IStudentService service = new StudentServiceImpl();
		List<Student> list = service.findall();

		req.setAttribute("list", list);
		req.getRequestDispatcher("/jsp/findAllStudents.jsp").forward(req, resp);

		/*
		 * resp.setContentType("text/html;charset=utf-8"); PrintWriter
		 * printWriter = resp.getWriter(); printWriter.println(
		 * "<a href='/Java1707web/html/add_Student.html'>添加<a/>");
		 * printWriter.print("<h1>欢迎回来" + userName + "</h1>");
		 * printWriter.println("<a href='/Java1707web/Logout'>退出</a>");
		 * printWriter.println("<table border='1px' cellspacing='0'>");
		 * printWriter.println("<tr>"); printWriter.println("<td>id</td>");
		 * printWriter.println("<td>Number</td>");
		 * printWriter.println("<td>Name</td>");
		 * printWriter.println("<td>Age</td>");
		 * printWriter.println("<td>Gender</td>");
		 * printWriter.println("<td>Address</td>");
		 * printWriter.println("</tr>"); for(Student student : list){
		 * printWriter.println("<tr>"); printWriter.println("    <td>" +
		 * student.getId() + "</td>"); printWriter.println("	 <td>"
		 * +student.getNumber()+"</td>"); printWriter.println("    <td>" +
		 * student.getName() + "</td>"); printWriter.println("    <td>" +
		 * student.getAge() + "</td>"); printWriter.println("    <td>" +
		 * student.getGender() + "</td>"); printWriter.println("    <td>" +
		 * student.getAddress() + "</td>"); printWriter.println("</tr>");
		 * 
		 * } printWriter.println("</table>");
		 * 
		 * printWriter.close();
		 */

	}

	private void AddStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String number = req.getParameter("number");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String address = req.getParameter("address");

		Student student = new Student(Integer.parseInt(number), name, gender, Integer.parseInt(age), address);
		IStudentService service = new StudentServiceImpl();

		service.add(student);

		resp.sendRedirect(req.getContextPath() + "/student?method=PageList");

	}

	private void PageList(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String pageIndexStr = req.getParameter("pageIndex");
		String pageSizeStr = req.getParameter("pageSize");
		int pageIndex = 1;
		if (pageIndexStr != null && !pageIndexStr.equals("")) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		int pageSize = 4;
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}

		IStudentService service = new StudentServiceImpl();
		PageBean pageBean = service.getPageBean(pageIndex, pageSize);
		System.out.println(pageBean);
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("/jsp/findAllStudents.jsp").forward(req, resp);

	}

	private void searchByCondition(HttpServletRequest req, HttpServletResponse resp)throws IOException, ServletException {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String pageIndexStr = req.getParameter("pageIndex");
		String pageSizeStr = req.getParameter("pageSize");
		int pageIndex = 1;
		if (pageIndexStr != null && !pageIndexStr.equals("")) {
			pageIndex = Integer.parseInt(pageIndexStr);
		}
		int pageSize = 4;
		if (pageSizeStr != null && !pageIndexStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		SearchCondition searchCondition = new SearchCondition(pageIndex, pageSize, name, age, gender);
		System.out.println(searchCondition);
		IStudentService service = new StudentServiceImpl();
		PageBean pageBean = service.searchByCondition(searchCondition);
		req.setAttribute("pageBean", pageBean);
		req.setAttribute("searchCondition", searchCondition);
		req.getRequestDispatcher("/jsp/searchStudent.jsp").forward(req, resp);
	}
	
	private void CheckName(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String name = req.getParameter("name");
		IStudentService service = new StudentServiceImpl();
		boolean isExist = service.checkName(name);
		String str = "{\"isExist\":"+isExist+"}";
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write(str);
	}
	
	private void DeleteAll(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		IStudentService service = new StudentServiceImpl();
		String[] names = req.getParameterValues("selectNames");
		service.deleteAll(names);
		resp.sendRedirect(req.getContextPath() + "/student?method=PageList");
	}
	
	private void getOnLineList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/onlineAdminList.jsp").forward(request, response);
	}
	private void getSearchPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/searchStudent.jsp").forward(req, resp);
	}
	private void getAddPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/addStudent.jsp").forward(req, resp);
	}
}
