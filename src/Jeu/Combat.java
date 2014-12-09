package Jeu;

import java.util.*;

public class Combat {

	private Joueur[] tabJoueurs;
	private Joueur joueurActif;
	private Joueur joueurPassif;
	private int choixAtk;
	private int damage;
	private Joueur gagnant;
	public boolean abandon;
	public boolean tousMort;
	
	public Combat(){
		abandon = false;
		tousMort = false;
	}

	public void setChoixAtk(int choixAtk) {
		this.choixAtk = choixAtk;
	}

	/**
	 * Crée 2 participants, leur nom leur est automatiquement attribué
	 */
	public void creationParticipant(){
		tabJoueurs = new Joueur[2];
		tabJoueurs[0] = new Joueur("Joueur1");
		tabJoueurs[1] = new Joueur("Joueur2");
		joueurActif = tabJoueurs[0];
		joueurPassif = tabJoueurs[1];
	}
	
	/**
	 * Si une créature a 0 pv, change avec l'autre
	 */
	public void testVieCreature(){
		if (joueurPassif.team[0].getPv()==0) changerCreature(joueurPassif);
		tousMort = testTousMort();
	}

	/**
	 * Attribue le statut de gagnant a un joueur
	 */
	public void setGagnant(Joueur joueur){
		gagnant=joueur;
	}
	
	public Joueur gagnant() {
		return gagnant;
	}
	
	/**
	 * Retourne le joueur actif, donc en place 0
	 */
	public Joueur getJoueurActif() {
		return joueurActif;
	}
	
	/**
	 * Retourne le joueur passif, donc en place 1
	 */
	public Joueur getJoueurPassif() {
		return joueurPassif;
	}

	/**
	 * Retourne true si le joueur clique sur le bouton abandonner
	 */
	public boolean abandonner(){
		return true;
	}

	/**
	 * Ajoute 25pv a la créature, maximum 100pv
	 */
	public void repos() {
		getJoueurActif().getTeam()[0].setPv(getJoueurActif().getTeam()[0].getPv()+25);
		
		if (getJoueurActif().getTeam()[0].getPv() > 100) getJoueurActif().getTeam()[0].setPv(100);
	}
	
	/**
	 * Execute le swapcreature pour le joueur donné
	 * @param j est le joueur à rentrer en paramètre
	 */
	public void changerCreature(Joueur j) {
		j.swapCreature();
	}
	
	/**
	 * En fonction de l'attaque choisie, lui retire une utilisation
	 * @param choix est l'attaque à rentrer en paramètre
	 */
	public void Attaquer(){
			moinsPP();
			calcDmg();
			getJoueurPassif().getTeam()[0].setPv(getJoueurPassif().getTeam()[0].getPv()-getDamage());
	}
	
	/**
	 * Intervertit les 2 joueurs pour que le joueur passif passe en joueur actif
	 */
	public void changerJoueur(){
		Joueur tmp;
		tmp=tabJoueurs[0];
		tabJoueurs[0]=tabJoueurs[1];
		tabJoueurs[1]=tmp;
		joueurActif = tabJoueurs[0];
		joueurPassif = tabJoueurs[1];
	}

	/**
	 * Si les deux créatures sont mortes, renvoie true
	 */
	public boolean testTousMort(){
		if (getJoueurPassif().getTeam()[0].getPv()==0 && getJoueurPassif().getTeam()[1].getPv()==0) return true;
		else return false;
	}
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	/**
	 * Si la créature est en position de faiblesse, réduit les dégats
	 */
	public void atkFaible(){
		setDamage(getDamage()-5);
	}
	/**
	 * Si la créature est en position de force, augmente les dégats
	 */
	public void atkFort(){
		setDamage(getDamage()+5);
	}

	/**
	 * Si le nombre d'utilisations de l'attaque est supérieure à 0, renvoie true
	 */
	public boolean atkDispo(){
		if (getJoueurActif().getTeam()[0].getNbAtkDispo(choixAtk-1)>0) return true;
		else {
			return false;
		}
	}
	
	/**
	 * Retire une utilisation à l'attaque
	 */
	public void moinsPP(){
		getJoueurActif().getTeam()[0].setNbAtkDispo(choixAtk-1, getJoueurActif().getTeam()[0].getNbAtkDispo(choixAtk-1)-1);
	}
	
	/**
	 * Random un nombre entre la valeur min et la valeur max
	 * @param min est la valeur minimum
	 * @param max est la valeur maximum
	 * @return retourne le nombre
	 */
	public int randInt(int min, int max){
		Random rand = new Random();
		int random = rand.nextInt((max - min) +1) + min;
		return random;
	}

	/**
	 * Random un nombre pour l'attaque choisie, puis calcule si atkFort ou atkFaible
	 */
	public void calcDmg(){
		switch(choixAtk){
		case 1:
			setDamage(randInt(5,15));
			break;

		case 2:
			setDamage(randInt(10,30));
			break;

		case 3:
			setDamage(randInt(20,40));
			break;

		case 4:
			setDamage(randInt(30,60));
			break;
	}

		switch(getJoueurActif().getTeam()[0].getType()){
		case 'e':
			if(getJoueurPassif().getTeam()[0].getType()=='f'){			//L'eau est fort contre le feu
				atkFort();
			}
			else if(getJoueurPassif().getTeam()[0].getType()=='p'){ 	//L'eau est faible contre la plante
				atkFaible();
			}
			break;
		case 'f':
			if(getJoueurPassif().getTeam()[0].getType()=='p'){ 			//Le feu est fort contre la plante
				atkFort();
			}
			else if(getJoueurPassif().getTeam()[0].getType()=='e'){		//Le feu est faible contre l'eau
				atkFaible();
			}
			break;
		case 'p':
			if(getJoueurPassif().getTeam()[0].getType()=='e'){ 			//La plante est forte contre l'eau
				atkFort(); 
			}
			else if(getJoueurPassif().getTeam()[0].getType()=='f'){ 	//La plante est faible contre le feu
				atkFaible();
			}
			break;
		}
	}
}
