package springproject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import springproject.hrms.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {

	boolean existsByTitleName(String titleName);
}
