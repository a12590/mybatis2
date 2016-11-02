package cn.itcast.javaee.mybatis.base;

import org.apache.ibatis.session.SqlSession;

import cn.itcast.javaee.mybatis.util.MybatisUtil;

/**
 * 持久层
 * @author AdminTC
 */
public class StudentDao {
	/**
	 * 增加学生
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
	 * 测试
	 */
	public static void main(String[] args) throws Exception{
		StudentDao dao = new StudentDao();
		dao.add(new Student(2,"呵呵",8000D));
	}
}
