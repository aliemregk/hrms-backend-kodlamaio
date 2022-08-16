package springproject.hrms.business.concretes;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springproject.hrms.business.abstracts.JobAdvertisementService;
import springproject.hrms.constants.Messages;
import springproject.hrms.core.utilities.results.ErrorResult;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.SuccessResult;
import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.core.utilities.results.dataResults.SuccessDataResult;
import springproject.hrms.dataAccess.abstracts.JobAdvertisementDao;
import springproject.hrms.entities.concretes.JobAdvertisement;
import springproject.hrms.entities.dtos.JobAdvertisementDetailDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	private String message = "Job advertisement(s) ";

	@Autowired
	protected JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(),
				this.message + Messages.LISTED);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByLastApply(Date date) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByLastApply(date),
				this.message + Messages.LISTED);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByJobTitleName(String jobTitleName) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getAllByJobTitle_TitleName(jobTitleName),
				this.message + Messages.LISTED);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByEmployer(String employerEmail) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getAllByEmployer_Email(employerEmail),
				this.message + Messages.LISTED);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActives() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByIsActive(),
				this.message + Messages.LISTED);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByCompanyNameAndIsActive(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getAllByEmployer_CompanyNameAndIsActive(companyName),
				this.message + Messages.LISTED);
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		return new SuccessDataResult<>(this.jobAdvertisementDao.save(jobAdvertisement), this.message + Messages.ADDED);
	}

	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.delete(jobAdvertisement);
		return new SuccessResult(this.message + Messages.DELETED);
	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		return new SuccessDataResult<>(this.jobAdvertisementDao.save(jobAdvertisement),
				this.message + Messages.UPDATED);
	}

	@Override
	public Result closeJobAdvertisement(int id) {
		Optional<JobAdvertisement> result = this.jobAdvertisementDao.findById(id);
		if (result.isPresent()) {
			JobAdvertisement jobAdvertisementToClose = result.get();
			jobAdvertisementToClose.setActive(false);
			this.jobAdvertisementDao.save(jobAdvertisementToClose);
			return new SuccessResult("Job advertisement closed.");
		}
		return new ErrorResult("Error while closing job advertisement.");
	}

	@Override
	public DataResult<List<JobAdvertisementDetailDto>> getJobAdvertisementDetails() {
		return new SuccessDataResult<List<JobAdvertisementDetailDto>>(
				this.jobAdvertisementDao.getJobAdvertisementDetails());
	}

}
