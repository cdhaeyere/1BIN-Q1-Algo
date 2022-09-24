/*
	@Author: Corentin D'haeyere
 */
public class TableauNonTrieDEntiers {

	private int[] tableDEntiers;
	private int nombreDEntiers; // taille logique
	private static final int TAILLE = 10; // taille physique

	// Les nombreDEntiers entiers occupent les nombreDEntiers premieres cases du tableau!
	// PAS DE TROU!
	// L'ordre des entiers n'a pas d'importance

	public TableauNonTrieDEntiers() {
		this.tableDEntiers = new int[TAILLE];
		this.nombreDEntiers = 0;
	}

	/**
	 * constructeur par recopie ce constructeur leve une exception si la table
	 * passee en parametre contient plus de 10 entiers constructeur utile pour
	 * les tests!!!
	 *
	 * @param tableARecopier
	 */
	public TableauNonTrieDEntiers(int[] tableARecopier) {
		this(tableARecopier, tableARecopier.length);
	}

	public TableauNonTrieDEntiers(int[] tableARecopier, int tailleLogique) {
		if (tableARecopier == null)
			throw new IllegalArgumentException();
		if (tailleLogique > tableARecopier.length || tableARecopier.length > TAILLE)
			throw new IllegalArgumentException();
		this.nombreDEntiers = tailleLogique;
		tableDEntiers = new int[TAILLE];
		for (int i = 0; i < tableARecopier.length; i++) {
			tableDEntiers[i] = tableARecopier[i];
		}
	}

	public int getNombreDEntiers() {
		return this.nombreDEntiers;
	}

	public boolean equals(TableauNonTrieDEntiers t) {
		if (t.nombreDEntiers != this.nombreDEntiers)
			return false;
		for (int i = 0; i < nombreDEntiers; i++)
			if (this.tableDEntiers[i] != t.tableDEntiers[i])
				return false;
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TableauNonTrieDEntiers t = (TableauNonTrieDEntiers) obj;
		return equals(t);
	}

	@Override
	public String toString() {
		String aRenvoyer = "\n nombreDEntiers : " + this.nombreDEntiers;
		aRenvoyer += "   tableDEntiers : ";
		for (int i = 0; i < this.nombreDEntiers; i++) {
			aRenvoyer += this.tableDEntiers[i] + " ";
		}
		return aRenvoyer;
	}

	/**
	 * methode qui ajoute un entier en fin de table si la table n'est pas encore pleine
	 * @param entier l'entier a ajouter
	 * @return boolean signale si l'entier a pu etre ajoute
	 */
	public boolean ajouterUnEntier(int entier) {
		if (nombreDEntiers < TAILLE) {
			tableDEntiers[nombreDEntiers] = entier;
			nombreDEntiers++;
			return true;
		}
		return false;
	}


	/**
	 * methode qui verifie si la table contient l'entier passe en parametre
	 * @param entier l'entier dont on desire tester la presence
	 * @return boolean true si l'entier est present dans la table, false sinon
	 */
	public boolean contient(int entier) {
		for (int tableDEntier : tableDEntiers) {
			if (tableDEntier == entier) {
				return true;
			}
		}
		return false;
	}

	/**
	 * methode qui calcule le nombre d'occurrences de l'entier passe en parametre
	 * @param entier l'entier dont on desire connaitre le nombre d'occurrences
	 * @return le nombre d'occurrences
	 */
	public int nombreOccurrences(int entier){
		int nbrOccurence = 0;
		for (int i = 0; i < nombreDEntiers; i++) {
			if (tableDEntiers[i] == entier) {
				nbrOccurence++;
			}
		}
		return nbrOccurence;
	}

	/**
	 * verifie si l'objet courant contient les memes entiers que celui passe en parametre
	 * le nombre d'occurrences de chaque entier doit etre le meme
	 * l'ordre des entiers est quelconque
	 * Par ex : this = (3,4,3,5,5) autreTable = (4,3,5,3,5) --> true
	 *          this = (3,4,3,5,5) autreTable = (3,4,5) --> false
	 * @param autreTable la table comparee
	 * @return true si les 2 tables ont le meme contenu, false sinon
	 */
	public boolean memeContenu(TableauNonTrieDEntiers autreTable){
		if (nombreDEntiers != autreTable.nombreDEntiers) {
			return false;
		}
		for (int i = 0; i < nombreDEntiers; i++) {
			if (this.nombreOccurrences(tableDEntiers[i]) != autreTable.nombreOccurrences(tableDEntiers[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * methode qui supprime la premiere occurrence d'un entier
	 * @param entier l'entier a supprimer
	 * @return boolean signale si l'entier a pu etre supprime
	 */
	public boolean supprimerLaPremiereOccurrence(int entier) {
		for (int i = 0; i < nombreDEntiers; i++) {
			if (tableDEntiers[i] == entier) {
				tableDEntiers[i--] = tableDEntiers[--nombreDEntiers];
				return true;
			}
		}
		return false;
	}

	/**
	 * methode qui supprime toutes les occurrences d'un entier
	 * @param entier l'entier a supprimer
	 * @return int le nombre de suppressions effectuees
	 */
	public int supprimerToutesLesOccurrences(int entier) {
		int nbrSupp = 0;
		for (int i = 0; i < nombreDEntiers; i++) {
			if (tableDEntiers[i] == entier) {
				tableDEntiers[i--] = tableDEntiers[--nombreDEntiers];
				nbrSupp++;
			}
		}
		return nbrSupp;
	}

	/**
	 * methode qui verifie si la table est triee par ordre croissant
	 * @return boolean true si la table est triee, false sinon
	 */
	public boolean estTrie() {
		boolean estTrie = true;
		for (int i = 0; i < nombreDEntiers-1; i++) {
			if (tableDEntiers[i] > tableDEntiers[i+1]) estTrie = false;
		}
		return estTrie;
	}

	/**
	 * methode qui verifie si la table contient des ex-aequos
	 * @return boolean true si la table contient des ex-aequos, false sinon
	 */
	public boolean contientExAequo() {
		int[] tableDEntiersUniques = tableDEntiers;
		for (int j = 0; j < nombreDEntiers; j++) {
			for (int i = j+1; i < nombreDEntiers; i++) {
				if (tableDEntiers[i] == tableDEntiersUniques[j]) return true;
			}
		}
		return false;
	}

	/**
	 * methode qui supprime tous les ex-aequos.
	 * Notez que cette methode laisse exactement une occurence de chaque entier qui se trouvait dans le tableau initial.
	 * @return int le nombre de suppressions effectuees
	 */
	public int supprimerTousLesExAequos() {
		int nbrSup = 0;
		if (nombreDEntiers > 1) {
			int i = 0;
			while (i < nombreDEntiers) {
				int j = i+1;
				while (j < nombreDEntiers) {
					if (j != i && tableDEntiers[i] == tableDEntiers[j]) {
						nombreDEntiers--;
						tableDEntiers[j] = tableDEntiers[nombreDEntiers];
						nbrSup++;
					}
					else j++;
				}
				i++;
			}
		}
		return nbrSup;
	}
}