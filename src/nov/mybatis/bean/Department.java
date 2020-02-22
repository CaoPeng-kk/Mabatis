package nov.mybatis.bean;

import java.util.List;

public class Department {
	
	private Integer id;
	private String deptName;
	private List<Employee_2> emps;
	
	public List<Employee_2> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee_2> emps) {
		this.emps = emps;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", deptName=" + deptName + "]";
	}
	
	
}
