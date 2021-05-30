package hrms.Project.Hrms.business.concretes;

import hrms.Project.Hrms.business.abstracts.JobAdvertisementService;
import hrms.Project.Hrms.business.constants.Messages;
import hrms.Project.Hrms.core.utilities.results.DataResult;
import hrms.Project.Hrms.core.utilities.results.Result;
import hrms.Project.Hrms.core.utilities.results.SuccessDataResult;
import hrms.Project.Hrms.core.utilities.results.SuccessResult;
import hrms.Project.Hrms.dataAccess.abstracts.JobAdvertisementDao;
import hrms.Project.Hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(Messages.successfullyListed, this.jobAdvertisementDao.findAll());
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult(Messages.successfullyAdded);
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByIsActiveTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(Messages.successfullyListed, this.jobAdvertisementDao.findByIsActiveTrue());
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByUpdatedAtAndIsActiveTrue(LocalDate localDate) {
        return new SuccessDataResult<List<JobAdvertisement>>(Messages.successfullyListed, this.jobAdvertisementDao.findByUpdatedAtAndIsActiveTrue(localDate));
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByEmployerId(int id) {
        return new SuccessDataResult<List<JobAdvertisement>>(Messages.successfullyListed, this.jobAdvertisementDao.findByEmployerId(id));
    }

    @Override
    public DataResult<JobAdvertisement> updateStatusJobAdvertisement(int id, boolean status) {
        JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(id);

        jobAdvertisement.setActive(status);

        this.jobAdvertisementDao.save(jobAdvertisement);

        return new SuccessDataResult<>(Messages.updateJobAdvertisementSuccess, jobAdvertisement);

    }

    @Override
    public DataResult<List<JobAdvertisement>> findByEmployer_CompanyName(String companyName) {
        return new SuccessDataResult<List<JobAdvertisement>>(Messages.successfullyListed, this.jobAdvertisementDao.findByEmployer_CompanyName(companyName));
    }
}
