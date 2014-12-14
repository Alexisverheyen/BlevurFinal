package Vue;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import Controller.Controleur;

import javax.swing.JTextField;

public class JPanelClientServeur extends JPanel {
	private JTextField textPort;
	private JTextField textIP;
	private int numPort;
	private String ip;

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
		
		JButton btnServeur = new JButton("Cr\u00E9er un serveur");
		btnServeur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				numPort = Integer.parseInt(textPort.getText());
				controleur.connexionServeur(numPort);
			}
		});
		btnServeur.setBounds(200, 257, 200, 50);
		panel.add(btnServeur);
		
		JButton btnClient = new JButton("Rejoindre");
		btnClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				numPort = Integer.parseInt(textPort.getText());
				ip = textIP.getText();
				controleur.connexionClient(ip, numPort);
				try {
					Thread.sleep(20000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(controleur.isConnected()) controleur.start();
			}
		});
		btnClient.setBounds(200, 350, 200, 50);
		panel.add(btnClient);
		
		JButton btnRetour = new JButton("RETOUR");
		btnRetour.setBounds(495, 5, 100, 30);
		panel.add(btnRetour);
		btnRetour.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.retour();
			}
		});
		
		textPort = new JTextField();
		textPort.setBounds(200, 187, 65, 20);
		panel.add(textPort);
		textPort.setColumns(10);
		
		textIP = new JTextField();
		textIP.setBounds(160, 104, 268, 20);
		panel.add(textIP);
		textIP.setColumns(10);
		
		JLabel lblfond = new JLabel("New label");
		lblfond.setIcon(new ImageIcon("Images\\fondChoix.png"));
		lblfond.setBounds(0, 0, 600, 600);
		panel.add(lblfond);

	}
}
