package hrms.Project.Hrms.business.concretes;

import hrms.Project.Hrms.business.abstracts.JobSeekerService;
import hrms.Project.Hrms.core.adapters.abstracts.VerificationService;
import hrms.Project.Hrms.core.utilities.email.abstracts.EmailService;
import hrms.Project.Hrms.business.constants.Messages;
import hrms.Project.Hrms.core.utilities.results.*;
import hrms.Project.Hrms.dataAccess.abstracts.JobSeekerDao;
import hrms.Project.Hrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private VerificationService verificationService;
	private EmailService emailService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, VerificationService verificationService,
			EmailService emailService) {
		this.jobSeekerDao = jobSeekerDao;
		this.verificationService = verificationService;
		this.emailService = emailService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(Messages.successfullyAdded, this.jobSeekerDao.findAll());
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		if (!isFieldsEmpty(jobSeeker.getEmail(), jobSeeker.getIdentityNumber(), jobSeeker.getFirstName(),
				jobSeeker.getLastName(), jobSeeker.getPasswordHash(),
				String.valueOf(jobSeeker.getDateOfBirth().getYear())))
			return new ErrorResult(Messages.requiredFields);

		else if (!verificationService.isRealPerson(jobSeeker)) {

			return new ErrorResult(Messages.notExistGovernment);

		} else if (this.jobSeekerDao.findByEmail(jobSeeker.getEmail()) != null
				|| this.jobSeekerDao.findByIdentityNumber(jobSeeker.getIdentityNumber()) != null) {

			return new ErrorResult(Messages.existInSystem);

		} else if (!emailService.isTheLinkClicked()) {

			return new ErrorResult(Messages.notVerifyMail);

		} else {
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult(Messages.successfullyAdded);
		}
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
