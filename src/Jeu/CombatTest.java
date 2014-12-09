package Jeu;

import static org.junit.Assert.*;

import org.junit.Test;

public class CombatTest {
	Combat c = new Combat();
	

	@Test
	public void testCreationParticipant() {
		c.creationParticipant();
		assertEquals("Joueur1", c.getJoueurActif().getJnom());
		assertEquals("Joueur2", c.getJoueurPassif().getJnom());
	}

	@Test
	public void testTestVieCreature() {
		c.creationParticipant();
		c.getJoueurActif().choixCreature(1, 0);
		assertEquals(100, c.getJoueurActif().getTeam()[0].getPv());
		
		c.getJoueurActif().getTeam()[0].setPv(78);
		assertEquals(78, c.getJoueurActif().getTeam()[0].getPv());
		
		c.getJoueurActif().getTeam()[0].setPv(-15);
		assertEquals(0, c.getJoueurActif().getTeam()[0].getPv());
	}

	@Test
	public void testRepos() {
		c.creationParticipant();
		c.getJoueurActif().choixCreature(1, 0);
		c.repos();
		assertEquals(100, c.getJoueurActif().getTeam()[0].getPv());
		
		c.getJoueurActif().getTeam()[0].setPv(25);
		c.repos();
		assertEquals(50, c.getJoueurActif().getTeam()[0].getPv());
		
	}

	@Test
	public void testChangerCreature() {
		c.creationParticipant();
		c.getJoueurActif().choixCreature(1, 0);
		c.getJoueurActif().choixCreature(2, 1);
		c.changerCreature(c.getJoueurActif());
		
		assertEquals("Emboar", c.getJoueurActif().getTeam()[0].getNom());
		assertEquals("Seismitoad", c.getJoueurActif().getTeam()[1].getNom());
	}

	@Test
	public void testChangerJoueur() {
		c.creationParticipant();
		c.changerJoueur();
		
		assertEquals("Joueur2", c.getJoueurActif().getJnom());
		assertEquals("Joueur1", c.getJoueurPassif().getJnom());
	}

	@Test
	public void testTestTousMort() {
		c.creationParticipant();
		c.getJoueurActif().choixCreature(1, 0);
		c.getJoueurActif().choixCreature(2, 1);
		c.getJoueurPassif().choixCreature(1, 0);
		c.getJoueurPassif().choixCreature(2, 1);
		
		c.getJoueurActif().getTeam()[0].setPv(78);
		c.getJoueurActif().getTeam()[1].setPv(0);
		c.getJoueurPassif().getTeam()[0].setPv(0);
		c.getJoueurPassif().getTeam()[1].setPv(0);
		c.changerJoueur();
		assertFalse(c.testTousMort());
		
		c.getJoueurActif().getTeam()[0].setPv(0);
		c.getJoueurActif().getTeam()[1].setPv(0);
		c.changerJoueur();
		assertTrue(c.testTousMort());
	}

	@Test
	public void testAtkDispo() {
		c.creationParticipant();
		c.getJoueurActif().choixCreature(1, 0);
		c.setChoixAtk(1);
		assertTrue(c.atkDispo());
		c.getJoueurActif().getTeam()[0].setNbAtkDispo(0, 0);
		assertFalse(c.atkDispo());

	}

	@Test
	public void testMoinsPP() {
		c.creationParticipant();
		c.getJoueurActif().choixCreature(1, 0);
		c.setChoixAtk(1);
		
		assertEquals(15, c.getJoueurActif().getTeam()[0].getNbAtkDispo(0));
		
		c.moinsPP();
		assertEquals(14, c.getJoueurActif().getTeam()[0].getNbAtkDispo(0));
	}
	
	@Test
	public void testCalcDmg() {
		c.creationParticipant();
		c.getJoueurActif().choixCreature(1, 0);
		c.getJoueurPassif().choixCreature(1, 0);
		c.setChoixAtk(1);
		c.calcDmg();
		assertEquals(true, c.getDamage()>5 &&  c.getDamage()<=16);

		c.setChoixAtk(4);
		c.calcDmg();
		assertEquals(true, c.getDamage()>45 &&  c.getDamage()<=56);
		
	}

}
