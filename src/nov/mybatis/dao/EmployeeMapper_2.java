package nov.mybatis.dao;

import java.util.List;

import nov.mybatis.bean.Employee_2;

public interface EmployeeMapper_2 {
	
	public Employee_2 getEmpAndDept(Integer id);
	
	public Employee_2 getEmpByIdStep(Integer id);
	
	public List<Employee_2> getEmpsByDeptId(Integer id);
	
}
