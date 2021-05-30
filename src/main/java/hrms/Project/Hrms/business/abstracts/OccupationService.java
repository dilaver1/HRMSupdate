package hrms.Project.Hrms.business.abstracts;

import hrms.Project.Hrms.core.utilities.results.DataResult;
import hrms.Project.Hrms.core.utilities.results.Result;
import hrms.Project.Hrms.entities.concretes.Occupation;

import java.util.List;

public interface OccupationService {

	DataResult<List<Occupation>> getAll();

	Result add(Occupation occupation);
}
