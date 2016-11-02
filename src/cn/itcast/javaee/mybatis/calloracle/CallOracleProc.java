package cn.itcast.javaee.mybatis.calloracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import cn.itcast.javaee.mybatis.util.JdbcUtil;

/**
 * 演示java-jdbc调用oracle过程
 * @author AdminTC
 */
public class CallOracleProc {
	public static void main(String[] args) throws Exception{
		String sql = "{call get_rax(?,?)}";
		Connection conn = JdbcUtil.getConnection();
		CallableStatement cstmt = conn.prepareCall(sql);
		//为第一个?号设置值，从1开始
		cstmt.setInt(1,7000);
		//为第二个？注册输出类型
		cstmt.registerOutParameter(2,Types.INTEGER);
		//执行调用过程
		cstmt.execute();
		//接收过程的返回值，即第二个？号
		int rax = cstmt.getInt(2);
		//显示
		System.out.println("7000元需要上交"+rax+"元税收");
		cstmt.close();
		conn.close();
	}
}
