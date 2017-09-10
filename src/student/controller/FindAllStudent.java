package student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.pojo.Student;
import student.service.IStudentService;
import student.service.StudentServiceImpl;

public class FindAllStudent extends HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		
		IStudentService service = new StudentServiceImpl();
		List<Student> list = service.findall();

		/*resp.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<table border='1px' cellspacing='0'>");
		printWriter.println("<tr>");
		printWriter.println("<td>id</td>");
		printWriter.println("<td>Number</td>");
		printWriter.println("<td>Name</td>");
		printWriter.println("<td>Age</td>");
		printWriter.println("<td>Gender</td>");
		printWriter.println("<td>Address</td>");
		printWriter.println("</tr>");
		for(Student student : list){
			printWriter.println("<tr>");
			printWriter.println("    <td>" + student.getId() + "</td>");
			printWriter.println("	 <td>"+student.getNumber()+"</td>");
	        printWriter.println("    <td>" + student.getName() + "</td>");
	        printWriter.println("    <td>" + student.getAge() + "</td>");
	        printWriter.println("    <td>" + student.getGender() + "</td>");
	        printWriter.println("    <td>" + student.getAddress() + "</td>");
	        printWriter.println("</tr>");

		}
		printWriter.println("</table>");
		
		printWriter.close();*/
	}
}
