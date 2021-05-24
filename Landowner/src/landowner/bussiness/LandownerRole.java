package landowner.bussiness;

public interface LandownerRole {

	public void add(IShape shape);

	public void sell(int index);

	public boolean exists(int index);

	public double computeTotalArea();

	public void printMyLands();
}
