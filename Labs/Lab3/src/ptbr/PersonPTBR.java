package ptbr;

import lab3.Languages;
import lab3.Person;

public class PersonPTBR extends Person {

	public PersonPTBR(PersonBuilder personBuilder) {
		super(personBuilder);
	}

	@Override
	public String getName() {
		return "Sr(a) " + this.firstName + " " + this.lastName;
	}

	@Override
	public String getPhone() {
		return this.phone;
	}
}
