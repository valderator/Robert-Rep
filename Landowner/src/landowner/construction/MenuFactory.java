package landowner.construction;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import landowner.bussiness.Landowner;
import landowner.ui.console.CircleOperation;
import landowner.ui.console.ComputeTotalArea;
import landowner.ui.console.DeleteLand;
import landowner.ui.console.ExceptionOperation;
import landowner.ui.console.ExitOperation;
import landowner.ui.console.Menu;
import landowner.ui.console.OperationRole;
import landowner.ui.console.RectangleOperation;
import landowner.ui.console.ShowMyLands;
import landowner.ui.console.SquareOperation;
import landowner.ui.console.TriangleOperation;

public class MenuFactory {

	private Scanner scanner = new Scanner(System.in);;
	private Landowner Landowner = new Landowner();

	public Menu build() {
		Map<Integer, OperationRole> operationMap = new HashMap<Integer, OperationRole>();

		ExceptionOperation exceptionOperation = new ExceptionOperation();
		operationMap.put(-1, exceptionOperation);

		ExitOperation exitOperation = new ExitOperation("Press '0' to exit.");
		operationMap.put(0, exitOperation);

		Menu addPlotMenu = buildPlotMenu();
		operationMap.put(1, addPlotMenu);

		DeleteLand DeleteLand = new DeleteLand("Press '2' to remove a land.", "Enter the index of the land: ", scanner,
				Landowner);
		operationMap.put(2, DeleteLand);

		ShowMyLands showMyLands = new ShowMyLands("Press '3' to display your current lands.", Landowner);
		operationMap.put(3, showMyLands);

		ComputeTotalArea computeTotalArea = new ComputeTotalArea("Press '4' to compute your current total area.",
				Landowner);
		operationMap.put(4, computeTotalArea);

		Menu menu = new Menu("", scanner, operationMap);

		return menu;
	}

	public Menu buildPlotMenu() {
		Map<Integer, OperationRole> operationMap = new HashMap<Integer, OperationRole>();

		ExceptionOperation exceptionOperation = new ExceptionOperation();
		operationMap.put(-1, exceptionOperation);

		ExitOperation exitOperation = new ExitOperation("Press '0' to exit. ");
		operationMap.put(0, exitOperation);

		SquareFactory squareFactory = new SquareFactory();
		SquareOperation squareOperation = new SquareOperation("Press '1' to add a square land.", "Chose the length: ",
				scanner, Landowner, squareFactory);
		operationMap.put(1, squareOperation);

		RectangleFactory rectangleFactory = new RectangleFactory();
		RectangleOperation rectangleOperation = new RectangleOperation("Press '2' to add a rectangle land.",
				"Chose the length: ", "Chose the width: ", scanner, Landowner, rectangleFactory);
		operationMap.put(2, rectangleOperation);

		CircleFactory circleFactory = new CircleFactory();
		CircleOperation circleOperation = new CircleOperation("Press '3' to add a circle land.", "Enter radius: ",
				"Enter PI: ", scanner, Landowner, circleFactory);
		operationMap.put(3, circleOperation);

		TriangleFactory triangleFactory = new TriangleFactory();
		TriangleOperation triangleOperation = new TriangleOperation("Press '4' to add a triangle land.",
				"Enter side1: ", "Enter side2: ", "Enter side3: ", Landowner, scanner, triangleFactory);
		operationMap.put(4, triangleOperation);

		Menu plotMenu = new Menu("Press '1' to add a new land. ", scanner, operationMap);

		return plotMenu;
	}
}
