package springproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springproject.hrms.business.abstracts.ResumeService;
import springproject.hrms.constants.Messages;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.SuccessResult;
import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.core.utilities.results.dataResults.SuccessDataResult;
import springproject.hrms.dataAccess.abstracts.ResumeDao;
import springproject.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService {

    private ResumeDao resumeDao;
    private String message = "Resume(s)";
    private String message1 = "Resume for user ";

    @Autowired
    public ResumeManager(ResumeDao resumeDao) {
        this.resumeDao = resumeDao;
    }

    @Override
    public DataResult<List<Resume>> getAll() {
        return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(), this.message + Messages.LISTED);
    }

    @Override
    public DataResult<Resume> getByEmployeeId(int id) {
        return new SuccessDataResult<>(this.resumeDao.getByEmployee_EmployeeId(id),
                this.message + Messages.LISTED);
    }

    @Override
    public Result add(Resume resume) {
        return new SuccessDataResult<>(this.resumeDao.save(resume),
                this.message1 + resume.getEmployee().getEmail() + Messages.ADDED);
    }

    @Override
    public Result delete(Resume resume) {
        this.resumeDao.delete(resume);
        return new SuccessResult(this.message1 + resume.getEmployee().getEmail() + Messages.DELETED);
    }

    @Override
    public Result update(Resume resume) {
        return new SuccessDataResult<>(this.resumeDao.save(resume),
                this.message1 + resume.getEmployee().getEmail() + Messages.UPDATED);
    }

    @Override
    public DataResult<Resume> getByEmployeeEmail(String email) {
        return new SuccessDataResult<Resume>(this.resumeDao.getByEmployee_Email(email));
    }

}
