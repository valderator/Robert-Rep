package hero.construction;

import hero.bussiness.BeastLuckRole;
import hero.bussiness.Hero;
import hero.bussiness.PlayerRole;

public class HeroFactory {

	public PlayerRole create(PlayerRole innerBeast, BeastLuckRole rapidStrike) {
		return new Hero(innerBeast, rapidStrike);
	}
}
