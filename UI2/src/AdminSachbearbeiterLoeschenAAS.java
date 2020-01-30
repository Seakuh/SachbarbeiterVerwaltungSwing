import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class AdminSachbearbeiterLoeschenAAS extends JPanel {
	
	SachbearbeiterAuswaehlenAAS auswahlCombobox = new SachbearbeiterAuswaehlenAAS();
	AdminSachbearbeiterLoeschenK kontrolle = new AdminSachbearbeiterLoeschenK();
	SachbearbeiterEK sachbZuloe;
	JPanel panel = new JPanel();
	

	/**
	 * Create the panel.
	 */
	public AdminSachbearbeiterLoeschenAAS() {
		panel.setLayout(null);
		
		JLabel lblSachbearbeiterLschen = new JLabel("Sachbearbeiter löschen: ");
		lblSachbearbeiterLschen.setBounds(22, 52, 218, 15);
		panel.add(lblSachbearbeiterLschen);
		
		JLabel lblSachbearbeiterAuswhlen = new JLabel("Sachbearbeiter auswählen:");
		lblSachbearbeiterAuswhlen.setBounds(22, 114, 187, 21);
		panel.add(lblSachbearbeiterAuswhlen);
		
		JComboBox auswahl = auswahlCombobox.oeffnen();
		auswahl.setBounds(227, 112, 143, 24);
		panel.add(auswahl);
		String ausw = auswahl.getSelectedItem().toString();
		sachbZuloe = SachbearbeiterEK.gib(ausw);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdministratorAS.entgrauen();

				panel.setVisible(false);
			}
		});
		btnAbbrechen.setBounds(22, 234, 114, 25);
		panel.add(btnAbbrechen);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdministratorAS.entgrauen();

				AdministratorAS.entgrauen();
				String auswahlString = auswahl.getSelectedItem().toString(); 
				kontrolle.loescheSachbearbeiter(auswahlString);
				panel.setVisible(false);
				
			}
		});
		btnOk.setBounds(148, 234, 114, 25);
		panel.add(btnOk);
		btnOk.setMnemonic(KeyEvent.VK_O);
		btnAbbrechen.setMnemonic(KeyEvent.VK_A);
		

	}
	
	public JPanel oeffnen(){
		return panel;
	}
}
