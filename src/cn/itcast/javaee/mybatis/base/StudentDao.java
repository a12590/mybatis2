package cn.itcast.javaee.mybatis.base;

import org.apache.ibatis.session.SqlSession;

import cn.itcast.javaee.mybatis.util.MybatisUtil;

/**
 * �־ò�
 * @author AdminTC
 */
public class StudentDao {
	/**
	 * ����ѧ��
	 */
	public void add(Student student) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			sqlSession.insert("studentNamespace.add",student);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}
	
	
	
	
	
	
	/**
	 * ����
	 */
	public static void main(String[] args) throws Exception{
		StudentDao dao = new StudentDao();
		dao.add(new Student(2,"�Ǻ�",8000D));
	}
}
