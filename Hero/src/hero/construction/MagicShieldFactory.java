package hero.construction;

import hero.bussiness.BeastDefenseRole;
import hero.bussiness.BeastLuckRole;
import hero.bussiness.MagicShield;

public class MagicShieldFactory {
	
	public BeastDefenseRole create(BeastDefenseRole defense, BeastLuckRole luck, int divider) {
		return new MagicShield(defense, luck, divider);
	}
}
