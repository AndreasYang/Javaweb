package student.service;

import java.util.List;

import student.dao.IStudentDao;
import student.dao.StudentDaoMySqlImpl;
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
		}else {
			int result = studentDao.add(student);
			if (result > 0) {
				return true;
			}else {
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
		int totalPage = (int) Math.ceil((double)totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex-1)*pageSize;
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
		int totalPage = (int) Math.ceil(1.0*totalCount/searchCondition.getPageSize());
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
		for(String name : names){
			studentDao.deleteByName(name);
		}
		
	}
	
}
