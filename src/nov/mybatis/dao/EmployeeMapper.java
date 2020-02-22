package nov.mybatis.dao;

import nov.mybatis.bean.Employee;

public interface EmployeeMapper {

	public Employee getEmpById(Integer id);
	public void updateEmp(Employee emp);
	public void addEmp(Employee emp);
	public void deleteEmpById(Integer id);
	
}
