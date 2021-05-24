package taxapp.bussiness;

import landowner.bussiness.IShape;
import taxapp.bussiness.cars.CarRole;

public class TaxPayer implements TaxPayerRole {

	private LandownerPayerRole landowner;
	private CarOwnerPayerRole carOwner;

	public TaxPayer(LandownerPayerRole landowner, CarOwnerPayerRole carOwner) {
		super();
		this.landowner = landowner;
		this.carOwner = carOwner;
	}

	public String toString() {
		return "LandownerPayer [landowner=" + landowner + ", landTax=" + landowner.computeTax() + ", carOwner="
				+ carOwner + ", carTax= " + carOwner.computeTax() + ", totalTax= " + computeTotalTax() + "]";
	}

	public void add(IShape shape) {
		landowner.add(shape);
	}

	public void sellLand(int index) {
		landowner.sell(index);
	}

	public boolean existsLand(int index) {
		return landowner.exists(index);
	}

	public void printMyLands() {
		landowner.printMyLands();
	}

	public void add(CarRole car) {
		carOwner.add(car);
	}

	public void sellCar(int index) {
		carOwner.sell(index);
	}

	public boolean existsCar(int index) {
		return carOwner.exists(index);
	}

	public void printMyCars() {
		carOwner.printMyCars();
	}

	public double computeTotalTax() {
		double totalTax = 0;
		totalTax = landowner.computeTax() + carOwner.computeTax();
		return totalTax;
	}
}
