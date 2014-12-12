package Controller;

import Vue.*;
import Jeu.*;


public class Controleur {
	
	public int getJoueur() {
		return joueur;
	}

	public void setJoueur(int joueur) {
		this.joueur = joueur;
	}

	public int getCreature() {
		return creature;
	}

	public void setCreature(int creature) {
		this.creature = creature;
	}

	private Combat combat;
	private Vue vue;
	private int joueur;
	private int creature;
	
	/**
	 * Utilise switchpanel pour définir le JPanel affiché
	 */
	public void setVue(Vue vue){
		this.vue = vue;
		vue.switchPanel(0);
	}
	
	public Controleur(){
		this.joueur = 0;
		this.creature = 0;
	}

	public Controleur(Combat combat) {	
		this.combat = combat;
	}
	
	public void retour(){
		vue.switchPanel(0);
		joueur=0;
		creature=0;
	}
	
	/**
	 * Démarre le jeu en créant un combat et en affichant le JPanel accueil
	 */
	public void start(){
		combat.creationParticipant();
		vue.switchPanel(1);
	}
	
	public void lan(){
		vue.switchPanel(5);
	}
	
	/**
	 * Permet de remplir les tableaux de créature de chaque joueur
	 * pendant les choix de créature sur le JPanel choix
	 */
	public void creatureChoisie(int choix){
		combat.getJoueurActif().choixCreature(choix, creature);
		creature++;
		
		if (joueur==1 && creature==2) {
			combat.changerJoueur();
			vue.switchPanel(2);
			creature=0;
		}
		
		if (creature == 2){
			combat.changerJoueur();
			creature=0;
			joueur++;
		}
	}
	
	/**
	 * Affiche le JPanelAttaques lorsqu'on clique sur le bouton attaquer
	 */
	public void attaquer(){
		vue.switchPanel(3);
	}
	
	/**
	 * Lance la méthode de repos et finit le tour
	 */
	public void repos(){
		combat.repos();
		combat.changerJoueur();
		vue.switchPanel(2);
	}
	
	/**
	 * Change les créatures et finit le tour
	 */
	public void changerCrea(){
		if (!combat.getJoueurActif().team[1].isKO()) {
			combat.changerCreature(combat.getJoueurActif());
			combat.changerJoueur();
			vue.switchPanel(2);
		}
	} 
	
	/**
	 * Le joueur actif abandonne, donc le joueur passif est indiqué comme gagnant.
	 * Passe sur le JPanel de fin
	 */
	public void abandonner(){
		combat.setGagnant(combat.getJoueurPassif());
		vue.switchPanel(4);
	}
	
	public void attaqueChoisie(int choix){
		combat.setChoixAtk(choix);
		
		if (combat.atkDispo()){
			combat.Attaquer();
			combat.testVieCreature();
			
			if (combat.tousMort) {
				combat.setGagnant(combat.getJoueurActif());
				vue.switchPanel(4);
			}
			
			else {
				combat.changerJoueur();
				vue.switchPanel(2);
			}		
		}
	}

}
