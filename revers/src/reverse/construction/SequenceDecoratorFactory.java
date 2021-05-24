package reverse.construction;

import reverse.buisiness.ReversableSequenceFactoryRole;
import reverse.buisiness.sequence.ReverseExtended;
import reverse.buisiness.sequence.SequenceDecorator;
import reverse.buisiness.sequence.SequenceRole;

public class SequenceDecoratorFactory implements SequenceDecoratorFactoryRole {

	public ReverseExtended create(SequenceRole sequence,ReversableSequenceFactoryRole decoratorFactory) {
		return new SequenceDecorator(sequence, decoratorFactory);
	}

}
