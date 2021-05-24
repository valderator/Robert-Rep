package landowner.bussiness;

public class Circle implements IShape {

	private double radius;
	private double area;
	private CircleGeometryRole circleGeometry;

	public Circle(double radius, CircleGeometryRole circleGeometry) {
		this.radius = radius;
		this.circleGeometry = circleGeometry;
		this.area = circleGeometry.computeArea(radius);
	}

	public double computeArea() {
		return circleGeometry.computeArea(radius);
	}

	public String toString() {
		return "Circle [radius=" + radius + ", area=" + area + "]";
	}

}
