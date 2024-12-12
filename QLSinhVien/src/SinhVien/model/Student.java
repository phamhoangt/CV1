package SinhVien.model;

public class Student {
	private String id;
	private String firstName;
	private String secondName;
	private String address;
	public Student(String id, String firstName, String secondName, String address) {
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", address=" + address
				+ "]";
	}
}
