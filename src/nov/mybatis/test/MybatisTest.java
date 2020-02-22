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
     * 1、根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象 有数据源一些运行环境信息
     * 2、sql映射文件；配置了每一个sql，以及sql的封装规则等。 
     * 3、将sql映射文件注册在全局配置文件中
     * 4、写代码：
     *         1）、根据全局配置文件得到SqlSessionFactory；
     *         2）、使用sqlSession工厂，获取到sqlSession对象使用他来执行增删改查
     *             一个sqlSession就是代表和数据库的一次会话，用完关闭
     *         3）、使用sql的唯一标志来告诉MyBatis执行哪个sql。sql都是保存在sql映射文件中的。
     * 
     * @throws IOException
     */
    @Test
    public void test() throws IOException {

        // 2、获取sqlSession实例，能直接执行已经映射的sql语句
        // sql的唯一标识：statement Unique identifier matching the statement to use.
        // 执行sql要用的参数：parameter A parameter object to pass to the statement.
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
    	 * 用接口的方式 取出数据
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
    	/* 测试增删改的方法
    	 * 一定要手动提交commit
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
    	/* 测试自定义查询
    	 *  注意 数据库外连接 可能会报错  应该显示一条记录 却查询出三条
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
    	 *  association定义关联对象的封装规则
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
    	 *  association 分步查询
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
    	 *  association 分步查询
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
    	 *  association 分步查询
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
