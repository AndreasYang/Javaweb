package student.service;

import java.util.List;
import java.util.Map;

import vo.Admin;
import vo.PageBean;
import vo.SearchCondition;
import student.pojo.Banji;
import student.pojo.Student;

public interface IStudentService {
	
	List<Student> findall();

	boolean add(Student student);

	int update(Student student);

	int deleteByName(String name);

	List<Student> findByName(String searchname);

	PageBean getPageBean(int pageIndex, int pageSize);
	
	PageBean getBanjiPageBean(int pageIndex, int pageSize);
	
	PageBean searchByCondition(SearchCondition searchCondition);

	boolean checkName(String name);

	Admin findByNameAndPassword(String name, String password);

	void deleteAll(String[] names);
	
	List<Banji> findBanji();

	int addBanji(Banji banji);

	int deleteBanjie(String classname);

	void deleteAllBanji(String[] names);

	List<Banji> findCourse();

	int addCourse(Banji banji);

	int deleteCourse(String coursename);

	void deleteAllCourse(String[] coursenames);

	List<Banji> findcourse(String coursename);

	int updateCourse(Banji banji);

	int addBanjiCourse(Banji banji);

	List<Map<String, Object>> searchBanjiCourse(String classname);

	int deleteBanjiCourse(int parseInt);

}
