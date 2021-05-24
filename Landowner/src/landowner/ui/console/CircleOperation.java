package landowner.ui.console;

import java.util.Scanner;

import landowner.bussiness.IShape;
import landowner.bussiness.Landowner;
import landowner.bussiness.NaturalCircleGeometry;
import landowner.construction.CircleFactoryRole;

public class CircleOperation implements OperationRole {

	private String message;
	private String enterRadius;
	private String enterPI;
	private Landowner landowner;
	private Scanner scanner;
	private CircleFactoryRole circleFactory;

	public CircleOperation(String message, String enterRadius, String enterPI, Scanner scanner, Landowner landowner,
			CircleFactoryRole circleFactory) {

		this.message = message;
		this.enterRadius = enterRadius;
		this.enterPI = enterPI;
		this.scanner = scanner;
		this.landowner = landowner;
		this.circleFactory = circleFactory;
	}

	public void run() {
		System.out.print(enterRadius);
		double radius = scanner.nextDouble();
		System.out.print(enterPI);
		double pi = scanner.nextDouble();
		NaturalCircleGeometry circle = new NaturalCircleGeometry(pi);
		IShape shape = circleFactory.create(radius, circle);
		landowner.add(shape);
	}

	public String getMessage() {
		return this.message;
	}

	public boolean doContinue() {
		return true;
	}

}
