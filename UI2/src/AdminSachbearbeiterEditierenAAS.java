import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AdminSachbearbeiterEditierenAAS {
	String bn;
	String pw;
	String berechtigung;
	JPanel editieren;
	JButton okButton;
	JButton beendenButton;
	JPanel a;
	SachbearbeiterEK sachbearbeiter;
	okLauscher okL = new okLauscher();
	abbruchLauscher aL = new abbruchLauscher();
	SachbearbeiterEditierenAS sachbEd;
	SachbearbeiterEditierenK kontrolle = new SachbearbeiterEditierenK();

	public AdminSachbearbeiterEditierenAAS() {
	}

	public JPanel oeffnen() {

		System.out.println("Im AdminSachbearbeiterEditierenAAS oeffnen Penel");
		JPanel erg = new JPanel();

		erg.setLayout(null);
		sachbEd = null;
		sachbEd = new SachbearbeiterEditierenAS();

		erg.add(sachbEd.sachbearbeiterEditieren(true));
		beendenButton = new JButton("Abbruch");
		beendenButton.setBounds(22, 418, 114, 25);
		beendenButton.addActionListener(aL);
		beendenButton.setMnemonic(KeyEvent.VK_A);
		erg.add(beendenButton);

		okButton = new JButton("OK");
		okButton.setBounds(178, 418, 114, 25);
		okButton.addActionListener(okL);
		okButton.setMnemonic(KeyEvent.VK_O);
		
		erg.add(okButton);
		erg.repaint();
		a = erg;
		return erg;
	}

	public JPanel gibEditieren() {
		return this.editieren;
	}

	private class okLauscher implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

//			if((sachbEd.getBenutzernameToString() =! null)
//					&& (sachbEd.getPasswortToString() =! null)
//					&& (sachbEd.getBerechtigung() =! null)
//					&& (sachbEd.getAuswahl() != null)) {

			System.out.println("hallo123");
			System.out.println(sachbEd.getBenutzernameToString());
			System.out.println(sachbEd.getPasswortToString());
			System.out.println(sachbEd.getBerechtigung());
			System.out.println(sachbEd.getAuswahl());

			if (sachbEd.getBenutzernameToString() != null && sachbEd.getPasswortToString() != null
					&& sachbEd.getBerechtigung() != null && sachbEd.getAuswahl() != null) {
				kontrolle.kontrolliereEingabe(sachbEd.getBenutzernameToString(), sachbEd.getPasswortToString(),
						sachbEd.getBerechtigung(), sachbEd.getAuswahl());
				AdministratorAS.entgrauen();

			} else {
				System.out.println("Ist null");
				JOptionPane.showMessageDialog(null, "Es wurde nichts ausgewählt", "Editiert",
						JOptionPane.ERROR_MESSAGE);
				AdministratorAS.entgrauen();
			}

			a.setVisible(false);
		}

	}

	public class abbruchLauscher implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			AdministratorAS.entgrauen();
			a.setVisible(false);
		}
	}

	public void adminSachbearbeiterEditierenAbschliessen(JPanel adminEditPanel) {

	}

	public JPanel gibPanel() {

		return a;
	}

}
