package enus;

import lab3.Languages;
import lab3.Person;

public class PersonENUS extends Person {

	public PersonENUS(PersonBuilder personBuilder) {
		super(personBuilder);
	}

	@Override
	public String getName() {
		return "Mr(s) " + this.firstName + " " + this.lastName;
	}

	@Override
	public String getPhone() {
		return this.phone;
	}

}
