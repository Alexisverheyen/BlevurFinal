package Jeu;

public class Plante extends Creature {

	public Plante(){

		setNom("Torterra");
		setType('p');
		
		setImage("Images/plante.gif");
		setImageBack("Images/planteBack.gif");

		setAttaque(0,"Charge");
		setAttaque(1,"Lancé de graines");
		setAttaque(2,"Tranch'herbe");
		setAttaque(3,"Tremblement de terre");
	}
}
