package reverse.buisiness.sequence;

import reverse.buisiness.ReversableSequenceFactoryRole;
import reverse.buisiness.intervals.IntervalRole;

public class SequenceDecorator implements ReverseExtended {
	
	private SequenceRole sequence;
	private ReversableSequenceFactoryRole factory;
	
	public SequenceDecorator(SequenceRole sequence, ReversableSequenceFactoryRole factory) {
		super();
		this.sequence = sequence;
		this.factory = factory;
	}

	public void add(IntervalRole interval) {
		sequence = factory.build(interval, sequence);
	}

	public int get(int index) {
		return sequence.get(index);
	}
}
