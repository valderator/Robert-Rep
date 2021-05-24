package landowner.construction;

import landowner.ui.console.Menu;

public class Application {

	private Menu menu;

	public Application() {
		MenuFactory menuFactory = new MenuFactory();
		menu = menuFactory.build();
	}

	public void run() {
		menu.run();
	}

	public static void main(String[] args) {
		Application application = new Application();
		application.run();
	}
}
