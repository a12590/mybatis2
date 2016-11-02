package cn.itcast.javaee.mybatis.many2many;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import cn.itcast.javaee.mybatis.util.MybatisUtil;

/**
 * 持久层
 * @author AdminTC
 */
public class StudentCourseDao {
	/**
	 * 查询哈哈选学了哪些课程
	 * @param name 表示学生的姓名
	 */
	public List<Course> findAllByName(String name) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			return sqlSession.selectList("courseNamespace.findAllByName",name);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}
	/**
	 * 查询java课程有哪些学生选修
	 * @param name 表示学生的课程
	 */
	public List<Student> findAllByCourseName(String name) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			return sqlSession.selectList("studentNamespace.findAllByCourseName",name);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) throws Exception{
		StudentCourseDao dao = new StudentCourseDao();
		List<Course> courseList = dao.findAllByName("哈哈");
		System.out.print("哈哈选学了" + courseList.size()+"个课程,分别是：");
		for(Course c : courseList){
			System.out.print(c.getName()+" ");
		}
		System.out.println("\n-----------------------------------------------------");
		List<Student> studentList = dao.findAllByCourseName("android");
		System.out.println("选修了android课程的学生有"+studentList.size()+"个，分别是：");
		for(Student s : studentList){
			System.out.print(s.getName()+" ");
		}
	}
}








