package springproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springproject.hrms.entities.concretes.Resume;

@Repository
public interface ResumeDao extends JpaRepository<Resume, Integer> {

    Resume getByEmployee_EmployeeId(int id);

    Resume getByEmployee_Email(String email);
}
