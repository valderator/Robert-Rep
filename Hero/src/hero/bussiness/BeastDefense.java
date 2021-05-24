package hero.bussiness;

public class BeastDefense implements BeastDefenseRole {

	private int defense;

	public BeastDefense(int defense) {
		this.defense = defense;
	}

	public int computeDamage(int strength) {
		return strength - defense;
	}

	public int getDefense() {
		return defense;
	}

}