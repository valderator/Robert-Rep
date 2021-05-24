package landowner.ui.console;

import landowner.bussiness.Landowner;

public class ShowMyLands implements OperationRole {

	private String message;
	private Landowner Landowner;

	public ShowMyLands(String message, Landowner landowner) {
		this.message = message;
		this.Landowner = landowner;
	}

	public void run() {
		Landowner.printMyLands();
	}

	public String getMessage() {
		return message;
	}

	public boolean doContinue() {
		return true;
	}

}
