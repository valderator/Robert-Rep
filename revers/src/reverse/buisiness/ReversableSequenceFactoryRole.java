package reverse.buisiness;

import reverse.buisiness.intervals.IntervalRole;
import reverse.buisiness.sequence.IntervalReverseSequence;
import reverse.buisiness.sequence.SequenceRole;

public interface ReversableSequenceFactoryRole {

	IntervalReverseSequence build(IntervalRole interval, SequenceRole sequence);

}
