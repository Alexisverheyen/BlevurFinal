package Vue;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import Controller.Controleur;

public class JPanelClientServeur extends JPanel {

	/**
	 * Create the panel.
	 */
	public JPanelClientServeur(Controleur controleur) {
		setSize(600,600);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 600, 600);
		add(panel);
		panel.setLayout(null);
		
		JButton btnServeur = new JButton("Serveur");
		btnServeur.setBounds(200, 200, 200, 50);
		panel.add(btnServeur);
		
		JButton btnClient = new JButton("Client");
		btnClient.setBounds(200, 350, 200, 50);
		panel.add(btnClient);
		
		JButton btnRetour = new JButton("RETOUR");
		btnRetour.setBounds(495, 5, 100, 30);
		panel.add(btnRetour);
		btnRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.retour();
			}
		});
		
		JLabel lblfond = new JLabel("New label");
		lblfond.setIcon(new ImageIcon("C:\\Users\\Pierre\\workspace\\BlevurFinal\\Images\\fondChoix.png"));
		lblfond.setBounds(0, 0, 600, 600);
		panel.add(lblfond);

	}
}
