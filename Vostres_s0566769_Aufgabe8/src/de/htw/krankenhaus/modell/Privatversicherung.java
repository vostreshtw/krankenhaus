package de.htw.krankenhaus.modell;

/**
 * Die Klasse Privatversicherung.
 *
 * @author Yevheniia Vostres (566769)
 * @since 16.04.2019
 */

public class Privatversicherung extends Krankenversicherung {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6654492461033340764L;

	private int deckungslimit;

	/**
	 * Instantiates a new privatversicherung.
	 *
	 * @param versicherungsnummer
	 *            the versicherungsnummer
	 * @param name
	 *            the name
	 * @param deckungslimit
	 *            the deckungslimit
	 */
	public Privatversicherung(String versicherungsnummer, String name, int deckungslimit) {
		super(versicherungsnummer, name);
		this.deckungslimit = deckungslimit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Privatversicherung: " + super.getVersicherungsnummer() + ", " + super.getName() + ", Deckungslimit: "
				+ deckungslimit + " Euro\n";
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
	 * @return deckungslimit
	 */
	public int calculateCoverage(int cost, int quarter, int previousQuarter) {

		if (cost < deckungslimit) {
			return cost;
		} else {

			return deckungslimit;

		}
	}

	/**
	 * Gets the deckungslimit.
	 *
	 * @return the deckungslimit
	 */
	public int getDeckungslimit() {
		return deckungslimit;
	}

	/**
	 * Sets the deckungslimit.
	 *
	 * @param deckungslimit
	 *            the deckungslimit to set
	 */
	public void setDeckungslimit(int deckungslimit) {
		this.deckungslimit = deckungslimit;
	}

}
