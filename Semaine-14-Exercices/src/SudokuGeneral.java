/**
 * Represente une grille de Sudoku d'une taille (presque) quelconque
 * 
 * @author Corentin D'haeyere
 *
 */
public class SudokuGeneral {
	
	private int tailleCote;
	private int tailleRegion;
	private int [] [] grille;
	
	/**
	 * Constructeur utilise pour les tests.
	 * prend la reference de la table passee en parametre
	 * Il deduit egalement la taille des cotes du carre ainsi que la
	 * taille des cotes des regions.
	 * Notez que la taille des cotes correspond au nombre de symboles
	 * differents que l'on utilise dans la grille
	 * 
	 * NE PAS MODIFIER, utilise pour les tests
	 * 
	 * @param grille grille qui sera recopiee.
	 * 
	 * Preconditions: le tableau grille doit etre un carre et la racine carree
	 * de la taille du cote doit etre un nombre entier (ex: 9, 16, 25, 36, ...)
	 * Ce constructeur ne verifie pas ces preconditions, on suppose qu'elles sont correctes.
	 */
	public SudokuGeneral(int[][] grille) {
		this.tailleCote = grille.length; 
		this.tailleRegion = (int)Math.sqrt(tailleCote);
		this.grille = grille;
	}
	
	
	/**
	 * Verifie que si l'on met le nombre 'nombre' a la position i, j
	 * La grille de sudoku reste legale. 
	 * Cela doit se faire sans parcourir toute la grille!
	 * 
	 * @param i ligne du coup. Les lignes sont numerotees a partir de 0
	 * @param j colonne du coup. Les colonnes sont numerotees a partir de 0
	 * @param nombre nombre que l'on veut placer dans la grille
	 * @return true si le coup est legal (voir enonce), false sinon
	 */
	public boolean isCoupLegal(int i, int j, int nombre) {
		
		// Verifie que la ligne ne contient pas deja le nombre 
		if (isNombreDansLigne(i, nombre))
			return false;
		
		// Verifie que la colonne j ne contient pas deja le nombre 
		if(isNombreDansColonne(j, nombre))
			return false;
		
		// Verifie que la region ne contient pas le nombre
		
		// Trouver le coin superieur gauche de la region
		int coinI = (i/tailleRegion)*tailleRegion;
		int coinJ = (j/tailleRegion)*tailleRegion; // Division entiere ex (4/3)*3 = 3
				
		if (isNombreDansRegion(nombre, coinI, coinJ))
			return false;
		
		return true;
	}

	/**
	 * Verifie si le nombre 'nombre' est present dans la region dont le
	 * coin superieur gauche se trouve a la position coinI, coinJ
	 * Vous ne devez pas verifier que coinI et coinJ sont valides.
	 * @param nombre
	 * @param coinI numero de ligne du coin superieur gauche de la region
	 * @param coinJ numero de colonne du coin superieur gauche de la region
	 * @return true si le nombre est dans la region
	 */
	private boolean isNombreDansRegion(int nombre, int coinI, int coinJ) {
		for (int j = coinI; j < tailleRegion+coinI; j++) {
			for (int i = coinJ; i < tailleRegion+coinJ; i++) {
				if (grille[j][i] == nombre) return true;
			}
		}
		return false;
	}

	/**
	 * Verifie si le nombre 'nombre' est present dans la colonne numero j
	 * Vous ne devez pas verifier que j est valide
	 * @param j
	 * @param nombre
	 * @return true si le nombre est present
	 */
	private boolean isNombreDansColonne(int j, int nombre) {
		for (int i = 0; i < tailleCote; i++) {
			if (nombre == grille[i][j]) return true;
		}
		return false;
	}

	/**
	 * Verifie si le nombre 'nombre' est present dans la ligne numero i
	 * Vous ne devez pas verifier que i est valide
	 * @param i
	 * @param nombre
	 * @return true si le nombre est present
	 */
	private boolean isNombreDansLigne(int i, int nombre) {
		for (int j = 0; j < tailleCote; j++) {
			if (grille[i][j] == nombre) return true;
		}
		return false;
	}
	
	/**
	 * Renvoie le chiffre different de 0 le plus present au sein de la grille.
	 * S'il n'y a que des 0 dans la grille, on renvoie un zero.
	 * En cas d'ex aequo, on renvoie n'importe lequel des vainqueurs.
	 * @return
	 */
	public int nombreLePlusPresent() {
		int[] entiers = new int[grille.length + 1];
		for (int i = 0; i < tailleCote; i++) {
			for (int j = 0; j < tailleCote; j++) {
				if (grille[i][j] != 0) entiers[grille[i][j]]+=1;
			}
		}
		int index = 0;
		for (int i = 0; i < grille.length; i++) {
			if (entiers[i] > entiers[index]) index = i;
		}
		return index;
	}
}
