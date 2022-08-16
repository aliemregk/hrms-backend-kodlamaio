package springproject.hrms.business.abstracts;

import java.util.List;

import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.entities.concretes.School;

public interface SchoolService {

    DataResult<List<School>> getAll();

    Result add(School school);

    Result delete(School school);

    Result update(School school);
}