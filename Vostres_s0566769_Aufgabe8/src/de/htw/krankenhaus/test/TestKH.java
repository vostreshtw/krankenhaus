package de.htw.krankenhaus.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.htw.krankenhaus.funktionen.DateiVerwaltung;
import de.htw.krankenhaus.modell.Adresse;
import de.htw.krankenhaus.modell.Anrede;
import de.htw.krankenhaus.modell.GesetzlicheVersicherung;
import de.htw.krankenhaus.modell.Krankenhaus;
import de.htw.krankenhaus.modell.Krankenversicherung;
import de.htw.krankenhaus.modell.Patient;
import de.htw.krankenhaus.start.DemoDaten;

/**
 * 
 * 
 * Die Klasse fuer Test des Programms
 * 
 * @author Yevheniia Vostres (566769)
 *
 */
class TestKH {

	private Adresse adresse = new Adresse("Schwanebecker Chaussee", "50", "13125", "Berlin");
	private Krankenhaus kh = new Krankenhaus("test", "DE812524991", adresse);
	private DateiVerwaltung dv = new DateiVerwaltung();
	private DemoDaten demo = new DemoDaten();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testImport() {
		ArrayList<Patient> patList = kh.getPatList();
		String filePath = "patienten.csv";
		patList = dv.importPatientTest(filePath);
		assertTrue(patList.size() != 0);
	}

	@Test
	void testExport() {
		demo.demoDaten(kh);
		String filePath = "patienten.csv";
		dv.exportPatientTest(filePath, kh);
		assertTrue(new File(filePath).exists());
	}

	@Test
	void testAddGKV() {
		Adresse adresse1 = new Adresse("Krumme Str", "56", "13567", "Berlin");
		Patient lorna = new Patient(999, Anrede.Frau, "Lorna", "Koch", "10.04.1980", adresse1, "+491525678985",
				"ek@web.de");
		Krankenversicherung aok = new GesetzlicheVersicherung("U23456", "AOK", true);
		lorna.addVersicherung(aok);
		List<Krankenversicherung> kvs = lorna.getVersList();
		assertEquals(1, kvs.size());

	}

	@Test
	void testAufnahme() {
		Adresse adresse1 = new Adresse("Krumme Str", "56", "13567", "Berlin");
		Patient lorna = new Patient(999, Anrede.Frau, "Lorna", "Koch", "10.04.1980", adresse1, "+491525678985",
				"ek@web.de");
		lorna.setIndate("25/05/2019", kh);
		List<Date> aufenthalte = lorna.getIndates();
		assertEquals(1, aufenthalte.size());
	}

	@Test
	void testEntlassung() {
		Adresse adresse1 = new Adresse("Krumme Str", "56", "13567", "Berlin");
		Patient lorna = new Patient(999, Anrede.Frau, "Lorna", "Koch", "10.04.1980", adresse1, "+491525678985",
				"ek@web.de");
		lorna.setOutdate("28/05/2019", kh);
		List<Date> aufenthalteOut = lorna.getOutdates();
		assertEquals(1, aufenthalteOut.size());
	}

}
