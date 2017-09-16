package student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import student.pojo.Banji;
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
		String banjiId= req.getParameter("banjiId");

		Student student = new Student(Integer.parseInt(number), name, gender, Integer.parseInt(age), address, Integer.parseInt(banjiId));
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

	private void searchByCondition(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
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

	private void CheckName(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name = req.getParameter("name");
		IStudentService service = new StudentServiceImpl();
		boolean isExist = service.checkName(name);
		String str = "{\"isExist\":" + isExist + "}";
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write(str);
	}

	private void DeleteAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		IStudentService service = new StudentServiceImpl();
		String[] names = req.getParameterValues("selectNames");
		service.deleteAll(names);
		resp.sendRedirect(req.getContextPath() + "/student?method=PageList");
	}

	private void BanjiList(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		IStudentService service = new StudentServiceImpl();
		List<Banji> list = service.findBanji();
		System.out.println(list);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/jsp/banji_list.jsp").forward(req, resp);
	}
	
	private void AddBanji(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String classname = req.getParameter("classname");
		Banji banji = new Banji(classname);
		IStudentService service = new StudentServiceImpl();
		service.addBanji(banji);
		
		resp.sendRedirect(req.getContextPath()+"/student?method=BanjiList");
	}

	private void BanjiCoursePageList(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
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
		PageBean pageBean = service.getBanjiPageBean(pageIndex, pageSize);
		System.out.println(pageBean);
		req.setAttribute("pageBean", pageBean);
		req.getRequestDispatcher("/jsp/banji_course_list.jsp").forward(req, resp);
	}
	
	private void DeleteBanjie(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String classname = req.getParameter("name");
		IStudentService service = new StudentServiceImpl();

		service.deleteBanjie(classname);

		resp.sendRedirect(req.getContextPath() + "/student?method=BanjiList");
	}
	
	private void CourseList(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		IStudentService service = new StudentServiceImpl();
		List<Banji> list = service.findCourse();
		System.out.println(list);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/jsp/course_list.jsp").forward(req, resp);
	}
	
	private void DeleteAllBanji(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		IStudentService service = new StudentServiceImpl();
		String[] names = req.getParameterValues("selectClassnames");
		service.deleteAllBanji(names);
		resp.sendRedirect(req.getContextPath() + "/student?method=BanjiList");
	}

	private void AddCourse(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String coursename = req.getParameter("coursename");
		String points = req.getParameter("points");
		Banji banji = new Banji(coursename, Integer.parseInt(points));
		IStudentService service = new StudentServiceImpl();
		service.addCourse(banji);
		
		resp.sendRedirect(req.getContextPath()+"/student?method=CourseList");
	}
	
	private void DeleteCourse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String coursename = req.getParameter("name");
		IStudentService service = new StudentServiceImpl();

		service.deleteCourse(coursename);

		resp.sendRedirect(req.getContextPath() + "/student?method=CourseList");
	}
	
	private void DeleteAllCourse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		IStudentService service = new StudentServiceImpl();
		String[] coursenames = req.getParameterValues("selectCoursenames");
		service.deleteAllCourse(coursenames);
		resp.sendRedirect(req.getContextPath() + "/student?method=CourseList");
	}
	
	private void ToUpdateCourse(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String coursename = req.getParameter("name");
		IStudentService service = new StudentServiceImpl();
		List<Banji> list = service.findcourse(coursename);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/jsp/course_update.jsp").forward(req, resp);

	}
	
	private void UpdateCourse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String coursename = req.getParameter("searchcoursename");
		
		String points = req.getParameter("points");

		Banji banji = new Banji(coursename, Integer.parseInt(points));
		IStudentService service = new StudentServiceImpl();

		service.updateCourse(banji);

		resp.sendRedirect(req.getContextPath() + "/student?method=CourseList");
	}
	
	private void AddBanjiCourse(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String banjiId = req.getParameter("banjiId");
		String courseId = req.getParameter("courseId");
		System.out.println(banjiId);
		System.out.println(courseId);
		
		IStudentService service = new StudentServiceImpl();
		Banji banji = new Banji(Integer.parseInt(banjiId), Integer.parseInt(courseId));
		service.addBanjiCourse(banji);
		
		resp.sendRedirect(req.getContextPath()+"/student?method=BanjiCoursePageList");
	}
	
	private void SearchBanjiCourse(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		String classname = req.getParameter("classname");
		IStudentService service = new StudentServiceImpl();
		List<Map<String, Object>> list = service.searchBanjiCourse(classname);
		req.setAttribute("list", list);
		System.out.println(list);
		req.getRequestDispatcher("/jsp/banji_course_search.jsp").forward(req, resp);;
		
	}
	
	private void DeleteBanjiCourse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String bcId = req.getParameter("bcId");
		IStudentService service = new StudentServiceImpl();

		service.deleteBanjiCourse(Integer.parseInt(bcId));

		resp.sendRedirect(req.getContextPath() + "/student?method=BanjiCoursePageList");
	}
	
	
	private void getOnLineList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/onlineAdminList.jsp").forward(request, response);
	}

	private void getSearchPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/searchStudent.jsp").forward(req, resp);
	}

	private void getAddPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IStudentService service = new StudentServiceImpl();
		List<Banji> banji = service.findBanji();
		System.out.println(banji);
		req.setAttribute("banji", banji);
		req.getRequestDispatcher("/jsp/addStudent.jsp").forward(req, resp);
	}
	
	private void getAddBanjiPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/banji_add.jsp").forward(req, resp);
	}
	
	private void getAddCoursePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/course_add.jsp").forward(req, resp);
	}
	
	private void getSearchCoursePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/course_search.jsp").forward(req, resp);
	}
	
	private void getAddBanjiCoursePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IStudentService service = new StudentServiceImpl();
		List<Banji> banji = service.findBanji();
		System.out.println(banji);
		req.setAttribute("banji", banji);
		
		List<Banji> course = service.findCourse();
		System.out.println(course);
		req.setAttribute("course", course);
		req.getRequestDispatcher("/jsp/banji_course_add.jsp").forward(req, resp);
	}
	
	private void getSearchBanjiCoursePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/banji_course_search.jsp").forward(req, resp);
	}
}
