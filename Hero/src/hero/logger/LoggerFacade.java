package hero.logger;

public class LoggerFacade implements LoggerRole {

	private MultipleLevelsLogger logger;

	public LoggerFacade(MultipleLevelsLogger logger) {
		this.logger = logger;
	}

	public void off(String message) {
		logger.log(LogLevel.OFF, message);
	}

	public void all(String message) {
		logger.log(LogLevel.ALL, message);
	}

	public void trace(String message) {
		logger.log(LogLevel.TRACE, message);
	}

	public void debug(String message) {
		logger.log(LogLevel.DEBUG, message);
	}

	public void info(String message) {
		logger.log(LogLevel.INFO, message);
	}

	public void warn(String message) {
		logger.log(LogLevel.WARN, message);
	}

	public void error(String message) {
		logger.log(LogLevel.ERROR, message);
	}

	public void fatal(String message) {
		logger.log(LogLevel.FATAL, message);
	}

	public static void main(String[] args) {
		MultipleLevelsLogger logger = new MultipleLevelsLogger(LogLevel.INFO);
		LoggerFacade logger1 = new LoggerFacade(logger);
		logger1.info("saluuut");
	}
}
