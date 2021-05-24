package taxapp.bussiness;

import java.util.ArrayList;

import taxapp.bussiness.cars.CarRole;

public class CarOwnerPayer implements CarOwnerPayerRole {

	private ArrayList<CarRole> cars;

	public CarOwnerPayer() {
		cars = new ArrayList<CarRole>();
	}

	public void add(CarRole car) {
		cars.add(car);
		System.out.println("Car added succesfully.\n");
	}

	public void sell(int index) {
		cars.remove(index - 1);
		System.out.println("Car sold succesfully.\n");
	}

	public double computeTax() {
		double tax = 0;
		for (CarRole car : cars) {
			tax = tax + car.computeTax();
		}
		return tax;
	}

	public boolean exists(int index) {
		if (index > cars.size() || index <= 0) {
			return false;
		} else
			return true;
	}

	public void printMyCars() {
		System.out.println();
		for (CarRole car : cars) {
			System.out.println(car.toString() + "\n");
		}
	}

	public String toString() {
		return "CarOwner [cars=" + cars + "]";
	}

}
