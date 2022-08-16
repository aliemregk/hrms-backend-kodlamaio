package springproject.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springproject.hrms.business.abstracts.EmployerService;
import springproject.hrms.constants.Messages;
import springproject.hrms.core.utilities.results.ErrorResult;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.core.utilities.results.dataResults.ErrorDataResult;
import springproject.hrms.core.utilities.results.dataResults.SuccessDataResult;
import springproject.hrms.dataAccess.abstracts.EmployerDao;
import springproject.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private String message = "Employer(s) ";

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), this.message + Messages.LISTED);
	}

	@Override
	public DataResult<Employer> getById(int id) {
		Optional<Employer> result = this.employerDao.findById(id);

		if (result.isPresent()) {
			return new SuccessDataResult<Employer>(result.get(), this.message + Messages.LISTED);
		} else {
			return new ErrorDataResult<Employer>(Messages.CANT_GET);
		}
	}

	@Override
	public DataResult<Employer> getByEmail(String email) {
		return new SuccessDataResult<Employer>(this.employerDao.getByEmail(email), this.message + Messages.LISTED);
	}

	@Override
	public DataResult<List<Employer>> getAllByCompanyName(String companyName) {
		return new SuccessDataResult<>(this.employerDao.getAllByCompanyName(companyName),
				this.message + Messages.LISTED);
	}

	@Override
	public Result add(Employer employer) {
		boolean result = this.employerDao.existsByEmail(employer.getEmail());

		if (result) {
			return new ErrorResult(employer.getEmail() + Messages.EXISTS);
		} else {
			return new SuccessDataResult<>(this.employerDao.save(employer), employer.getEmail() + Messages.ADDED);
		}
	}

	@Override
	public Result delete(Employer employer) {
		this.employerDao.delete(employer);
		return new SuccessDataResult<>(employer.getEmail() + Messages.DELETED);
	}

	@Override
	public Result update(Employer employer) {
		return new SuccessDataResult<>(this.employerDao.save(employer), employer.getEmail() + Messages.UPDATED);
	}

	@Override
	public Result confirmEmployer(int id) {
		Employer employerToConfirm = getById(id).getData();

		if (employerToConfirm.isConfirmed()) {
			return new ErrorDataResult<>(employerToConfirm.getEmail() + Messages.ALREADY_CONFIRMED);
		} else if (!employerToConfirm.isConfirmed()) {
			employerToConfirm.setConfirmed(true);
			return new SuccessDataResult<>(this.employerDao.save(employerToConfirm),
					employerToConfirm.getEmail() + Messages.CONFIRMED);
		} else {
			return new ErrorDataResult<>(employerToConfirm.getEmail() + Messages.CANT_CONFIRMED);
		}
	}

}
