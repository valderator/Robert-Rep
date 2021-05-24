package hero.bussiness;

import hero.logger.LogLevel;
import hero.logger.LoggerFacade;
import hero.logger.LoggerRole;
import hero.logger.MultipleLevelsLogger;

public class Battle {

	private PlayerRole attacker;
	private PlayerRole defender;
	private int rounds;
	private LoggerRole logger;

	public Battle(PlayerRole firstPlayer, PlayerRole secondPlayer, int Rounds) {
		attacker = firstPlayer; 
		defender = secondPlayer;
		rounds = Rounds;
		logger = new LoggerFacade(new MultipleLevelsLogger(LogLevel.INFO));
	}

	public void fight() {
		logger.info("\n" + attacker.getName() + " stats: ");
		attacker.displayInfo();
		logger.info(defender.getName() + " stats: ");
		defender.displayInfo();
		decideAttacker();
		for (int i = 1; i <= rounds; i++) {
			logger.info("Round no." + i + " start!\n");
			logger.info(attacker.getName() + " attacks and " + defender.getName() + " is defending.");
			attacker.attack(defender);
			if (someoneDied()) {
				break;
			}
			switchRoles();
		}
	}

	private void switchRoles() {
		PlayerRole aux;
		aux = attacker;
		attacker = defender;
		defender = aux;
		logger.info("\nSwitching roles between attacker and defender.\n");
	}

	private void decideAttacker() {
		if (defender.isMeAttackingFirst(attacker)) {
			switchRoles();
		}
		logger.info("\n" + attacker.getName() + " is attacking first.\n");
	}

	private boolean someoneDied() {
		if (attacker.isDead()) {
			logger.info("\n" + attacker.getName() + " died.");
			return true;
		}
		if (defender.isDead()) {
			logger.info("\n" + defender.getName() + " died.");
			return true;
		}
		return false;
	}

}
