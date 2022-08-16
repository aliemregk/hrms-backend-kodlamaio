package springproject.hrms.business.abstracts;

import java.util.List;

import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.entities.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getAll();

	DataResult<Employer> getById(int id);

	DataResult<Employer> getByEmail(String email);

	DataResult<List<Employer>> getAllByCompanyName(String companyName);

	Result add(Employer employer);

	Result delete(Employer employer);

	Result update(Employer employer);

	Result confirmEmployer(int id);
}
