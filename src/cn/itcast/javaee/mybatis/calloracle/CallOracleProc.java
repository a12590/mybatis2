package cn.itcast.javaee.mybatis.calloracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import cn.itcast.javaee.mybatis.util.JdbcUtil;

/**
 * ��ʾjava-jdbc����oracle����
 * @author AdminTC
 */
public class CallOracleProc {
	public static void main(String[] args) throws Exception{
		String sql = "{call get_rax(?,?)}";
		Connection conn = JdbcUtil.getConnection();
		CallableStatement cstmt = conn.prepareCall(sql);
		//Ϊ��һ��?������ֵ����1��ʼ
		cstmt.setInt(1,7000);
		//Ϊ�ڶ�����ע���������
		cstmt.registerOutParameter(2,Types.INTEGER);
		//ִ�е��ù���
		cstmt.execute();
		//���չ��̵ķ���ֵ�����ڶ�������
		int rax = cstmt.getInt(2);
		//��ʾ
		System.out.println("7000Ԫ��Ҫ�Ͻ�"+rax+"Ԫ˰��");
		cstmt.close();
		conn.close();
	}
}
