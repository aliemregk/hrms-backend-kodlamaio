package springproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import springproject.hrms.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	Employee getByEmail(String email);

	Employee getByNationalIdentity(String nationalIdentity);

	boolean existsByEmailOrNationalIdentity(String email, String nationalIdentity);
}
