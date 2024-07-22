package SerializationAndDeserialization;

public class createEmployee3Pojo {
	String name;
	String Job;
	int empid;
	String[] email;
	createSpouse spouse;
	public createEmployee3Pojo(String name, String job, int empid, String[] email, createSpouse spouse) {
		super();
		this.name = name;
		Job = job;
		this.empid = empid;
		this.email = email;
		this.spouse = spouse;
	}
	public createEmployee3Pojo() {
		super();
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
	public createSpouse getSpouse() {
		return spouse;
	}
	public void setSpouse(createSpouse spouse) {
		this.spouse = spouse;
	}
	
}
