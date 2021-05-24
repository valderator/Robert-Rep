package taxapp.bussiness;

import taxapp.bussiness.cars.CarRole;

public interface CarOwnerPayerRole {
	
	public void add(CarRole car);
	
	public void sell(int index);
	
	public double computeTax();
	
	public boolean exists(int index);
	
	public void printMyCars();
	
}
