package taxapp.bussiness.taxes;

public class NormalLandTax implements CalculatorTaxRole {

	private double tax;

	public NormalLandTax(double tax) {
		this.tax = tax;
	}

	public double computeTax(double totalArea) {
		return tax * totalArea;
	}

	public String toString() {
		return "NormalLandTax [tax=" + tax + "]";
	}

}
