package lab3;

public class Person {
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	
	private Person(PersonBuilder builder) {
		this.firstName = builder.getFirstName();
		this.lastName = builder.getLastName();
		this.phone = builder.getPhone();
		this.email = builder.getEmail();
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}
	
	public static class PersonBuilder implements PersonBuilderInterface{
		private String firstName;
		private String lastName;
		private String phone;
		private String email;
		
		public PersonBuilder (String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public PersonBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		public PersonBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public PersonBuilder phone(String phone) {
			this.phone = phone;
			return this;
		}
		
		public PersonBuilder email(String email) {
			this.email = email;
			return this;
		}
		
		public Person build() {
			return new Person(this);
		}

		public String getFirstName() {
			return firstName;
		}
		
		public String getLastName() {
			return lastName;
		}
		
		public String getPhone() {
			return phone;
		}
		
		public String getEmail() {
			return email;
		}
	}
}
