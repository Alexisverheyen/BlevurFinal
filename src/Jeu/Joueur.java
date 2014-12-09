package Jeu;

import java.util.Arrays;

public class Joueur {

	private String Jnom;
	public Creature[] team = new Creature[2];
	Combat combat;
	int choix;
	
	public Joueur(){
		team = new Creature[2];
	}
	
	/**
	 * Au moment de la création du joueur, on lui donne directement un nom
	 * @param name est le nom entré en paramètre qu'on va donner au joueur
	 */
	public Joueur(String name){
		setJnom(name);
	}

	public void setTeam(Creature[] team) {
		this.team = team;
	}

	public Creature[] getTeam() {
		return team;
	}

	public String getJnom() {
		return Jnom;
	}

	public void setJnom(String jnom) {
		Jnom = jnom;
	}

	/**
	 * Crée une nouvelle créature dans le tableau du joueur, en place i
	 * @param choix est le numero associé au bouton CHOISI cliqué
	 * @param i est la position dans le tableau de créatures du joueur
	 */
	public void choixCreature(int choix, int i){
		switch(choix){
		case 1:
			this.team[i]= new Eau();
			break;
		case 2:
			this.team[i]= new Feu();
			break;
		case 3:
			this.team[i]= new Plante();
			break;
		case 4:
			this.team[i]= new Normal();
			break;
		}
	}
	
	/**
	 * Intervertit les deux créatures du joueur, pour que la créature passive
	 * passe en créature active
	 */
	public void swapCreature(){
		Creature temp;
		temp=team[0];
		team[0]=team[1];
		team[1]=temp;	
	}
}
