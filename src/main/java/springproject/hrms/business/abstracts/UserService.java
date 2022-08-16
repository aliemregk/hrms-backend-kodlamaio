package springproject.hrms.business.abstracts;

import java.util.List;

import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.entities.User;
import springproject.hrms.core.utilities.results.dataResults.DataResult;

public interface UserService {

    DataResult<List<User>> getAll();

    DataResult<User> getByEmail(String email);

    Result add(User user);

    Result delete(User user);

    Result update(User user);
}
