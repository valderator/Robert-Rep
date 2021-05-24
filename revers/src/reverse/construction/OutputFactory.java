package reverse.construction;

import reverse.ui.Output;
import reverse.ui.OutputRole;

public class OutputFactory implements OutputFactoryRole {

	public OutputRole create() {
		return new Output();
	}

}
