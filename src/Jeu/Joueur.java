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
	 * Au moment de la cr�ation du joueur, on lui donne directement un nom
	 * @param name est le nom entr� en param�tre qu'on va donner au joueur
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
	 * Cr�e une nouvelle cr�ature dans le tableau du joueur, en place i
	 * @param choix est le numero associ� au bouton CHOISI cliqu�
	 * @param i est la position dans le tableau de cr�atures du joueur
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
	 * Intervertit les deux cr�atures du joueur, pour que la cr�ature passive
	 * passe en cr�ature active
	 */
	public void swapCreature(){
		Creature temp;
		temp=team[0];
		team[0]=team[1];
		team[1]=temp;	
	}
}
