package de.htw.krankenhaus.modell;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

import de.htw.krankenhaus.funktionen.Logger;

/**
 * 
 * @author Yevheniia Vostres (566769)
 * @since 16.04.2019
 *
 */

public class Patient extends Observable implements Comparable<Object>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3897269270406873629L;
	private int patientenNummer;
	private Anrede anrede;
	private String vorname;
	private String nachname;
	private HashMap<String, Krankenversicherung> versHash = new HashMap<>();
	private LinkedList<Krankenversicherung> versList = new LinkedList<>();
	private String geburtsdatum;
	private Adresse adresse;
	private String telefonnummer;
	private String eMail;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date indate = new Date();
	private Date outdate = new Date();
	private long dauer = 0;
	private Qualitaetsmanagementstelle qms = new Qualitaetsmanagementstelle();
	private Abrechnungsstelle as = new Abrechnungsstelle();
	private LinkedList<Date> indates = new LinkedList();
	private LinkedList<Date> outdates = new LinkedList();

	/**
	 * 
	 * Konstruktor fuer die Klasse Patient
	 * 
	 * @param patientenNummer
	 *            - Nummer eines Patienten
	 * @param anrede
	 *            - Anrede eines Patienten
	 * @param vorname
	 *            - Vorname eines Patienten
	 * @param nachname
	 *            - Nachname eines Patienten
	 * @param geburtsdatum
	 *            - Geburtsdatum eines Patienten
	 * @param adresse
	 *            - Adresse eines Patienten
	 * @param telefonnummer
	 *            - Telefonnummer eines Patienten
	 * @param eMail
	 *            - E-Mail eines Patienten
	 */
	public Patient(int patientenNummer, Anrede anrede, String vorname, String nachname, String geburtsdatum,
			Adresse adresse, String telefonnummer, String eMail) {
		this.patientenNummer = patientenNummer;
		this.anrede = anrede;
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsdatum = geburtsdatum;
		this.adresse = adresse;
		this.telefonnummer = telefonnummer;
		this.eMail = eMail;
	}

	/**
	 * Diese Methode ermoeglicht das Hinzufuegen von der Versicherung
	 * 
	 * @param krankVers
	 *            - krankVersicherung: die neue Versicherung
	 */
	public void addVersicherung(Krankenversicherung krankVers) {
		versHash.put(krankVers.getVersicherungsnummer(), krankVers);
		versList.add(krankVers);
	}

	/**
	 * 
	 * Getter fuer Patientennummer
	 * 
	 * @return the patientenNummer
	 */
	public Integer getPatientenNummer() {
		return patientenNummer;
	}

	/**
	 * 
	 * Setter fuer Patientennummer
	 * 
	 * @param patientenNummer
	 *            - Patientennummer
	 */
	public void setPatientenNummer(int patientenNummer) {
		this.patientenNummer = patientenNummer;
	}

	/**
	 * 
	 * Getter fuer die Anrede
	 * 
	 * @return anrede - die Anrede
	 */
	public Anrede getAnrede() {
		return anrede;
	}

	/**
	 * 
	 * Setter fuer die Anrede
	 * 
	 * @param anrede
	 *            - die Anrede der Patienten
	 */
	public void setAnrede(Anrede anrede) {
		this.anrede = anrede;
	}

	/**
	 * 
	 * Getter fuer die Vorname der Patienten
	 * 
	 * @return vorname - die Vorname der Patienten
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * 
	 * Setter fuer die Vorname der Patienten
	 * 
	 * @param vorname
	 *            - Vorname der Patienten
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * 
	 * Getter fuer die Nachname der Patienten
	 * 
	 * @return nachname - Nachname der Patienten
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * 
	 * Setter fuer die Nachname der Patienten
	 * 
	 * @param nachname
	 *            - Nachname der Patienten
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * 
	 * Getter fuer Geburtsdatum des Patienten
	 * 
	 * @return geburtsdatum - Geburtsdatum des Patienten
	 */
	public String getGeburtsdatum() {
		return geburtsdatum;
	}

	/**
	 * 
	 * Setter fuer Geburtsdatum des Patienten
	 * 
	 * @param geburtsdatum
	 *            - Geburtsdatum des Patienten
	 */
	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	/**
	 * 
	 * Getter fuer die Adresse des Patienten
	 * 
	 * @return die Adresse des Patienten
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * 
	 * Setter fuer die Adresse des Patienten
	 * 
	 * @param adresse
	 *            - die Adresse des Patienten
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * 
	 * Getter fuer die Telefonnummer des Patienten
	 * 
	 * @return telefonnummer - die Telefonnummer des Patienten
	 */
	public String getTelefonnummer() {
		return telefonnummer;
	}

	/**
	 * 
	 * Setter fuer die Telefonnummer des Patienten
	 * 
	 * @param telefonnummer
	 *            - die Telefonnummer des Patienten
	 */
	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	/**
	 * @return the indates
	 */
	public LinkedList<Date> getIndates() {
		return indates;
	}

	/**
	 * @param indates
	 *            the indates to set
	 */
	public void setIndates(LinkedList<Date> indates) {
		this.indates = indates;
	}

	/**
	 * @return the outdates
	 */
	public LinkedList<Date> getOutdates() {
		return outdates;
	}

	/**
	 * @param outdates
	 *            the outdates to set
	 */
	public void setOutdates(LinkedList<Date> outdates) {
		this.outdates = outdates;
	}

	/**
	 * 
	 * Getter fuer die E-Mail des Patienten
	 * 
	 * @return email - die E-Mail des Patienten
	 */
	public String geteMail() {
		return eMail;
	}

	/**
	 * 
	 * Setter fuer die E-Mail des Patienten
	 * 
	 * @param eMail
	 *            - E-Mail des Patienten
	 */
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	/**
	 * @return the indate
	 */
	public Date getIndate() {
		notifyObservers(indates);
		return indate;
	}

	/**
	 * @param indate
	 *            - the indate to set
	 */
	public void setIndate(String input, Krankenhaus kh) {
		String today = sdf.format(new Date());
		try {
			if (input.isEmpty())
				indate = sdf.parse(today);
			else
				indate = sdf.parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		kh.getIndates().add(indate);
		getIndates().add(indate);
		kh.getAufenthalte().add(new Aufenthalt(getName(), patientenNummer, indate));
		System.out.println(indate);
	}

	/**
	 * @return the outdate
	 */
	public Date getOutdate() {
		notifyObservers(outdates);
		return outdate;
	}

	/**
	 * @param outdate
	 *            - the outdate to set
	 */
	public void setOutdate(String input, Krankenhaus kh) {
		String today = sdf.format(new Date());
		try {
			if (input.isEmpty())
				outdate = sdf.parse(today);
			else
				outdate = sdf.parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println(outdate);
		String message = "Entlassung: " + getName() + " (Nr. " + patientenNummer + ") am " + outdate;
		long diff = Math.abs(indate.getTime() - outdate.getTime());
		long dauer = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		setDauer(dauer + 1);
		kh.getOutdates().add(outdate);
		getOutdates().add(outdate);
		if (dauer > 2) {
			setChanged();
			notifyObservers(this);
			qms.getAufenthalt().add(new Aufenthalt(getName(), patientenNummer, dauer, indate, outdate));
			as.getAufenthalt().add(new Aufenthalt(getName(), patientenNummer, dauer, indate, outdate));
			Logger.getInstance().log(message);
		}
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return vorname + " " + nachname;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observable#setChanged()
	 */
	public void setChanged() {

		super.setChanged();
	}

	/**
	 * @return the dauer
	 */
	public long getDauer() {
		return dauer;
	}

	/**
	 * @param dauer
	 *            the dauer to set
	 */
	public void setDauer(long dauer) {
		this.dauer = dauer;
		System.out.println(dauer);
	}

	/*
	 * toString Methode fuer die Ausgabe des Patienten
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nPatientennummer: " + patientenNummer + "\nName: " + anrede + " " + vorname + " " + nachname
				+ "\nGeburtsdatum: " + geburtsdatum + "\n" + adresse + "\nTelefonnummer: " + telefonnummer + "\nE-Mail:"
				+ eMail + "\n" + "Versicherung(en):\n" + versHash.values() + "\n";
	}

	/**
	 * @return the versHash
	 */
	public HashMap<String, Krankenversicherung> getVersHash() {
		return versHash;
	}

	/**
	 * @param versHash
	 *            the versHash to set
	 */
	public void setVersHash(HashMap<String, Krankenversicherung> versHash) {
		this.versHash = versHash;
	}

	/**
	 * @return the versList
	 */
	public LinkedList<Krankenversicherung> getVersList() {
		return versList;
	}

	/**
	 * @param versList
	 *            the versList to set
	 */
	public void setVersList(LinkedList<Krankenversicherung> versList) {
		this.versList = versList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object o) {
		Patient patient = (Patient) o;
		return getPatientenNummer().compareTo(patient.getPatientenNummer());
	}

	public void forceUpdate() {
		notifyObservers(indates);
		notifyObservers(outdates);
	}

}