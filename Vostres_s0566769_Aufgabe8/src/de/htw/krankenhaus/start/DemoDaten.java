package de.htw.krankenhaus.start;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import de.htw.krankenhaus.modell.Adresse;
import de.htw.krankenhaus.modell.Anrede;
import de.htw.krankenhaus.modell.Aufenthalt;
import de.htw.krankenhaus.modell.GesetzlicheVersicherung;
import de.htw.krankenhaus.modell.Krankenhaus;
import de.htw.krankenhaus.modell.Patient;
import de.htw.krankenhaus.modell.Privatversicherung;

/**
 * Die Klasse zum Speichern von Testdaten.
 *
 * @author Yevheniia Vostres (566769)
 * @since 16.04.2019
 */

public class DemoDaten {
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static int counterP = 1;

	/**
	 * Die Methode zum Speichern von Demodaten.
	 *
	 * @param helios
	 *            - Krankenhaus
	 */
	public void demoDaten(Krankenhaus helios) {

		// Testdaten Adresse
		Adresse adresse1 = new Adresse("Krumme Str", "56", "13567", "Berlin");
		Adresse adresse2 = new Adresse("Knaackst", "89", "15675", "Berlin");
		Adresse adresse3 = new Adresse("Breite Allee", "1a", "14567", "Berlin");
		Adresse adresse4 = new Adresse("Inselstr", "237", "13167", "Berlin");
		Adresse adresse5 = new Adresse("Beuselstr", "1", "13359", "Berlin");
		Adresse adresse6 = new Adresse("Schoene Str", "156", "13694", "Berlin");
		Adresse adresse7 = new Adresse("Weberstr", "12", "16959", "Berlin");
		Adresse adresse8 = new Adresse("Kastanienalee", "67", "13050", "Berlin");
		Adresse adresse9 = new Adresse("Brueckenstr", "98", "10796", "Berlin");
		Adresse adresse10 = new Adresse("Alte Allee", "4", "15050", "Berlin");

		// Testdaten Krankenhaus
		// Krankenhaus helios = new Krankenhaus("Helios", "DE812524991", adresseHelios);
		Date date1 = new Date();
		Date date2 = new Date();
		Date date3 = new Date();
		Date date4 = new Date();
		Date date5 = new Date();
		Date date6 = new Date();
		Date date7 = new Date();

		try {
			date1 = sdf.parse("25/05/2019");
			date2 = sdf.parse("28/05/2019");
			date3 = sdf.parse("29/05/2019");
			date4 = sdf.parse("02/06/2019");
			date5 = sdf.parse("10/06/2019");
			date6 = sdf.parse("15/06/2019");
			date7 = sdf.parse("25/06/2019");

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Testdaten Patient
		Patient patient1 = new Patient(counterP, Anrede.Herr, "Erik", "Koch", "10.04.1980", adresse1, "+491525678985",
				"ek@web.de");
		patient1.getIndates().add(date1);
		patient1.getIndates().add(date3);
		patient1.getOutdates().add(date4);

		counterP++;
		Patient patient2 = new Patient(counterP, Anrede.Frau, "Monica", "Fly", "23.11.1976", adresse2, "+491545678954",
				"mf@web.de");
		patient2.getIndates().add(date2);
		patient2.getIndates().add(date4);
		patient2.getOutdates().add(date3);
		patient2.getOutdates().add(date5);
		counterP++;
		Patient patient3 = new Patient(counterP, Anrede.Herr, "Max", "Mustermann", "01.01.2000", adresse3,
				"+4917593969302", "mm@web.de");
		patient3.getIndates().add(date2);
		patient3.getIndates().add(date4);
		patient3.getOutdates().add(date3);
		patient3.getOutdates().add(date5);
		counterP++;
		Patient patient4 = new Patient(counterP, Anrede.Frau, "Lilly", "Muster", "31.03.1995", adresse4,
				"+4916593859936", "lm@web.de");
		patient4.getIndates().add(date2);
		patient4.getIndates().add(date4);
		patient4.getOutdates().add(date3);
		patient4.getOutdates().add(date5);
		counterP++;
		Patient patient5 = new Patient(counterP, Anrede.Herr, "Lucas", "As", "4.09.1971", adresse5, "+4916094030500",
				"lh@web.de");
		patient5.getIndates().add(date2);
		patient5.getIndates().add(date4);
		patient5.getOutdates().add(date3);
		patient5.getOutdates().add(date5);
		counterP++;
		Patient patient6 = new Patient(counterP, Anrede.Frau, "Ana", "Horn", "03.08.1960", adresse6, "+4916094030500",
				"lh@web.de");
		patient6.getIndates().add(date2);
		patient6.getIndates().add(date4);
		patient6.getOutdates().add(date3);
		patient6.getOutdates().add(date5);
		counterP++;
		Patient patient7 = new Patient(counterP, Anrede.Herr, "Robert", "Maik", "7.09.1956", adresse7, "+4916094030500",
				"lh@web.de");
		patient7.getIndates().add(date2);
		patient7.getIndates().add(date4);
		patient7.getOutdates().add(date3);
		patient7.getOutdates().add(date5);
		counterP++;
		Patient patient8 = new Patient(counterP, Anrede.Herr, "Vincent", "Lu", "20.07.1990", adresse8, "+4916094030500",
				"lh@web.de");
		patient8.getIndates().add(date2);
		patient8.getIndates().add(date4);
		patient8.getOutdates().add(date3);
		patient8.getOutdates().add(date5);
		counterP++;
		Patient patient9 = new Patient(counterP, Anrede.Frau, "Lisa", "Stark", "01.06.1945", adresse9, "+4916094030500",
				"lh@web.de");
		counterP++;
		patient9.getIndates().add(date2);
		patient9.getIndates().add(date4);
		patient9.getOutdates().add(date3);
		patient9.getOutdates().add(date5);
		Patient patient10 = new Patient(counterP, Anrede.Herr, "Bernhard", "Hirsch", "17.10.1998", adresse10,
				"+4916094030500", "lh@web.de");
		patient10.getIndates().add(date2);
		patient10.getIndates().add(date4);
		patient10.getOutdates().add(date3);
		patient10.getOutdates().add(date5);
		counterP++;

		// Testdaten Krankenversicherung

		GesetzlicheVersicherung gesVer1 = new GesetzlicheVersicherung("U23456", "AOK", true);
		GesetzlicheVersicherung gesVer2 = new GesetzlicheVersicherung("U67896", "TK", false);
		GesetzlicheVersicherung gesVer3 = new GesetzlicheVersicherung("K20006", "AOK", false);
		GesetzlicheVersicherung gesVer4 = new GesetzlicheVersicherung("L20045", "TK", false);

		Privatversicherung privatver1 = new Privatversicherung("U23676", "Deutsche Familienvericherung", 1000000);
		Privatversicherung privatver2 = new Privatversicherung("B205666", "Bayerische", 1100000);
		Privatversicherung privatver3 = new Privatversicherung("B494949", "Coburg", 200000);

		// Krankenversicherung krankVer3 = new Krankenversicherung("U23676", "Deutsche
		// Familienvericherung");
		// Krankenversicherung krankVer5 = new Krankenversicherung("B205666",
		// "Bayerische");

		// Hinzufuegen von Versicherungen
		patient1.addVersicherung(gesVer1);
		patient2.addVersicherung(gesVer2);
		patient3.addVersicherung(gesVer3);
		patient4.addVersicherung(gesVer4);

		patient1.addVersicherung(privatver1);
		patient1.addVersicherung(privatver2);
		patient2.addVersicherung(privatver3);

		// Hinzufuegen von Patienten
		helios.addPatient(patient1);
		helios.addPatient(patient2);
		helios.addPatient(patient3);
		helios.addPatient(patient4);
		helios.addPatient(patient5);
		helios.addPatient(patient6);
		helios.addPatient(patient7);
		helios.addPatient(patient8);
		helios.addPatient(patient9);
		helios.addPatient(patient10);
		
		Aufenthalt auf1 = new Aufenthalt(patient1.getName(), patient1.getPatientenNummer(), date1);
		helios.addAufenthalt(auf1);

	}
}
