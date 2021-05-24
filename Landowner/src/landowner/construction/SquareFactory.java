package landowner.construction;

import landowner.bussiness.IShape;
import landowner.bussiness.Square;

public class SquareFactory implements SquareFactoryRole{

	public IShape create(double length) {
		return new Square(length);
	}

}
