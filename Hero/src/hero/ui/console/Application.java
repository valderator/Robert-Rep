package hero.ui.console;

import hero.bussiness.Battle;

public class Application {

	private Battle battle;

	public Application() {
		CreateBattle battleFactory = new CreateBattle();
		battle = battleFactory.create();
	}

	public void run() {
		battle.fight();
	}

	public static void main(String[] args) {
		Application application = new Application();
		application.run();
	}
}
