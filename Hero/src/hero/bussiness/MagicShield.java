package hero.bussiness;

import hero.logger.LogLevel;
import hero.logger.LoggerFacade;
import hero.logger.LoggerRole;
import hero.logger.MultipleLevelsLogger;

public class MagicShield implements BeastDefenseRole {

	private BeastDefenseRole defense;
	private BeastLuckRole luck;
	private int divider;
	private LoggerRole logger;

	public MagicShield(BeastDefenseRole defense, BeastLuckRole luck, int divider) {
		this.defense = defense;
		this.luck = luck;
		this.divider = divider;
		logger = new LoggerFacade(new MultipleLevelsLogger(LogLevel.INFO));
	}

	public int computeDamage(int strength) {
		int damage = defense.computeDamage(strength);
		if (luck.iAmLucky()) {
			logger.info("Magic shield gets lucky this round and uses magic shield!");
			damage = damage / divider;
		}
		return damage;
	}

	public int getDefense() {
		return defense.getDefense();
	}

}
