package Jeu;

public class Feu extends Creature {
	
	public Feu(){
		
		setNom("Emboar");
		setType('f');
		
		setImage("Images/feu.gif");
		setImageBack("Images/feuBack.gif");

		setAttaque(0,"Charge");
		setAttaque(1,"Charbon ardent");
		setAttaque(2,"Choc de chaleur");
		setAttaque(3,"Lance flammes");		
	}
}
