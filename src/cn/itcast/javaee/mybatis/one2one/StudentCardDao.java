package cn.itcast.javaee.mybatis.one2one;

import org.apache.ibatis.session.SqlSession;
import cn.itcast.javaee.mybatis.util.MybatisUtil;

/**
 * �־ò�
 * @author AdminTC
 */
public class StudentCardDao {
	/**
	 * ��ѯ1��ѧ������Ϣ
	 * @param id ��ʾѧ���ı��
	 */
	public Student findById(int id) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			return sqlSession.selectOne("studentNamespace.findById",id);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}
	/**
	 * ��ѯ"����"ѧ������Ϣ
	 * @param name ��ʾѧ��������
	 */
	public Student findByName(String name) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			return sqlSession.selectOne("studentNamespace.findByName",name);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}
	
	
	
	
	
	public static void main(String[] args) throws Exception{
		StudentCardDao dao = new StudentCardDao();
		Student s = dao.findById(1);
		System.out.println(s.getId()+":"+s.getName()+":"+s.getCard().getId()+":"+s.getCard().getNum());
		
		System.out.println("-------------------------------");
		
		s = dao.findByName("����");
		System.out.println(s.getName()+"�����֤����Ϊ:" + s.getCard().getNum());
	}
}








