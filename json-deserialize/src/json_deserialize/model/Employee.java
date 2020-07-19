package json_deserialize.model;

public class Employee {

	private int empId;
	private String empName;
	private String empDept;
	
	public int getEmpId() {
		return empId;
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public String getEmpAd() {
		return empName;
	}
	
	public void setEmpAd(String empName) {
		this.empName = empName;
	}
	
	public String getEmpDept() {
		return empDept;
	}
	
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	@Override
	public String toString() {
		return "Employee [Id = " + empId + ", empName = " + empName + ", empDept = " + empDept + "]";
	}
	
}
