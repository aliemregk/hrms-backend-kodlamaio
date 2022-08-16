package springproject.hrms.business.abstracts;

import java.util.Date;
import java.util.List;

import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.entities.concretes.JobAdvertisement;
import springproject.hrms.entities.dtos.JobAdvertisementDetailDto;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();

	DataResult<List<JobAdvertisement>> getAllByLastApply(Date date);

	DataResult<List<JobAdvertisement>> getAllByJobTitleName(String jobTitleName);

	DataResult<List<JobAdvertisement>> getAllByEmployer(String employerEmail);

	DataResult<List<JobAdvertisement>> getAllActives();

	DataResult<List<JobAdvertisement>> getAllByCompanyNameAndIsActive(String companyName);

	DataResult<List<JobAdvertisementDetailDto>> getJobAdvertisementDetails();

	Result add(JobAdvertisement jobAdvertisement);

	Result delete(JobAdvertisement jobAdvertisement);

	Result update(JobAdvertisement jobAdvertisement);

	Result closeJobAdvertisement(int id);

}
