package de.htw.krankenhaus.funktionen;

import java.util.Comparator;

import de.htw.krankenhaus.modell.Patient;

/**
 * The Class PatientComparator.
 *
 * @author Yevheniia Vostres (566769)
 * @version 3.0
 * @since 16.04.2019
 */

public class PatientComparator implements Comparator<Patient> {

	/*
	 * 
	 * Ueberschreiben von Compare Methode (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 * 
	 */
	@Override
	public int compare(Patient o1, Patient o2) {
		// TODO Auto-generated method stub

		return o1.getNachname().compareTo(o2.getNachname());
	}

}
