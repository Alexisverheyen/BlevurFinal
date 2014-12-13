package Vue;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.GridLayout;

import javax.swing.JTextPane;

import Controller.Controleur;
import Jeu.Combat;
import Jeu.Creature;
import Jeu.Eau;
import Jeu.Feu;
import Jeu.Normal;
import Jeu.Plante;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Vue.*;

import java.awt.Font;

public class JPanelChoix extends JPanel {
	
	
	/**
	 * Panneau pour choisir ses créatures pour former sa team
	 * @param combat permet d'accéder aux méthodes du combat
	 * @param controleur permet d'accéder aux méthodes du controleur
	 */
	public JPanelChoix(Combat combat, Controleur controleur) {
		setBorder(null);
		setBackground(Color.GRAY);
		this.setSize(600,600);
		setLayout(null);
		Font OSU20 = new Font("Old School United Stencil", Font.PLAIN, 20);
		
		JPanel panel = new JPanel();
		panel.setLocation(0, 0);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setSize(600, 600);
		this.setOpaque(false);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblinfos = new JLabel();
		lblinfos.setBounds(40, 5, 400, 30);
		panel.add(lblinfos);
		lblinfos.setText("Le joueur " + (controleur.getJoueur()+1) + " doit choisir sa creature " + (controleur.getCreature()+1));
		lblinfos.setFont(OSU20);
		lblinfos.setOpaque(false);
		lblinfos.setForeground(Color.white);
		lblinfos.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnEau = new JButton("CHOISIR");
		btnEau.setBounds(25, 70, 150, 80);
		panel.add(btnEau);
		btnEau.setFont(OSU20);
		btnEau.setForeground(Color.WHITE);
		btnEau.setOpaque(false);
		btnEau.setContentAreaFilled(false);
		btnEau.setBorderPainted(true);
		btnEau.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controleur.creatureChoisie(1);
				lblinfos.setText("Le joueur " + (controleur.getJoueur()+1) + " doit choisir sa creature " + (controleur.getCreature()+1));
			}
		});
	
		JLabel lblIco = new JLabel();
		lblIco.setBounds(200, 40, 200, 140);
		lblIco.setHorizontalAlignment(SwingConstants.CENTER);
		lblIco.setIcon(new ImageIcon("Images\\eau.gif"));
		panel.add(lblIco);
		
		JTextPane Info1 = new JTextPane();
		Info1.setFont(OSU20);
		Info1.setForeground(Color.WHITE);
		Info1.setBounds(400, 80, 200, 50);
		Info1.setEditable(false); 
		Info1.setText("Nom : Seismitoad\nType : Eau");
		Info1.setOpaque(false);
		panel.add(Info1);
		
		JButton btnFeu = new JButton("CHOISIR");
		btnFeu.setBounds(25, 210, 150, 80);
		panel.add(btnFeu);
		btnFeu.setFont(OSU20);
		btnFeu.setForeground(Color.WHITE);
		btnEau.setOpaque(false);
		btnFeu.setContentAreaFilled(false);
		btnFeu.setBorderPainted(true);
		btnFeu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controleur.creatureChoisie(2);
				lblinfos.setText("Le joueur " + (controleur.getJoueur()+1) + " doit choisir sa creature " + (controleur.getCreature()+1));
			}
		});
		
		JLabel lblIco2 = new JLabel();
		lblIco2.setBounds(200, 180, 200, 140);
		lblIco2.setHorizontalAlignment(SwingConstants.CENTER);
		lblIco2.setIcon(new ImageIcon("Images\\feu.gif"));
		panel.add(lblIco2);
		
		JTextPane Info2 = new JTextPane();
		Info2.setFont(OSU20);
		Info2.setForeground(Color.WHITE);
		Info2.setBounds(400, 220, 200, 50);
		Info2.setText("Nom : Emboar\nType : Feu");
		Info2.setOpaque(false);
		panel.add(Info2);
		
		JButton btnPlante = new JButton("CHOISIR");
		btnPlante.setBounds(25, 350, 150, 80);
		panel.add(btnPlante);
		btnPlante.setFont(OSU20);
		btnPlante.setForeground(Color.WHITE);
		btnPlante.setOpaque(false);
		btnPlante.setContentAreaFilled(false);
		btnPlante.setBorderPainted(true);
		btnPlante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controleur.creatureChoisie(3);
				lblinfos.setText("Le joueur " + (controleur.getJoueur()+1) + " doit choisir sa creature " + (controleur.getCreature()+1));
			}
		});
		
		JLabel lblIco3 = new JLabel();
		lblIco3.setBounds(200, 320, 200, 140);
		lblIco3.setHorizontalAlignment(SwingConstants.CENTER);
		lblIco3.setIcon(new ImageIcon("Images\\plante.gif"));
		panel.add(lblIco3);
		
		JTextPane Info3 = new JTextPane();
		Info3.setFont(OSU20);
		Info3.setForeground(Color.WHITE);
		Info3.setBounds(400, 500, 200, 50);
		Info3.setOpaque(false);
		panel.add(Info3);
		Info3.setText("Nom : Torterra\nType : Plante");
		
		JButton btnNormal = new JButton("CHOISIR");
		btnNormal.setBounds(25, 490, 150, 80);
		panel.add(btnNormal);
		btnNormal.setFont(OSU20);
		btnNormal.setForeground(Color.WHITE);
		btnNormal.setOpaque(false);
		btnNormal.setContentAreaFilled(false);
		btnNormal.setBorderPainted(true);
		btnNormal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controleur.creatureChoisie(4);
				lblinfos.setText("Le joueur " + (controleur.getJoueur()+1) + " doit choisir sa creature " + (controleur.getCreature()+1));
			}
		});
		
		JLabel lblIco4 = new JLabel();
		lblIco4.setBounds(200, 460, 200, 140);
		lblIco4.setHorizontalAlignment(SwingConstants.CENTER);
		lblIco4.setIcon(new ImageIcon("Images\\normal.gif"));
		panel.add(lblIco4);
		
		JTextPane Info4 = new JTextPane();
		Info4.setFont(OSU20);
		Info4.setForeground(Color.WHITE);
		Info4.setBounds(400, 360, 200, 50);
		panel.add(Info4);
		Info4.setText("Nom : Bouffalant \nType : Normal");
		Info4.setOpaque(false);
		
		JButton btnRetour = new JButton("RETOUR");
		btnRetour.setBounds(495, 5, 100, 30);
		btnRetour.setOpaque(false);
		btnRetour.setFont(OSU20);
		panel.add(btnRetour);
		
		JLabel lblFond = new JLabel("Fond");
		lblFond.setBounds(0, 0, 600, 600);
		lblFond.setIcon(new ImageIcon("Images\\fondChoix.png"));
		lblFond.setOpaque(false);
		panel.add(lblFond);
		btnRetour.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.retour();
			}
		});
	}
}

