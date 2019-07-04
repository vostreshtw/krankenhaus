package de.htw.krankenhaus.modell;

/**
 * Klasse fuer Aufenthalte
 * 
 * @author Yevheniia Vostres (566769)
 * @since 16.04.2019
 *
 */

import java.util.Date;
import java.util.LinkedList;

public class Aufenthalt {

	private String patientenName;
	private int patientenNummer;
	private long dauer;
	private Date aufnahmeDatum;
	private Date entlassungsDatum;
	/**
	 * @return the aufnahmeDatum
	 */
	public Date getAufnahmeDatum() {
		return aufnahmeDatum;
	}

	/**
	 * @param aufnahmeDatum
	 *            the aufnahmeDatum to set
	 */
	public void setAufnahmeDatum(Date aufnahmeDatum) {
		this.aufnahmeDatum = aufnahmeDatum;
	}

	/**
	 * @return the entlassungsDatum
	 */
	public Date getEntlassungsDatum() {
		return entlassungsDatum;
	}

	/**
	 * @param entlassungsDatum
	 *            the entlassungsDatum to set
	 */
	public void setEntlassungsDatum(Date entlassungsDatum) {
		this.entlassungsDatum = entlassungsDatum;
	}

	/**
	 * @return the patientenName
	 */
	public String getPatientenName() {
		return patientenName;
	}

	/**
	 * @param patientenName
	 *            the patientenName to set
	 */
	public void setPatientenName(String patientenName) {
		this.patientenName = patientenName;
	}

	/**
	 * @return the patientenNummer
	 */
	public int getPatientenNummer() {
		return patientenNummer;
	}

	/**
	 * @param patientenNummer
	 *            the patientenNummer to set
	 */
	public void setPatientenNummer(int patientenNummer) {
		this.patientenNummer = patientenNummer;
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
	}

	/**
	 * @param patientenName
	 * @param patientenNummer
	 * @param dauer
	 * @param aufnahmeDatum
	 * @param entlassungsDatum
	 */
	public Aufenthalt(String patientenName, int patientenNummer, long dauer, Date aufnahmeDatum,
			Date entlassungsDatum) {
		super();
		this.patientenName = patientenName;
		this.patientenNummer = patientenNummer;
		this.dauer = dauer;
		this.aufnahmeDatum = aufnahmeDatum;
		this.entlassungsDatum = entlassungsDatum;
	}
	
	
	// 2. Konstruktor fuer aktuelle Aufenthalte
	/**
	 * @param patientenName
	 * @param patientenNummer
	 * @param dauer
	 * @param aufnahmeDatum
	 */
	public Aufenthalt(String patientenName, int patientenNummer, Date aufnahmeDatum) {
		super();
		this.patientenName = patientenName;
		this.patientenNummer = patientenNummer;
		this.aufnahmeDatum = aufnahmeDatum;
		this.entlassungsDatum = entlassungsDatum;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Aufenthalt [patientenName=" + patientenName + ", patientenNummer=" + patientenNummer + ", dauer="
				+ dauer + ", aufnahmeDatum=" + aufnahmeDatum + ", entlassungsDatum=" + entlassungsDatum + "]";
	}

}
