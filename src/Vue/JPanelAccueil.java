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

public class JPanelAccueil extends JPanel {
	
	/**
	 * Panneau d'accueil, avec le bouton nouveau jeu
	 * @param combat permet d'accéder aux méthodes du combat
	 * @param controleur permet d'accéder aux méthodes du controleur
	 */
	public JPanelAccueil(Combat combat, Controleur controleur) {
		setLayout(null);
		setSize(600,600);
		setOpaque(false);
		
		Font OSU = new Font("Old School United Stencil", Font.PLAIN, 60);
		
		JButton btnNewGame = new JButton("NEW GAME");
		btnNewGame.setBounds(150, 400, 300, 100);
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
