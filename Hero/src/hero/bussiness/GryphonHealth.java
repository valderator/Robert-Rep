package hero.bussiness;

public class GryphonHealth implements BeastHealthRole {

	private BeastLuckRole luck;
	private BeastHealthRole beastHealth;

	public GryphonHealth(BeastLuckRole luck, BeastHealthRole beastHealth) {
		this.luck = luck;
		this.beastHealth = beastHealth;
	}

	public boolean isDead() {
		return beastHealth.isDead();
	}

	public void applyDamage(int damage) {
		beastHealth.applyDamage(damage);
		if (beastHealth.isDead()) {
			if (luck.iAmLucky()) {
				System.out.println("Gryphon got lucky this time and negate the damage received.");
				beastHealth.applyDamage(-damage);
			}
		}
	}

	public int getHealth() {
		return beastHealth.getHealth();
	}
}
