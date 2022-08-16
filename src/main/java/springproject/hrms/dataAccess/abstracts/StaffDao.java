package springproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import springproject.hrms.entities.concretes.Staff;

public interface StaffDao extends JpaRepository<Staff, Integer> {

	Staff getByEmail(String email);

	boolean existsByEmail(String email); 
}
