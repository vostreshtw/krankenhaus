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
public interface LoggerStrategy {

	/**
	 * Write.
	 *
	 * @param message
	 *            the message
	 */
	public void write(String message);
}
