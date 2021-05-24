package reverse.construction;

import reverse.buisiness.ReversableSequenceFactoryRole;
import reverse.buisiness.sequence.ReverseExtended;
import reverse.buisiness.sequence.SequenceRole;

public interface SequenceDecoratorFactoryRole {

	public ReverseExtended create(SequenceRole sequence,ReversableSequenceFactoryRole decoratorFactory);
}
