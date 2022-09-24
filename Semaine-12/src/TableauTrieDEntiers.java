/*
    @Author: Corentin D'haeyere
 */
public class TableauTrieDEntiers{

	private int [] tableDEntiers;  // table d'entiers triee par ordre croissant
	private int nombreDEntiers;    // nombre d'entiers dans tableDEntiers
	private static final int TAILLE = 10;

	public TableauTrieDEntiers(){
		this.tableDEntiers = new int[TAILLE];
		this.nombreDEntiers = 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TableauTrieDEntiers t = (TableauTrieDEntiers)obj;
		if (t.nombreDEntiers!=this.nombreDEntiers)
			return false;
		for (int i = 0; i < nombreDEntiers;i++)		
			if (this.tableDEntiers[i]!=t.tableDEntiers[i]) 
				return false;
		return true;
	}
	
	
	public String toString(){
		String aRenvoyer = "\n nombreDEntiers : " + this.nombreDEntiers;
		aRenvoyer += "   tableDEntiers : ";
		for (int i = 0; i < this.nombreDEntiers; i++) {
			aRenvoyer += this.tableDEntiers[i]+" ";
		}
		return aRenvoyer;
	}
	
	/**
	 * constructeur par recopie
	 * ce constructeur leve une exception si la table passee en parametre contient plus de 10 entiers
	 * utile pour les tests et/ou si elle n'est pas triee
	 * @param tableARecopier une table triee d'au plus TAILLE entiers triee par ordre croissant
	 */

	public TableauTrieDEntiers(int[] tableARecopier){
		if (tableARecopier.length>TAILLE) 
			throw new IllegalArgumentException();
		this.nombreDEntiers = tableARecopier.length;
		tableDEntiers= new int[TAILLE];
		if(tableARecopier.length!=0)
			tableDEntiers[0] = tableARecopier[0];
		for (int i = 1; i<nombreDEntiers; i++){
			if(tableARecopier[i]<tableARecopier[i-1]){
				throw new IllegalArgumentException();
			}
			tableDEntiers[i] = tableARecopier[i];
		}     	
	}

	public int getNombreDEntiers(){
		return this.nombreDEntiers;
	}


	/** 
	 * methode qui ajoute un entier si la table n'est pas encore pleine.
	 * La table doit rester triee!
	 * @param entier l'entier a ajouter
	 * @return boolean signale si l'entier a pu etre ajoute
	 */

	public boolean ajouterUnEntier(int entier){

		// CONTRAINTE : UTILISER L ALGORITHME D INSERTION DANS UNE TABLE TRIEE VU AU COURS
		// ou une variante plus efficace : il n'est pas indispensable de faire des permutations
		// de simples decalages suffisent
		// Dans l'algorithme vu au cours, l'element ajoute est deplace d'une case à la fois
		// jusqu'a sa place, alors qu'il pourrait etre deplace en une fois apres avoir fait les decalages
		// necessaires
		// A REFLECHIR !

		// Si cela ne va pas, revoyez le diaporama AnimationInsertionDansUneTableTriee
		// et/ou refaites le test moovin classe Participants V3

		if(nombreDEntiers == tableDEntiers.length) {
			return false;
		}

		int i = nombreDEntiers-1;
		while(i>=0 && tableDEntiers[i] > entier) {
			tableDEntiers[i+1] = tableDEntiers[i];
			i--;
		}
		tableDEntiers[i+1] = entier;
		nombreDEntiers++;
		return true;
	}

	
	/**
	 * methode qui recherche l'indice correspondant a la premiere occurrence de l'entier passe en parametre
	 * @param entier l'entier recherche
	 * @return indice correspondant a l'entier, -1 s'il n'est pas dans la table
	 */
	private int trouverIndiceLineaire(int entier){
		for (int i = 0; i < nombreDEntiers; i++) {
			if (tableDEntiers[i] == entier) {
				return i;
			}
		}
		return -1;
	}

	
	/**
	 * methode qui recherche l'indice correspondant a une occurrence (pas necessairement la premiere)
	 * de l'entier passe en parametre
	 * @param entier l'entier recherche
	 * @return indice correspondant a unEntier, -1 s'il n'est pas dans la table
	 */
	private int trouverIndiceDicho(int entier){
		
		//recherche dichotomique cout O(logN)

		// Dans un premier temps, passez cette methode difficile
		// Pour tester cette methode, utilisez cette methode dans la methode contient()

		// Si cela ne va pas, refaites la demo su site
		// https://www.infoforall.fr/art/algo/animation-de-la-recherche-dichotomique/
		// et/ou refaites le test moovin recherche dichotomique

		int indiceMin = 0;
		int indiceMax = nombreDEntiers-1;
		while (indiceMin <= indiceMax){
			int indiceMilieu = (indiceMin + indiceMax)/2;
			if (tableDEntiers[indiceMilieu] == entier) return indiceMilieu;
			if (tableDEntiers[indiceMilieu] > entier) indiceMax = indiceMilieu-1;
			else indiceMin = indiceMilieu+1;
		}
		return -1;
	}

	/** 
	 * methode qui verifie si la table contient l'entier passe en parametre
	 * @param entier l'entier recherche
	 * @return boolean true si l'entier est present dans la table, false sinon
	 */
	public boolean contient(int entier){

		// UTILISER LA METHODE trouverIndiceLineaire() donnee
		// OU (de preference) LA METHODE trouverIndiceDicho() une fois celle-ci ecrite
		return trouverIndiceLineaire(entier) != -1;
	}  

	
	/** 
	 * methode qui supprime une occurrence de l'entier passe en parametre.
	 * La table doit rester triee!
	 * @param entier l'entier a supprimer
	 * @return boolean signale si l'entier a pu etre supprime
	 */
	public boolean supprimerUneOccurrence(int entier){

		// UTILISER LA METHODE trouverIndiceLineaire() donnee
		// OU (de preference) LA METHODE trouverIndiceDicho() une fois celle-ci ecrite
		if (trouverIndiceDicho(entier) != -1) {
			int pos = trouverIndiceLineaire(entier);
			for(int i = pos; i<nombreDEntiers-1; i++) {
				tableDEntiers[i] = tableDEntiers[i+1];
			}
			nombreDEntiers--;
			return true;
		}
		return false;
	} 

	
	/** 
	 * methode qui supprime toutes les occurrences d'un entier
	 * @param entier l'entier a supprimer
	 * @return int le nombre de suppressions effectuees
	 */
	public int supprimerToutesLesOccurrences(int entier){

		// UTILISER LA METHODE trouverIndiceLineaire() donnee.
		// Il est possible d'ecrire cette methode en un seul passage dans la boucle
		// Inspirez vous de la solution de la methode supprimerTousLesParticipants()
		// qui vous a ete donnee au cours theorique de la semaine derniere
		// Cette solution se trouve sur moovin !

		// DEFI!!! : UTILISER une recherche dichotomique - cfr fiche d'exercices

		int nombreOcuSup = 0;
		int nombreOcuASup = 0;
		for(int i=0; i<nombreDEntiers; i++) {
			if(tableDEntiers[i] == entier) {
				nombreOcuASup++;
			}else {
				tableDEntiers[i-nombreOcuASup] = tableDEntiers[i];
			}
		}
		nombreDEntiers = nombreDEntiers - nombreOcuASup;
		nombreOcuSup = nombreOcuASup;
		return nombreOcuSup;

	}

	
	/** 
	 * methode qui verifie si la table contient des ex-aequos
	 * @return boolean true si la table contient des ex-aequos, false sinon
	 */
	public boolean contientExAequo(){
		for(int i=0; i<nombreDEntiers-1; i++) {
			if(tableDEntiers[i] == tableDEntiers[i+1])
				return true;
		}
		return false;

		//Cette methode peut s'ecrire en O(N)
		// N'oubliez pas que la table est triee!

	}

	
	/** 
	 * methode qui supprime tous les ex-aequos
	 * @return int le nombre de suppressions effectuees
	 */
	public int supprimerTousLesExAequos(){
		int nombreExSupp = 0;
		int nombreExASupp = 0;
		for(int i=1; i<nombreDEntiers; i++) {
			if(tableDEntiers[i] == tableDEntiers[i-1]) {
				nombreExASupp++;
			}else {
				tableDEntiers[i-nombreExASupp] = tableDEntiers[i];
			}
		}
		nombreExSupp = nombreExASupp;
		nombreDEntiers = nombreDEntiers - nombreExASupp;
		return nombreExSupp;

		// Il est possible d'ecrire cette methode en un seul passage dans la boucle
		// Inspirez vous de la solution de la methode supprimerTousLesParticipants()
		// qui vous a ete donnee au cours theorique de la semaine derniere
		// Cette solution se trouve sur moovin !

	}

	/**
	 * supprime tous les entiers compris entre borneInf et borneSup (bornes comprises)
	 * si borneInf est > que borneSup, il faut inverser les bornes
	 * @param borneInf l'entier le plus petit a supprimer
	 * @param borneSup l'entier le plus grand a supprimer
	 * @return le nombre de suppressions effectuees
	 */
	public int supprimerEntre(int borneInf, int borneSup) {
		int nombreDeSupp = 0;
		int nombreDElementASupp = 0;
		for(int i=0; i<nombreDEntiers; i++) {
			if(tableDEntiers[i] >= borneInf && tableDEntiers[i] <= borneSup) {
				nombreDElementASupp++;
			}else {
				tableDEntiers[i-nombreDElementASupp] = tableDEntiers[i];
			}
		}
		nombreDeSupp = nombreDElementASupp;
		nombreDEntiers = nombreDEntiers - nombreDElementASupp;
		return nombreDeSupp;
		//ex supplementaire
		//essayez de faire cet exercice apres avoir termine tous les exercices obligatoires
	}

}