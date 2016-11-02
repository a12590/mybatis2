package cn.itcast.javaee.mybatis.one2one;

import org.apache.ibatis.session.SqlSession;
import cn.itcast.javaee.mybatis.util.MybatisUtil;

/**
 * 持久层
 * @author AdminTC
 */
public class StudentCardDao {
	/**
	 * 查询1号学生的信息
	 * @param id 表示学生的编号
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
	 * 查询"哈哈"学生的信息
	 * @param name 表示学生的姓名
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
		
		s = dao.findByName("哈哈");
		System.out.println(s.getName()+"的身份证号码为:" + s.getCard().getNum());
	}
}








