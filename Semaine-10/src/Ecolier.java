/*
	@Author: Corentin D'haeyere
 */
public class Ecolier {
	
	private String nom;
	private char couleur;
	
	public Ecolier(String nom, char couleur) {
		super();
		if(nom == null||nom.equals(""))
			throw new IllegalArgumentException();
		if(couleur!='n' && couleur!='j' && couleur!='r')
			throw new IllegalArgumentException();
		this.nom = nom;
		this.couleur = couleur;
	}

	public String getNom() {
		return nom;
	}

	public char getCouleur() {
		return couleur;
	}

	@Override
	public String toString() {
		return "[nom=" + nom + ", couleur=" + couleur + "]";
	}
	
	
}
