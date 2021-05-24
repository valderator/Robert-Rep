package hero.bussiness;

public class BeastSpeed implements BeastSpeedRole {

	private int mySpeed;

	public BeastSpeed(int speed) {
		this.mySpeed = speed;
	}

	public boolean isFasterThan(BeastSpeedRole Speed) {
		if (Speed.isFasterThan(mySpeed)) {
			return true;
		}
		return false;
	}

	public boolean isFasterThan(int Speed) {
		if (mySpeed > Speed) {
			return false;
		}
		return true;
	}

	public int getSpeed() {
		return mySpeed;
	}

}
