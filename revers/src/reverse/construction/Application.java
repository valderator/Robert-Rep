package reverse.construction;

import reverse.buisiness.Revers;
import reverse.ui.ReversFactory;

public class Application {
	
	private Revers revers;
	
	public Application() {
		ReversFactory factory = new ReversFactory();
		revers = factory.create();
	}
	
	public void run() {
		revers.revers();
	}
	
	public static void main(String[] args) {
		Application application = new Application();
		application.run();
	}
}
