package nov.mybatis.dao;

import java.util.List;

import nov.mybatis.bean.Department;
import nov.mybatis.bean.Employee_2;

public interface DepartmentMapper {

	public Department getDeptById(Integer id);
	
	public Department getDeptByIdPlus(Integer id);
	
	public Department getDeptByIdStep(Integer id);
}
