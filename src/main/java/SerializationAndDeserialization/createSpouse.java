package SerializationAndDeserialization;

public class createSpouse {
	String name ;
	String mail;
	int[] phone;
	public createSpouse(String name, String mail, int[] phone) {
		super();
		this.name = name;
		this.mail = mail;
		this.phone = phone;
	}

	public createSpouse() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int[] getPhone() {
		return phone;
	}

	public void setPhone(int[] phone) {
		this.phone = phone;
	}
	
}
