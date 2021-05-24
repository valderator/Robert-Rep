package landowner.bussiness;

public class Square implements IShape {

	private double length;
	private double area;

	public Square(double length) {
		this.length = length;
		area = computeArea();
	}

	public double computeArea() {
		area = length * length;
		return area;
	}

	public String toString() {
		return "Square [length=" + length + ", area=" + area + "]";
	}
}
