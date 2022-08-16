package springproject.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springproject.hrms.business.abstracts.WorkExperienceService;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.entities.concretes.WorkExperience;

@CrossOrigin
@RestController
@RequestMapping("/api/workexperiences")
public class WorkExperiencesController {

    private WorkExperienceService workExperienceService;

    @Autowired
    public WorkExperiencesController(WorkExperienceService workExperienceService) {
        this.workExperienceService = workExperienceService;
    }

    @GetMapping("/getall")
    public DataResult<List<WorkExperience>> getAll() {
        return this.workExperienceService.getAll();
    }

    @GetMapping("/getallbyresumeid")
    public DataResult<List<WorkExperience>> getAllByResumeId(int id) {
        return this.workExperienceService.getAllByResumeId(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody WorkExperience workExperience) {
        return this.workExperienceService.add(workExperience);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody WorkExperience workExperience) {
        return this.workExperienceService.delete(workExperience);
    }

    @PostMapping("/update")
    public Result update(@RequestBody WorkExperience workExperience) {
        return this.workExperienceService.update(workExperience);
    }
}
