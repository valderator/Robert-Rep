package hero.ui.console;

import java.util.Scanner;

import hero.bussiness.BeastDefenseRole;
import hero.bussiness.BeastHealthRole;
import hero.bussiness.BeastLuckRole;
import hero.bussiness.BeastSpeedRole;
import hero.bussiness.PlayerRole;
import hero.construction.BeastFactory;
import hero.construction.BeastHealthFactory;
import hero.construction.BeastLuckFactory;
import hero.construction.BeastSpeedFactory;

public class CreateBeast {

	private Scanner s = new Scanner(System.in);
	
	public PlayerRole initBeast(BeastDefenseRole defenseChoice) {

		int strRangeMax, strRangeMin, Strength;
		System.out.println("\nEnter the range of the strength.");
		System.out.print("Enter minimum value: ");
		strRangeMin = s.nextInt();
		System.out.print("Enter maximum value: ");
		strRangeMax = s.nextInt();

		Strength = (int) (Math.random() * (strRangeMax - strRangeMin + 1) + strRangeMin);

		int luckRangeMax, luckRangeMin, Luck;
		System.out.println("\nEnter the range of the luck.");
		System.out.print("Enter minimum value: ");
		luckRangeMin = s.nextInt();
		System.out.print("Enter maximum value: ");
		luckRangeMax = s.nextInt();

		Luck = (int) (Math.random() * (luckRangeMax - luckRangeMin + 1) + luckRangeMin);
		BeastLuckFactory beastLuckFactory = new BeastLuckFactory();
		BeastLuckRole beastLuck = beastLuckFactory.create(Luck, 100);

		int healthRangeMax, healthRangeMin, Health;
		System.out.println("\nEnter the range of the health.");
		System.out.print("Enter minimum value: ");
		healthRangeMin = s.nextInt();
		System.out.print("Enter maximum value: ");
		healthRangeMax = s.nextInt();

		Health = (int) (Math.random() * (healthRangeMax - healthRangeMin + 1) + healthRangeMin);
		BeastHealthFactory beastHealthFactory = new BeastHealthFactory();
		BeastHealthRole beastHealth = beastHealthFactory.create(Health);

		int speedRangeMax, speedRangeMin, Speed;
		System.out.println("\nEnter the range of the speed.");
		System.out.print("Enter minimum value: ");
		speedRangeMin = s.nextInt();
		System.out.print("Enter maximum value: ");
		speedRangeMax = s.nextInt();

		Speed = (int) (Math.random() * (speedRangeMax - speedRangeMin + 1) + speedRangeMin);
		BeastSpeedFactory beastSpeedFactory = new BeastSpeedFactory();
		BeastSpeedRole beastSpeed = beastSpeedFactory.create(Speed);

		BeastFactory beastFactory = new BeastFactory();

		return beastFactory.create(Strength, beastSpeed, beastLuck, defenseChoice, beastHealth);
	}

}
