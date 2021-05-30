package hrms.Project.Hrms.core.utilities.results;

public class DataResult<T> extends Result {

	private T data;

	public DataResult(boolean success, T data) {
		super(success);
		this.data = data;
	}

	public DataResult(boolean success, String message, T data) {
		super(success, message);
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
