package reverse.buisiness.operations;

import reverse.buisiness.intervals.IntervalFactoryRole;
import reverse.buisiness.intervals.IntervalRole;
import reverse.buisiness.sequence.SequenceDecoratorRole;
import reverse.ui.InputRole;

public class ReverseOperation implements OperationRole {
	
	private InputRole input;
	private SequenceDecoratorRole sequence;
	private IntervalFactoryRole factory;

	public ReverseOperation(InputRole input, SequenceDecoratorRole sequence, IntervalFactoryRole factory) {
		super();
		this.input = input;
		this.sequence = sequence;
		this.factory = factory;
	}

	public void run() { 
		int lower = input.nextInt();
		int upper = input.nextInt();
		IntervalRole interval = factory.build(lower,upper);
		sequence.add(interval);
	}
}
