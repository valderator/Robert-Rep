package reverse.ui;

import java.util.Scanner;

public class Input implements InputRole {

	private Scanner scanner;

	public Input(Scanner scanner) {
		this.scanner = scanner;
	}

	public int nextInt() {
		return scanner.nextInt();
	}

	public boolean hasData() {
		if (scanner.hasNext())
			return true;
		return false;
	}
}
