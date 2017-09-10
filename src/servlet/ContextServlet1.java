package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.pojo.Student;
import student.service.IStudentService;
import student.service.StudentServiceImpl;

public class ContextServlet1 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		servletContext.setAttribute("name", "ÕÅÈý");
		IStudentService service = new StudentServiceImpl();
		List<Student> list = service.findall();
		servletContext.setAttribute("list", list);
	}
}
