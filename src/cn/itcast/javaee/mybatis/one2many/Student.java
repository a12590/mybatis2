package cn.itcast.javaee.mybatis.one2many;

/**
 * ѧ��(�෽)
 * @author AdminTC
 */
public class Student {
	private Integer id;
	private String name;
	private Grade grade;//��������
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
