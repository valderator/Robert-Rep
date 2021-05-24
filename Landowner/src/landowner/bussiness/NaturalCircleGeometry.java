package landowner.bussiness;

public class NaturalCircleGeometry implements CircleGeometryRole {

	private double pi;

	public NaturalCircleGeometry(double PI) {
		pi = PI;
	}

	public double computeArea(double radius) {
		return pi * radius * radius;
	}

}
