package hero.ui.console;

import java.util.Scanner;

import hero.bussiness.BeastDefenseRole;
import hero.bussiness.BeastLuckRole;
import hero.construction.BeastDefenseFactory;
import hero.construction.BeastLuckFactory;
import hero.construction.MagicShieldFactory;

public class CreateMagicShield {

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
		BeastDefenseRole magicShieldDefense = beastDefenseFactory.create(Defense);

		System.out.print("\nEnter the magic shield chance of happening: ");
		int luck = s.nextInt();
		BeastLuckFactory magicShieldLuckFactory = new BeastLuckFactory();
		BeastLuckRole magicShieldLuck = magicShieldLuckFactory.create(luck, 100);

		MagicShieldFactory magicShieldFactory = new MagicShieldFactory();
		BeastDefenseRole magicShield = magicShieldFactory.create(magicShieldDefense, magicShieldLuck, 2);

		return magicShield;
	}
}
