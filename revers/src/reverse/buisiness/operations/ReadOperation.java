package reverse.buisiness.operations;

import reverse.buisiness.sequence.SequenceRole;
import reverse.ui.InputRole;
import reverse.ui.OutputRole;

public class ReadOperation implements OperationRole {
	
	private InputRole input;
	private OutputRole output;
	private SequenceRole sequence;

	public ReadOperation(InputRole input, SequenceRole sequence, OutputRole output) {
		super();
		this.input = input;
		this.output = output;
		this.sequence = sequence;
	}

	public void run() {
		int index = input.nextInt();
		int value = sequence.get(index);
		output.print(value);
	}

}
