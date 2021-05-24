package landowner.construction;

import landowner.bussiness.IShape;
import landowner.bussiness.Rectangle;

public class RectangleFactory implements RectangleFactoryRole {

	public IShape create(double length, double width) {
		return new Rectangle(length, width);
	}

}
