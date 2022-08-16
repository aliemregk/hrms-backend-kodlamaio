package springproject.hrms.core.utilities.results;

public class Result {

	private boolean success;
	private String message;

	protected Result(boolean success) {
		this.success = success;
	}

	protected Result(boolean success, String message) {
		this(success);
		this.message = message;
	}

	public boolean isSucceed() {
		return this.success;
	}

	public String getMessage() {
		return this.message;
	}
}
