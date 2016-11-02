package cn.itcast.javaee.mybatis.one2many;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.itcast.javaee.mybatis.util.MybatisUtil;

/**
 * 持久层
 * @author AdminTC
 */
public class GradeStudentDao {
	/**
	 * 查询java学科有哪些学生信息
	 * @param name 表示学科名
	 */
	public List<Student> findAllByName(String name) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			return sqlSession.selectList("studentNamespace.findAllByName",name);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}
	
	/**
	 * 查询哈哈是哪个学科的
	 * @param name 表示学生姓名
	 */
	public Grade findByName(String name) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			return sqlSession.selectOne("gradeNamespace.findByName",name);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}
	
	
	
	
	
	public static void main(String[] args) throws Exception{
		GradeStudentDao dao = new GradeStudentDao();
		List<Student> studentList = dao.findAllByName("java");
		System.out.println("java学科有"+studentList.size()+"个学生，它们信息如下：");
		for(Student s : studentList){
			System.out.println(s.getId()+":"+s.getName());
		}
		System.out.println("-----------------------------------------------------------");
		Grade grade = dao.findByName("哈哈");
		System.out.println("哈哈是"+grade.getName()+"学科的");
		System.out.println("-----------------------------------------------------------");
		grade = dao.findByName("呵呵");
		System.out.println("呵呵是"+grade.getName()+"学科的");
	}
}








