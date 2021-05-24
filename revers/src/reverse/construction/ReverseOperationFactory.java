package reverse.construction;

import reverse.buisiness.intervals.IntervalFactoryRole;
import reverse.buisiness.operations.OperationRole;
import reverse.buisiness.operations.ReverseOperation;
import reverse.buisiness.sequence.SequenceDecoratorRole;
import reverse.ui.InputRole;

public class ReverseOperationFactory implements ReverseOperationFactoryRole{

	public OperationRole create(InputRole input, SequenceDecoratorRole decoratorSequence,
			IntervalFactoryRole intervalFactory) {
		return new ReverseOperation(input, decoratorSequence, intervalFactory);
	}

}
