package student.dao;

import java.util.List;

import student.pojo.Student;
import vo.Admin;

public interface IStudentDao {
	
	public int add(Student student);
	
	public int deleteByName(String name);
	
	public int update(Student student);
	
	public List<Student > findByGender(String gender);

	public List<Student> findAll();

	public boolean checkName(String name);

	public List<Student> findByName(String searchname);

	public List<Student> findPageBeanList(int index, int pageSize);

	public int getTotalCount();
	
	public List<Student> findPageBeanList(vo.SearchCondition searchCondition);

	public int getTotalCount(vo.SearchCondition searchCondition);

	public Admin findByNameAndPassword(String name, String password);


}
