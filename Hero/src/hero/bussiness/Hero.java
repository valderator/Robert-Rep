package hero.bussiness;

import hero.logger.LogLevel;
import hero.logger.LoggerFacade;
import hero.logger.LoggerRole;
import hero.logger.MultipleLevelsLogger;

public class Hero implements PlayerRole {

	private String name;
	private PlayerRole innerBeast;
	private BeastLuckRole rapidStrike;
	private LoggerRole logger;

	public Hero(PlayerRole innerBeast, BeastLuckRole rapidStrike) {
		this.name = "Orderus";
		this.innerBeast = innerBeast;
		this.rapidStrike = rapidStrike;
		logger = new LoggerFacade(new MultipleLevelsLogger(LogLevel.INFO));
	}

	public void attack(PlayerRole defender) {
		innerBeast.attack(defender);
		if (rapidStrike.iAmLucky()) {
			logger.info("Rapid strike got lucky this round and uses rapid strike!");
			innerBeast.attack(defender);
		}
	}

	public boolean isDead() {
		return innerBeast.isDead();
	}

	public boolean isMeAttackingFirst(PlayerRole attacker) {
		return innerBeast.isMeAttackingFirst(attacker);
	}

	public void defend(int strength) {
		innerBeast.defend(strength);
	}

	public boolean isMeAttackingFirst(BeastSpeedRole speed, BeastLuckRole luck) {
		return innerBeast.isMeAttackingFirst(speed, luck);
	}

	public void displayInfo() {
		innerBeast.displayInfo();
	}

	public String getName() {
		return name;
	}

}
