package springproject.hrms.api.controllers;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springproject.hrms.business.abstracts.JobAdvertisementService;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.entities.concretes.JobAdvertisement;
import springproject.hrms.entities.dtos.JobAdvertisementDetailDto;

@CrossOrigin
@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	protected JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}

	@GetMapping("/getallbylastapply")
	public DataResult<List<JobAdvertisement>> getAllByLastApply(@RequestParam String date) throws Exception {
		return this.jobAdvertisementService.getAllByLastApply(new SimpleDateFormat("yyyy-MM-dd").parse(date));
	}

	@GetMapping("/getallbyjobtitlename")
	public DataResult<List<JobAdvertisement>> getAllByJobTitle_TitleName(@RequestParam String jobTitleName) {
		return this.jobAdvertisementService.getAllByJobTitleName(jobTitleName);
	}

	@GetMapping("/getallbyemployer")
	public DataResult<List<JobAdvertisement>> getAllByEmployer_Email(@RequestParam String employerEmail) {
		return this.jobAdvertisementService.getAllByEmployer(employerEmail);
	}

	@GetMapping("/getallactives")
	public DataResult<List<JobAdvertisement>> getAllActive() {
		return this.jobAdvertisementService.getAllActives();
	}

	@GetMapping("/getallactivesbycompany")
	public DataResult<List<JobAdvertisement>> getAllByCompanyNameAndIsActive(
			@RequestParam("companyName") String companyName) {
		return this.jobAdvertisementService.getAllByCompanyNameAndIsActive(companyName);
	}

	@GetMapping("/getjobadvertisementdetail")
	public DataResult<List<JobAdvertisementDetailDto>> getJobAdvertisementDetails() {
		return this.jobAdvertisementService.getJobAdvertisementDetails();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.delete(jobAdvertisement);
	}

	@PostMapping("/update")
	public Result update(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.update(jobAdvertisement);
	}

	@PostMapping("/close")
	public Result close(@RequestParam int id) {
		return this.jobAdvertisementService.closeJobAdvertisement(id);
	}
}
