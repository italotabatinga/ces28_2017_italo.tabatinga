package lab3;

import enus.PersonENUS;
import ptbr.PersonPTBR;

public abstract class Person {
	protected String firstName;
	protected String lastName;
	protected String phone;
	protected String email;
	protected Languages language;
	
	protected Person(PersonBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.phone = builder.phone;
		this.email = builder.email;
		this.language = builder.language;
	}
	
	public static class PersonBuilder {
		private String firstName;
		private String lastName;
		private String phone;
		private String email;
		private Languages language;
		
		public PersonBuilder (String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
			language = Languages.ENUS;
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
		
		public PersonBuilder language(Languages language) {
			this.language = language;
			return this;
		}
		
		public Person build() {
			switch (this.language) {
				case PTBR:
					return new PersonPTBR(this);
				case ENUS:
					return new PersonENUS(this);
				default:
					return null;
			}	
		}
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public abstract String getName();

	public abstract String getPhone();

	public String getEmail() {
		return this.email;
	}
}
