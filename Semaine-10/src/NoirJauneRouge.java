/*
	@Author: Corentin D'haeyere
 */
public class NoirJauneRouge {
	
	private Ecolier[] tableTriee;   // table triee d'abord les noirs puis les jaunes puis les rouges
										// Pas de doublons
	private int nombreNoirs;
	private int nombreJaunes;
	private int nombreRouges;
	private static final int NOMBRE_MAX_ECOLIERS = 10;
	
	
	public NoirJauneRouge(){
		this.tableTriee = new Ecolier[NOMBRE_MAX_ECOLIERS];
		this.nombreNoirs = 0;
		this.nombreJaunes = 0;
		this.nombreRouges = 0;
	}
	
	// A NE PAS MODIFIER
	// VA SERVIR POUR LES TESTS
	public NoirJauneRouge(Ecolier[] tableARecopier, int nombreNoirs, int nombreJaunes, int nombreRouges) {
		this.tableTriee = new Ecolier[NOMBRE_MAX_ECOLIERS];
		for (int i = 0; i < tableARecopier.length; i++) {
			tableTriee[i]=tableARecopier[i];
		}
		this.nombreNoirs = nombreNoirs;
		this.nombreJaunes = nombreJaunes;
		this.nombreRouges = nombreRouges;
	}	
	

	// A NE PAS MODIFIER
	// VA SERVIR POUR LES TESTS
	public String toString() {
		String aRenvoyer="";
		for (int i = 0; i < nombreEcoliers(); i++) {
			aRenvoyer += "\n" + tableTriee[i];
		}
		return aRenvoyer;
	}
	

	/**
	 * determine le nombre d ecoliers contenu dans la table
	 * @return le nombre d ecoliers
	 */
	public int nombreEcoliers(){
		return nombreNoirs + nombreJaunes + nombreRouges;
	}
	
	
	public int getNombreNoirs() {
		return nombreNoirs;
	}	

	
	public int getNombreJaunes() {
		return nombreJaunes;
	}
	
	
	public int getNombreRouges() {
		return nombreRouges;
	}

	
	
	
	/**
	 * recherche l ecolier dont le nom est passe en parametre
	 * @param nom le nom de l ecolier recherche
	 * @return l'indice de la table de l ecolier recherche ou -1 si la table ne contient pas ce nom
	 */
	private int trouverIndiceEcolier(String nom){
		
		if(nom == null)
			throw new IllegalArgumentException();
		for (int i = 0; i < nombreEcoliers(); i++) {
			if(tableTriee[i].getNom().equals(nom))
				return i;
		}
		return -1;
		
	}

	/**
	 * ajoute l ecolier, s'il n'y a pas d ecolier avec ce nom et si le nombre max d ecoliers n'est pas atteint
	 * @param nom
	 * @return true si l'ajout a pu etre fait, false sinon
	 */
	public boolean ajouter(String nom, char couleur){
		
		if(nom == null||nom.equals(""))
			throw new IllegalArgumentException();
		
		if(couleur!='n' && couleur!='j' && couleur!='r')
			throw new IllegalArgumentException();
		
		// Pensez a utiliser la methode trouverIndiceEcolier() donnee ci-dessus
		
		// CONTRAINTE :
		// Utilisez l'algorithme d'ajout IMPOSE.
		// Celui-ci est explique dans le document DrapeauBelge

		Ecolier ecolier = new Ecolier(nom, couleur);

		if (trouverIndiceEcolier(nom) == -1) {
			switch (couleur) {
				case 'n':
					Ecolier ecolier2 = tableTriee[NOMBRE_MAX_ECOLIERS-1-nombreRouges];
					Ecolier ecolier3 = tableTriee[NOMBRE_MAX_ECOLIERS-1-nombreRouges-nombreJaunes];
					tableTriee[NOMBRE_MAX_ECOLIERS-1-nombreRouges-nombreJaunes] = ecolier;
					tableTriee[NOMBRE_MAX_ECOLIERS-1-nombreRouges] = ecolier3;
					tableTriee[NOMBRE_MAX_ECOLIERS-1] = ecolier2;
					nombreNoirs++;
					break;
				case 'j':
					Ecolier ecolier1 = tableTriee[NOMBRE_MAX_ECOLIERS-1-nombreRouges];
					tableTriee[NOMBRE_MAX_ECOLIERS-1-nombreRouges] = ecolier;
					tableTriee[NOMBRE_MAX_ECOLIERS-1] = ecolier1;
					nombreJaunes++;
					break;
				case 'r':
					tableTriee[NOMBRE_MAX_ECOLIERS-1] = ecolier;
					nombreRouges++;
					break;
				default:
					break;
			}
			return true;
		}
		return false;
		
		
	}

	/**
	 * supprime l ecolier dont le nom est passe en parametre
	 * @param nom le nom de l ecolier a supprimer
	 * @return true si l ecolier a ete supprime, false sinon
	 */
	public boolean supprimer(String nom){
		
		if(nom == null||nom.equals(""))
			throw new IllegalArgumentException();

		int indiceEcolier = trouverIndiceEcolier(nom);
		if (indiceEcolier == -1) {
			return false;
		}
		switch (tableTriee[indiceEcolier].getCouleur()) {
			case 'r':
				tableTriee[indiceEcolier] = tableTriee[nombreEcoliers() -1];
				nombreRouges--;
				break;
			case 'j':
				tableTriee[indiceEcolier] = tableTriee[nombreNoirs + nombreJaunes -1];
				tableTriee[nombreNoirs + nombreJaunes -1] = tableTriee[nombreEcoliers() -1];
				nombreJaunes--;
				break;
			case 'n':
				tableTriee[indiceEcolier] = tableTriee[nombreNoirs-1];
				tableTriee[nombreNoirs -1] = tableTriee[nombreNoirs + nombreJaunes -1];
				tableTriee[nombreNoirs + nombreJaunes -1] = tableTriee[nombreEcoliers()-1];
				nombreNoirs--;
				break;
			default:
				break;
		}
		return true;
	}
}
