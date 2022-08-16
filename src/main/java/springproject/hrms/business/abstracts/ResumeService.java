package springproject.hrms.business.abstracts;

import java.util.List;

import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.entities.concretes.Resume;

public interface ResumeService {

    DataResult<List<Resume>> getAll();

    DataResult<Resume> getByEmployeeId(int id);

    DataResult<Resume> getByEmployeeEmail(String email);

    Result add(Resume resume);

    Result delete(Resume resume);

    Result update(Resume resume);
}
