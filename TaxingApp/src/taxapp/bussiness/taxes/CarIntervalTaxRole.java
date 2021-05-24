package taxapp.bussiness.taxes;

public interface CarIntervalTaxRole {

	public double computeTax();
	
	public boolean belongs(double CC);
}
