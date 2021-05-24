package reverse.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import reverse.buisiness.Revers;
import reverse.buisiness.ReversableSequenceFactory;
import reverse.buisiness.ReversableSequenceFactoryRole;
import reverse.buisiness.intervals.IntervalFactory;
import reverse.buisiness.intervals.IntervalFactoryRole;
import reverse.buisiness.operations.OperationRole;
import reverse.buisiness.sequence.ReverseExtended;
import reverse.buisiness.sequence.SequenceRole;
import reverse.construction.InputFactory;
import reverse.construction.InputFactoryRole;
import reverse.construction.OutputFactory;
import reverse.construction.OutputFactoryRole;
import reverse.construction.ReadOperationFactory;
import reverse.construction.ReadOperationFactoryRole;
import reverse.construction.ReverseOperationFactory;
import reverse.construction.ReverseOperationFactoryRole;
import reverse.construction.SequenceDecoratorFactory;
import reverse.construction.SequenceDecoratorFactoryRole;
import reverse.construction.SimpleSequenceFactory;
import reverse.construction.SimpleSequenceFactoryRole;

public class ReversFactory {

	public Revers create() {
		
		HashMap<Integer, OperationRole> operationMap = new HashMap<Integer, OperationRole>();
		
		File inputfile = new File("C:\\Users\\Robert\\Desktop\\OOD\\TaxingApp\\input.txt");

		Scanner scanner = null;
		try {
			scanner = new Scanner(inputfile);
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't open input file.");
			e.printStackTrace();
		}

		InputFactoryRole inputFactory = new InputFactory();
		InputRole input = inputFactory.create(scanner);

		OutputFactoryRole outputFactory = new OutputFactory();
		OutputRole output = outputFactory.create();

		SimpleSequenceFactoryRole simpleSequenceFactory = new SimpleSequenceFactory();
		SequenceRole simpleSequence = simpleSequenceFactory.create();

		ReversableSequenceFactoryRole decoratorFactory = new ReversableSequenceFactory();
		SequenceDecoratorFactoryRole sequenceDecoratorFactory = new SequenceDecoratorFactory();
		ReverseExtended decoratorSequence = sequenceDecoratorFactory.create(simpleSequence, decoratorFactory);

		ReadOperationFactoryRole readOperationFactoryRole = new ReadOperationFactory();
		OperationRole readOperation = readOperationFactoryRole.create(input, decoratorSequence, output);

		operationMap.put(1, readOperation);

		IntervalFactoryRole intervalFactory = new IntervalFactory();
		ReverseOperationFactoryRole reverseOperationFactoryRole = new ReverseOperationFactory();
		OperationRole reverseOperation = reverseOperationFactoryRole.create(input, decoratorSequence, intervalFactory);

		operationMap.put(2, reverseOperation);

		Revers revers = new Revers(input, operationMap);

		return revers;
	}
}
