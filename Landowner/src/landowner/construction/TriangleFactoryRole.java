package landowner.construction;

import landowner.bussiness.IShape;

public interface TriangleFactoryRole {

	public IShape create(double side1, double side2, double side3);
}
