package landowner.ui.console;

public class ExceptionOperation implements OperationRole {

	public void run() {
		System.out.println("Chose a valid option.");
	}

	public String getMessage() {
		return "";
	}

	public boolean doContinue() {
		return true;
	}

}
