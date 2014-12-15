package Vue;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;

import Controller.Controleur;
import Jeu.Combat;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TimerTask;
import java.util.Timer;

public class JPanelAttaques extends JPanel {

	private Timer timer = new Timer();
	private JLabel lblexplo;
	
	/**
	 * Panneau des attaques, avec les 4 boutons d'attaque
	 * @param combat permet d'accéder aux méthodes du combat
	 * @param controleur permet d'accéder aux méthodes du controleur
	 */
	public JPanelAttaques(Combat combat, Controleur controleur) {
		this.setSize(600, 600);
		setLayout(null);
		
		Font OSU50 = new Font("Old School United Stencil", Font.PLAIN, 50);
		Font OSU25 = new Font("Old School United Stencil", Font.PLAIN, 20);	
		Font OSU30 = new Font("Old School United Stencil", Font.PLAIN, 30);
			
		lblexplo = new JLabel("");
		lblexplo.setBounds(372, 11, 155, 154);
		add(lblexplo);
		
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
		add(panel);
		panel.setLayout(null);
		panel.setOpaque(true);
		panel.setBackground(Color.DARK_GRAY);
		
		JButton btnAtk1 = new JButton();
		btnAtk1.setBounds(0, 0, 150, 100);
		btnAtk1.setForeground(Color.WHITE);
		btnAtk1.setFont(OSU25);
		btnAtk1.setOpaque(false);
		btnAtk1.setContentAreaFilled(false);
		btnAtk1.setBorderPainted(true);
		panel.add(btnAtk1);
		String str = new String("<html>" + combat.getJoueurActif().team[0].getAttaques(0) + 
				"<br>(" + combat.getJoueurActif().getTeam()[0].getNbAtkDispo(0) + "/15)</html>");
		btnAtk1.setText(str);
		btnAtk1.getParent().revalidate();
		btnAtk1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controleur.attaqueChoisie(1);
			}
		});
		
		JButton btnAtk2 = new JButton();
		btnAtk2.setBounds(150, 0, 150, 100);
		btnAtk2.setForeground(Color.WHITE);
		btnAtk2.setFont(OSU25);
		btnAtk2.setOpaque(false);
		btnAtk2.setContentAreaFilled(false);
		btnAtk2.setBorderPainted(true);
		panel.add(btnAtk2);
		btnAtk2.setText("<html>" + combat.getJoueurActif().team[0].getAttaques(1) + 
				"<br>(" + combat.getJoueurActif().getTeam()[0].getNbAtkDispo(1) + "/10)</html>");
		btnAtk2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controleur.attaqueChoisie(2);
			}
		});
		
		JButton btnAtk3 = new JButton();
		btnAtk3.setBounds(0, 100, 150, 100);
		btnAtk3.setForeground(Color.WHITE);
		btnAtk3.setFont(OSU25);
		btnAtk3.setOpaque(false);
		btnAtk3.setContentAreaFilled(false);
		btnAtk3.setBorderPainted(true);
		panel.add(btnAtk3);
		btnAtk3.setText("<html>" + combat.getJoueurActif().team[0].getAttaques(2) + 
				"<br>(" + combat.getJoueurActif().getTeam()[0].getNbAtkDispo(2) + "/5)</html>");
		btnAtk3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controleur.attaqueChoisie(3);
			}
		});
		
		JButton btnAtk4 = new JButton();
		btnAtk4.setBounds(150, 100, 150, 100);
		btnAtk4.setForeground(Color.WHITE);
		btnAtk4.setFont(OSU25);
		btnAtk4.setOpaque(false);
		btnAtk4.setContentAreaFilled(false);
		btnAtk4.setBorderPainted(true);
		panel.add(btnAtk4);
		btnAtk4.setText("<html>" + combat.getJoueurActif().team[0].getAttaques(3) + 
				" <br>(" + combat.getJoueurActif().getTeam()[0].getNbAtkDispo(3) + "/1)</html>");
		btnAtk4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controleur.attaqueChoisie(4);
			}
		});
		
		JLabel lblfond = new JLabel("");
		lblfond.setBounds(0, 0, 600, 200);
		lblfond.setOpaque(false);
		lblfond.setIcon(new ImageIcon("Images\\fondChoix.png"));
		panel.add(lblfond);
	}
	
	public void gifExplosion(){
		timer.schedule(new TimerTask(){
			@Override
			public void run(){
				ImageIcon animExplo = new ImageIcon("Images\\explosion.gif");
				lblexplo.setVisible(true);
				lblexplo.setIcon(animExplo);
			}	
		}, 650);
	}
}
