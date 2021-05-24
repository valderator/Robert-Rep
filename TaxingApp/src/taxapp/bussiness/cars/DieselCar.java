package taxapp.bussiness.cars;

import java.util.ArrayList;

import taxapp.bussiness.taxes.CarIntervalTaxRole;

public class DieselCar implements CarRole {

	private double CC;
	private ArrayList<CarIntervalTaxRole> carTaxes;

	public DieselCar(double CC, ArrayList<CarIntervalTaxRole> carTaxes) {
		this.CC = CC;
		this.carTaxes = carTaxes;
	}

	public double computeTax() {
		for (CarIntervalTaxRole interval : carTaxes) {
			if (interval.belongs(CC)) {
				return interval.computeTax();
			}
		}
		return 0;
	}

	public String toString() {
		return "DieselCar [CC=" + CC + ", carTax=" + carTaxes + "]";
	}
}
