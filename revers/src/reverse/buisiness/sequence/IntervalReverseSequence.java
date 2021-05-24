package reverse.buisiness.sequence;

import reverse.buisiness.intervals.IntervalRole;

public class IntervalReverseSequence implements SequenceRole {
	
	private SequenceRole reverseSequence;
	private IntervalRole interval;

	public IntervalReverseSequence(SequenceRole reverseSequence, IntervalRole interval) {
		this.reverseSequence = reverseSequence;
		this.interval = interval;
	}

	public int get(int index) {
		if (interval.contains(index)) {
			int reversedIndex = interval.reverse(index);
			return reverseSequence.get(reversedIndex);
		} else {
			return reverseSequence.get(index);
		}
	}

}
