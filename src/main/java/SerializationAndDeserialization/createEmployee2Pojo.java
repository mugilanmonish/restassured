package SerializationAndDeserialization;

public class createEmployee2Pojo {
	String name;
	String Job;
	int empid;
	String[] email;
	public createEmployee2Pojo(String name, String job, int empid, String[] email) {
		super();
		this.name = name;
		Job = job;
		this.empid = empid;
		this.email = email;
	}
	
	public createEmployee2Pojo() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return Job;
	}
	public void setJob(String job) {
		Job = job;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String[] getEmail() {
		return email;
	}
	public void setEmail(String[] email) {
		this.email = email;
	}

}
