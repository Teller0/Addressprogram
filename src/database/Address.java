package database;

public class Address {
	private String lastName;
	private String givenName;
	private String phoneNumber;
	private int id;

	public Address(String lastName, String givenName, String phoneNumber, int id) {
		this.lastName = lastName;
		this.givenName = givenName;
		this.phoneNumber = phoneNumber;
		this.id = id;
	}

	public Address(String lastName, String givenName, String phoneNumber) {
		this(lastName, givenName, phoneNumber, 0);
	}

	@Override
	public String toString() {
		return "Address [lastName=" + lastName + ", givenName=" + givenName
				+ ", phoneNumber=" + phoneNumber + ", id=" + id + "]";
	}

	public String getLastName() {
		return lastName;
	}

	
	public String getGivenName() {
		return givenName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public int getId() {
		return id;
	}
}
