package PojoClass;

public class CreateCustomerPojo {
	
	String firstname;
	String secondname;
	String emailId;
	long phoneNumber;
	
	public CreateCustomerPojo(String firstname, String secondname, String emailId, long phoneNumber) {
		super();
		this.firstname = firstname;
		this.secondname = secondname;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getphoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
