package de.htw.krankenhaus.modell;

import java.io.Serializable;

/**
 * The Class Adresse.
 *
 * @author Yevheniia Vostres (566769)
 * @since 16.04.2019
 */

public class Adresse implements Serializable {

	private static final long serialVersionUID = 3026122328118332077L;

	private String adresszeile1;

	private String adresszeile2;

	private String plz;

	private String ort;

	/**
	 * Konstruktor fuer die Klasse Adresse.
	 *
	 * @param adresszeile1
	 *            - Adresszeile 1
	 * @param adresszeile2
	 *            - Adresszeile 2
	 * @param plz
	 *            - PLZ
	 * @param ort
	 *            - Ort
	 */
	public Adresse(String adresszeile1, String adresszeile2, String plz, String ort) {
		super();
		this.adresszeile1 = adresszeile1;
		this.adresszeile2 = adresszeile2;
		this.plz = plz;
		this.ort = ort;
	}

	/**
	 * Getter fuer Adresszeile1.
	 *
	 * @return adresszeile1 - Adresszeile 1
	 */
	public String getAdresszeile1() {
		return adresszeile1;
	}

	/**
	 * Setter fuer Adresszeile 1.
	 *
	 * @param adresszeile1
	 *            - Adresszeile 1
	 */
	public void setAdresszeile1(String adresszeile1) {
		this.adresszeile1 = adresszeile1;
	}

	/**
	 * Getter fuer Adresszeile 2.
	 *
	 * @return adresszeile 2 - Adresszeile2
	 */
	public String getAdresszeile2() {
		return adresszeile2;
	}

	/**
	 * Setter fuer Adresszeile 2.
	 *
	 * @param adresszeile2
	 *            - Adresszeile 2
	 */
	public void setAdresszeile2(String adresszeile2) {
		this.adresszeile2 = adresszeile2;
	}

	/**
	 * Getter fuer PLZ.
	 *
	 * @return plz - PLZ
	 */
	public String getPlz() {
		return plz;
	}

	/**
	 * Setter fuer PLZ.
	 *
	 * @param plz
	 *            PLZ
	 */
	public void setPlz(String plz) {
		this.plz = plz;
	}

	/**
	 * Getter fuer Ort.
	 *
	 * @return ort - Ort
	 */
	public String getOrt() {
		return ort;
	}

	/**
	 * Setter fuer Ort.
	 *
	 * @param ort
	 *            the ort to set
	 */
	public void setOrt(String ort) {
		this.ort = ort;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	/*
	 * toString Methode fuer die Ausgabe der Adresse
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Adresse: " + adresszeile1 + " " + adresszeile2 + " " + plz + " " + ort;
	}

}
