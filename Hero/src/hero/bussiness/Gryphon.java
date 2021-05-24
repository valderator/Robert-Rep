package hero.bussiness;

public class Gryphon implements PlayerRole {

	private String name;
	private PlayerRole innerBeast;
	private int energyNeeded;
	private int energyCounter;

	public Gryphon(PlayerRole innerBeast, int energy, int energyCounter) {
		this.name = "Gryphon";
		this.innerBeast = innerBeast;
		this.energyNeeded = energy;
		this.energyCounter = energyCounter;
	}

	public void attack(PlayerRole defender) {
		innerBeast.attack(defender);
		energyCounter += 10; // increasing the energy with 10 every time gryphon attacks
		if (energyCounter == energyNeeded) {
			// ??
		}
	}

	public boolean isDead() {
		return innerBeast.isDead(); // there is a 20% chance that if he is about to die after receiving damage,
									// to ignore that damage
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
