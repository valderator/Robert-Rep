package hero.ui.console;

import java.util.Scanner;

import hero.bussiness.BeastDefenseRole;
import hero.construction.BeastDefenseFactory;

public class CreateNormalDefense {

	private Scanner s = new Scanner(System.in);
	
	public BeastDefenseRole create() {

		int defRangeMax, defRangeMin, Defense;
		System.out.println("\nEnter the range of the defense.");
		System.out.print("Enter minimum value: ");
		defRangeMin = s.nextInt();
		System.out.print("Enter maximum value: ");
		defRangeMax = s.nextInt();

		Defense = (int) (Math.random() * (defRangeMax - defRangeMin + 1) + defRangeMin);
		BeastDefenseFactory beastDefenseFactory = new BeastDefenseFactory();
		BeastDefenseRole normalDefense = beastDefenseFactory.create(Defense);

		return normalDefense;
	}
}
