package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JRadioButton;
import javax.swing.JProgressBar;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;

import Jeu.Combat;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Controller.*;
import Jeu.*;
import javax.swing.JTextField;

public class JPanelAccueil extends JPanel {
	private JTextField txtNewGame;
	
	/**
	 * Panneau d'accueil, avec le bouton nouveau jeu
	 * @param combat permet d'accéder aux méthodes du combat
	 * @param controleur permet d'accéder aux méthodes du controleur
	 */
	public JPanelAccueil(Combat combat, Controleur controleur) {
		setLayout(null);
		setSize(600,600);
		setOpaque(false);
		
		Font OSU = new Font("Old School United Stencil", Font.PLAIN, 40);
		
		txtNewGame = new JTextField();
		txtNewGame.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewGame.setText("NEW GAME");
		txtNewGame.setBounds(175, 300, 250, 50);
		txtNewGame.setFont(OSU);
		txtNewGame.setOpaque(false);
		txtNewGame.setEditable(false); 
		txtNewGame.setBorder(null);
		txtNewGame.setForeground(Color.WHITE);
		add(txtNewGame);
		txtNewGame.setColumns(10);
		
		JButton btnNewGame = new JButton("LOCAL");
		btnNewGame.setBounds(175, 400, 250, 50);
		btnNewGame.setFont(OSU);
		btnNewGame.setForeground(Color.WHITE);
		btnNewGame.setOpaque(false);
		btnNewGame.setContentAreaFilled(false);
		btnNewGame.setBorderPainted(true);
		this.add(btnNewGame);
		btnNewGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controleur.start();
			}
		});
		
		JButton btnLAN = new JButton("RESEAU");
		btnLAN.setBounds(175, 500, 250, 50);
		btnLAN.setFont(OSU);
		btnLAN.setForeground(Color.white);
		btnLAN.setOpaque(false);
		btnLAN.setContentAreaFilled(false);
		btnLAN.setBorderPainted(true);
		add(btnLAN);
		btnLAN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controleur.lan();
			}
		});
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("Images\\fondBlevur2.png"));
		label_1.setBounds(0, 0, 600, 300);
		this.add(label_1);
		
		JLabel lblFond = new JLabel();
		lblFond.setIcon(new ImageIcon("Images\\fondChoix.png"));
		lblFond.setBounds(0, 0, 600, 600);
		lblFond.setOpaque(false);
		add(lblFond);
	}
}
