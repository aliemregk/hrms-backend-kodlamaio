package springproject.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springproject.hrms.business.abstracts.StaffService;
import springproject.hrms.constants.Messages;
import springproject.hrms.core.utilities.results.ErrorResult;
import springproject.hrms.core.utilities.results.Result;
import springproject.hrms.core.utilities.results.SuccessResult;
import springproject.hrms.core.utilities.results.dataResults.DataResult;
import springproject.hrms.core.utilities.results.dataResults.ErrorDataResult;
import springproject.hrms.core.utilities.results.dataResults.SuccessDataResult;
import springproject.hrms.dataAccess.abstracts.StaffDao;
import springproject.hrms.entities.concretes.Staff;

@Service
public class StaffManager implements StaffService {

	private StaffDao staffDao;
	private String message = "Staff(s) ";

	@Autowired
	public StaffManager(StaffDao staffDao) {
		this.staffDao = staffDao;
	}

	@Override
	public DataResult<List<Staff>> getAll() {
		return new SuccessDataResult<List<Staff>>(this.staffDao.findAll(), this.message + Messages.LISTED);
	}

	@Override
	public DataResult<Staff> getById(int id) {
		Optional<Staff> result = staffDao.findById(id);
		if (result.isPresent()) {
			return new SuccessDataResult<Staff>(result.get(), this.message + Messages.LISTED);
		} else {
			return new ErrorDataResult<Staff>(Messages.CANT_GET);
		}
	}

	@Override
	public DataResult<Staff> getByEmail(String email) {
		return new SuccessDataResult<>(staffDao.getByEmail(email), Messages.LISTED);
	}

	@Override
	public Result add(Staff staff) {
		boolean result = staffDao.existsByEmail(staff.getEmail());
		if (result) {
			return new ErrorResult(staff.getEmail() + Messages.EXISTS);
		} else {
			return new SuccessDataResult<>(this.staffDao.save(staff), staff.getEmail() + Messages.ADDED);
		}
	}

	@Override
	public Result delete(Staff staff) {
		this.staffDao.delete(staff);
		return new SuccessResult(staff.getEmail() + Messages.DELETED);
	}

	@Override
	public Result update(Staff staff) {
		return new SuccessDataResult<>(this.staffDao.save(staff), staff.getEmail() + Messages.UPDATED);
	}

}
