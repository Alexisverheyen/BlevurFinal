package Jeu;

import java.util.Arrays;

public class Creature {

	private String nom;
	private int pv;
	private char type;
	private String[] attaques;
	private int[] nbAtkDispo;
	private String Image;
	private String ImageBack;


	public Creature(){
		pv = 100;
		attaques = new String[4];
		nbAtkDispo = new int[]{15, 10, 5, 1};
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPv() {
		return pv;
	}

	/**
	 * Méthode qui modifie la variable d'instance pv.
	 * @param pv
	 */
	public void setPv(int pv) {
		this.pv = pv;
		if (this.pv<0){
			this.pv=0;
		}
	}

	/**
	 * Retourne le type de la créture (eau feu plante normal)
	 */
	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}
	
	/**
	 * Retourne le nom de l'attaque dans en position i
	 * @param i est la position de l'attaque dans le tableau d'attaques
	 * @return
	 */
	public String getAttaques(int i) {
		return attaques[i];
	}
	public void setAttaque(int i, String nom) {
		this.attaques[i] = nom;
	}

	public int getNbAtkDispo(int i) {
		return nbAtkDispo[i];
	}

	public void setNbAtkDispo(int indice, int nbAtkDispo) {
		this.nbAtkDispo[indice] = nbAtkDispo;
	}

	/**
	 * Si plus de pv (pv=0) on prévient que la créature est KO
	 * @return retourne l'état KO ou pas
	 */
	public boolean isKO(){
		if(this.pv==0){
			return true;
		}
		return false;
	}
	
	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getImageBack() {
		return ImageBack;
	}

	public void setImageBack(String imageBack) {
		ImageBack = imageBack;
	}

	@Override
	public String toString() {
		return "Nom=\n" + nom
				+ "\ntype=" + type
				+ "attaques=" + Arrays.toString(attaques);
	}
}
