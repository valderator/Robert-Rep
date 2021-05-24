package hero.bussiness;

import hero.logger.LogLevel;
import hero.logger.LoggerFacade;
import hero.logger.LoggerRole;
import hero.logger.MultipleLevelsLogger;

public class Beast implements PlayerRole {

	private String name;
	private int strength;
	private BeastSpeedRole speed;
	private BeastLuckRole luck;
	private BeastDefenseRole defense;
	private BeastHealthRole health;
	private LoggerRole logger;

	public Beast(int strength, BeastSpeedRole speed, BeastLuckRole luck, BeastDefenseRole defense,
			BeastHealthRole health) {
		this.name = "Beast";
		this.strength = strength;
		this.speed = speed;
		this.luck = luck;
		this.defense = defense;
		this.health = health;
		logger = new LoggerFacade(new MultipleLevelsLogger(LogLevel.INFO));
	}

	public void attack(PlayerRole defender) {
		logger.info("Attacks with " + strength + " strength.");
		defender.defend(strength);
	}

	public boolean isDead() {
		return health.isDead();
	}

	public void defend(int strength) {
		if (luck.iAmLucky()) {
			logger.info("He got lucky this turn and dodges the attack.");
			return;
		}
		int damage = defense.computeDamage(strength);
		health.applyDamage(damage);
		logger.info("He takes " + damage + " damage and currently has " + health.getHealth()
				+ " health remaining.");  
	}

	public boolean isMeAttackingFirst(BeastSpeedRole theOtherSpeed, BeastLuckRole Luck) {
		if (speed.isFasterThan(theOtherSpeed)) {
			return true;
		}

		if (theOtherSpeed.isFasterThan(speed)) {
			return false;
		}

		if (luck.isLuckierThan(Luck)) {
			return true;
		}

		return false;
	}

	public boolean isMeAttackingFirst(PlayerRole theOtherPlayer) {
		return theOtherPlayer.isMeAttackingFirst(speed, luck) == false;
	}

	public void displayInfo() {
		System.out.println("\nDisplaying stats:");
		System.out.println("Strength = " + strength);
		System.out.println("Health = " + health.getHealth());
		System.out.println("Defense = " + defense.getDefense());
		System.out.println("Speed = " + speed.getSpeed());
		System.out.println("Luck = " + luck.getLuck() + "\n");
	}

	public String getName() {
		return name;
	}

}
