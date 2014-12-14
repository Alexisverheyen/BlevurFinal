package Vue;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Font;

import javax.swing.SwingConstants;

import Controller.Controleur;
import Jeu.Combat;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JPanelFin extends JPanel {
	
	
	
	/**
	 * Affiche GAME OVER et le nom du joueur qui a gagné
	 * @param combat permet d'accéder aux méthodes du combat
	 * @param controleur permet d'accéder aux méthodes du controleur
	 */
	public JPanelFin(Combat combat, Controleur controleur) {
		setSize(600,600);
		setLayout(null);
		setBackground(Color.black);
		
		JLabel lblFinDuGame = new JLabel("GAME OVER");
		lblFinDuGame.setFont(new Font("Old School United Stencil", Font.PLAIN, 90));
		lblFinDuGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinDuGame.setForeground(Color.WHITE);
		lblFinDuGame.setBackground(Color.BLACK);
		lblFinDuGame.setBounds(0, 150, 600, 100);
		this.add(lblFinDuGame);
		
		JLabel lblGagnant = new JLabel("GAGNANT VAR");
		lblGagnant.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGagnant.setHorizontalAlignment(SwingConstants.CENTER);
		lblGagnant.setForeground(Color.WHITE);
		lblGagnant.setBackground(Color.BLACK);
		lblGagnant.setBounds(0, 300, 600, 50);
		lblGagnant.setText(combat.gagnant().getJnom());
		this.add(lblGagnant);
		
		JLabel lblAGagn = new JLabel("A GAGN\u00C9");
		lblAGagn.setHorizontalAlignment(SwingConstants.CENTER);
		lblAGagn.setForeground(Color.WHITE);
		lblAGagn.setBounds(0, 350, 600, 20);
		this.add(lblAGagn);
		
		JButton btnRejouer = new JButton("REJOUER");
		btnRejouer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controleur.retour();
			}
		});
		btnRejouer.setHorizontalAlignment(SwingConstants.CENTER);
		btnRejouer.setForeground(Color.WHITE);
		btnRejouer.setBackground(Color.black);
		btnRejouer.setOpaque(false);
		btnRejouer.setBounds(225, 420, 150, 35);
		add(btnRejouer);
	}
}
