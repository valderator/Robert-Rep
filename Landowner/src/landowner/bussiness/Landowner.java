package landowner.bussiness;

import java.util.ArrayList;

public class Landowner implements LandownerRole {

	private ArrayList<IShape> lands;

	public Landowner() {
		lands = new ArrayList<IShape>();
	}

	public void add(IShape shape) {
		lands.add(shape);
		System.out.println("Land added succesfully.\n");
	}

	public String toString() {
		return lands + "";
	}

	public void sell(int index) {
		lands.remove(index - 1);
		System.out.println("Land sold succesfully.\n");
	}

	public boolean exists(int index) {
		if (index > lands.size() || index <= 0) {
			return false;
		} else
			return true;
	}

	public double computeTotalArea() {
		double totalArea = 0;
		if (lands.size() == 0) {
			return totalArea;
		}
		for (int i = 0; i < lands.size(); i++) {
			totalArea = totalArea + lands.get(i).computeArea();
		}
		return totalArea;
	}

	public void printMyLands() {
		System.out.println("\nMy lands:\n");
		for (int i = 0; i < lands.size(); i++) {
			System.out.println((i + 1) + ". " + lands.get(i).toString() + "\n");
		}
	}
}
