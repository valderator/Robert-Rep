package hero.construction;

import hero.bussiness.BeastLuck;
import hero.bussiness.BeastLuckRole;

public class BeastLuckFactory {

	public BeastLuckRole create(int luck, int range) {
		return new BeastLuck(luck, range);
	}
}
