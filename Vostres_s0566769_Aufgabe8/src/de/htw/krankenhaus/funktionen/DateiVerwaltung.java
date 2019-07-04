package de.htw.krankenhaus.funktionen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import de.htw.krankenhaus.modell.Adresse;
import de.htw.krankenhaus.modell.Anrede;
import de.htw.krankenhaus.modell.Krankenhaus;
import de.htw.krankenhaus.modell.Patient;

/**
 * 
 * 
 * Die Klasse fuer Methoden, die zur Export/Import von Daten dienen
 * 
 * @author Yevheniia Vostres (566769)
 * @since 16.04.2019
 *
 */

public class DateiVerwaltung {

	/**
	 * Gesamte Krankenhaus wird gespeichert. Wenn den selben Dateiname bereits in
	 * dem selben Verzeichnis befindet, wird diese ueberschrieben.
	 * 
	 * @param dateiname
	 *            Dateiname inklusive Path
	 * @param kh
	 *            Das zu speichernde Kranknhaus
	 */
	public void exportKH(String dateiname, Krankenhaus kh) {

		File datei = new File(dateiname);
		if (datei.exists()) {
			System.out.println("Die Datei existiert bereits und wird versucht zu ueberschreiben");
		}
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(dateiname);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(kh);
			System.out.println("Daten gespeichert unter: " + dateiname);
		} catch (IOException e) {
			System.out.println("Es ist ein Fehler beim Schreiben der Daten aufgetreten." + e.getMessage());
			e.getStackTrace();
		}
		if (oos != null) {
			try {
				oos.close();
			} catch (IOException e) {
				System.out.println("Es ist ein Fehler beim Schliessen des Streams aufgetreten.");
				e.printStackTrace();
			}
		}
	}

	/**
	 * Krankenhaus wird geladen. Falls die Datei nicht existiert oder nicht geladen
	 * werden kann, wird dies ueber die Fehlermeldung informiert.
	 * 
	 * @param dateiname
	 *            Dateiname inklusive Path
	 * @return kh - das geladene Krankenhaus
	 */
	public Krankenhaus importKH(String dateiname) {
		File datei = new File(dateiname);
		if (!datei.exists() || !datei.canRead()) {
			System.out.println("Die Datei existiert nicht oder kann nicht gelesen werden.");
		}
		Krankenhaus kh = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(dateiname);
			ois = new ObjectInputStream(fis);
			kh = (Krankenhaus) ois.readObject();
			System.out.println(dateiname
					+ " wurde erfolgreich geladen.\n-------------------------------------------------------\n");

		} catch (IOException | ClassNotFoundException ex) {
			System.out.println("Es ist ein Fehler beim Laden der Daten aufgetreten.");
			ex.getStackTrace();
		}

		if (ois != null) {
			try {
				ois.close();
			} catch (IOException e) {
				System.out.println("Es ist ein Fehler beim Schliessen des Streams aufgetreten.");
				e.printStackTrace();
			}
		}
		return kh;
	}

	/**
	 * Patientendaten werden als csv exportiert. Nach Namen sortiert
	 * 
	 * @param dateiname
	 *            Dateiname inklusive Path
	 * @param kh
	 *            Das zu speichernde Krankenhaus
	 */
	public void exportPatient(String dateiname, Krankenhaus kh) {
		File datei = new File(dateiname);
		if (datei.exists()) {
			System.out.println("Die Datei existiert bereits und wird versucht zu ueberschreiben");
		}
		try {
			FileWriter writer = new FileWriter(dateiname);
			writer.write("Patientennummr;Name;AnzahlKV;HauptKV\n");
			ArrayList<Patient> pat = kh.getPatList();
			Collections.sort(pat, new PatientComparator()); // sort name

			for (Patient patient : pat) {
				writer.write(patient.getPatientenNummer() + ";" + patient.getAnrede() + ";" + patient.getVorname() + " "
						+ patient.getNachname() + ";" + patient.getVersHash().size() + ";");
				writer.write(patient.getVersList().isEmpty() ? "Keine" : patient.getVersList().get(0).getName());
				writer.write("\n");
				writer.flush();
			}
			System.out.println(pat.size() + " Datensaetze in der Datei " + dateiname + " erfolgreich erstellt.");
			writer.close();
		} catch (IOException e) {
			System.out.println("Es ist ein Fehler beim Speichern der Daten aufgetreten." + e.getMessage());
			e.getStackTrace();

		}
	}

	/**
	 * Import Patientenliste CSV.
	 *
	 * @param dateiname
	 *            Pfad/Dateiname von zu importierenden Patientenliste
	 * @return Patientenliste
	 */
	public ArrayList<Patient> importPatientTest(String dateiname) {

		ArrayList<Patient> datalist = new ArrayList<Patient>();
		try {
			FileReader fr = new FileReader(dateiname);
			BufferedReader br = new BufferedReader(fr);
			String stringRead = br.readLine();
			while (stringRead != null) {
				StringTokenizer st = new StringTokenizer(stringRead, ";");
				String patientenNummer = st.nextToken();
				String anrede = st.nextToken();
				String vorname = st.nextToken();
				String nachname = st.nextToken();
				String geburtsdatum = st.nextToken();
				Anrede anr;
				if (anrede == "Herr") {
					anr = Anrede.Herr;
				} else {
					anr = Anrede.Frau;
				}
				String adresszeile1 = st.nextToken();
				String adresszeile2 = st.nextToken();
				String plz = st.nextToken();
				String ort = st.nextToken();
				Adresse adresse = new Adresse(adresszeile1, adresszeile2, plz, ort);
				String telefonnummer = st.nextToken();
				String eMail = st.nextToken();
				if (!patientenNummer.equals("PatientenNummer")) {
					Integer i = Integer.valueOf(patientenNummer);
					Patient temp = new Patient(i, anr, vorname, nachname, geburtsdatum, adresse, telefonnummer, eMail);
					datalist.add(temp);
				}
				// read the next line
				stringRead = br.readLine();
			}
			br.close();
		} catch (IOException ioe) {
			System.out.println("Es ist ein Fehler beim Lesen der Daten aufgetreten.");
			ioe.getStackTrace();
		}
		return datalist;
	}

	/**
	 * Patientendaten werden als csv exportiert. Nach Namen sortiert. Exta fuer
	 * Aufgabe 8 erstellt, um Import von vollstaendigen Patientendaten testen zu
	 * koennen
	 * 
	 * @param dateiname
	 *            Dateiname inklusive Path
	 * @param kh
	 *            Das zu speichernde Krankenhaus
	 */
	public void exportPatientTest(String dateiname, Krankenhaus kh) {
		File datei = new File(dateiname);
		if (datei.exists()) {
			System.out.println("Die Datei existiert bereits und wird versucht zu ueberschreiben");
		}
		try {
			FileWriter writer = new FileWriter(dateiname);
			writer.write(
					"PatientenNummer;Anrede;Vorname;Nachname;Geburtsdatum;Adresszeile1;Adresszeile2;PLZ;Ort;TelNummer;Mail\n");
			ArrayList<Patient> pat = kh.getPatList();
			Collections.sort(pat, new PatientComparator()); // sort name

			for (Patient patient : pat) {
				writer.write(patient.getPatientenNummer() + ";" + patient.getAnrede() + ";" + patient.getVorname() + ";"
						+ patient.getNachname() + ";" + patient.getGeburtsdatum() + ";"
						+ patient.getAdresse().getAdresszeile1() + ";" + patient.getAdresse().getAdresszeile2() + ";"
						+ patient.getAdresse().getOrt() + ";" + patient.getAdresse().getPlz() + ";"
						+ patient.getTelefonnummer() + ";" + patient.geteMail());
				writer.write("\n");
				writer.flush();
			}
			System.out.println(pat.size() + " Datensaetze in der Datei " + dateiname + " erfolgreich erstellt.");
			writer.close();
		} catch (IOException e) {
			System.out.println("Es ist ein Fehler beim Speichern der Daten aufgetreten." + e.getMessage());
			e.getStackTrace();

		}
	}

}
