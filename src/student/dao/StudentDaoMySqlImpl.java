package student.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.regexp.internal.recompile;

import oracle.jrockit.jfr.tools.ConCatRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import student.pojo.Banji;
import student.pojo.Student;
import student.util.ModelConvert;
import student.util.jdbcUtil;
import vo.Admin;
import vo.SearchCondition;

public class StudentDaoMySqlImpl implements IStudentDao {

	@Override
	public int add(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = jdbcUtil.getConnection();
			String sql = "INSERT INTO student(number,NAME,gender,age,address,banji_id) VALUES(?,?,?,?,?,?);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, student.getNumber());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getGender());
			preparedStatement.setInt(4, student.getAge());
			preparedStatement.setString(5, student.getAddress());
			preparedStatement.setInt(6, student.getBanjiId());
			System.out.println(student.getBanjiId());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtil.close(connection, preparedStatement);
		}
		return result;
	}

	@Override
	public int update(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = jdbcUtil.getConnection();
			String sql = "UPDATE student SET number=?,name=?, gender=?,age=?,address=?WHERE name=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, student.getNumber());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getGender());
			preparedStatement.setInt(4, student.getAge());
			preparedStatement.setString(5, student.getAddress());
			preparedStatement.setString(6, student.getSearchname());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtil.close(connection, preparedStatement);
		}

		return result;
	}

	@Override
	public List<Student> findByGender(String gender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findByName(String searchname) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = jdbcUtil.getConnection();
			String sql = "SELECT*FROM student WHERE name=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, searchname);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int number = resultSet.getInt("number");
				String name = resultSet.getString("NAME");
				String gender = resultSet.getString("gender");
				int age = resultSet.getInt("age");
				String address = resultSet.getString("address");
				Student student = new Student(id, number, name, gender, age, address);
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Student> findAll() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = jdbcUtil.getConnection();
			String sql = "SELECT id,number,NAME,gender,age,address FROM student;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int number = resultSet.getInt("number");
				String name = resultSet.getString("NAME");
				String gender = resultSet.getString("gender");
				int age = resultSet.getInt("age");
				String address = resultSet.getString("address");
				Student student = new Student(id, number, name, gender, age, address);
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtil.close(connection, preparedStatement);
		}
		return list;
	}

	@Override
	public boolean checkName(String name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		boolean isExist = false;
		try {
			connection = jdbcUtil.getConnection();
			String sql = "SELECT id FROM student WHERE NAME=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				isExist = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtil.close(connection, preparedStatement);
		}
		return isExist;
	}

	@Override
	public int deleteByName(String name) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = jdbcUtil.getConnection();
			String sql = "DELETE FROM student WHERE name=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtil.close(connection, preparedStatement);
		}

		return result;
	}

	@Override
	public List<Student> findPageBeanList(int index, int pageSize) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = jdbcUtil.getConnection();
			String sql = "SELECT*FROM student AS s INNER JOIN banji AS bj ON s.banji_id=bj.id ORDER BY s.id LIMIT ?,?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setObject(1, index);
			preparedStatement.setObject(2, pageSize);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int number = resultSet.getInt("number");
				String name = resultSet.getString("NAME");
				String gender = resultSet.getString("gender");
				int age = resultSet.getInt("age");
				String address = resultSet.getString("address");
				String classname = resultSet.getString("classname");
				Student student = new Student(id, number, name, gender, age, address, classname);
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public int getTotalCount() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int count = 0;
		try {
			connection = jdbcUtil.getConnection();
			String sql = "SELECT COUNT(*) FROM student;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Student> findPageBeanList(SearchCondition searchCondition) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Student> list = new ArrayList<Student>();
		try {
			connection = jdbcUtil.getConnection();
			String sql = "select * from student where 1=1 ";

			String nameSearch = searchCondition.getName();
			List<String> listCondition = new ArrayList<String>();
			if (nameSearch != null && !nameSearch.equals("")) {
				sql += " and name like ?";
				listCondition.add("%" + nameSearch + "%");
			}
			String ageSearch = searchCondition.getAge();
			if (ageSearch != null && !ageSearch.equals("")) {
				sql += " and age=?";
				listCondition.add(ageSearch);
			}
			String genderSearch = searchCondition.getGender();
			if (genderSearch != null && !genderSearch.equals("")) {
				sql += " and gender=?";
				listCondition.add(genderSearch);
			}

			sql += " limit ?,?";

			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < listCondition.size(); i++) {
				preparedStatement.setString(i + 1, listCondition.get(i));
			}
			int pageIndex = searchCondition.getPageIndex() - 1;
			int index = pageIndex*searchCondition.getPageSize();
			preparedStatement.setInt(listCondition.size() + 1, index);
			preparedStatement.setInt(listCondition.size() + 2, searchCondition.getPageSize());

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int number = resultSet.getInt("number");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String gender = resultSet.getString("gender");
				String address = resultSet.getString("address");
				Student student = new Student(id, number, name, gender, age, address);
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getTotalCount(SearchCondition searchCondition) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int count = 0;
		try {
			connection = jdbcUtil.getConnection();
			String sql = "SELECT COUNT(*) FROM student where 1=1 ";

			String nameSearch = searchCondition.getName();
			List<String> listCondition = new ArrayList<String>();
			if (nameSearch != null && !nameSearch.equals("")) {
				sql += " and name like ?";
				listCondition.add("%" + nameSearch + "%");
			}
			String ageSearch = searchCondition.getAge();
			if (ageSearch != null && !ageSearch.equals("")) {
				sql += " and age=?";
				listCondition.add(ageSearch);
			}
			String genderSearch = searchCondition.getGender();
			if (genderSearch != null && !genderSearch.equals("")) {
				sql += " and gender=?";
				listCondition.add(genderSearch);
			}

			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < listCondition.size(); i++) {
				preparedStatement.setString(i + 1, listCondition.get(i));
			}

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public Admin findByNameAndPassword(String name, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Admin admin = null;
		try {
			connection = jdbcUtil.getConnection();
			String sql = "SELECT * FROM admin WHERE username=? and passWord=?	";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String adminusername = resultSet.getString("username");
				String adminpassword = resultSet.getString("passWord");
				admin = new Admin(adminusername, adminpassword);
				return admin;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcUtil.close(connection, preparedStatement);
		}
		return null;
	}

	@Override
	public int getBanjiTotalCount() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int count = 0;
		try {
			connection = jdbcUtil.getConnection();
			String sql = "SELECT COUNT(*) FROM banji AS bj INNER JOIN banji_course AS bc ON bj.id=bc.banji_id INNER JOIN course AS c ON bc.course_id=c.id;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				count = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Banji> findBanjiPageBeanList(int index, int pageSize) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Banji> list = new ArrayList<Banji>();
		try {
			connection = jdbcUtil.getConnection();
			String sql = "SELECT * "
					+ "FROM banji AS bj INNER JOIN banji_course AS bc ON bj.id=bc.banji_id "
					+ "INNER JOIN course AS c ON bc.course_id=c.id ORDER BY classname limit ?,?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setObject(1, index);
			preparedStatement.setObject(2, pageSize);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String classname = resultSet.getString("bj.classname");
				String coursename = resultSet.getString("c.coursename");
				int points = resultSet.getInt("c.points");
				int banji_course_id = resultSet.getInt("bc.id");
				Banji banji = new Banji(classname,coursename,points,banji_course_id);
				list.add(banji);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<Banji> findBanji() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Banji> list = new ArrayList<Banji>();
		try {
			connection = jdbcUtil.getConnection();
			String sql = "SELECT*FROM banji;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int banjiId = resultSet.getInt("id");
				String classname = resultSet.getString("classname");
				Banji banji = new Banji(banjiId, classname);
				list.add(banji);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtil.close(connection, preparedStatement);
		}
		return list;
	}

	@Override
	public int addBanji(Banji banji) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = jdbcUtil.getConnection();
			String sql = "INSERT INTO banji(classname) VALUES(?);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, banji.getClassname());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtil.close(connection, preparedStatement);
		}
		return result;
		
	}

	@Override
	public int deleteBanji(String classname) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = jdbcUtil.getConnection();
			String sql = "DELETE FROM banji WHERE classname=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, classname);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtil.close(connection, preparedStatement);
		}

		return result;
	}

	@Override
	public List<Banji> findCourse() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Banji>list = new ArrayList<Banji>();
		try {
			connection = jdbcUtil.getConnection();
			String sql = "SELECT*FROM course";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int courseId = resultSet.getInt("id");
				String coursename = resultSet.getString("coursename");
				int points = resultSet.getInt("points");
				Banji banji = new Banji(courseId, coursename, points);
				list.add(banji);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addCourse(Banji banji) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = jdbcUtil.getConnection();
			String sql = "INSERT INTO course(coursename, points) VALUES(?,?);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, banji.getCoursename());
			preparedStatement.setInt(2, banji.getPoints());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteCourse(String coursename) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = jdbcUtil.getConnection();
			String sql = "DELETE FROM course WHERE coursename=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, coursename);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtil.close(connection, preparedStatement);
		}

		return result;
	}

	@Override
	public List<Banji> findCourse(String coursename) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Banji> list = new ArrayList<Banji>();
		try {
			connection = jdbcUtil.getConnection();
			String sql = "SELECT*FROM course WHERE coursename=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, coursename);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int points = resultSet.getInt("points");
				Banji banji = new Banji(coursename, points);
				list.add(banji);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int updateCourse(Banji banji) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = jdbcUtil.getConnection();
			String sql = "UPDATE course SET points=? WHERE coursename=?;";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, banji.getPoints());
			System.out.println(banji.getPoints());
			preparedStatement.setString(2, banji.getCoursename());
			System.out.println(banji.getCoursename());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtil.close(connection, preparedStatement);
		}

		return result;
	}

	@Override
	public int addBanjiCourse(Banji banji) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = jdbcUtil.getConnection();
			String sql="INSERT INTO banji_course(banji_id, course_id) VALUES(?,?);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, banji.getBanjiId());
			preparedStatement.setInt(2, banji.getCourseId());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> searchBanjiCourse(String classname) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Map<String, Object>> list = null;
		try {
			connection = jdbcUtil.getConnection();
			String sql= "SELECT bj.id,classname,c.coursename,points  FROM banji AS bj INNER JOIN banji_course AS bc ON bj.id=bc.banji_id  INNER JOIN course AS c ON bc.course_id=c.id WHERE bj.classname = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, classname);
			resultSet = preparedStatement.executeQuery();
			list = ModelConvert.converList(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdbcUtil.close(connection, preparedStatement);
		}

		
		return list;
	}

	@Override
	public int deleteBanjiCourse(int parseInt) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = jdbcUtil.getConnection();
			String sql = "DELETE FROM banji_course WHERE id=?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, parseInt);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbcUtil.close(connection, preparedStatement);
		}

		return result;
	}

}
