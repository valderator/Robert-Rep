package hero.construction;

import hero.bussiness.BeastHealth;
import hero.bussiness.BeastHealthRole;

public class BeastHealthFactory {

	public BeastHealthRole create(int health) {
		return new BeastHealth(health);
	}
}
