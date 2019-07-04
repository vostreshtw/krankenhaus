package de.htw.krankenhaus.funktionen;

import de.htw.krankenhaus.modell.Adresse;
import de.htw.krankenhaus.modell.Anrede;
import de.htw.krankenhaus.modell.GesetzlicheVersicherung;
import de.htw.krankenhaus.modell.Krankenhaus;
import de.htw.krankenhaus.modell.Patient;
import de.htw.krankenhaus.modell.Privatversicherung;

/**
 * Die Klasse dient zum Anlegen von neuen Objekten durch Benutzereingabe.
 *
 * @author Yevheniia Vostres (566769)
 * @since 16.04.2019
 */

public class ObjektAnlegen {

	Eingabe ein = new Eingabe();

	Suche suche = new Suche();

	/**
	 * Die Methode fuers Anlegen der neuen gesetzlichen Versicherung durch
	 * Benutzereingaben und Einordnung dieser zu einem Patient.
	 *
	 * @param helios
	 *            - Krankenhaus
	 */
	public void addGesetzlicheVersicherung(Krankenhaus helios) {
		suche.suchePatientNachNummer(helios);
		String versNum = ein.askVersicherungsNr();
		String versName = ein.askVersicherungsname();
		boolean versFuerFamilie = ein.askObFamilienvers();
		GesetzlicheVersicherung gesetzlich = new GesetzlicheVersicherung(versNum, versName, versFuerFamilie);
		Patient patient = null;
		patient.addVersicherung(gesetzlich);
	}

	/**
	 * Die Methode fuers Anlegen der neuen Privatversicherung durch Benutzereingaben
	 * und Einordnung dieser zu einem Patient.
	 *
	 * @param helios
	 *            - Krankenhaus
	 */
	public void addPrivatversicherung(Krankenhaus helios) {
		suche.suchePatientNachNummer(helios);
		String versNum = ein.askVersicherungsNr();
		String versName = ein.askVersicherungsname();
		int deckung = ein.askDeckungslimit();
		Privatversicherung privat = new Privatversicherung(versNum, versName, deckung);
		Patient patient = null;
		patient.addVersicherung(privat);
	}

	/**
	 * Methode fuers Anlegen der neuen Adresse durch Benutzereingaben.
	 *
	 * @param helios
	 *            - Krankenhaus
	 * @return adresse - die neue Adresse
	 */
	public Adresse adresseAnlegen(Krankenhaus helios) {
		String adrzeile1 = ein.askAdrZeile1();
		String adrzeile2 = ein.askAdrZeile2();
		String plz = ein.askPLZ();
		String ort = ein.askOrt();
		Adresse adresse = new Adresse(adrzeile1, adrzeile2, plz, ort);
		return adresse;
	}

	/**
	 * Methode fuers Anlegen des neuen Patienten durch Benutzereingaben.
	 *
	 * @param helios
	 *            - Krankenhaus
	 * @return patient - der neue Patient
	 */
	public Patient patientAnlegen(Krankenhaus helios) {
		int counter = 11; // 10 Patienten schon eingelegt worden sind, deswegen faengt zaehler bei 11 an
		Anrede anrede = ein.askAnrede();
		String vorname = ein.askVorname();
		String nachname = ein.askNachname();
		String geburtsdatum = ein.askGeburtsdatum();
		String email = ein.askEmail();
		String telefonnummer = ein.askTelNummer();
		Adresse adresse = adresseAnlegen(helios);
		Patient patient = new Patient(counter, anrede, vorname, nachname, geburtsdatum, adresse, telefonnummer, email);
		counter++;
		return patient;
	}
}
