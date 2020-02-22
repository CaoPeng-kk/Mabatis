package nov.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import nov.mybatis.bean.Department;
import nov.mybatis.bean.Employee;
import nov.mybatis.bean.Employee_2;
import nov.mybatis.dao.DepartmentMapper;
import nov.mybatis.dao.EmployeeMapper;
import nov.mybatis.dao.EmployeeMapper_2;

public class MybatisTest {

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    /**
     * 1������xml�����ļ���ȫ�������ļ�������һ��SqlSessionFactory���� ������ԴһЩ���л�����Ϣ
     * 2��sqlӳ���ļ���������ÿһ��sql���Լ�sql�ķ�װ����ȡ� 
     * 3����sqlӳ���ļ�ע����ȫ�������ļ���
     * 4��д���룺
     *         1��������ȫ�������ļ��õ�SqlSessionFactory��
     *         2����ʹ��sqlSession��������ȡ��sqlSession����ʹ������ִ����ɾ�Ĳ�
     *             һ��sqlSession���Ǵ�������ݿ��һ�λỰ������ر�
     *         3����ʹ��sql��Ψһ��־������MyBatisִ���ĸ�sql��sql���Ǳ�����sqlӳ���ļ��еġ�
     * 
     * @throws IOException
     */
    @Test
    public void test() throws IOException {

        // 2����ȡsqlSessionʵ������ֱ��ִ���Ѿ�ӳ���sql���
        // sql��Ψһ��ʶ��statement Unique identifier matching the statement to use.
        // ִ��sqlҪ�õĲ�����parameter A parameter object to pass to the statement.
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            Employee employee = openSession.selectOne(
                    "com.atguigu.mybatis.dao.EmployeeMapper.getEmpById", 1);
            System.out.println(employee);
        } finally {
            openSession.close();
        }
    }
    
    @Test
    public void fun2() throws IOException {
    	/*
    	 * �ýӿڵķ�ʽ ȡ������
    	 */
    	SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    	SqlSession session = sqlSessionFactory.openSession();
    	EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
    	Employee em = mapper.getEmpById(1);
    	System.out.println(em.toString());
    	session.close();
    }
    @Test
    public void fun3() throws IOException {
    	/* ������ɾ�ĵķ���
    	 * һ��Ҫ�ֶ��ύcommit
    	 */
    	SqlSessionFactory sqlFactory  = getSqlSessionFactory();
    	SqlSession session = sqlFactory.openSession();
    	EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
    	Employee emp = new Employee("li", "1", "123@");
    	mapper.addEmp(emp);
    	session.commit();
    	session.close();
	}
    @Test
    public void fun4() throws IOException {
    	/* �����Զ����ѯ
    	 *  ע�� ���ݿ������� ���ܻᱨ��  Ӧ����ʾһ����¼ ȴ��ѯ������
    	 */
    	SqlSessionFactory sqlFactory  = getSqlSessionFactory();
    	SqlSession session = sqlFactory.openSession();
    	EmployeeMapper_2 mapper = session.getMapper(EmployeeMapper_2.class);
    	Employee_2 emp = mapper.getEmpAndDept(2);
    	System.out.println(emp);
    	session.commit();
    	session.close();
    }
    @Test
    public void fun5() throws IOException {
    	/* 
    	 *  association�����������ķ�װ����
    	 */
    	SqlSessionFactory sqlFactory  = getSqlSessionFactory();
    	SqlSession session = sqlFactory.openSession();
    	DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
    	Department de = mapper.getDeptById(2);
    	System.out.println(de);
    	
    	session.commit();
    	session.close();
    }
    @Test
    public void fun6() throws IOException {
    	/* 
    	 *  association �ֲ���ѯ
    	 */
    	SqlSessionFactory sqlFactory  = getSqlSessionFactory();
    	SqlSession session = sqlFactory.openSession();
    	EmployeeMapper_2 mapper = session.getMapper(EmployeeMapper_2.class);
    	Employee_2 de = mapper.getEmpByIdStep(2);
    	System.out.println(de.getName());
//    	System.out.println(de.getDept());
    	
    	session.commit();
    	session.close();
    }
    @Test
    public void fun7() throws IOException {
    	/* 
    	 *  association �ֲ���ѯ
    	 */
    	SqlSessionFactory sqlFactory  = getSqlSessionFactory();
    	SqlSession session = sqlFactory.openSession();
    	DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
    	Department de = mapper.getDeptByIdPlus(1);
    	System.out.println(de.getEmps());
//    	System.out.println(de.getDept());
    	
    	session.commit();
    	session.close();
    }
    
    @Test
    public void fun8() throws IOException {
    	/* 
    	 *  association �ֲ���ѯ
    	 */
    	SqlSessionFactory sqlFactory  = getSqlSessionFactory();
    	SqlSession session = sqlFactory.openSession();
    	DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
    	Department de = mapper.getDeptByIdStep(1);
    	System.out.println(de);
    	System.out.println(de.getEmps());
//    	System.out.println(de.getDept());
    	session.commit();
    	session.close();
    }
    
}
