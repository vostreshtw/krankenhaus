package de.htw.krankenhaus.funktionen;

/**
 * 
 * 
 * 
 * 
 * @author Yevheniia Vostres (566769)
 * @since 16.04.2019
 *
 */

public class Logger {

	private static Logger instance;
	private int auswahl = 1;
	private Ausgabe aus = new Ausgabe();
	private Eingabe ein = new Eingabe();

	private Logger() {

	}

	/**
	 * Gets the single instance of Logger.
	 *
	 * @return single instance of Logger
	 */
	public static Logger getInstance() {
		if (instance == null) {
			instance = new Logger();
		}
		return instance;
	}

	/**
	 * Log.
	 *
	 * @param message
	 *            the message
	 */
	public void log(String message) {
		if (auswahl == 1) {
			logAuswahl(new ConsoleLogger(), message);
		} else {
			logAuswahl(new DateiLogger(), message);
		}
	}

	/**
	 * Log auswahl.
	 *
	 * @param strategy
	 *            the strategy
	 * @param message
	 *            the message
	 */
	public void logAuswahl(LoggerStrategy strategy, String message) {
		strategy.write(message);
	}

	/**
	 * Select log.
	 */
	public void selectLog() {
		aus.loggerStrategy();
		auswahl = ein.askLogger();
	}
}
