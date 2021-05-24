package landowner.bussiness;

public class Triangle implements IShape {

	public double side1;
	public double side2;
	public double side3;
	public double area;

	public Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		area = computeArea();
	}

	public double computeArea() {
		double p = (side1 + side2 + side3) / 2;
		area = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
		return area;
	}

	public String toString() {
		return "Triangle [side1=" + side1 + ", side2=" + side2 + ", side3=" + side3 + ", area=" + area + "]";
	}

}
