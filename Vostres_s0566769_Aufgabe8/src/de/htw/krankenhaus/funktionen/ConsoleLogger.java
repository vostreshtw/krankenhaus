package de.htw.krankenhaus.funktionen;

/**
 * 
 * 
 * Diese Klasse dient zum Loggen auf der Console
 * 
 * @author Yevheniia Vostres (566769)
 * @since 16.04.2019
 *
 */

public class ConsoleLogger implements LoggerStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.htw.krankenhaus.funktionen.LoggerStrategy#write(java.lang.String)
	 * 
	 * 
	 * @param message -
	 * 
	 */
	@Override
	public void write(String message) {

		System.out.println(message);

	}

}
