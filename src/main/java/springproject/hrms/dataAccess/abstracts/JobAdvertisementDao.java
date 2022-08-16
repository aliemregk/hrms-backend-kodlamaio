package springproject.hrms.dataAccess.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import springproject.hrms.entities.concretes.JobAdvertisement;
import springproject.hrms.entities.dtos.JobAdvertisementDetailDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	@Query("From JobAdvertisement where isActive = true")
	  List<JobAdvertisement> getAllByIsActive();

	List<JobAdvertisement> getAllByLastApply(Date date);

	List<JobAdvertisement> getAllByJobTitle_TitleName(String jobTitleName);

	List<JobAdvertisement> getAllByEmployer_Email(String employerEmail);

	@Query("From JobAdvertisement where employer.companyName=:companyName and isActive = true")
	List<JobAdvertisement> getAllByEmployer_CompanyNameAndIsActive(String companyName);

	@Query("Select new springproject.hrms.entities.dtos.JobAdvertisementDetailDto"
			+ "(ja.id, ja.description, e.companyName, jt.titleName)"
			+ "From Employer e, JobTitle jt, JobAdvertisement ja")

	List<JobAdvertisementDetailDto> getJobAdvertisementDetails();
}
