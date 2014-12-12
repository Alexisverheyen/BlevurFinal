package Jeu;

import static org.junit.Assert.*;

import org.junit.Test;

public class JoueurTest {
	Combat c = new Combat();
	
	@Test
	public void testChoixCreature() {
		c.creationParticipant();
		c.getJoueurActif().choixCreature(1, 0);
		c.getJoueurActif().choixCreature(4, 1);
		
		assertEquals("Seismitoad", c.getJoueurActif().getTeam()[0].getNom());
		assertEquals("Bouffalant", c.getJoueurActif().getTeam()[1].getNom());
	}

	@Test
	public void testSwapCreature() {
		c.creationParticipant();
		c.getJoueurActif().choixCreature(1, 0);
		c.getJoueurActif().choixCreature(4, 1);
		
		c.getJoueurActif().swapCreature();
		assertEquals("Bouffalant", c.getJoueurActif().getTeam()[0].getNom());
		assertEquals("Seismitoad", c.getJoueurActif().getTeam()[1].getNom());
	}

}
