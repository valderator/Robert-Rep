package hero.bussiness;

public interface BeastLuckRole {

	public boolean iAmLucky();

	public boolean isLuckierThan(BeastLuckRole luck);

	public boolean isLuckierThan(int luck);
	
	public int getLuck();

}
