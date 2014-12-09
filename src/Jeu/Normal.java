package Jeu;

public class Normal extends Creature {
	
	public Normal(){
		
		setNom("Bouffalant");
		setType('n');
		
		setImage("Images/normal.gif");
		setImageBack("Images/normalBack.gif");
		
		setAttaque(0,"Charge");
		setAttaque(1,"Coup de corne");
		setAttaque(2,"Renverser");
		setAttaque(3,"Giga impact");
	}
}
