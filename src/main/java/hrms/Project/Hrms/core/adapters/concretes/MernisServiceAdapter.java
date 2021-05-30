package hrms.Project.Hrms.core.adapters.concretes;

import hrms.Project.Hrms.core.adapters.abstracts.VerificationService;
import hrms.Project.Hrms.entities.abstracts.IndividualUser;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements VerificationService {

	@Override
	public boolean isRealPerson(IndividualUser individualUser) {

		return true;
	}
}
