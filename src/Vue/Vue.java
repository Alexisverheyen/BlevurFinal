package Vue;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import java.net.URL;



import Jeu.Combat;

import java.util.Observer;

import Controller.*;
import Jeu.*;

public class Vue extends JFrame {
	
	JPanel[] panels; 
	Combat combat;
	Controleur controleur;
	
	

	public Vue(Combat combat, Controleur controleur) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(606, 629);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.BLACK);
		this.setTitle("BLEVUR �");
		this.combat = combat;
		this.controleur = controleur;
		panels = new JPanel[5];
	}
	
	/*
	 * Methode qui permet de changer le JPanel affich�
	 * Les JPanel sont stock�s dans un tableau (panels[])
	 * Le numero correspond � leur place dans le tableau
	 */
	public void switchPanel(int numPanel){
		switch (numPanel){
			case 0 : 	panels[0] = new JPanelAccueil(combat, controleur);
						break;
						
			case 1 :	panels[1] = new JPanelChoix(combat, controleur);
						break;
				
			case 2 :	panels[2] = new JPanelCombat(combat, controleur);
						break;
				
			case 3 :	panels[3] = new JPanelAttaques(combat, controleur);
						break;
				
			case 4 :	panels[4] = new JPanelFin(combat, controleur);
						
		}
		this.setContentPane(panels[numPanel]);	
	}	
}

