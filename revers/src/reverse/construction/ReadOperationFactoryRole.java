package reverse.construction;

import reverse.buisiness.operations.OperationRole;
import reverse.buisiness.sequence.SequenceRole;
import reverse.ui.InputRole;
import reverse.ui.OutputRole;

public interface ReadOperationFactoryRole {

	public OperationRole create(InputRole input, SequenceRole decoratorSequence, OutputRole output);
}
