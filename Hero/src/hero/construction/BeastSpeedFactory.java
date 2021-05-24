package hero.construction;

import hero.bussiness.BeastSpeed;
import hero.bussiness.BeastSpeedRole;

public class BeastSpeedFactory {

	public BeastSpeedRole create(int speed) {
		return new BeastSpeed(speed);
	}
}
