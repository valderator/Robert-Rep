package reverse.construction;

import reverse.buisiness.operations.OperationRole;
import reverse.buisiness.operations.ReadOperation;
import reverse.buisiness.sequence.SequenceRole;
import reverse.ui.InputRole;
import reverse.ui.OutputRole;

public class ReadOperationFactory implements ReadOperationFactoryRole {

	public OperationRole create(InputRole input, SequenceRole decoratorSequence, OutputRole output) {
		return new ReadOperation(input, decoratorSequence, output);
	}

}
