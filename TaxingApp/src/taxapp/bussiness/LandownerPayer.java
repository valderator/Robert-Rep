package taxapp.bussiness;

import landowner.bussiness.IShape;
import landowner.bussiness.LandownerRole;
import taxapp.bussiness.taxes.CalculatorTaxRole;

public class LandownerPayer implements LandownerPayerRole {

	private LandownerRole landowner;
	private CalculatorTaxRole landTax;

	public LandownerPayer(LandownerRole landowner, CalculatorTaxRole landTax) {
		super();
		this.landowner = landowner;
		this.landTax = landTax;
	}

	public void add(IShape shape) {
		landowner.add(shape);
	}

	public void sell(int index) {
		landowner.sell(index);
	}

	public boolean exists(int index) {
		return landowner.exists(index);
	}

	public void printMyLands() {
		landowner.printMyLands();
	}

	public double computeTax() {
		return landTax.computeTax(landowner.computeTotalArea());
	}
	
	public String toString() {
		return "LandownerPayer [landowner=" + landowner + ", landTax=" + landTax + "]";
	}

}
