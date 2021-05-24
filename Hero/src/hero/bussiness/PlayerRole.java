package hero.bussiness;

public interface PlayerRole {

	void attack(PlayerRole defender);

	boolean isDead();

	boolean isMeAttackingFirst(PlayerRole attacker);

	void defend(int strength);

	boolean isMeAttackingFirst(BeastSpeedRole speed, BeastLuckRole luck);

	void displayInfo();

	String getName();

}
