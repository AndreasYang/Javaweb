package student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.pojo.Student;
import student.service.IStudentService;
import student.service.StudentServiceImpl;

public class AddStudent extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String number = req.getParameter("number");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String address = req.getParameter("address");
		
		Student student = new Student(Integer.parseInt(number), name, gender, Integer.parseInt(age), address);
		IStudentService service = new StudentServiceImpl();
		
	       service.add(student);

		resp.sendRedirect("/Java1707web/FindAllStudent");
		
	}
	
}
