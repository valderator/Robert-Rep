package taxapp.bussiness.cars;

public class ElectricCar implements CarRole {

	private double elecTax;

	public ElectricCar(double carTax) {
		this.elecTax = carTax;
	}

	public double computeTax() {
		return elecTax;
	}

	public String toString() {
		return "ElectricCar [carTax=" + elecTax + "]";
	}
}
