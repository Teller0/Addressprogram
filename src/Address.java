public class Address {
	private String lastname;
	private String givenname;
	private String phonenumber;
	private int id;
	
	public Address(String lastname, String givenname, String phonenumber, int id) {
		this.lastname = lastname;
		this.givenname = givenname;
		this.phonenumber = phonenumber;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Address [lastname=" + lastname + ", givenname=" + givenname
				+ ", phonenumber=" + phonenumber + ", id=" + id + "]";
	}
	public String getLastname() {
		return lastname;
	}
	public String getGivenname() {
		return givenname;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public int getId() {
		return id;
	}
}
