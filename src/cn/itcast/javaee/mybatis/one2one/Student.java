package cn.itcast.javaee.mybatis.one2one;

/**
 * 学生(单方)
 * @author AdminTC
 */
public class Student {
	private Integer id;
	private String name;
	private Card card;//关联属性
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
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
}
