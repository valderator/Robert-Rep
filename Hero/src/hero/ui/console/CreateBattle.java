package hero.ui.console;

import java.util.Scanner;

import hero.bussiness.Battle;
import hero.bussiness.BeastDefenseRole;
import hero.bussiness.PlayerRole;

public class CreateBattle {

	private Scanner s = new Scanner(System.in);

	public Battle create() {

		System.out.println("-----Initializing battle-----\n");
		
		System.out.print("\nEnter the maximum number of rounds: ");
		int rounds = s.nextInt();
		
		System.out.println("\n-----Initializing beast status-----\n");
		CreateNormalDefense createNormalDefense = new CreateNormalDefense();
		BeastDefenseRole beastDefense = createNormalDefense.create();

		CreateBeast createBeatBeast = new CreateBeast();
		PlayerRole attacker = createBeatBeast.initBeast(beastDefense);

		System.out.println("\n\n-----Initializing hero status-----\n");
		CreateMagicShield createMagicShield = new CreateMagicShield();
		BeastDefenseRole magicShieldDefense = createMagicShield.create();

		CreateHero createHero = new CreateHero();
		PlayerRole defender = createHero.initHero(magicShieldDefense);

		return new Battle(attacker, defender, rounds);
	}
}
