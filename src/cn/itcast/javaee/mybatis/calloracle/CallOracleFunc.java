package cn.itcast.javaee.mybatis.calloracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import cn.itcast.javaee.mybatis.util.JdbcUtil;

/**
 * ��ʾjava-jdbc����oracle����
 * @author AdminTC
 */
public class CallOracleFunc {
	public static void main(String[] args) throws Exception{
		String sql = "{ ? = call findEmpNameAndJobAndSal(?,?,?) }";
		Connection conn = JdbcUtil.getConnection();
		CallableStatement cstmt = conn.prepareCall(sql);
		
		//Ϊ��һ��?ע���������
		cstmt.registerOutParameter(1,Types.VARCHAR);
		//Ϊ�ڶ���?ע��ֵ
		cstmt.setInt(2,7788);
		//Ϊ������?ע���������
		cstmt.registerOutParameter(3,Types.VARCHAR);
		//Ϊ���ĸ�?ע���������
		cstmt.registerOutParameter(4,Types.INTEGER);
		//ִ�к�������
		cstmt.execute();
		//�ֱ��ȡ1,3,4ռλ����ֵ
		String ename = cstmt.getString(1);
		String job = cstmt.getString(3);
		int sal = cstmt.getInt(4);
		//��ʾ
		System.out.println("7788--"+ename+"--"+job+"--"+sal);
		cstmt.close();
		conn.close();
	}
}
