package Blevur;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import Controller.*;
import Vue.*;
import Jeu.*;


public class Blevur {

	public Blevur() {
		Combat combat = new Combat();
		
		Controleur controleur= new Controleur(combat);
		
		Vue vueBlevur = new Vue(combat, controleur);
		
		controleur.setVue(vueBlevur);
		
		vueBlevur.setVisible(true);
	}
		
	public Blevur(String a){ 
		Sound player = new Sound(a);
	    InputStream stream = new ByteArrayInputStream(player.getSamples()); 
	    player.play(stream);
	}
		
	public static void main(String[] args){
		// Create two threads:
		Thread thread1 = new Thread() {
		    public void run() {
		        new Blevur();
		    }
		};

		Thread thread2 = new Thread() {
		    public void run() {
		        new Blevur("Sound/a.wav");
		    }
		};

		// Start the downloads.
		thread1.start();
		thread2.start();
	}
}