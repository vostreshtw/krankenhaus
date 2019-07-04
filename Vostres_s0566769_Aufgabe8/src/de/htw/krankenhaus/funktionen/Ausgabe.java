package de.htw.krankenhaus.funktionen;

import de.htw.krankenhaus.modell.Krankenhaus;

/**
 * 
 * 
 * Diese Klasse dient zur Ausgabe auf der Konsole
 * 
 * @author Yevheniia Vostres (566769)
 * @since 16.04.2019
 *
 */

public class Ausgabe {

	Eingabe ein = new Eingabe();
	Suche suche = new Suche();

	/**
	 * 
	 * Methode fuer Ausgabe des Patienten (die Suche nach Nummer)
	 * 
	 * @param helios
	 *            - Krankenhaus
	 */
	public void printPatientNummer(Krankenhaus helios) {
		System.out.println(suche.suchePatientNachNummer(helios));
	}

	/**
	 * 
	 * Methode fuer Ausgabe des Patienten (die Suche nach Name)
	 * 
	 * @param helios
	 *            - Krankenhaus
	 */
	public void printPatientName(Krankenhaus helios) {
		System.out.println(suche.suchePatientNachName(helios));
	}

	/**
	 * Speichern unter Ausgabe.
	 *
	 * @return dateiname - Dateiname inklusive Pfad
	 */
	public String speichernUnterAusgabe() {
		System.out.println(
				"Geben Sie bitte einen vollstaendigen Pfad inklusive Dateiname ein. Z. B. C:\\Users\\eugen\\Desktop\\sample.ser\nSpeichern unter:");
		String dateiname = ein.askDateiname();
		return dateiname;
	}

	/**
	 * Lade Datei Ausgabe.
	 *
	 * @return dateiname - Dateiname inklusive Pfad
	 */
	public String ladeDateiAusgabe() {
		System.out.println(
				"Geben Sie bitte einen vollstaendigen Pfad inklusive Dateiname ein. Z. B. C:\\Users\\eugen\\Desktop\\sample.ser\nDatei öffnen:");
		String dateiname = ein.askDateiname();
		return dateiname;
	}

	/**
	 * Export Patientendatei.
	 *
	 * @return dateiname - Dateiname inklusive Pfad
	 */
	public String exportPatientendatei() {
		System.out.println(
				"Geben Sie bitte einen vollstaendigen Pfad inklusive Dateiname ein. Z. B. C:\\Users\\eugen\\Desktop\\sample.csv\nDatei als CSV exportieren:");
		String dateiname = ein.askDateiname();
		return dateiname;
	}

	/**
	 * Ausgabe von Menue fuer Auswahl von Logger Strategy.
	 */
	public void loggerStrategy() {
		System.out.println(
				"Logger Auswahl\n(1) Ausgabe auf der Konsole anzeigen\n(2) Daten in eine Datei bereitstellen\n");
	}
}
