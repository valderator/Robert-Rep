package hero.construction;

import hero.bussiness.Beast;
import hero.bussiness.BeastDefenseRole;
import hero.bussiness.BeastHealthRole;
import hero.bussiness.BeastLuckRole;
import hero.bussiness.BeastSpeedRole;
import hero.bussiness.PlayerRole;

public class BeastFactory {
	
	public PlayerRole create(int strength, BeastSpeedRole speed, BeastLuckRole luck, BeastDefenseRole defense,
			BeastHealthRole health) {
		return new Beast(strength, speed, luck, defense, health);
	}
}
