package Vue;


import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import Controller.Controleur;
import Jeu.Combat;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Jeu.*;

public class JPanelCombat extends JPanel {

	/**
	 * Panneau de combat, avec : 
	 * - La créature active pour chaque joueur
	 * - Les 4 boutons des actions possibles
	 * @param combat permet d'accéder aux méthodes du combat
	 * @param controleur permet d'accéder aux méthodes du controleur
	 */
	public JPanelCombat(Combat combat, Controleur controleur) {
		setSize(600,600);
		setLayout(null);
		
		Font OSU50 = new Font("Old School United Stencil", Font.PLAIN, 50);
		Font OSU30 = new Font("Old School United Stencil", Font.PLAIN, 30);
		Font OSU25 = new Font("Old School United Stencil", Font.PLAIN, 25);
		
		JLabel lblCreajoueur1 = new JLabel("");
		lblCreajoueur1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreajoueur1.setIcon(new ImageIcon(combat.getJoueurActif().getTeam()[0].getImageBack()));
		lblCreajoueur1.setBounds(35, 165, 300, 200);
		this.add(lblCreajoueur1);
		
		JLabel lblCreajoueur2 = new JLabel("");
		lblCreajoueur2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreajoueur2.setIcon(new ImageIcon(combat.getJoueurPassif().getTeam()[0].getImage()));
		lblCreajoueur2.setBounds(280, 30, 300, 200);
		this.add(lblCreajoueur2);
		
		JLabel lblPVCrea1 = new JLabel();
		lblPVCrea1.setForeground(Color.WHITE);
		lblPVCrea1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPVCrea1.setBounds(360, 335, 240, 35);
		lblPVCrea1.setFont(OSU50);
		this.add(lblPVCrea1);
		lblPVCrea1.setText("PV : " + String.valueOf(combat.getJoueurActif().team[0].getPv()));
		
		JLabel lblPVCrea2 = new JLabel();
		lblPVCrea2.setForeground(Color.WHITE);
		lblPVCrea2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPVCrea2.setBounds(0, 100, 240, 35);
		lblPVCrea2.setFont(OSU50);
		this.add(lblPVCrea2);
		lblPVCrea2.setText("PV : " + String.valueOf(combat.getJoueurPassif().getTeam()[0].getPv()));
		
		JLabel lblNomcrea1 = new JLabel();
		lblNomcrea1.setForeground(Color.WHITE);
		lblNomcrea1.setFont(OSU30);
		lblNomcrea1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomcrea1.setBounds(360, 300, 240, 35);
		this.add(lblNomcrea1);
		lblNomcrea1.setText(combat.getJoueurActif().getTeam()[0].getNom());
		
		JLabel lblNomCrea2 = new JLabel();
		lblNomCrea2.setForeground(Color.WHITE);
		lblNomCrea2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomCrea2.setBounds(0, 65, 240, 35);
		lblNomCrea2.setFont(OSU30);
		this.add(lblNomCrea2);
		lblNomCrea2.setText(combat.getJoueurPassif().getTeam()[0].getNom());
		
		JLabel lblNomJ1 = new JLabel();
		lblNomJ1.setForeground(Color.WHITE);
		lblNomJ1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomJ1.setFont(OSU30);
		lblNomJ1.setBounds(360, 265, 240, 35);
		this.add(lblNomJ1);
		lblNomJ1.setText(combat.getJoueurActif().getJnom());
		
		JLabel lblNomJ2 = new JLabel();
		lblNomJ2.setForeground(Color.WHITE);
		lblNomJ2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomJ2.setFont(OSU30);
		lblNomJ2.setBounds(0, 30, 240, 35);
		this.add(lblNomJ2);
		lblNomJ2.setText(combat.getJoueurPassif().getJnom());
	
		
		JLabel lblBgd = new JLabel("");
		lblBgd.setIcon(new ImageIcon("Images\\fond2.png"));
		lblBgd.setBounds(0, 0, 600, 400);
		this.add(lblBgd);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 400, 600, 200);
		panel.setLayout(null);
		add(panel);
		
		JButton btnAttaquer = new JButton("Attaquer");
		btnAttaquer.setForeground(Color.WHITE);
		btnAttaquer.setFont(OSU25);
		btnAttaquer.setOpaque(false);
		btnAttaquer.setContentAreaFilled(false);
		btnAttaquer.setBorderPainted(true);
		btnAttaquer.setBounds(0, 0, 150, 100);
		panel.add(btnAttaquer);
		btnAttaquer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.attaquer();
			}
		});
		
		JButton btnRepos = new JButton("Repos");
		btnRepos.setForeground(Color.WHITE);
		btnRepos.setFont(OSU25);
		btnRepos.setOpaque(false);
		btnRepos.setContentAreaFilled(false);
		btnRepos.setBorderPainted(true);
		btnRepos.setBounds(150, 0, 150, 100);
		panel.add(btnRepos);
		btnRepos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.repos();
			}
		});
		
		JButton btnChanger = new JButton("Swap");
		btnChanger.setForeground(Color.WHITE);
		btnChanger.setFont(OSU25);
		btnChanger.setOpaque(false);
		btnChanger.setContentAreaFilled(false);
		btnChanger.setBorderPainted(true);
		btnChanger.setBounds(0, 100, 150, 100);
		panel.add(btnChanger);
		btnChanger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.changerCrea();
			}
		});
		
		JButton btnAbandon = new JButton("Abandon");
		btnAbandon.setForeground(Color.WHITE);
		btnAbandon.setFont(OSU25);
		btnAbandon.setOpaque(false);
		btnAbandon.setContentAreaFilled(false);
		btnAbandon.setBorderPainted(true);
		btnAbandon.setBounds(150, 100, 150, 100);
		panel.add(btnAbandon);
		btnAbandon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controleur.abandonner();
			}
		});
		
		JLabel lblLattaqueAFait = new JLabel("L'attaque a fait");
		lblLattaqueAFait.setFont(OSU25);
		lblLattaqueAFait.setForeground(Color.WHITE);
		lblLattaqueAFait.setHorizontalAlignment(SwingConstants.CENTER);
		lblLattaqueAFait.setBounds(300, 30, 300, 20);
		
		
		JLabel lblX_Degats = new JLabel();
		lblX_Degats.setText(combat.getDamage() + " dégats !");
		lblX_Degats.setFont(OSU25);
		lblX_Degats.setForeground(Color.WHITE);
		lblX_Degats.setHorizontalAlignment(SwingConstants.CENTER);
		lblX_Degats.setBounds(300, 55, 300, 20);
		
		
		if(combat.getDamage()!=0){
			panel.add(lblLattaqueAFait);
			panel.add(lblX_Degats);
		}
		
		JLabel lblCesta = new JLabel("C'est à");
		lblCesta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCesta.setForeground(Color.WHITE);
		lblCesta.setFont(OSU25);
		lblCesta.setBounds(300, 100, 300, 30);
		panel.add(lblCesta);
		
		JLabel lblNomJoueurActif = new JLabel();
		lblNomJoueurActif.setText(combat.getJoueurActif().getJnom());
		lblNomJoueurActif.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomJoueurActif.setBounds(300, 130, 300, 30);
		lblNomJoueurActif.setForeground(Color.WHITE);
		lblNomJoueurActif.setFont(OSU25);
		panel.add(lblNomJoueurActif);
		
		JLabel lblDejouer = new JLabel("de jouer !");
		lblDejouer.setHorizontalAlignment(SwingConstants.CENTER);
		lblDejouer.setForeground(Color.WHITE);
		lblDejouer.setFont(OSU25);
		lblDejouer.setBounds(300, 160, 300, 30);
		panel.add(lblDejouer);
		
		
		
		JLabel lblbgd = new JLabel("");
		lblbgd.setIcon(new ImageIcon("Images\\fondChoix.png"));
		lblbgd.setBounds(0, 0, 600, 200);
		panel.add(lblbgd);
		
	}
}
