package springproject.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springproject.hrms.business.abstracts.EmployeeService;
import springproject.hrms.constants.Messages;
import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.core.utilities.results.dataResults.ErrorDataResult;
import springproject.hrms.core.utilities.results.dataResults.SuccessDataResult;
import springproject.hrms.dataAccess.abstracts.EmployeeDao;
import springproject.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeDao employeeDao;
	private String message = "Employee(s) ";

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(), this.message + Messages.LISTED);
	}

	@Override
	public DataResult<Employee> getById(int id) {
		Optional<Employee> result = this.employeeDao.findById(id);

		if (result.isPresent()) {
			return new SuccessDataResult<>(result.get(), this.message + Messages.LISTED);
		} else {
			return new ErrorDataResult<>(Messages.CANT_GET);
		}
	}

	@Override
	public DataResult<Employee> getByEmail(String email) {

		Employee result = this.employeeDao.getByEmail(email);

		if (result != null) {
			return new SuccessDataResult<>(result, this.message + Messages.LISTED);
		} else {
			return new ErrorDataResult<>(Messages.CANT_GET);
		}
	}

	@Override
	public DataResult<Employee> getByNationalId(String nationalIdentity) {
		return new SuccessDataResult<>(this.employeeDao.getByNationalIdentity(nationalIdentity),
				this.message + Messages.LISTED);
	}

	@Override
	public DataResult<Employee> add(Employee employee) {
		boolean result = employeeDao.existsByEmailOrNationalIdentity(employee.getEmail(),
				employee.getNationalIdentity());
		if (result) {
			return new ErrorDataResult<>(employee.getEmail() + Messages.EXISTS);
		} else {
			this.employeeDao.save(employee);
			return new SuccessDataResult<>(employee.getEmail() + Messages.ADDED);
		}
	}

	@Override
	public DataResult<Employee> delete(Employee employee) {
		this.employeeDao.delete(employee);
		return new SuccessDataResult<>(employee.getEmail() + Messages.DELETED);
	}

	@Override
	public DataResult<Employee> update(Employee employee) {
		this.employeeDao.save(employee);
		return new SuccessDataResult<>(employee.getEmail() + Messages.UPDATED);
	}

	@Override
	public DataResult<Employee> confirmEmployee(int id) {
		Employee employeeToConfirm = getById(id).getData();

		if (employeeToConfirm.isConfirmed()) {
			return new SuccessDataResult<>(employeeToConfirm.getEmail() + Messages.ALREADY_CONFIRMED);
		} else if (!employeeToConfirm.isConfirmed()) {
			employeeToConfirm.setConfirmed(true);
			update(employeeToConfirm);
			return new SuccessDataResult<>(employeeToConfirm.getEmail() + Messages.CONFIRMED);
		} else {
			return new ErrorDataResult<>(employeeToConfirm.getEmail() + Messages.CANT_CONFIRMED);
		}
	}

}
