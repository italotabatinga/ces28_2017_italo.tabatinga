package lab3;

import enus.CommercialLetterENUS;
import enus.InterviewInvitationENUS;
import ptbr.CommercialLetterPTBR;
import ptbr.InterviewInvitationPTBR;

public abstract class InterviewInvitation{
	protected String _position;
	protected  Date _interviewDate;
	protected Person _sender;
	protected Person _destinatary;
	protected Address _senderAddress;
	protected Address _destinataryAddress;
	protected Date _date;
	protected Languages _language;
	
	protected InterviewInvitation (Languages language, Person sender, Person destinatary,
			Address senderAddress, Address destinataryAddress, Date date, String position, Date interviewDate) {
		_sender = sender;
		_destinatary = destinatary;
		_senderAddress = senderAddress;
		_destinataryAddress = destinataryAddress;
		_date = date;
		_position = position;
		_interviewDate = interviewDate;
		_language = language;
	}
	
	public static InterviewInvitation getLetter(Languages language, Person sender, Person destinatary,
			Address senderAddress, Address destinataryAddress, Date date, String position, Date interviewDate) {
		InterviewInvitation letter = null;
		switch(language) {
			case PTBR:
				letter = new InterviewInvitationPTBR(sender, destinatary, senderAddress, destinataryAddress, date,
						position, interviewDate);
				break;
			case ENUS:
				letter = new InterviewInvitationENUS(sender, destinatary, senderAddress, destinataryAddress, date,
						position, interviewDate);
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
		return getInvitationMSG();
	}

	protected String buildConclusion() {
		return getGoodLuck();
	}

	protected String buildSignature() {
		return _sender.getFirstName() + "\n"
				+ _senderAddress.toPrint() + "\n"
				+ _sender.getPhone() + "\n"
				+ _sender.getEmail();
	}
	
	public String model() {
		return buildHeader() + buildBody() + buildConclusion() + buildSignature();
	}
	
	protected abstract String getInvitationMSG();
	protected abstract String getGoodLuck();
}
