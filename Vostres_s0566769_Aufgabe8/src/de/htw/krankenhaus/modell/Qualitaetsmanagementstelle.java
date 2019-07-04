package de.htw.krankenhaus.modell;

import java.util.Date;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

/**
 * Klasse fuer Qualitaetmanagementstelle
 * 
 * @author Yevheniia Vostres (566769)
 * @since 16.04.2019
 *
 */
public class Qualitaetsmanagementstelle implements Observer {

	private LinkedList<Aufenthalt> aufenthalt = new LinkedList<>();
	private LinkedList<Date> indates = new LinkedList<>();
	

	public LinkedList<Date> getIndates() {
		return indates;
	}

	public void setIndates(LinkedList<Date> indates) {
		this.indates = indates;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (arg instanceof Patient) {
			Patient patient = (Patient) arg;
			System.out.println("Qualitaetsmanagementstelle hat die Information erhalten, dass ein " + patient.getDauer()
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
