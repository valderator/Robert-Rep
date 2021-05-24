package landowner.construction;

import landowner.bussiness.IShape;
import landowner.bussiness.Triangle;

public class TriangleFactory implements TriangleFactoryRole {

	public IShape create(double side1, double side2, double side3) {
		return new Triangle(side1, side2, side3);
	}

}
