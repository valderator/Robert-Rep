package taxapp.bussiness.taxes;

public class Interval implements IntervalRole {

	private double lower;
	private double upper;

	public Interval(double lower, double upper) {
		this.lower = lower;
		this.upper = upper;
	}

	public boolean checkInterval(double value) {
		if (value < lower) {
			return false;
		}

		if (value > upper) {
			return false;
		}

		return true;
	}

	public String toString() {
		return "Interval [lower=" + lower + ", upper=" + upper + "]";
	}
}
