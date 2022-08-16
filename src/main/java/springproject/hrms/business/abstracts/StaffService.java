package springproject.hrms.business.abstracts;

import java.util.List;

import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.entities.concretes.Staff;

public interface StaffService {
	DataResult<List<Staff>> getAll();

	DataResult<Staff> getById(int id);

	DataResult<Staff> getByEmail(String email);

	Result add(Staff staff);

	Result delete(Staff staff);

	Result update(Staff staff);
}
