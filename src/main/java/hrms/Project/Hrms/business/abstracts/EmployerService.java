package hrms.Project.Hrms.business.abstracts;

import hrms.Project.Hrms.core.utilities.results.DataResult;
import hrms.Project.Hrms.core.utilities.results.Result;
import hrms.Project.Hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {

	DataResult<List<Employer>> getAll();

	Result add(Employer employer);
}
