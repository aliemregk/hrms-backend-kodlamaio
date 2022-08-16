package springproject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springproject.hrms.business.abstracts.EmployeeService;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.entities.concretes.Employee;

@CrossOrigin
@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/getall")
	public DataResult<List<Employee>> getAll() {
		return this.employeeService.getAll();
	}

	@GetMapping("/getbyid")
	public DataResult<Employee> getById(int id) {
		return this.employeeService.getById(id);
	}

	@GetMapping("/getbyemail")
	public DataResult<Employee> getByEmail(String email) {
		return this.employeeService.getByEmail(email);
	}

	@GetMapping("/getbynatid")
	public DataResult<Employee> getByNationalIdentity(String nationalIdentity) {
		return this.employeeService.getByNationalId(nationalIdentity);
	}

	@PostMapping("/confirm")
	public Result confirmEmployee(int id) {
		return this.employeeService.confirmEmployee(id);
	}

	@PostMapping("/add")
	public Result add(@RequestBody Employee employee) {
		return this.employeeService.add(employee);
	}

	@PostMapping("/delete")
	public Result delete(@RequestBody Employee employee) {
		return this.employeeService.delete(employee);
	}

}
