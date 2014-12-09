package Jeu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;

public class Eau extends Creature{

	public Eau(){
		
		setNom("Seismitoad");
		setType('e');
		
		setImage("Images/eau.gif");
		setImageBack("Images/eauBack.gif");

		setAttaque(0,"Charge");
		setAttaque(1,"Coup de boue");
		setAttaque(2,"Eau boueuse");
		setAttaque(3,"Hydrocanon");
	}	
}
