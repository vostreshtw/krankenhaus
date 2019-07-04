package de.htw.krankenhaus.modell;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

/**
 * Klasse fuer Abrechnungsstelle
 * 
 * @author Yevheniia Vostres (566769)
 * @since 16.04.2019
 *
 */
public class Abrechnungsstelle implements Observer, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<Aufenthalt> aufenthalt = new LinkedList<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (arg instanceof Patient) {
			Patient patient = (Patient) arg;
			System.out.println("Abrechnungsstelle hat die Information erhalten, dass ein " + patient.getDauer()
					+ "- Tage Aufenthalt für den Patient " + patient.getVorname() + " " + patient.getNachname()
					+ " mit den Patientennumer " + patient.getPatientenNummer() + " stattgefunden hat");
		}

	}

	/**
	 * @return the aufenthalt
	 */
	public LinkedList<Aufenthalt> getAufenthalt() {
		return aufenthalt;
	}

	/**
	 * @param aufenthalt
	 *            the aufenthalt to set
	 */
	public void setAufenthalt(LinkedList<Aufenthalt> aufenthalt) {
		this.aufenthalt = aufenthalt;
	}

}
