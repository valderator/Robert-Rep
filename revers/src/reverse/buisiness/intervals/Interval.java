package reverse.buisiness.intervals;

public class Interval implements IntervalRole {

	private int lower;
	private int upper;

	public Interval(int lower, int upper) {
		super();
		this.lower = lower;
		this.upper = upper;
	}

	public boolean contains(int index) {
		if (index < lower) {
			return false;
		}
		if (index > upper) {
			return false;
		}
		return true;
	}

	public int reverse(int index) {
		return lower + upper - index;
	}

}