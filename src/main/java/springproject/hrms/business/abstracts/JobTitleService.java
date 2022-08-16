package springproject.hrms.business.abstracts;

import java.util.List;

import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	DataResult<List<JobTitle>> getAll();

	DataResult<JobTitle> getById(int id);


	Result add(JobTitle jobTitle);

	Result delete(JobTitle jobTitle);

	Result update(JobTitle jobTitle);
}
