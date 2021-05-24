package landowner.bussiness;

public class Rectangle implements IShape {

	private double length;
	private double width;
	private double area;

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
		area = computeArea();
	}

	public double computeArea() {
		area = length * width;
		return area;
	}

	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + ", area=" + area + "]";
	}

}
