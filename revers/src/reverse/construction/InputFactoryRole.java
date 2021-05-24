package reverse.construction;

import java.util.Scanner;

import reverse.ui.InputRole;

public interface InputFactoryRole {
	
	public InputRole create(Scanner scanner);
}
