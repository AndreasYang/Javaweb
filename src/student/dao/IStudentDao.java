package student.dao;

import java.util.List;
import java.util.Map;

import student.pojo.Banji;
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

	public int getBanjiTotalCount();

	public List<Banji> findBanjiPageBeanList(int index, int pageSize);

	public List<Banji> findBanji();
	
	public int addBanji(Banji banji);

	public int deleteBanji(String classname);

	public List<Banji> findCourse();

	public int addCourse(Banji banji);

	public int deleteCourse(String coursename);

	public List<Banji> findCourse(String coursename);

	public int updateCourse(Banji banji);

	public int addBanjiCourse(Banji banji);

	public List<Map<String, Object>> searchBanjiCourse(String classname);

	public int deleteBanjiCourse(int parseInt);
		

}
