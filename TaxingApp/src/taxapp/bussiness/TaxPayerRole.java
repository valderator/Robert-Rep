package taxapp.bussiness;

import landowner.bussiness.IShape;
import taxapp.bussiness.cars.CarRole;

public interface TaxPayerRole {

	public void add(IShape shape);

	public void add(CarRole car);

	public void sellLand(int index);

	public void sellCar(int index);

	public boolean existsLand(int index);

	public boolean existsCar(int index);

	public void printMyLands();

	public void printMyCars();

	public double computeTotalTax();
}
