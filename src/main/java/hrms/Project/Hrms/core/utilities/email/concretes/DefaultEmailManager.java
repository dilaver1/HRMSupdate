package hrms.Project.Hrms.core.utilities.email.concretes;

import hrms.Project.Hrms.core.utilities.email.abstracts.EmailService;
import org.springframework.stereotype.Service;

@Service
public class DefaultEmailManager implements EmailService {
	@Override
	public boolean isTheLinkClicked() {
		return true;
	}

	@Override
	public String sendToVerificationMail(String email) {
		return "Confirmation email has been sent. Please check your inbox";
	}
}
