package hero.logger;

public class MultipleLevelsLogger {

	private LogLevel currentLevel;

	public MultipleLevelsLogger(LogLevel currentLevel) {
		this.currentLevel = currentLevel;
	}

	public void log(LogLevel level, String message) {
		int compare = currentLevel.compareTo(level);
		if (compare >= 0) {
			log(message);
		}
		else {
			System.out.println("error");
		}
	}

	private void log(String message) {
		System.out.println(message);
	}
}
