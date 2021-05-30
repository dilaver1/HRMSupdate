package hrms.Project.Hrms.core.adapters.abstracts;

import hrms.Project.Hrms.entities.abstracts.IndividualUser;

public interface VerificationService {

	boolean isRealPerson(IndividualUser individualUser);
}
