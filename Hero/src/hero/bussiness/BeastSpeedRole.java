package hero.bussiness;

public interface BeastSpeedRole {
	
	public boolean isFasterThan(BeastSpeedRole speed);

	public boolean isFasterThan(int speed);
	
	public int getSpeed();
}
