package hero.bussiness;

import java.util.Random;

public class BeastLuck implements BeastLuckRole {

	private int myLuck;
	private int range;

	public BeastLuck(int luck, int range) {
		this.myLuck = luck;
		this.range = range;
	}

	public boolean iAmLucky() {

		int random = new Random().nextInt(range);

		if (isLuckierThan(random)) {
			return true;
		}

		return false;
	}

	public boolean isLuckierThan(BeastLuckRole luck) {
		if (luck.isLuckierThan(myLuck)) {
			return false;
		}
		return true;
	}

	public boolean isLuckierThan(int luck) {
		if (myLuck >= luck) {
			return true;
		}
		return false;
	}

	public int getLuck() {
		return myLuck;
	}
}
