package hrms.Project.Hrms.business.abstracts;

import hrms.Project.Hrms.core.utilities.results.DataResult;
import hrms.Project.Hrms.core.utilities.results.Result;
import hrms.Project.Hrms.entities.concretes.JobSeeker;

import java.util.List;

public interface JobSeekerService {

	DataResult<List<JobSeeker>> getAll();

	Result add(JobSeeker jobSeeker);
}
