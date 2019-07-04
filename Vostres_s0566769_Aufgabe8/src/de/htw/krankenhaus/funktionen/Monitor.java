package de.htw.krankenhaus.funktionen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

import de.htw.krankenhaus.modell.Aufenthalt;
import de.htw.krankenhaus.modell.Krankenhaus;
import de.htw.krankenhaus.modell.Qualitaetsmanagementstelle;


/**
 * 
 * 
 * Die Klasse fuer Monitoring des Programms
 * 
 * @author Yevheniia Vostres (566769)
 *
 */
public class Monitor implements Runnable {

	private static long INTERVAL;
	private PrintWriter pw;
	private final AtomicBoolean running = new AtomicBoolean(false);
	private Thread thread;
	private Krankenhaus kh;
	
	 /**
 	 * Konstruktor fuer Intervall.
 	 *
 	 * @param sleepInterval the sleep interval
 	 */
 	public Monitor(long sleepInterval) {
		 INTERVAL = sleepInterval;
	    }
	 
	/**
	 * Monitor an.
	 *
	 * @param kh the kh
	 */
	public void monitorOn(Krankenhaus kh) {
		this.kh = kh;
		thread = new Thread(this);
		thread.start();
		System.out.println("Monitoring aktiviert.\n");
	}

	/**
	 * Monitor aus.
	 */
	public void monitorOff() {
		running.set(false);
		System.out.println("Monitoring deaktiviert.\n: " + thread.getState());
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		running.set(true);
		while (running.get()) {
			monitor(kh);
				try {
					Thread.sleep(INTERVAL);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					 System.out.println(
			                  "Thread was interrupted, Failed to complete operation");
				}
		}
	}

	/**
	 * Methode zum Schreiben von CSV Datei.
	 *
	 * @param kh the kh
	 */
	public void monitor(Krankenhaus kh) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		if (pw == null) {
			FileOutputStream fos;
			try {
				fos = new FileOutputStream(new File("monitor.csv"), true);
				pw = new PrintWriter(fos);
			} catch (IOException e) {
				e.printStackTrace();
			}
		pw.append(LocalDateTime.now().format(formatter) + " - das Krankenhaus hat gerade " + 
				+ (kh.getIndates().size() - kh.getOutdates().size()) + " aktuelle Aufenthalte vos insgesamt " +kh.getAufenthalte().size() + "\r\n");}
		pw.flush();
		
		// Ausgabe nur zum schnell testen
		//System.out.println(LocalDateTime.now().format(formatter) + " - das Krankenhaus hat gerade " + 
			//	+ (kh.getIndates().size() - kh.getOutdates().size()) + " aktuelle Aufenthalte von insgesamt " +kh.getAufenthalte().size() + "\r\n");
	}
}
