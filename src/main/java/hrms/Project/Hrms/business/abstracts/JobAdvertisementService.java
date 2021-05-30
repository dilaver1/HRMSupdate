package hrms.Project.Hrms.business.abstracts;

import hrms.Project.Hrms.core.utilities.results.DataResult;
import hrms.Project.Hrms.core.utilities.results.Result;
import hrms.Project.Hrms.entities.concretes.JobAdvertisement;

import java.time.LocalDate;
import java.util.List;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();

	Result add(JobAdvertisement jobAdvertisement);

	DataResult<List<JobAdvertisement>> findByIsActiveTrue();

	DataResult<List<JobAdvertisement>> findByUpdatedAtAndIsActiveTrue(LocalDate localDate);

	DataResult<List<JobAdvertisement>> findByEmployerId(int id);

	DataResult<JobAdvertisement> updateStatusJobAdvertisement(int id, boolean status);

	DataResult<List<JobAdvertisement>> findByEmployer_CompanyName(String companyName);
}
