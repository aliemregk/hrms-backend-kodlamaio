package springproject.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springproject.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

	Employer getByEmail(String email);

	List<Employer> getAllByCompanyName(String companyName);

	boolean existsByEmail(String email);
}
