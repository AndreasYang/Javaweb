package student.service;

import java.util.List;

import vo.Admin;
import vo.PageBean;
import vo.SearchCondition;
import student.pojo.Student;

public interface IStudentService {
	
	List<Student> findall();

	boolean add(Student student);

	int update(Student student);

	int deleteByName(String name);

	List<Student> findByName(String searchname);

	PageBean getPageBean(int pageIndex, int pageSize);
	
	PageBean searchByCondition(SearchCondition searchCondition);

	boolean checkName(String name);

	Admin findByNameAndPassword(String name, String password);

	void deleteAll(String[] names);

}
