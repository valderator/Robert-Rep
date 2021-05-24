package reverse.buisiness.intervals;

public class IntervalFactory implements IntervalFactoryRole {

	public IntervalRole build(int lower, int upper) {
		return new Interval(lower, upper);
	}

}
