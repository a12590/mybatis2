package cn.itcast.javaee.mybatis.one2many;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.itcast.javaee.mybatis.util.MybatisUtil;

/**
 * �־ò�
 * @author AdminTC
 */
public class GradeStudentDao {
	/**
	 * ��ѯjavaѧ������Щѧ����Ϣ
	 * @param name ��ʾѧ����
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
	 * ��ѯ�������ĸ�ѧ�Ƶ�
	 * @param name ��ʾѧ������
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
		System.out.println("javaѧ����"+studentList.size()+"��ѧ����������Ϣ���£�");
		for(Student s : studentList){
			System.out.println(s.getId()+":"+s.getName());
		}
		System.out.println("-----------------------------------------------------------");
		Grade grade = dao.findByName("����");
		System.out.println("������"+grade.getName()+"ѧ�Ƶ�");
		System.out.println("-----------------------------------------------------------");
		grade = dao.findByName("�Ǻ�");
		System.out.println("�Ǻ���"+grade.getName()+"ѧ�Ƶ�");
	}
}








