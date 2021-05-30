package hrms.Project.Hrms.core.utilities.results;

//Hocam Result u corede ilk kez yazdigim icin baska bir yerden importlamadim (sizin yayindayken sorun vardi yazamamistim)
//Bundan sonraki projelerimde importlayarak kullanicam
import lombok.Getter;

@Getter
public class Result {

	private boolean success;
	private String message;

	public Result(boolean success) {
		this.success = success;
	}

	public Result(boolean success, String message) {
		this(success);
		this.message = message;
	}
}
