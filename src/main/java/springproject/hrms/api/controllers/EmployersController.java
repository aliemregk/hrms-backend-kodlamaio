package springproject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springproject.hrms.business.abstracts.EmployerService;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.entities.concretes.Employer;

@CrossOrigin
@RestController
@RequestMapping("/api/employers")
public class EmployersController {

	private EmployerService employerService;

	@Autowired
	protected EmployersController(EmployerService employerService) {
		this.employerService = employerService;
	}

	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll() {
		return this.employerService.getAll();
	}

	@GetMapping("/getbyid")
	public DataResult<Employer> getById(int id) {
		return this.employerService.getById(id);
	}

	@GetMapping("/getbyemail")
	public DataResult<Employer> getByEmail(String email) {
		return this.employerService.getByEmail(email);
	}

	@GetMapping("/getallbycompanyname")
	public DataResult<List<Employer>> getAllByCompany(String companyName) {
		return this.employerService.getAllByCompanyName(companyName);
	}

	@PostMapping("/add")
	public Result add(@RequestBody Employer employer) {
		return this.employerService.add(employer);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody Employer employer) {
		return this.employerService.delete(employer);
	}

	@PostMapping("/update")
	public Result update(@RequestBody Employer employer) {
		return this.employerService.update(employer);
	}

	@PostMapping("/confirm")
	public Result confirmEmployer(int id) {
		return this.employerService.confirmEmployer(id);
	}
}
