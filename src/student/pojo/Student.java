package student.pojo;

import java.io.Serializable;

public class Student implements Serializable{
	
	private Integer id;
	private Integer number;
	private String name;
	private String gender;
	private Integer age;
	private String address;
	private String searchname;
	private String classname;
	private String coursername;
	private Integer points;
	private Integer banjiId;
	
	public Student() {
		super();
	}


	public Student(Integer id, Integer number, String name, String gender, Integer age, String address) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.address = address;
	}



	public Student(Integer number, String name, String gender, Integer age, String address) {
		super();
		this.number = number;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.address = address;
	}

	public Student(String searchname) {
		super();
		this.searchname = searchname;
	}


	public Student(String name, String gender, int age) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.gender = gender;
		this.age = age;
	}


	public Student(Integer number, String name, String gender, Integer age, String address, String searchname) {
		super();
		this.number = number;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.searchname = searchname;
	}

	

	public Student(String classname, String coursername, Integer points) {
		super();
		this.classname = classname;
		this.coursername = coursername;
		this.points = points;
	}


	public Student(Integer id, Integer number, String name, String gender, Integer age, String address,
			String searchname, String classname, String coursername, Integer points, Integer banjiId) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.searchname = searchname;
		this.classname = classname;
		this.coursername = coursername;
		this.points = points;
		this.banjiId = banjiId;
	}


	
	
	public Student(Integer id, Integer number, String name, String gender, Integer age, String address,
			String classname) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.classname = classname;
	}


	public Student(Integer number, String name, String gender, Integer age, String address, Integer banjiId) {
		super();
		this.number = number;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.banjiId = banjiId;
	}


	public String getClassname() {
		return classname;
	}


	public void setClassname(String classname) {
		this.classname = classname;
	}


	public String getCoursername() {
		return coursername;
	}


	public void setCoursername(String coursername) {
		this.coursername = coursername;
	}


	public Integer getPoints() {
		return points;
	}


	public void setPoints(Integer points) {
		this.points = points;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSearchname() {
		return searchname;
	}

	public void setSearchname(String searchname) {
		this.searchname = searchname;
	}


	public Integer getBanjiId() {
		return banjiId;
	}


	public void setBanjiId(Integer banjiId) {
		this.banjiId = banjiId;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", number=" + number + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ ", address=" + address + ", searchname=" + searchname + ", classname=" + classname + ", coursername="
				+ coursername + ", points=" + points + ", banjiId=" + banjiId + "]";
	}
	
	

}
