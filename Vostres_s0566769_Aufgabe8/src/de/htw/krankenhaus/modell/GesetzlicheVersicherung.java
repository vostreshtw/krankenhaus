package de.htw.krankenhaus.modell;

/**
 * The Class GesetzlicheVersicherung.
 *
 * @author Yevheniia Vostres (566769)
 * @since 16.04.2019
 */

public class GesetzlicheVersicherung extends Krankenversicherung {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7619410519790443398L;
	private boolean familienversicherung;

	/**
	 *
	 * @param versicherungsnummer
	 *            - Versicherungsnummer
	 * @param name
	 *            - Versicherungsname
	 * @param familienversicherung
	 *            - Familienversicherung (true oder false)
	 */
	public GesetzlicheVersicherung(String versicherungsnummer, String name, boolean familienversicherung) {
		super(versicherungsnummer, name);
		this.familienversicherung = familienversicherung;
	}

	/**
	 * Ueberprueft ob eine Versicherung eine Familienversicherung ist.
	 *
	 * @return the familienversicherung
	 */
	public boolean isFamilienversicherung() {
		return familienversicherung;
	}

	/**
	 * Sets the familienversicherung.
	 *
	 * @param familienversicherung
	 *            the familienversicherung to set
	 */
	public void setFamilienversicherung(boolean familienversicherung) {
		this.familienversicherung = familienversicherung;
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
	 * @return deckung
	 */
	public int calculateCoverage(int cost, int quarter, int previousQuarter) {

		int deckung;
		if (quarter != previousQuarter) {
			deckung = cost;
		} else {
			deckung = 0;
		}
		return deckung;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Gesetzliche Versicherung: " + super.getVersicherungsnummer() + ", " + super.getName()
				+ ", Familienversicherung: " + familienversicherung + "\n";
	}

}
