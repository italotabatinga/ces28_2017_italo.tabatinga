package lab3;

public class CommercialLetter extends LetterBuilder {
	public CommercialLetter(Person sender, Person destinatary, Address senderAddress, Address destinataryAddress, Date date) {
		super(sender, destinatary, senderAddress, destinataryAddress, date);
	}
	
	protected String buildHeader() {
		return _date.toPrint() + "\n\n" + _sender.getFirstName() + " " + _sender.getLastName()+ "\n" +
				_senderAddress.toPrint() + "\n" + _destinatary.getFirstName() + " " + _destinatary.getLastName() +
				"\n" + _destinataryAddress.toPrint() + "\n\n";
	}
	
	protected String buildBody() {
		return "Dear " + _destinatary.getFirstName() + "\n";
	}
	
	protected String buildConclusion() {
		return "\nSincerely,";
	}
	
	protected String buildSignature() {
		return "\n\n                    ---------\n"
				+ _sender.getFirstName() + "\n            " + _sender.getPhone() +
				"\n            email:" + _sender.getEmail();
	}
}
