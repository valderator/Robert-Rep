package hero.bussiness;

public class BeastHealth implements BeastHealthRole {

	private int health;

	public BeastHealth(int health) {
		this.health = health;
	}

	public boolean isDead() {
		if (health <= 0) {
			return true;
		}
		return false;
	}

	public void applyDamage(int damage) {
		health = health - damage;
	}

	public int getHealth() {
		return health;
	}

}