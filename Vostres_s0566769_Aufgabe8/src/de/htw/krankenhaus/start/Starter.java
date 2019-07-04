package de.htw.krankenhaus.start;

import de.htw.krankenhaus.gui.Fenster;
import de.htw.krankenhaus.modell.Adresse;
import de.htw.krankenhaus.modell.Krankenhaus;

/**
 * 
 * Start der Programmausfuerung
 * 
 * @author Yevheniia Vostres (566769)
 * @since 16.04.2019
 *
 */

public class Starter {

	public static void main(String[] args) {

		DemoDaten demo = new DemoDaten();

		// Testdaten Krankenhaus
		Adresse adresseHelios = new Adresse("Schwanebecker Chaussee", "50", "13125", "Berlin");
		Krankenhaus helios = new Krankenhaus("Helios", "DE812524991", adresseHelios);
		demo.demoDaten(helios);

		// Menueaufruf
		Menue menue = new Menue();
		
		// Bedingungen fuer Program Arguments
		if(args.length == 0) {
		menue.ansicht(helios);
		} else if(args[0].equalsIgnoreCase("CLI")) 
		{ menue.menue(helios);
			
		} else if(args[0].equalsIgnoreCase("GUI")) {
			Fenster fenster = new Fenster(helios, helios.getPatList().get(0));
			fenster.setVisible(true);
		}
		
	}

}
