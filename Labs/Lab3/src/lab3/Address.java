package lab3;

public class Address {
	private String street;
	private String zipcode;
	private String city;
	private String state;
	private String country;
	
	public Address(String street, String zipcode, String city, String state, String country) {
		this.street = street;
		this.zipcode = zipcode;
		this.city = city;
		this.state = state;
		this.country = country;
	}
	
	public String toPrint() {
		return street + ", " + zipcode + ", " + city + ", " + state + ", " + country;
	}
}
