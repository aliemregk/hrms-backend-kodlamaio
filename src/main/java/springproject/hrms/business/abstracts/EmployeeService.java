package springproject.hrms.business.abstracts;

import java.util.List;

import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.entities.concretes.Employee;

public interface EmployeeService {
	DataResult<List<Employee>> getAll();

	DataResult<Employee> getById(int id);

	DataResult<Employee> getByEmail(String email);

	DataResult<Employee> getByNationalId(String nationalIdentity);

	DataResult<Employee> add(Employee employee);

	DataResult<Employee> delete(Employee employee);

	DataResult<Employee> update(Employee employee);

	DataResult<Employee> confirmEmployee(int id);
}
