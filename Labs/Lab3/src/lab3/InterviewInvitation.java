package lab3;

public class InterviewInvitation extends LetterBuilder{
	private String _position;
	private Date _interviewDate;
	
	public InterviewInvitation(Person sender, Person destinatary, Address senderAddress, Address destinataryAddress,
			Date date, String position, Date interviewDate) {
		super(sender, destinatary, senderAddress, destinataryAddress, date);
		this._position = position;
		this._interviewDate = interviewDate;
	}
	
	protected String buildHeader() {
		return _date.toPrint() + "\n\n" + _sender.getFirstName() + " " + _sender.getLastName()+ "\n" +
				_senderAddress.toPrint() + "\n" + _destinatary.getFirstName() + " " + _destinatary.getLastName() +
				"\n" + _destinataryAddress.toPrint() + "\n\n";
	}

	protected String buildBody() {
		return "Dear, " + _destinatary.getFirstName() + " " + _destinatary.getLastName() + ",\n\n" +
				"As result of your application for the position of " + _position + ", I would like "
				+ "to invite you to attend on " + _interviewDate.toPrint() + " at our office.\n\n";
	}

	protected String buildConclusion() {
		return "Best regards,\n\n";
	}

	protected String buildSignature() {
		return _sender.getFirstName() + " " + _sender.getLastName() + "\n"
				+ _senderAddress.toPrint() + "\n"
				+ _sender.getPhone() + "\n"
				+ _sender.getEmail();
	}

}
