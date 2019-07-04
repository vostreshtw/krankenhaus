package de.htw.krankenhaus.funktionen;

import de.htw.krankenhaus.modell.Krankenhaus;
import de.htw.krankenhaus.modell.Patient;

/**
 * Die Klasse dient fuer die Suche von Daten nach unterschiedlichen Kriterien.
 *
 * @author Yevheniia Vostres (566769)
 * @since 16.04.2019
 */

public class Suche {

	Eingabe ein = new Eingabe();

	/**
	 * Methode fuer die suche des Patienten nach Nummer.
	 *
	 * @param helios
	 *            - Krankenhaus
	 * @return patient - der gesuchte Patient
	 */
	public Patient suchePatientNachNummer(Krankenhaus helios) {
		int patNummer = ein.askPatientennummer();

		Patient patient = null;

		for (Patient p : helios.getPatList()) {
			if (p.getPatientenNummer() == patNummer) {
				patient = p;
			}
		}

		return patient;
	}

	/**
	 * 
	 * Methode fuer die suche des Patienten nach Namen.
	 * 
	 * @param helios
	 *            - Krankenhaus
	 * @return patient - der gesuchte Patient
	 */

	public Patient suchePatientNachName(Krankenhaus helios) {

		String patName = ein.askPatientenname();
		Patient patient = null;

		for (Patient p : helios.getPatList()) {
			if (p.getNachname().trim().toUpperCase().equals(patName.trim().toUpperCase())) {
				patient = p;
			}
		}
		return patient;
	}
}