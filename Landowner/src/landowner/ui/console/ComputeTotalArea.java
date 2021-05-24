package landowner.ui.console;

import landowner.bussiness.Landowner;

public class ComputeTotalArea implements OperationRole {

	private String message;
	private Landowner Landowner;

	public ComputeTotalArea(String message, Landowner Landowner) {
		this.message = message;
		this.Landowner = Landowner;
	}

	public void run() {
		double area = Landowner.computeTotalArea();
		System.out.println("Your total area is: " + area + " m^2.\n");
	}

	public String getMessage() {
		return message;
	}

	public boolean doContinue() {
		return true;
	}

}
