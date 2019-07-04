package de.htw.krankenhaus.start;

import java.util.Collections;
import java.util.Scanner;

import de.htw.krankenhaus.funktionen.Ausgabe;
import de.htw.krankenhaus.funktionen.DateiVerwaltung;
import de.htw.krankenhaus.funktionen.Eingabe;
import de.htw.krankenhaus.funktionen.Logger;
import de.htw.krankenhaus.funktionen.Monitor;
import de.htw.krankenhaus.funktionen.ObjektAnlegen;
import de.htw.krankenhaus.funktionen.PatientComparator;
import de.htw.krankenhaus.funktionen.Suche;
import de.htw.krankenhaus.gui.Fenster;
import de.htw.krankenhaus.modell.Adresse;
import de.htw.krankenhaus.modell.Anrede;
import de.htw.krankenhaus.modell.Krankenhaus;
import de.htw.krankenhaus.modell.Patient;

/**
 * 
 * 
 * Die Klasse fuer Menue des Programms
 * 
 * @author Yevheniia Vostres (566769)
 * @since 16.04.2019
 *
 */

public class Menue {

	Scanner scan;
	Eingabe ein = new Eingabe();
	Ausgabe aus = new Ausgabe();
	ObjektAnlegen neu = new ObjektAnlegen();
	DateiVerwaltung daten = new DateiVerwaltung();
	Suche suche = new Suche();
	Monitor monitor = new Monitor(10*1000);

	/**
	 * 
	 * Die Methode beschreibt Optionen im Programm, die von Benutzereingabe
	 * abhaengig sind
	 * 
	 * @param helios
	 *            - Krankenhaus
	 */

	public void ansicht(Krankenhaus helios) {
		String auswahlAnsicht;

		do {
			auswahlAnsicht = ein.auswahlAnsicht();
			switch (auswahlAnsicht) {
			case "1":
				menue(helios);
				break;
			case "2":
				Fenster fenster = new Fenster(helios, helios.getPatList().get(0));
				fenster.setVisible(true);
				break;
			case "0":
				// Beenden
				System.out.println("-----Programm beendet. Auf Wiedersehen!------");
				break;
			default:
				// Bei der ungueltigen Eingabe
				System.out.println("-----Keine gültige Eingabe. Bitte erneut eingeben!------");
				break;
			} // switch case fuer Menue

		} while (!auswahlAnsicht.equals("0"));
	}

	/**
	 * 
	 * Die Methode beschreibt Optionen im Programm, die von Benutzereingabe
	 * abhaengig sind
	 * 
	 * @param helios
	 *            - Krankenhaus
	 */
	public void menue(Krankenhaus helios) {
		scan = new Scanner(System.in);
		int counterP = 11;

		String auswahlMenue;
		do {
			auswahlMenue = ein.auswahlMenue();
			switch (auswahlMenue) {
			case "0":
				// (00) Demo Daten anzeigen
				System.out.println("-----Gesamtdaten anzeigen-----");
				for (Patient patient : helios.getPatList()) {
					System.out.println(patient);
				}

				break;
			case "1":
				// (01) Patient anlegen
				System.out.println("-----Patient anlegen-----");
				Anrede anrede = ein.askAnrede();
				String vorname = ein.askVorname();
				String nachname = ein.askNachname();
				String geburtsdatum = ein.askGeburtsdatum();
				String email = ein.askEmail();
				String telefonnummer = ein.askTelNummer();
				Adresse adresse = neu.adresseAnlegen(helios);
				Patient patient = new Patient(counterP, anrede, vorname, nachname, geburtsdatum, adresse, telefonnummer,
						email);
				helios.addPatient(patient);
				counterP++;
				System.out.println("Patient erfolgreich hinzugefügt");
				break;
			case "2":
				// (02) Gesetzliche Versicherung anlegen und Patientennummer zuordnen
				System.out.println("-----Gesetzliche Versicherung anlegen-----");
				neu.addGesetzlicheVersicherung(helios);
				System.out.println("Gesetzliche Versicherung erfolgreich hinzugefügt");
				break;
			case "3":
				// (03) Privatversicherung anlegen und Patientennummer zuordnen
				System.out.println("-----Privatversicherung anlegen-----");
				neu.addPrivatversicherung(helios);
				System.out.println("Privatversicherung erfolgreich hinzugefügt");
				break;
			case "4":
				// (04) Patient mit Versicherungen anzeigen (Auswahl durch Patientennummer)
				System.out.println("-----Patient anzeigen. Auswahl durch Patientennummer-----");
				aus.printPatientNummer(helios);
				break;
			case "5":
				// (05) Patient mit Versicherungen anzeigen (Auswahl durch Name)
				System.out.println("-----Patient anzeigen. Auswahl durch Patientenname-----");
				aus.printPatientName(helios);
				break;
			case "6": // UMSCHREIBEN
				// (06) Versicherung anzeigen (Auswahl durch Versicherungsnummer)
				System.out.println("-----Versicherung anzeigen. Auswahl durch Versicherungsnummer-----");
				String versNum = ein.askVersicherungsNr();
				System.out.println(helios.getVersHash().get(versNum).toString());
				break;
			case "7":
				// (08) Alle Patienten sortiert nach aufsteigendem Patientennummer anzeigen
				System.out.println("-----Alle Patienten sortiert nach aufsteigender Patientennummer-----");
				Collections.sort(helios.getPatList());
				System.out.println(helios.getPatList());
				break;
			case "8":
				// (08) Alle Patienten sortiert nach aufsteigendem Nachnamen
				System.out.println("-----Alle Patienten sortiert nach aufsteigendem Nachnamen-----");
				Collections.sort(helios.getPatList(), new PatientComparator());
				System.out.println(helios.getPatList());
				break;
			case "9":
				// (09) Alle Krankenversicherungen unsortiert anzeigen
				System.out.println("-----Alle Krankenversicherungen unsortiert anzeigen------");
				System.out.println(helios.getVersHash().values());
			case "10":
				// (10) Daten Export
				System.out.println("-----Daten von Krankenhaus exportieren------");
				daten.exportKH(aus.speichernUnterAusgabe(), helios);
				break;
			case "11":
				// (11) Daten Import
				System.out.println("-----Daten von Krankenhaus importieren------");
				Krankenhaus khNeu = null;
				khNeu = daten.importKH(aus.ladeDateiAusgabe()); // Bankdaten laden
				if (khNeu != null) { // catch falls manipuliert
					helios = khNeu;
				}
				break;
			case "12":
				// (12) Patienten nach Namen sortiert als CSV-Datei exportieren
				System.out.println("-----Patienten nach Namen sortiert als CSV-Datei exportieren------");
				daten.exportPatient(aus.exportPatientendatei(), helios);// Patienten nach Namen sortiert als CSV-Datei
				// exportieren
				break;
			case "13":
				// (13) Patient aufnehmen
				System.out.println("Patientennumer");
				Patient patient13 = suche.suchePatientNachNummer(helios);
				System.out.println("Aufnahmedatum:");
				String input = scan.nextLine();
				patient13.setIndate(input, helios);

				break;
			case "14":
				// (14) Patient entlassen
				System.out.println("Patientennumer");
				Patient patient14 = suche.suchePatientNachNummer(helios);
				System.out.println("Entlassungsdatum:");
				String input14 = scan.nextLine();
				patient14.setOutdate(input14, helios);
				break;
			case "15":
				// (15) Protokoll-Strategie wählen
				Logger.getInstance().selectLog();
				break;
			case "16":
				monitor.monitorOn(helios);
				break;
			case "17":
				monitor.monitorOff();
				break;
			case "18":
				// (18) Beenden
				System.out.println("-----Programm beendet. Auf Wiedersehen!------");
				break;
			default:
				// Bei der ungueltigen Eingabe
				System.out.println("-----Keine gültige Eingabe. Bitte erneut eingeben!------");
				break;
			} // switch case fuer Menue

		} while (!auswahlMenue.equals("18")); // auswahlMenue

	}

}