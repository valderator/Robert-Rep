package reverse.construction;

import reverse.buisiness.intervals.IntervalFactoryRole;
import reverse.buisiness.operations.OperationRole;
import reverse.buisiness.sequence.SequenceDecoratorRole;
import reverse.ui.InputRole;

public interface ReverseOperationFactoryRole {

	public OperationRole create(InputRole input, SequenceDecoratorRole decoratorSequence, IntervalFactoryRole intervalFactory);
}
