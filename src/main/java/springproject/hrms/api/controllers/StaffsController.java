package springproject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springproject.hrms.business.abstracts.StaffService;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.entities.concretes.Staff;

@CrossOrigin
@RestController
@RequestMapping("/api/staffs")
public class StaffsController {

	private StaffService staffService;

	@Autowired
	protected StaffsController(StaffService staffService) {
		this.staffService = staffService;
	}

	@GetMapping("/getall")
	public DataResult<List<Staff>> getAll() {
		return this.staffService.getAll();
	}

	@GetMapping("/getbyid")
	public DataResult<Staff> getById(int id) {
		return this.staffService.getById(id);
	}

	@GetMapping("/getbyemail")
	public DataResult<Staff> getByEmail(String email) {
		return this.staffService.getByEmail(email);
	}

	@PostMapping("/add")
	public Result add(@RequestBody Staff staff) {
		return this.staffService.add(staff);
	}

	@PostMapping("/update")
	public Result update(@RequestBody Staff staff) {
		return this.staffService.update(staff);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody Staff staff) {
		return this.staffService.delete(staff);
	}

}
