package hrms.Project.Hrms.business.concretes;

import hrms.Project.Hrms.business.abstracts.OccupationService;
import hrms.Project.Hrms.business.constants.Messages;
import hrms.Project.Hrms.core.utilities.results.*;
import hrms.Project.Hrms.dataAccess.abstracts.OccupationDao;
import hrms.Project.Hrms.entities.concretes.Occupation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OccupationManager implements OccupationService {

	private OccupationDao occupationDao;

	@Autowired
	public OccupationManager(OccupationDao occupationDao) {
		this.occupationDao = occupationDao;
	}

	@Override
	public DataResult<List<Occupation>> getAll() {
		return new SuccessDataResult<List<Occupation>>(Messages.successfullyListed, this.occupationDao.findAll());
	}

	@Override
	public Result add(Occupation occupation) {
		if (this.occupationDao.findByName(occupation.getName()) != null) {
			return new ErrorResult(Messages.existInRecords);
		} else {
			this.occupationDao.save(occupation);
			return new SuccessResult(Messages.successfullyAdded);
		}
	}
}
