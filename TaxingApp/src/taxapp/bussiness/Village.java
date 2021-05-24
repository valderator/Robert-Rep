package taxapp.bussiness;

import java.util.ArrayList;

import landowner.bussiness.IShape;
import landowner.bussiness.Landowner;
import landowner.bussiness.LandownerRole;
import landowner.bussiness.Rectangle;
import landowner.bussiness.Square;
import landowner.bussiness.Triangle;
import taxapp.bussiness.cars.CarRole;
import taxapp.bussiness.cars.DieselCar;
import taxapp.bussiness.cars.ElectricCar;
import taxapp.bussiness.cars.GasolineCar;
import taxapp.bussiness.taxes.CalculatorTaxRole;
import taxapp.bussiness.taxes.CarIntervalTax;
import taxapp.bussiness.taxes.CarIntervalTaxRole;
import taxapp.bussiness.taxes.Interval;
import taxapp.bussiness.taxes.IntervalRole;
import taxapp.bussiness.taxes.NormalLandTax;

public class Village {

	private ArrayList<TaxPayerRole> villagers;

	public Village() {
		villagers = new ArrayList<TaxPayerRole>();
	}

	public void add(TaxPayerRole villager) {
		villagers.add(villager);
		System.out.println("Villager added succesfully.\n");
	}

	public void remove(int index) {
		villagers.remove(index - 1);
		System.out.println("Villager removed succesfully.\n");
	}

	public boolean exists(int index) {
		if (index > villagers.size() || index <= 0) {
			return false;
		} else
			return true;
	}

	public void printVillage() {
		for (int i = 0; i < villagers.size(); i++) {
			printVillager(i + 1);
		}
	}

	public void printVillager(int index) {
		System.out.println(index + ". " + villagers.get(index - 1).toString() + "\n");
	}

	public void clearVillage() {
		villagers.clear();
		System.out.println("Village has been wiped out.");
	}

	public static void main(String[] args) {
		Village village = new Village();

		// villager 1
		LandownerRole landowner1 = new Landowner();
		IShape shape1 = new Square(12);
		landowner1.add(shape1);

		CalculatorTaxRole landTax1 = new NormalLandTax(1);

		LandownerPayerRole landownerPayer = new LandownerPayer(landowner1, landTax1);

		CarOwnerPayerRole carOwner = new CarOwnerPayer();

		ArrayList<CarIntervalTaxRole> taxes = new ArrayList<CarIntervalTaxRole>();
		IntervalRole interval1 = new Interval(1.0, 2.0);
		CarIntervalTaxRole carTax1 = new CarIntervalTax(interval1, 15);
		IntervalRole interval2 = new Interval(2.0, 3.0);
		CarIntervalTaxRole carTax2 = new CarIntervalTax(interval2, 25);
		IntervalRole interval3 = new Interval(3.0, 10.0);
		CarIntervalTaxRole carTax3 = new CarIntervalTax(interval3, 35);

		taxes.add(carTax1);
		taxes.add(carTax2);
		taxes.add(carTax3);

		CarRole diesel = new DieselCar(2.2, taxes);
		carOwner.add(diesel);

		TaxPayerRole villager = new TaxPayer(landownerPayer, carOwner);
		village.add(villager);

		// villager 2
		LandownerRole landowner2 = new Landowner();
		IShape shape2 = new Rectangle(12, 2);
		landowner2.add(shape2);

		CalculatorTaxRole landTax2 = new NormalLandTax(2);

		LandownerPayerRole landownerPayer2 = new LandownerPayer(landowner2, landTax2);

		CarOwnerPayerRole carOwner2 = new CarOwnerPayer();

		ArrayList<CarIntervalTaxRole> taxes2 = new ArrayList<CarIntervalTaxRole>();
		IntervalRole interval12 = new Interval(1.0, 2.0);
		CarIntervalTaxRole carTax12 = new CarIntervalTax(interval12, 11);
		IntervalRole interval22 = new Interval(2.0, 3.0);
		CarIntervalTaxRole carTax22 = new CarIntervalTax(interval22, 19);
		IntervalRole interval32 = new Interval(3.0, 8.0);
		CarIntervalTaxRole carTax32 = new CarIntervalTax(interval32, 28);

		taxes2.add(carTax12);
		taxes2.add(carTax22);
		taxes2.add(carTax32);

		CarRole diesel2 = new DieselCar(1.2, taxes2);
		CarRole electric = new ElectricCar(22);
		carOwner2.add(diesel2);
		carOwner2.add(electric);

		TaxPayerRole villager2 = new TaxPayer(landownerPayer2, carOwner2);
		village.add(villager2);

		// villager 3
		LandownerRole landowner3 = new Landowner();
		IShape shape3 = new Triangle(3, 4, 5);
		landowner3.add(shape3);

		CalculatorTaxRole landTax3 = new NormalLandTax(1);

		LandownerPayerRole landownerPayer3 = new LandownerPayer(landowner3, landTax3);

		CarOwnerPayerRole carOwner3 = new CarOwnerPayer();

		ArrayList<CarIntervalTaxRole> taxes3 = new ArrayList<CarIntervalTaxRole>();
		IntervalRole interval13 = new Interval(1.0, 2.0);
		CarIntervalTaxRole carTax13 = new CarIntervalTax(interval13, 10);
		IntervalRole interval23 = new Interval(2.0, 3.0);
		CarIntervalTaxRole carTax23 = new CarIntervalTax(interval23, 30);
		IntervalRole interval33 = new Interval(3.0, 5.0);
		CarIntervalTaxRole carTax33 = new CarIntervalTax(interval33, 40);

		taxes3.add(carTax13);
		taxes3.add(carTax23);
		taxes3.add(carTax33);

		CarRole diesel3 = new DieselCar(4.8, taxes3);
		CarRole gasoline = new GasolineCar(diesel3);
		carOwner3.add(gasoline);

		TaxPayerRole villager3 = new TaxPayer(landownerPayer3, carOwner3);
		village.add(villager3);

		village.printVillage();
	}

}
