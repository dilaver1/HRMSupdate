package hrms.Project.Hrms.business.concretes;

import hrms.Project.Hrms.business.abstracts.EmployerService;
import hrms.Project.Hrms.core.utilities.email.abstracts.EmailService;
import hrms.Project.Hrms.business.constants.Messages;
import hrms.Project.Hrms.core.utilities.results.*;
import hrms.Project.Hrms.dataAccess.abstracts.EmployerDao;
import hrms.Project.Hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailService emailService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailService emailService) {
		this.employerDao = employerDao;
		this.emailService = emailService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(Messages.successfullyListed, this.employerDao.findAll());
	}

	@Override
	public Result add(Employer employer) {

		if (!isFieldsEmpty(employer.getEmail(), employer.getWebsite(), employer.getEmail(), employer.getPasswordHash(),
				employer.getPhoneNumber(), employer.getCompanyName())) {
			return new ErrorResult(Messages.requiredFields);
		} else if (!isCompanyEmail(employer.getEmail(), employer.getWebsite())) {
			return new ErrorResult(Messages.wrongMailFormat);
		} else if (this.employerDao.findByEmail(employer.getEmail()) != null) {
			return new ErrorResult(Messages.existInSystem);
		} else if (!emailService.isTheLinkClicked()) {
			return new ErrorResult(Messages.notVerifyMail);
		} else {
			this.employerDao.save(employer);
			return new SuccessResult(Messages.successfullyAdded);
		}
	}

	private boolean isCompanyEmail(String email, String webSite) {

		if (email == null || email.isEmpty())
			return false;

		String[] array = webSite.split(".");

		String finalString = "";

		for (int i = 1; i < array.length; i++) {
			finalString += array[i];
		}

		String emailRegex = "info@" + finalString;
		Pattern pattern = Pattern.compile(emailRegex);

		return pattern.matcher(email).matches();
	}

	public boolean isFieldsEmpty(String... args) {
		for (String s : args) {
			if (s.isEmpty() || s == null) {
				return true;
			}
		}
		return false;
	}
}
