package cn.itcast.javaee.mybatis.one2many;

/**
 * 学生(多方)
 * @author AdminTC
 */
public class Student {
	private Integer id;
	private String name;
	private Grade grade;//关联属性
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
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
}
