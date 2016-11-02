package cn.itcast.javaee.mybatis.many2many;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import cn.itcast.javaee.mybatis.util.MybatisUtil;

/**
 * �־ò�
 * @author AdminTC
 */
public class StudentCourseDao {
	/**
	 * ��ѯ����ѡѧ����Щ�γ�
	 * @param name ��ʾѧ��������
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
	 * ��ѯjava�γ�����Щѧ��ѡ��
	 * @param name ��ʾѧ���Ŀγ�
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
		List<Course> courseList = dao.findAllByName("����");
		System.out.print("����ѡѧ��" + courseList.size()+"���γ�,�ֱ��ǣ�");
		for(Course c : courseList){
			System.out.print(c.getName()+" ");
		}
		System.out.println("\n-----------------------------------------------------");
		List<Student> studentList = dao.findAllByCourseName("android");
		System.out.println("ѡ����android�γ̵�ѧ����"+studentList.size()+"�����ֱ��ǣ�");
		for(Student s : studentList){
			System.out.print(s.getName()+" ");
		}
	}
}








