package Jeu;

import static org.junit.Assert.*;

import org.junit.Test;

public class CreatureTest {
	Combat c = new Combat();

	@Test
	public void testSetPv() {
		c.creationParticipant();
		c.getJoueurActif().choixCreature(1, 0);
		assertEquals(100, c.getJoueurActif().getTeam()[0].getPv());
		
		c.getJoueurActif().getTeam()[0].setPv(50);
		assertEquals(50, c.getJoueurActif().getTeam()[0].getPv());
		
		c.getJoueurActif().getTeam()[0].setPv(-15);
		assertEquals(0, c.getJoueurActif().getTeam()[0].getPv());
	}

	@Test
	public void testSetAttaque() {
		c.creationParticipant();
		c.getJoueurActif().choixCreature(1, 0);		
		c.getJoueurActif().getTeam()[0].setAttaque(0, "hahaha");
		assertEquals("hahaha", c.getJoueurActif().getTeam()[0].getAttaques(0));
		
		c.getJoueurActif().getTeam()[0].setAttaque(2, "hehe");
		assertEquals("hehe", c.getJoueurActif().getTeam()[0].getAttaques(2));
		
	}

	@Test
	public void testSetNbAtkDispo() {
		c.creationParticipant();
		c.getJoueurActif().choixCreature(1, 0);
		
		c.getJoueurActif().getTeam()[0].setNbAtkDispo(0, 99);
		assertEquals(99, c.getJoueurActif().getTeam()[0].getNbAtkDispo(0));
	}

	@Test
	public void testIsKO() {
		c.creationParticipant();
		c.getJoueurActif().choixCreature(1, 0);
		assertEquals(false, c.getJoueurActif().getTeam()[0].isKO());
		
		c.getJoueurActif().getTeam()[0].setPv(-15);
		assertEquals(true, c.getJoueurActif().getTeam()[0].isKO());
	}

}
