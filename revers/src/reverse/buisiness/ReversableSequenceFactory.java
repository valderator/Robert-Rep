package reverse.buisiness;

import reverse.buisiness.intervals.IntervalRole;
import reverse.buisiness.sequence.IntervalReverseSequence;
import reverse.buisiness.sequence.SequenceRole;

public class ReversableSequenceFactory implements ReversableSequenceFactoryRole {

	public IntervalReverseSequence build(IntervalRole interval, SequenceRole sequence) {
		return new IntervalReverseSequence(sequence, interval);
	}

}
