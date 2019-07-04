package de.htw.krankenhaus.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SingleSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import de.htw.krankenhaus.modell.Krankenhaus;
import de.htw.krankenhaus.modell.Patient;
import de.htw.krankenhaus.modell.Qualitaetsmanagementstelle;

public class Fenster extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Patient patient;
	private Krankenhaus kh;
	private JList<Object> plist;
	private JList<Object> alist;
	private JTextArea aufenthaltList;
	private String[] patienten;
	private JButton auf;
	private JButton ent;
	private ArrayList<String> aeh;
	private Qualitaetsmanagementstelle qms;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private String today = sdf.format(new Date());
	private JTextField ad = new JTextField();
	private JTextField ed = new JTextField();
	private JLabel pnamevalue = new JLabel();
	private JLabel pnumbervalue = new JLabel();
	private JTextField pannahme = new JTextField();
	private JTextField pentlassung = new JTextField();

	public Fenster(Krankenhaus kh, Patient patient) {
		this.patient = patient;
		this.kh = kh;
		setTitle(kh.getName());
		setSize(1000, 700);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screen.width - getSize().width) / 2, (screen.height - getSize().height) / 2);
		addMenu();
		setupGUI(kh, patient);
		setVisible(true);
		setResizable(true);
		patient.forceUpdate();
	}

	public JMenuBar addMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu patient = new JMenu();
		patient.setText("Patient");
		JMenu kv = new JMenu();
		kv.setText("Krankenversicherung");
		JMenu ah = new JMenu();
		ah.setText("Aufenthalte");
		JMenu info = new JMenu();
		info.setText("Information");
		info.add(addItem());

		JMenuItem anlegen = new JMenuItem("anlegen");
		patient.add(anlegen);
		JMenuItem nachNameSuchen = new JMenuItem("nach Name suchen");
		patient.add(nachNameSuchen);
		JMenuItem nachNummerSuchen = new JMenuItem("nach Nummer suchen");
		patient.add(nachNummerSuchen);

		JMenuItem pvAnlegen = new JMenuItem("Privatversicherung anlegen");
		kv.add(pvAnlegen);
		JMenuItem gvAnlegen = new JMenuItem("Gesetzliche Versicherung anlegen");
		kv.add(gvAnlegen);
		JMenuItem vAnzeigen = new JMenuItem("Versicherung anzeigen");
		kv.add(vAnzeigen);

		JMenuItem pAufnehmen = new JMenuItem("Patient aufnehmen");
		ah.add(pAufnehmen);
		JMenuItem pEntlassen = new JMenuItem("Patient entlassen");
		ah.add(pEntlassen);

		menuBar.add(patient);
		menuBar.add(kv);
		menuBar.add(ah);
		menuBar.add(info);
		return menuBar;
	}

	public JMenuItem addItem() {
		JMenuItem about = new JMenuItem("about");
		about.addActionListener(e -> new AboutFenster());
		return about;
	}

	private void setupGUI(Krankenhaus kh, Patient patient) {

		// left
		auf = new JButton("Aufnehmen");
		ent = new JButton("Entlassen");
		aufenthaltList = new JTextArea();
		JPanel left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.PAGE_AXIS));
		left.add(new JLabel("Patienten"));
		plist = showPatient(kh);
		plist.setSelectedIndex(0);
		
		Patient patient2 = kh.getPatList().get(plist.getSelectedIndex());
		aufenthaltList.setText(aufenthaltListTex(patient2));
		patient.addObserver((o,a)->aufenthaltList.setText(aufenthaltListTex(patient2)));
		
		plist.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				ad.setText("");
				ed.setText("");
				if(!arg0.getValueIsAdjusting()) {
					Patient patient = kh.getPatList().get(plist.getSelectedIndex());

					aufenthaltList.setText(aufenthaltListTex(patient));
					patient.addObserver((o,a)->aufenthaltList.setText(aufenthaltListTex(patient)));
					pnamevalue.setText(patient.getName());
					pnumbervalue.setText(patient.getPatientenNummer().toString());
				}
			}
		});

		left.add(plist);
		JScrollPane leftScroll = new JScrollPane(left);
		
		// right
		JPanel right = new JPanel();
		GridLayout experimentLayout = new GridLayout(0, 2, 1, 1);
		right.setLayout(experimentLayout);
		JScrollPane rightScroll = new JScrollPane(right);
		right.add(new JLabel("Aufenthalte:"));
		right.add(aufenthaltList);
		right.add(new JLabel("Name:"));
		right.add(pnamevalue);
		right.add(new JLabel("Patientennummer:"));
		right.add(pnumbervalue);
		right.add(new JLabel("Aufnahmedatum:"));
		right.add(ad);
		right.add(new JLabel("Entlassungsdatum:"));
		right.add(ed);
		right.add(auf);
		right.add(ent);
		// common
		JSplitPane board = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftScroll, rightScroll);
		board.setResizeWeight(0.5);
		add(board);
	}

	private JList<Object> showPatient(Krankenhaus kh) {
		plist = new JList<>();
		plist.setSize(200, 270);
		plist.setAlignmentX(LEFT_ALIGNMENT);
		int size = kh.getPatList().size();

		patienten = new String[size];

		for (int i = 0; i < patienten.length; i++) {
			Patient patient = kh.getPatList().get(i);
			String info = patient.getName();
			patienten[i] = info;
		}

		plist.setPreferredSize(new Dimension(200, 250));
		plist.setListData(patienten);
		return plist;
	}

	private String aufenthaltListTex(Patient patient) {
		aeh = new ArrayList();
		if(patient.getIndates().size() == patient.getOutdates().size()) {
			for (int i = patient.getIndates().size()-1; i >= 0; i--) {
				String info = sdf.format(patient.getIndates().get(i)) + " - " + sdf.format(patient.getOutdates().get(i)) + "\n";
				aeh.add(info);
			}
			ad.setText(today);
			ad.setEnabled(true);
			ed.setText("");
			auf.setEnabled(true);
			auf.addActionListener(e -> {
				try {
					patient.getIndates().add(sdf.parse(ad.getText()));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			});
			ent.setEnabled(false);
			 	
			
		}else {
			String info2 = sdf.format(patient.getIndates().getLast()) + " - \n";
			aeh.add(info2);
			for (int i = patient.getOutdates().size()-1; i >= 0; i--) {
				String info3 = sdf.format(patient.getIndates().get(i)) + " - " + sdf.format(patient.getOutdates().get(i)) + "\n";
				aeh.add(info3);
			}
			ad.setText(sdf.format(patient.getIndates().getLast()));
			ad.setEnabled(false);
			ed.setEditable(true);
			auf.setEnabled(false);
			ent.setEnabled(true);
			ent.addActionListener(e -> {
				try {
					patient.getOutdates().add(sdf.parse(ed.getText()));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			});
			ed.setText(today);
		}
		String s = "";
		for(String string: aeh) {
			s += string;
		}
		return s;
	}
}
