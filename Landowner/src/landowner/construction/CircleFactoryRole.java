package landowner.construction;

import landowner.bussiness.CircleGeometryRole;
import landowner.bussiness.IShape;

public interface CircleFactoryRole {

	public IShape create(double radius, CircleGeometryRole circleGeometry);
}
