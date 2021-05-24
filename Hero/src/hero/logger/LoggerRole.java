package hero.logger;

public interface LoggerRole {

	void off(String message);

	void all(String message);

	void trace(String message);

	void debug(String message);

	void info(String message);

	void warn(String message);

	void error(String message);

	void fatal(String message);

}
