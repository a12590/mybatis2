package cn.itcast.javaee.mybatis.many2many;

import java.util.ArrayList;
import java.util.List;

/**
 * ѧ��(�෽)
 * @author AdminTC
 */
public class Student {
	private Integer id;
	private String name;
	private List<Course> courseList = new ArrayList<Course>();//��������
	public Student(){}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
}
