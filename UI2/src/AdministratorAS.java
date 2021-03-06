import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class AdministratorAS extends JFrame {

	static JFrame frame;
	static AdminSachbearbeiterEditierenAAS edit = new AdminSachbearbeiterEditierenAAS();
	static JPanel editierenfenster = edit.gibPanel();
//	static JPanel erzeugenfenster;
	static JPanel fallEditieren;
	static JMenuBar menuBar = new JMenuBar();
	static JMenu mnSachbearbeiter = new JMenu("Sachbearbeiter");
	static JToolBar toolAdmin = new JToolBar();
	static JMenuItem erstellen = new JMenuItem("Erstellen", KeyEvent.VK_E);
	static JMenuItem loeschen = new JMenuItem("Löschen");
	static JMenu mnZurck = new JMenu("Zurück");
	static JMenuItem zurueck = new JMenuItem("Zurück");
	static JMenuItem forbildungzuordnenLoeschen = new JMenuItem("Fortbildungzuordnung Löschen");


	static JButton btnLogin = new JButton("Erstellen");
	static JButton btnEditieren = new JButton("Editieren");
	static JButton btnloeschen = new JButton("Löschen");
	static JButton btnfortbildung_zuweisen = new JButton("Fortbildung zuweisen");
	static JButton btnFortbildungzuordnenLoeschne = new JButton("Fortbildungzuordnung löschen");
	static JButton btnZurueck = new JButton("Zurück");

	public static void start(JFrame f) {
		frame = f;
		f.setTitle("Sachbearbeiter Verwaltung Administrator");
		f.repaint();
		f.setVisible(true);

		System.out.println("In Admin Administrator AS");

		f.setJMenuBar(menuBar);

		menuBar.add(mnSachbearbeiter);

		KeyStroke erstellenkeyStroke = KeyStroke.getKeyStroke("alt shift E");
		erstellen.setAccelerator(erstellenkeyStroke);
		erstellen.addActionListener(new erstellenlistener());
		mnSachbearbeiter.add(erstellen);

		JMenuItem editieren = new JMenuItem("Editieren", KeyEvent.VK_D);
		KeyStroke editierenKeyStroke = KeyStroke.getKeyStroke("alt shift D");
		editieren.setAccelerator(editierenKeyStroke);
		editieren.addActionListener(new editierenlistener());
		mnSachbearbeiter.add(editieren);

		KeyStroke loeschenKeyStroke = KeyStroke.getKeyStroke("alt shift L");
		loeschen.addActionListener(new loeschenlistener());
		loeschen.setAccelerator(loeschenKeyStroke);
		mnSachbearbeiter.add(loeschen);

		JMenuItem folbildung_zuordnen = new JMenuItem("Fortbildung zuorden");
		KeyStroke fortbildungZuordnenKeyStroke = KeyStroke.getKeyStroke("alt shift U");
		folbildung_zuordnen.setAccelerator(fortbildungZuordnenKeyStroke);
		folbildung_zuordnen.addActionListener(new zuweisenlistener());
		mnSachbearbeiter.add(folbildung_zuordnen);

		KeyStroke zurueckKeyStroke = KeyStroke.getKeyStroke("alt shift Z");
		zurueck.setAccelerator(zurueckKeyStroke);
		mnZurck.add(zurueck);
		mnZurck.addActionListener(new zuruecklistener());
		menuBar.add(mnZurck);
		
		
		KeyStroke fortbildungzuordnungLoeschen = KeyStroke.getKeyStroke("alt shift O");
		forbildungzuordnenLoeschen.setAccelerator(fortbildungzuordnungLoeschen);
		forbildungzuordnenLoeschen.addActionListener(new fortbildungloeschenlistener());
		mnSachbearbeiter.add(forbildungzuordnenLoeschen);


		f.add(toolAdmin, BorderLayout.NORTH);

		btnLogin.addActionListener(new erstellenlistener());
		btnLogin.setMnemonic(KeyEvent.VK_E);
		toolAdmin.add(btnLogin);

		btnEditieren.addActionListener(new editierenlistener());
		btnEditieren.setMnemonic(KeyEvent.VK_D);
		toolAdmin.add(btnEditieren);

		btnloeschen.addActionListener(new loeschenlistener());
		toolAdmin.add(btnloeschen);
		btnloeschen.setMnemonic(KeyEvent.VK_L);
		
		
		btnfortbildung_zuweisen.addActionListener(new zuweisenlistener());
		btnfortbildung_zuweisen.setMnemonic(KeyEvent.VK_U);
		toolAdmin.add(btnfortbildung_zuweisen);

		btnFortbildungzuordnenLoeschne.addActionListener(new fortbildungloeschenlistener());
		btnFortbildungzuordnenLoeschne.setMnemonic(KeyEvent.VK_O);
		toolAdmin.add(btnFortbildungzuordnenLoeschne);

		btnZurueck.addActionListener(new zuruecklistener());
		btnZurueck.setMnemonic(KeyEvent.VK_Z);
		toolAdmin.add(btnZurueck);

		frame = f;

	}

	void adminSachbearbeiterEditierenAbschliessen(JPanel adminEditPanel) {
		System.out.println("Im adminsachbearbeiterEditieren ");
	}

	public static void graumachen() {
		btnLogin.setEnabled(false);
		btnEditieren.setEnabled(false);
		btnfortbildung_zuweisen.setEnabled(false);
		btnFortbildungzuordnenLoeschne.setEnabled(false);	
		btnZurueck.setEnabled(false);
		btnloeschen.setEnabled(false);
	}

	public static void entgrauen() {
		btnLogin.setEnabled(true);
		btnEditieren.setEnabled(true);
		btnfortbildung_zuweisen.setEnabled(true);
		btnFortbildungzuordnenLoeschne.setEnabled(true);
		btnZurueck.setEnabled(true);
		btnloeschen.setEnabled(true);
	}

	public static class erstellenlistener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			AdministratorAS.graumachen();
			AdminSachbearbeiterErzeugenAAS erz = new AdminSachbearbeiterErzeugenAAS();
			JPanel erzeugenfenster = erz.getPanel();
			frame.repaint();
			frame.add(erzeugenfenster);
			frame.setVisible(true);
		}
	}

	public static class editierenlistener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			
			AdministratorAS.graumachen();
			AdminSachbearbeiterEditierenAAS adminEditieren = new AdminSachbearbeiterEditierenAAS();
			fallEditieren = adminEditieren.oeffnen();
			frame.repaint();
			frame.add(fallEditieren);
			frame.setVisible(true);

		}
	}

	public static class loeschenlistener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			AdministratorAS.graumachen();
			AdminSachbearbeiterLoeschenAAS loeschen = new AdminSachbearbeiterLoeschenAAS();
			JPanel loeschenFenster = loeschen.oeffnen();
			frame.repaint();
			frame.add(loeschenFenster);
			frame.setVisible(true);

		}
	}

	public static class zuweisenlistener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			AdministratorAS.graumachen();
			FortbildungZuordnenAAS auswaehlen = new FortbildungZuordnenAAS();
			JPanel fortbildungZuweisen = auswaehlen.oeffnen();
			frame.repaint();
			frame.add(fortbildungZuweisen);
			frame.setVisible(true);

		}
	}

	public static class fortbildungloeschenlistener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			AdministratorAS.graumachen();
			FortbildungLoeschenAAS loeschen = new FortbildungLoeschenAAS();
			JPanel fortbildungloeschen = loeschen.oeffnen();
			frame.repaint();
			frame.add(fortbildungloeschen);
			frame.setVisible(true);
		}
	}

	public static class zuruecklistener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Im zurück Listener");
			LehrveranstaltungsVerwaltungHS.neuOeffnen();
			

		}
	}
	


}
