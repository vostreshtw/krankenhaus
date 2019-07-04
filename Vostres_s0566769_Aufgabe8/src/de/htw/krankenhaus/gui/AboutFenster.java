package de.htw.krankenhaus.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class AboutFenster extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AboutFenster() {
		setTitle("About");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(screen.width / 2 - getWidth() / 2, screen.height / 2 - getHeight() / 2);
		setupGUI();
		setVisible(true);

	}

	private void setupGUI() {
		setLayout(new GridLayout(0, 1));
		add(new JTextArea("Yevheniia Vostres, 566769"));
	}
}
