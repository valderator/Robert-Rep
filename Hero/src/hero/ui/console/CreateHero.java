package hero.ui.console;

import java.util.Scanner;

import hero.bussiness.BeastDefenseRole;
import hero.bussiness.BeastLuckRole;
import hero.bussiness.PlayerRole;
import hero.construction.BeastLuckFactory;
import hero.construction.HeroFactory;

public class CreateHero {

	private Scanner s = new Scanner(System.in);
	
	public PlayerRole initHero(BeastDefenseRole defenseChoice) {

		CreateBeast beastFactory = new CreateBeast();
		PlayerRole innerBeast = beastFactory.initBeast(defenseChoice);

		System.out.print("\nEnter the rapid strike chance of happening: ");
		int chance = s.nextInt();
		BeastLuckFactory rapidStrikeFactory = new BeastLuckFactory();
		BeastLuckRole rapidStrike = rapidStrikeFactory.create(chance, 100);

		HeroFactory heroFactory = new HeroFactory();
		return heroFactory.create(innerBeast, rapidStrike);
	}
}
