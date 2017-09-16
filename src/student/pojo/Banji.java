package student.pojo;

public class Banji {
	private Integer banjiId;
	private String classname;
	private Integer courseId;
	private String coursename;
	private String searchcoursename;
	private Integer points;
	private Integer banji_course_id;
	
	
	public Banji() {
		super();
	}
	
	
	public Banji(Integer banjiId, String classname, Integer courseId, String coursename, String searchcoursename,
			Integer points) {
		super();
		this.banjiId = banjiId;
		this.classname = classname;
		this.courseId = courseId;
		this.coursename = coursename;
		this.searchcoursename = searchcoursename;
		this.points = points;
	}


	public Banji(String classname, String coursename, Integer points, Integer banji_course_id) {
		super();
		this.classname = classname;
		this.coursename = coursename;
		this.points = points;
		this.banji_course_id = banji_course_id;
	}
	
	
	public Banji(String classname) {
		super();
		this.classname = classname;
	}

	public Banji(String coursename, Integer points) {
		super();
		this.coursename = coursename;
		this.points = points;
	}
	

	
	public Banji(Integer courseId, String coursename, Integer points) {
		super();
		this.courseId = courseId;
		this.coursename = coursename;
		this.points = points;
	}

	

	public Banji(Integer banjiId, String classname) {
		super();
		this.banjiId = banjiId;
		this.classname = classname;
	}

	

	public Banji(Integer banjiId, Integer courseId) {
		super();
		this.banjiId = banjiId;
		this.courseId = courseId;
	}

	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getSearchcoursename() {
		return searchcoursename;
	}
	public void setSearchcoursename(String searchcoursename) {
		this.searchcoursename = searchcoursename;
	}


	public Integer getBanjiId() {
		return banjiId;
	}


	public void setBanjiId(Integer banjiId) {
		this.banjiId = banjiId;
	}


	public Integer getCourseId() {
		return courseId;
	}


	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}


	public Integer getBanji_course_id() {
		return banji_course_id;
	}


	public void setBanji_course_id(Integer banji_course_id) {
		this.banji_course_id = banji_course_id;
	}


	@Override
	public String toString() {
		return "Banji [banjiId=" + banjiId + ", classname=" + classname + ", courseId=" + courseId + ", coursename="
				+ coursename + ", searchcoursename=" + searchcoursename + ", points=" + points + ", banji_course_id="
				+ banji_course_id + "]";
	}
	
	
	
	
}
