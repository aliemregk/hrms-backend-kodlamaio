package springproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springproject.hrms.business.abstracts.WorkExperienceService;
import springproject.hrms.constants.Messages;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.SuccessResult;
import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.core.utilities.results.dataResults.SuccessDataResult;
import springproject.hrms.dataAccess.abstracts.WorkExperienceDao;
import springproject.hrms.entities.concretes.WorkExperience;

@Service
public class WorkExperienceManager implements WorkExperienceService {

    private WorkExperienceDao workExperienceDao;
    private String message = "Work experience(s) ";

    @Autowired
    public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
        this.workExperienceDao = workExperienceDao;
    }

    @Override
    public DataResult<List<WorkExperience>> getAll() {
        return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAll(),
                this.message + Messages.LISTED);
    }

    @Override
    public DataResult<List<WorkExperience>> getAllByResumeId(int id) {
        return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.getAllByResume_ResumeId(id),
                this.message + Messages.LISTED);
    }

    @Override
    public Result add(WorkExperience workExperience) {
        return new SuccessDataResult<>(this.workExperienceDao.save(workExperience), this.message + Messages.ADDED);
    }

    @Override
    public Result delete(WorkExperience workExperience) {
        this.workExperienceDao.delete(workExperience);
        return new SuccessResult(this.message + Messages.DELETED);
    }

    @Override
    public Result update(WorkExperience workExperience) {
        return new SuccessDataResult<>(this.workExperienceDao.save(workExperience), this.message + Messages.UPDATED);
    }

}
