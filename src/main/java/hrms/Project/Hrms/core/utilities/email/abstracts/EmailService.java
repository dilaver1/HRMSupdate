package hrms.Project.Hrms.core.utilities.email.abstracts;

public interface EmailService {

	boolean isTheLinkClicked();

	String sendToVerificationMail(String email);
}
