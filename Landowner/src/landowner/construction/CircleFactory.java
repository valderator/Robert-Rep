package landowner.construction;

import landowner.bussiness.Circle;
import landowner.bussiness.CircleGeometryRole;
import landowner.bussiness.IShape;

public class CircleFactory implements CircleFactoryRole {

	public IShape create(double radius, CircleGeometryRole circleGeometry) {
		return new Circle(radius, circleGeometry);
	}

}
