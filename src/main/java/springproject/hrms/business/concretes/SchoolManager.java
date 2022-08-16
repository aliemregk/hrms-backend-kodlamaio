package springproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springproject.hrms.business.abstracts.SchoolService;
import springproject.hrms.constants.Messages;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.SuccessResult;
import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.core.utilities.results.dataResults.SuccessDataResult;
import springproject.hrms.dataAccess.abstracts.SchoolDao;
import springproject.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService {

    private SchoolDao schoolDao;
    private String message = "School(s)";

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<List<School>>(this.schoolDao.findAll(), this.message + Messages.LISTED);
    }

    @Override
    public Result add(School school) {
        return new SuccessDataResult<>(this.schoolDao.save(school), school.getSchoolName() + Messages.ADDED);
    }

    @Override
    public Result delete(School school) {
        this.schoolDao.delete(school);
        return new SuccessResult(school.getSchoolName() + Messages.DELETED);
    }

    @Override
    public Result update(School school) {
        return new SuccessDataResult<>(this.schoolDao.save(school), school.getSchoolName() + Messages.UPDATED);
    }

}
