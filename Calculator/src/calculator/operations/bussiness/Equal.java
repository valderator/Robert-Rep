package calculator.operations.bussiness;

public class Equal implements EqualRole {

	private OperationRole currentState;
	private OperationRole plusState;
	private OperationRole minusState;
	private OperationRole multiplicationState;
	private OperationRole moduloState;

	public Equal(OperationRole currentState, OperationRole plusState, OperationRole minusState,
			OperationRole multiplicationState, OperationRole moduloState) {
		this.currentState = currentState;
		this.plusState = plusState;
		this.minusState = minusState;
		this.multiplicationState = multiplicationState;
		this.moduloState = moduloState;
	}

	public int compute(int firstNumber, int secondNumber) {
		int result = currentState.compute(firstNumber, secondNumber);
		return result;
	}

	public void plus() {
		currentState = plusState;
	}

	public void minus() {
		currentState = minusState;
	}

	public void multiplication() {
		currentState = multiplicationState;
	}
	
	public void modulo() {
		currentState = moduloState;
	}

}
