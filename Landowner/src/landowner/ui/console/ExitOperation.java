package landowner.ui.console;

public class ExitOperation implements OperationRole {

	private String message;

	public ExitOperation(String message) {
		this.message = message;
	}

	public void run() {
		System.out.println("Exited succesfully.");
	}

	public String getMessage() {
		return message;
	}

	public boolean doContinue() {
		return false;
	}

}
