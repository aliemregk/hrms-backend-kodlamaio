package springproject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springproject.hrms.business.abstracts.ResumeService;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.entities.concretes.Resume;

@CrossOrigin
@RestController
@RequestMapping("/api/resumes")
public class ResumesController {

    private ResumeService resumeService;

    @Autowired
    public ResumesController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping("/getall")
    public DataResult<List<Resume>> getAll() {
        return this.resumeService.getAll();
    }

    @GetMapping("/getbyemployeeid")
    public DataResult<Resume> getByEmployeeId(int id) {
        return this.resumeService.getByEmployeeId(id);
    }

    @GetMapping("/getbyemployeeemail")
    public DataResult<Resume> getByEmployeeEmail(String email) {
        return this.resumeService.getByEmployeeEmail(email);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Resume resume) {
        return this.resumeService.add(resume);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Resume resume) {
        return this.resumeService.delete(resume);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Resume resume) {
        return this.resumeService.update(resume);
    }
}
