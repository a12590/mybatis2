package cn.itcast.javaee.mybatis.calloracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import cn.itcast.javaee.mybatis.util.JdbcUtil;

/**
 * 演示java-jdbc调用oracle函数
 * @author AdminTC
 */
public class CallOracleFunc {
	public static void main(String[] args) throws Exception{
		String sql = "{ ? = call findEmpNameAndJobAndSal(?,?,?) }";
		Connection conn = JdbcUtil.getConnection();
		CallableStatement cstmt = conn.prepareCall(sql);
		
		//为第一个?注册输出类型
		cstmt.registerOutParameter(1,Types.VARCHAR);
		//为第二个?注入值
		cstmt.setInt(2,7788);
		//为第三个?注册输出类型
		cstmt.registerOutParameter(3,Types.VARCHAR);
		//为第四个?注册输出类型
		cstmt.registerOutParameter(4,Types.INTEGER);
		//执行函数调用
		cstmt.execute();
		//分别获取1,3,4占位符的值
		String ename = cstmt.getString(1);
		String job = cstmt.getString(3);
		int sal = cstmt.getInt(4);
		//显示
		System.out.println("7788--"+ename+"--"+job+"--"+sal);
		cstmt.close();
		conn.close();
	}
}
