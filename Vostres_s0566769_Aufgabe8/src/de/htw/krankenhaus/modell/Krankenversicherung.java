package de.htw.krankenhaus.modell;

import java.io.Serializable;

/**
 * Die Klasse Krankenversicherung.
 *
 * @author Yevheniia Vostres (566769)
 * @since 16.04.2019
 */

public abstract class Krankenversicherung implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 381248079914828151L;

	private String versicherungsnummer;

	private String name;

	private int[] quarter = { 1, 2, 3, 4 };

	private int[] previousQuarter = { 1, 2, 3, 4 };

	/**
	 * Konstruktor fuer die Klasse Krankenversicherung.
	 *
	 * @param versicherungsnummer
	 *            - Nummer der Versicherung
	 * @param name
	 *            - Name der Versicherung
	 */
	public Krankenversicherung(String versicherungsnummer, String name) {
		super();
		this.versicherungsnummer = versicherungsnummer;
		this.name = name;
	}

	/**
	 * Getter fuer Versicherungsnummer.
	 *
	 * @return versicherungsnummer - die Versicherungsnummer
	 */
	public String getVersicherungsnummer() {
		return versicherungsnummer;
	}

	/**
	 * Setter fuer Versicherungsnummer.
	 *
	 * @param versicherungsnummer
	 *            - die Versicherungsnummer
	 */
	public void setVersicherungsnummer(String versicherungsnummer) {
		this.versicherungsnummer = versicherungsnummer;
	}

	/**
	 * Getter fuer Name der Versicherung.
	 *
	 * @return name - Name der Versicherung
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter fuer die Name der Versicherung.
	 *
	 * @param name
	 *            - Name der Versicherung
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * toString Methode fuer die Ausgabe der Krankenversicherung
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * 
	 */
	@Override
	public String toString() {
		return "Krankenversicherung: " + versicherungsnummer + ", " + name + "\n";
	}

	/**
	 * Calculate coverage.
	 *
	 * @param cost
	 *            the cost
	 * @param quarter
	 *            the quarter
	 * @param previousQuarter
	 *            the previous quarter
	 * @return deckung - berechnete Deckung
	 */
	public abstract int calculateCoverage(int cost, int quarter, int previousQuarter);

}
