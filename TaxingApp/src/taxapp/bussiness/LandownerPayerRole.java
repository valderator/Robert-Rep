package taxapp.bussiness;

import landowner.bussiness.IShape;

public interface LandownerPayerRole {
	
	public void add(IShape shape);

	public void sell(int index);

	public boolean exists(int index);
	
	public double computeTax();
	
	public void printMyLands();
}
