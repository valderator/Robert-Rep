package landowner.construction;

import landowner.bussiness.IShape;

public interface RectangleFactoryRole {

	IShape create(double length, double width);
	
}
