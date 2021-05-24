package reverse.construction;

import reverse.buisiness.sequence.SequenceRole;
import reverse.buisiness.sequence.SimpleSequence;

public class SimpleSequenceFactory implements SimpleSequenceFactoryRole {

	public SequenceRole create() {
		return new SimpleSequence();
	}
}
