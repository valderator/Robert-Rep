package reverse.buisiness;

import java.util.Map;

import reverse.buisiness.operations.OperationRole;
import reverse.ui.InputRole;

public class Revers {

	private InputRole input;
	private Map<Integer, OperationRole> operationMap;

	public Revers(InputRole input, Map<Integer, OperationRole> operationMap) {
		this.input = input;
		this.operationMap = operationMap;
	}

	public void revers() {
		while (input.hasData()) {
			int commandCode = input.nextInt();
			OperationRole operation = operationMap.get(commandCode);
			operation.run();
		}
	}
}
