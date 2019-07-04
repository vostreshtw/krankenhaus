package de.htw.krankenhaus.funktionen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

import de.htw.krankenhaus.modell.Anrede;

// TODO: Auto-generated Javadoc
/**
 * Klasse zum Ablesen der Benutzereingaben.
 *
 * @author Yevheniia Vostres (566769)
 * @version 3.0
 * @since 16.04.2019
 */
/**
 * 
 * @author Yevheniia Vostres (566769)
 * @since 16.04.2019
 *
 */
public class Eingabe {

	/** The scan. */
	Scanner scan = new Scanner(System.in);

	/**
	 * Menueauswahl ablesen.
	 *
	 * @return antwort - Benutzereingabe von Menueauswahl (Antwort)
	 */
	public String auswahlAnsicht() {
		scan = new Scanner(System.in);
		String antwort;

		System.out.println("Modus w‰hlen\n" + "(01) CLI\n" + "(02) GUI\n" + "(0) Beenden\n");

		antwort = scan.nextLine();
		return antwort;
	}

	public String auswahlMenue() {
		scan = new Scanner(System.in);
		String antwort;

		System.out.println("Aufgabe 7\n" + "(00) Alle Daten anzeigen lassen\n" + "(01) Patient anlegen\n"
				+ "(02) Gesetzliche Versicherung anlegen und Patientennummer zuordnen\n"
				+ "(03) Privatversicherung anlegen und Patientennummer zuordnen\n"
				+ "(04) Patient mit Krankenversicherungen anzeigen (Auswahl durch Patientennummer)\n"
				+ "(05) Patient mit Krankenversicherungen anzeigen (Auswahl durch Name)\n"
				+ "(06) Krankenversicherungen anzeigen (Auswahl durch KVN)\n"
				+ "(07) Alle Patienten sortiert nach aufsteigender Patientennummer anzeigen\n"
				+ "(08) Alle Patienten sortiert nach aufsteigendem Nachnamen\n"
				+ "(09) Alle Krankenversicherungen unsortiert anzeigen\n" + "(10) Daten Export\n"
				+ "(11) Daten Import\n" + "(12) Patienten nach Namen sortiert als CSV-Datei exportieren\n"
				+ "(13) Patient aufnehmen\n" + "(14) Patient entlassen\n" + "(15) Protokoll-Strategie w‰hlen\n"
				+ "(16) Monitoring aktivieren\n" + "(17) Monitoring deaktivieren\n" + "(18) Beenden\n");

		antwort = scan.nextLine();

		return antwort;

	}

	/**
	 * Versicherungsnummer ablesen.
	 *
	 * @return versNum - Benutzereingabe von Versicherungsnummer
	 */
	public String askVersicherungsNr() {
		System.out.println("Versicherungsnummer:");
		String versNum = scan.nextLine();
		return versNum;
	}

	/**
	 * Versicherungsname ablesen.
	 *
	 * @return versName - Benutzereingabe von Versicherungsname
	 */
	public String askVersicherungsname() {
		System.out.println("Versicherungsname:");
		String versName = scan.nextLine();
		return versName;
	}

	/**
	 * Patientennummer ablesen.
	 *
	 * @return patNummer - Benutzereingabe von Patientennummer
	 */
	public int askPatientennummer() {
		System.out.println("Geben Sie Patientennummer ein:");
		int patNummer = scan.nextInt();
		return patNummer;
	}

	/**
	 * Deckungslimit ablesen.
	 *
	 * @return deckung - Benutzereingabe von Deckungslimit
	 */
	public int askDeckungslimit() {
		System.out.println("Deckungslimit:");
		int deckung = Integer.parseInt(scan.nextLine());
		return deckung;
	}

	/**
	 * ablesen, ob eine Versicherung eine Familienversicherung ist.
	 *
	 * @return versFuerFamilie - Benutzereingabe von Familienversicherung
	 */
	public boolean askObFamilienvers() {
		System.out.println("Familienversicherung (j/n):");
		String familienvers = scan.nextLine();
		boolean versFuerFamilie;
		if (familienvers.equals("j")) {
			versFuerFamilie = true;
		} else {
			versFuerFamilie = false;
		}

		return versFuerFamilie;
	}

	/**
	 * Patientenname ablesen.
	 *
	 * @return patName - Benutzereingabe von Patientenname
	 */
	public String askPatientenname() {
		String patName;
		boolean check;
		do {
			System.out.println("Patientenname:");
			patName = scan.nextLine();
			if (patName.isEmpty()) {
				System.out.println("Nachname muss eingegeben werden.");
				check = false;
			} else if (patName.matches(".*[A-Z|a-z].*")) {
				check = true;
			} else {
				System.out.println("Ihr Eingabe ist ungueltig. Bitte erneut eingeben.");
				check = false;
			}
		} while (check == false);
		return patName;
	}

	/**
	 * Vorname ablesen.
	 *
	 * @return vorname - Benutzereingabe von Vorname
	 */
	public String askVorname() {
		String vorname;
		boolean check;
		do {
			System.out.println("Vorname:");
			vorname = scan.nextLine();
			if (vorname.isEmpty()) {
				System.out.println("Vorname muss eingegeben werden.");
				check = false;
			} else if (vorname.matches(".*[A-Z|a-z].*")) {
				check = true;
			} else {
				System.out.println("Ihr Eingabe ist ungueltig. Bitte erneut eingeben.");
				check = false;
			}
		} while (check == false);
		return vorname;
	}

	/**
	 * Nachname ablesen.
	 *
	 * @return nachname - Benutzereingabe von Nachname
	 */
	public String askNachname() {
		String nachname;
		boolean check;
		do {
			System.out.println("Nachname:");
			nachname = scan.nextLine();
			if (nachname.isEmpty()) {
				System.out.println("Nachname muss eingegeben werden.");
				check = false;
			} else if (nachname.matches(".*[A-Z|a-z].*")) {
				check = true;
			} else {
				System.out.println("Ihr Eingabe ist ungueltig. Bitte erneut eingeben.");
				check = false;
			}
		} while (check == false);
		return nachname;
	}

	/**
	 * Anrede ablesen.
	 *
	 * @return anrede - Benutzereingabe von Anrede
	 */
	public Anrede askAnrede() {
		System.out.println("Anrede(m/f):");
		String input;
		Anrede anrede = Anrede.Frau;
		boolean eingabeOk;

		do {
			System.out.println("Anrede(HERR oder FRAU):");
			input = scan.nextLine();
			if (input.matches("^(?i:Herr|Frau)$")) {
				eingabeOk = true;
			} else {
				System.out.println("Ihr Eingabe ist ungueltig. Bitte erneut eingeben.");
				eingabeOk = false;
			}
		} while (eingabeOk == false);

		if (input.toUpperCase().equals("HERR")) {
			anrede = Anrede.Herr;
		} else if (input.toUpperCase().equals("FRAU")) {
			anrede = Anrede.Frau;
		}
		return anrede;
	}

	/**
	 * Geburtsdatum ablesen.
	 *
	 * @return geburtsdatum - Benutzereingabe von Geburtsdatum
	 */
	public String askGeburtsdatum() {
		boolean datumok = true;
		String geburtsdatum;
		SimpleDateFormat sdfrmt = new SimpleDateFormat("dd.MM.yyyy");
		sdfrmt.setLenient(false);

		do {
			boolean check = true;
			datumok = true;
			System.out.println("Geburtsdatum(tt.MM.jjjj):");
			geburtsdatum = scan.nextLine();
			try {
				sdfrmt.parse(geburtsdatum);
			}

			catch (ParseException e) {
				System.out.println(geburtsdatum + " ist ungueltiges Datenformat. Bitte erneut eingeben(tt.MM.jjjj).");
				check = false;
			}
			if (check == false) {
				datumok = false;
			}
			if (geburtsdatum.isEmpty()) {
				System.out.println("Geburtsdatum muss eingegeben werden.");
				datumok = false;
			}
		} while (datumok == false);

		return geburtsdatum;
	}

	/**
	 * Email ablesen.
	 *
	 * @return email - Benutzereingabe von Email
	 */
	public String askEmail() {
		String emailFormat = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailFormat);
		boolean check;
		String email;
		do {
			System.out.println("Email:");
			email = scan.nextLine();
			if (email.isEmpty()) {
				System.out.println("Eine Email muss eingegeben werden.");
				check = false;
			} else if (!pat.matcher(email).matches()) {
				System.out.println("Ung√ºltiges Emailformat. Bitte erneut eingeben.");
				check = false;
			} else {
				check = true;
			}
		} while (check == false);
		return email;
	}

	/**
	 * Telefonnummer ablesen.
	 *
	 * @return telefonnr - Benutzereingabe von Telefonnummer
	 */
	public String askTelNummer() {
		String telefonnr;
		boolean check;
		do {
			System.out.println("Telefonnummmer:");
			telefonnr = scan.nextLine();
			if (telefonnr.isEmpty()) {
				System.out.println("Telefonnummer muss eingegeben werden.");
				check = false;
			} else if (!telefonnr.matches("[0-9]+")) {
				System.out.println(
						"Telefonnummer soll keine Buchstabe oder Sonderzeichen erhalten. Bitte erneut eingeben.");
				check = false;
			} else {
				check = true;
			}
		} while (check == false);
		return telefonnr;
	}

	/**
	 * Adresszeile 1 ablesen.
	 *
	 * @return adr1 - Benutzereingabe von Adresszeile 1
	 */
	public String askAdrZeile1() {
		String adr1;
		boolean check;
		do {
			System.out.println("Adressezeile 1:");
			adr1 = scan.nextLine().toUpperCase();
			if (adr1.isEmpty()) {
				System.out.println("Die erste Adressezeile muss eingegeben werden.");
				check = false;
			} else {
				check = true;
			}
		} while (check == false);

		return adr1;
	}

	/**
	 * Adresszeile 2 ablesen.
	 *
	 * @return adr2 - Benutzereingabe von Adresszeile 2
	 */
	public String askAdrZeile2() {
		String adr2;
		boolean check;
		do {
			System.out.println("Adressezeile 2:");
			adr2 = scan.nextLine().toUpperCase();
			if (adr2.isEmpty()) {
				System.out.println("Die erste Adressezeile muss eingegeben werden.");
				check = false;
			} else {
				check = true;
			}
		} while (check == false);

		return adr2;
	}

	/**
	 * PLZ ablesen.
	 *
	 * @return plz - Benutzereingabe von PLZ
	 */
	public String askPLZ() {
		String plz;
		boolean check;
		do {
			System.out.println("PLZ:");
			plz = scan.nextLine();
			if (plz.isEmpty()) {
				System.out.println("PLZ muss eingegeben werden.");
				check = false;
			} else if (!plz.matches("\\d{5}")) {
				System.out.println("Ungueltiges Format fuer Postleizahl. Postleitzahl ist 5-stellige Nummer.");
				check = false;
			} else {
				check = true;
			}
		} while (check == false);
		return plz;
	}

	/**
	 * Ort ablesen.
	 *
	 * @return ort - Benutzereingabe von Ort
	 */
	public String askOrt() {
		String ort;
		boolean check;
		do {
			System.out.println("Ort:");
			ort = scan.nextLine().toUpperCase();
			if (ort.isEmpty()) {
				System.out.println("Ort muss eingegeben werden.");
				check = false;
			} else if (ort.matches(".*[0-9].*")) {
				System.out.println("Ihre Eingabe enth√§lt eine oder mehrere Nummer(n). Bitte korrigieren.");
				check = false;
			} else {
				check = true;
			}
		} while (check == false);
		return ort;
	}

	/**
	 * Dateiname inklusive Pfad ablesen.
	 *
	 * @return dateiname - Dateiname inklusive Pfad
	 */
	public String askDateiname() {
		String dateiname = scan.nextLine();
		return dateiname;
	}

	/**
	 * Auswahl von Logger-Strategie.
	 *
	 * @return the int - Logger Auswahl
	 */
	public int askLogger() {
		int log;
		boolean check;
		do {

			log = scan.nextInt();
			if ((log == 2) || (log == 1)) {
				check = true;
			} else {
				System.out.println("Bitte erneut Auswahl von Logger-Strategie eingeben (Ziffer 1 oder 2).");
				check = false;
			}
		} while (check == false);
		return log;
	}

}
