package de.htw.krankenhaus.funktionen;

/**
 * 
 * 
 * Diese Klasse dient zum Loggen in die Datei
 * 
 * @author Yevheniia Vostres (566769)
 * @since 16.04.2019
 *
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class DateiLogger implements LoggerStrategy {

	// TODO Auto-generated method stub
	private PrintWriter pw;

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.htw.krankenhaus.funktionen.LoggerStrategy#write(java.lang.String)
	 */
	@Override
	public void write(String message) {

		if (pw == null) {
			FileOutputStream fos;
			try {
				fos = new FileOutputStream(new File("log.csv"), true);
				pw = new PrintWriter(fos);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		pw.append(message + ";\r\n");
		pw.flush();
	}

}
