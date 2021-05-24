package taxapp.bussiness.taxes;

public class CarIntervalTax implements CarIntervalTaxRole {

	private IntervalRole interval;
	private double amount;

	public CarIntervalTax(IntervalRole interval, double amount) {
		super();
		this.interval = interval;
		this.amount = amount;
	}

	public boolean belongs(double CC) {
		if (interval.checkInterval(CC))
			return true;
		return false;
	}

	public double computeTax() {
		return amount;
	}

	public String toString() {
		return "CarIntervalTax [interval=" + interval + ", carTax=" + amount + "]";
	}
}
