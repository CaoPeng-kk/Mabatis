package nov.mybatis.bean;

public class Employee_2 {

	private Integer id ;
	private String name ;
	private String gender ;
	private String email ;
	private String dId;
	private Department dept;
	public String getdId() {
		return dId;
	}
	public void setdId(String dId) {
		this.dId = dId;
	}
	public Integer getId() {
		return id;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee_2 [id=" + id + ", name=" + name + ", gender=" + gender + ", email=" + email + ", dId=" + dId
				+ ", dept=" + dept + "]";
	}
	public Employee_2() {
		super();
	}
	
}
