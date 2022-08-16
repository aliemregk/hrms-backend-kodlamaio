package springproject.hrms.business.abstracts;

import java.util.List;

import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.entities.concretes.WorkExperience;

public interface WorkExperienceService {

    DataResult<List<WorkExperience>> getAll();

    DataResult<List<WorkExperience>> getAllByResumeId(int id);

    Result add(WorkExperience workExperience);

    Result delete(WorkExperience workExperience);

    Result update(WorkExperience workExperience);
}
