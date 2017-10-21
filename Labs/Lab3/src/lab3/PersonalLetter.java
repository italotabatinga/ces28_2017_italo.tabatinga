package lab3;

import enus.CommercialLetterENUS;
import enus.PersonalLetterENUS;
import ptbr.CommercialLetterPTBR;
import ptbr.PersonalLetterPTBR;

public abstract class PersonalLetter {
	protected Person _sender;
	protected Person _destinatary;
	protected Address _senderAddress;
	protected Address _destinataryAddress;
	protected Date _date;
	protected Languages _language;
	
	protected PersonalLetter (Languages language, Person sender, Person destinatary,
			Address senderAddress, Address destinataryAddress, Date date) {
		_sender = sender;
		_destinatary = destinatary;
		_senderAddress = senderAddress;
		_destinataryAddress = destinataryAddress;
		_date = date;
		_language = language;
	}
	
	public static PersonalLetter getLetter(Languages language, Person sender, Person destinatary,
			Address senderAddress, Address destinataryAddress, Date date) {
		PersonalLetter letter = null;
		switch(language) {
			case PTBR:
				letter = new PersonalLetterPTBR(sender, destinatary, senderAddress, destinataryAddress, date);
				break;
			case ENUS:
				letter = new PersonalLetterENUS(sender, destinatary, senderAddress, destinataryAddress, date);
				break;
		}
		return letter;
	}
	
	protected String buildHeader() {
		return _date.toPrint() + "\n\n" + _sender.getName()+ "\n" +
				_senderAddress.toPrint() + "\n" + _destinatary.getName() +
				"\n" + _destinataryAddress.toPrint() + "\n\n";
	}
	
	protected String buildBody() {
		return this.getCompliments();
	}
	
	protected String buildConclusion() {
		return this.getBye();
	}
	
	protected String buildSignature() {
		return "\n\n                    ---------\n"
				+ _sender.getFirstName();
	}
	
	public String model() {
		return buildHeader() + buildBody() + buildConclusion() + buildSignature();
	}
	
	protected abstract String getCompliments();
	protected abstract String getBye();
}
