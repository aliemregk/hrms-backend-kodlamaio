package springproject.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springproject.hrms.business.abstracts.JobTitleService;
import springproject.hrms.constants.Messages;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.SuccessResult;
import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.core.utilities.results.dataResults.ErrorDataResult;
import springproject.hrms.core.utilities.results.dataResults.SuccessDataResult;
import springproject.hrms.dataAccess.abstracts.JobTitleDao;
import springproject.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {

	private JobTitleDao jobTitleDao;
	private String message = "Job title(s)";

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(), this.message + Messages.LISTED);
	}

	@Override
	public DataResult<JobTitle> getById(int id) {
		Optional<JobTitle> result = this.jobTitleDao.findById(id);

		if (result.isPresent()) {
			return new SuccessDataResult<JobTitle>(result.get(), this.message + Messages.LISTED);
		} else {
			return new ErrorDataResult<JobTitle>(Messages.CANT_GET);
		}
	}

	@Override
	public Result add(JobTitle jobTitle) {
		boolean result = this.jobTitleDao.existsByTitleName(jobTitle.getTitleName());

		if (result) {
			return new ErrorDataResult<>(jobTitle, this.message + Messages.EXISTS);
		} else {
			return new SuccessDataResult<>(this.jobTitleDao.save(jobTitle), jobTitle.getTitleName() + Messages.ADDED);
		}
	}

	@Override
	public Result delete(JobTitle jobTitle) {
		this.jobTitleDao.delete(jobTitle);
		return new SuccessResult(jobTitle.getTitleName() + Messages.DELETED);
	}

	@Override
	public Result update(JobTitle jobTitle) {
		return new SuccessDataResult<>(this.jobTitleDao.save(jobTitle), jobTitle.getTitleName() + Messages.UPDATED);
	}
}
