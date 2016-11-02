package cn.itcast.javaee.mybatis.one2one;

/**
 * 身份证(单方)
 * @author AdminTC
 */
public class Card {
	private Integer id;
	private String num;
	public Card(){}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
}
