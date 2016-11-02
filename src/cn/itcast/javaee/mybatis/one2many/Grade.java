package cn.itcast.javaee.mybatis.one2many;

import java.util.ArrayList;
import java.util.List;

/**
 * 学科(单方)
 * @author AdminTC
 */
public class Grade {
	private Integer id;
	private String name;
	private List<Student> studentList = new ArrayList<Student>();//关联属性
	public Grade(){}
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
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
}
