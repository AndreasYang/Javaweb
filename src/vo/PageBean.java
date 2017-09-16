package vo;

import java.io.Serializable;
import java.util.List;

import student.pojo.Banji;
import student.pojo.Student;

public class PageBean implements Serializable {

	private Integer pageIndex;
	private Integer pageSize;
	private Integer totalPage;
	private Integer totalCount;
	private List<Student> list;
	private List<Banji> list2;
	public PageBean() {
		super();
	}
	public PageBean(Integer pageIndex, Integer pageSize, Integer totalPage, Integer totalCount, List<Student> list) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.totalCount = totalCount;
		this.list = list;
	}
	
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
	
	
	public List<Banji> getList2() {
		return list2;
	}
	public void setList2(List<Banji> list2) {
		this.list2 = list2;
	}
	@Override
	public String toString() {
		return "PageBean [pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", totalPage=" + totalPage
				+ ", totalCount=" + totalCount + ", list=" + list + ", list2=" + list2 + "]";
	}	
	
}
