package hero.construction;

import hero.bussiness.BeastDefense;
import hero.bussiness.BeastDefenseRole;

public class BeastDefenseFactory {

	public BeastDefenseRole create(int defense) {
		return new BeastDefense(defense);
	}
}
