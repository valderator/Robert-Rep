package reverse.construction;

import java.util.Scanner;

import reverse.ui.Input;
import reverse.ui.InputRole;

public class InputFactory implements InputFactoryRole {

	public InputRole create(Scanner scanner) {
		return new Input(scanner);
	}

}
