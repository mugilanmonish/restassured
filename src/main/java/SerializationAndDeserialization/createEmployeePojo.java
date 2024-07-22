package SerializationAndDeserialization;


public class createEmployeePojo {
	String name;
	String Job;
	int empid;
	String email;
	
	public createEmployeePojo(String name, String Job, int empid, String email) {
		super();
		this.name = name;
		this.Job = Job;
		this.empid = empid;
		this.email = email;
	}
	
	public createEmployeePojo() {
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
