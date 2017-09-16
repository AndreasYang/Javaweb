package student.service;

import java.util.List;
import java.util.Map;

import student.dao.IStudentDao;
import student.dao.StudentDaoMySqlImpl;
import student.pojo.Banji;
import student.pojo.Student;
import vo.Admin;
import vo.PageBean;

public class StudentServiceImpl<SearchCondition> implements IStudentService {

	private IStudentDao studentDao = new StudentDaoMySqlImpl();

	@Override
	public List<Student> findall() {
		// TODO Auto-generated method stub
		return studentDao.findAll();
	}

	@Override
	public boolean add(Student student) {
		if (studentDao.checkName(student.getName())) {
			System.out.println("该学生已存在");
		} else {
			int result = studentDao.add(student);
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	public int update(Student student) {
		return studentDao.update(student);
	}

	@Override
	public List<Student> findByName(String searchname) {
		// TODO Auto-generated method stub
		return studentDao.findByName(searchname);
	}

	@Override
	public int deleteByName(String name) {
		return studentDao.deleteByName(name);

	}

	@Override
	public PageBean getPageBean(int pageIndex, int pageSize) {
		PageBean pageBean = new PageBean();

		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalCount = studentDao.getTotalCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil((double) totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex - 1) * pageSize;
		List<Student> list = studentDao.findPageBeanList(index, pageSize);
		pageBean.setList(list);

		return pageBean;
	}

	@Override
	public PageBean searchByCondition(vo.SearchCondition searchCondition) {
		PageBean pageBean = new PageBean();
		pageBean.setPageIndex(searchCondition.getPageIndex());
		pageBean.setPageSize(searchCondition.getPageSize());
		int totalCount = studentDao.getTotalCount(searchCondition);
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / searchCondition.getPageSize());
		pageBean.setTotalPage(totalPage);
		List<Student> list = studentDao.findPageBeanList(searchCondition);
		pageBean.setList(list);

		return pageBean;
	}

	@Override
	public boolean checkName(String name) {
		return studentDao.checkName(name);
	}

	@Override
	public Admin findByNameAndPassword(String name, String password) {
		// TODO Auto-generated method stub
		return studentDao.findByNameAndPassword(name, password);
	}

	@Override
	public void deleteAll(String[] names) {
		for (String name : names) {
			studentDao.deleteByName(name);
		}

	}

	@Override
	public PageBean getBanjiPageBean(int pageIndex, int pageSize) {
		PageBean pageBean = new PageBean();

		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int BanjitotalCount = studentDao.getBanjiTotalCount();
		pageBean.setTotalCount(BanjitotalCount);
		int totalPage = (int) Math.ceil((double) BanjitotalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex - 1) * pageSize;
		List<Banji> list = studentDao.findBanjiPageBeanList(index, pageSize);
		pageBean.setList2(list);

		return pageBean;
	}

	@Override
	public List<Banji> findBanji() {
		// TODO Auto-generated method stub
		return studentDao.findBanji();
	}

	@Override
	public int addBanji(Banji banji) {
		return studentDao.addBanji(banji);
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteBanjie(String classname) {
		// TODO Auto-generated method stub
		return studentDao.deleteBanji(classname);
	}

	@Override
	public void deleteAllBanji(String[] names) {
		for (String name : names) {
			studentDao.deleteBanji(name);
		}
		
	}

	@Override
	public List<Banji> findCourse() {
		// TODO Auto-generated method stub
		return studentDao.findCourse();
	}

	@Override
	public int addCourse(Banji banji) {
		// TODO Auto-generated method stub
		return studentDao.addCourse(banji);
	}

	@Override
	public int deleteCourse(String coursename) {
		// TODO Auto-generated method stub
		return studentDao.deleteCourse(coursename);
	}

	@Override
	public void deleteAllCourse(String[] coursenames) {
		for(String coursename : coursenames){
			studentDao.deleteCourse(coursename);
		}
		
	}

	@Override
	public List<Banji> findcourse(String coursename) {
		// TODO Auto-generated method stub
		return studentDao.findCourse(coursename);
	}

	@Override
	public int updateCourse(Banji banji) {
		// TODO Auto-generated method stub
		return studentDao.updateCourse(banji);
	}

	@Override
	public int addBanjiCourse(Banji banji) {
		// TODO Auto-generated method stub
		return studentDao.addBanjiCourse(banji);
	}

	@Override
	public List<Map<String, Object>> searchBanjiCourse(String classname) {
		// TODO Auto-generated method stub
		return studentDao.searchBanjiCourse(classname);
	}

	@Override
	public int deleteBanjiCourse(int parseInt) {
		// TODO Auto-generated method stub
		return studentDao.deleteBanjiCourse(parseInt);
	}

}
