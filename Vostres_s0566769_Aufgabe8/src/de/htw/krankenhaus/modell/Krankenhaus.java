package de.htw.krankenhaus.modell;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Die Klasse Krankenhaus.
 *
 * @author Yevheniia Vostres (566769)
 * @since 16.04.2019
 */

public class Krankenhaus implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1278816740381061240L;

	private String name;

	private String ustIdnr;

	private Adresse adresse;

	private ArrayList<Patient> patList = new ArrayList<Patient>();

	private HashMap<String, Krankenversicherung> versHash = new HashMap<>();

	private Qualitaetsmanagementstelle quali = new Qualitaetsmanagementstelle();
	private Abrechnungsstelle abrechnung = new Abrechnungsstelle();
	
	private LinkedList<Aufenthalt> aufenthalte = new LinkedList<>();
	private LinkedList<Date> indates = new LinkedList();
	private LinkedList<Date> outdates = new LinkedList();
	public LinkedList<Aufenthalt> getAufenthalte() {
		return aufenthalte;
	}

	public void setAufenthalte(LinkedList<Aufenthalt> aufenthalte) {
		this.aufenthalte = aufenthalte;
	}

	public LinkedList<Date> getIndates() {
		return indates;
	}

	public void setIndates(LinkedList<Date> indates) {
		this.indates = indates;
	}

	public LinkedList<Date> getOutdates() {
		return outdates;
	}

	public void setOutdates(LinkedList<Date> outdates) {
		this.outdates = outdates;
	}

	/**
	 * Konstruktor fuer die Klasse Krankenhaus.
	 *
	 * @param name
	 *            - Name des Krankenhauses
	 * @param ustIdnr
	 *            - UST-IDNR des Krankenhauses
	 * @param adresse
	 *            - die Adresse des Krankenhauses
	 */
	public Krankenhaus(String name, String ustIdnr, Adresse adresse) {
		super();
		this.name = name;
		this.ustIdnr = ustIdnr;
		this.adresse = adresse;

	}
	

	/**
	 * Diese Methode ermoeglicht das Hinzufuegen von den neuen Patienten.
	 *
	 * @param patientNeu
	 *            the patient neu
	 */
	public void addPatient(Patient patientNeu) {
		patList.add(patientNeu);
		patientNeu.addObserver(quali);
		patientNeu.addObserver(abrechnung);

	}
	
	public void addAufenthalt(Aufenthalt aufenthalt) {
		aufenthalte.add(aufenthalt);
	}

	/**
	 * Getter fuer Name des Krankenhauses.
	 *
	 * @return name - Name des Krankenhauses
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter fuer Name des Krankenhauses.
	 *
	 * @param name
	 *            - Name des Krankenhauses
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter fuer UST-IDNR.
	 *
	 * @return ustIdnr - UST-IDNR des Krankenhauses
	 */
	public String getUstIdnr() {
		return ustIdnr;
	}

	/**
	 * Setter fuer UST-IDNR.
	 *
	 * @param ustIdnr
	 *            UST-IDNR des Krankenhauses
	 */
	public void setUstIdnr(String ustIdnr) {
		this.ustIdnr = ustIdnr;
	}

	/**
	 * Getter fuer die Adresse des Krankenhauses.
	 *
	 * @return adresse - die Adresse des Krankenhauses
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * Setter fuer die Adresse des Krankenhauses.
	 *
	 * @param adresse
	 *            die Adresse des Krankenhauses
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/*
	 * String Methode fuer die Ausgabe des Krankenhauses
	 * 
	 * @see java.lang.Object#toString()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Krankenhaus: " + name + "\nUST-IDNR:" + ustIdnr + "\n" + adresse + "\nPatientenliste:\n" + patList
				+ "\n";
	}

	/**
	 * Gets the pat list.
	 *
	 * @return patList - Patientenliste
	 */
	public ArrayList<Patient> getPatList() {
		return patList;
	}

	/**
	 * Setter fuer Patientenliste.
	 *
	 * @param patList
	 *            - Patientenliste
	 */
	public void setPatList(ArrayList<Patient> patList) {
		this.patList = patList;
	}

	/**
	 * Getter fuer Krankenversicherungen HashMap.
	 *
	 * @return versHash - HashMap mit Krankenversicherungen
	 */
	public HashMap<String, Krankenversicherung> getVersHash() {
		for (Patient patient : patList) {
			versHash.putAll(patient.getVersHash());
		}
		return versHash;
	}

	/**
	 * Setter fuer Krankenversicherungen HashMap.
	 *
	 * @param versHash
	 *            - Krankenversicherungen HashMap
	 */
	public void setVersHash(HashMap<String, Krankenversicherung> versHash) {
		this.versHash = versHash;
	}

}
