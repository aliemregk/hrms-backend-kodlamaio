package springproject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.business.abstracts.UserService;
import springproject.hrms.constants.Messages;
import springproject.hrms.core.dataAccess.UserRepository;
import springproject.hrms.core.entities.User;
import springproject.hrms.core.utilities.results.SuccessResult;
import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.core.utilities.results.dataResults.SuccessDataResult;

@Service
public class UserManager implements UserService {

    private UserRepository userRepository;
    private String message = "User(s) ";

    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userRepository.findAll(), this.message + Messages.LISTED);
    }

    @Override
    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<User>(this.userRepository.getByEmail(email), this.message + Messages.LISTED);
    }

    @Override
    public Result add(User user) {
        return new SuccessDataResult<>(this.userRepository.save(user), user.getEmail() + Messages.ADDED);
    }

    @Override
    public Result delete(User user) {
        this.userRepository.delete(user);
        return new SuccessResult(user.getEmail() + Messages.DELETED);
    }

    @Override
    public Result update(User user) {
        return new SuccessDataResult<>(this.userRepository.save(user), user.getEmail() + Messages.UPDATED);
    }

}
