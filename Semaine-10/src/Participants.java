/*
	@Author: Corentin D'haeyere
 */
public class Participants {
	private String[] tableParticipants;
	private int nombreInscrits = 4; 	// taille logique
	private int nombreMaxParticipants;

	// Les nombreInscrits participants occupent les nombreInscrits premieres
	// cases du tableau!

	public Participants(int nombreMaxParticipants) {
		this.nombreMaxParticipants = nombreMaxParticipants;
		if (nombreMaxParticipants < 1)
			throw new IllegalArgumentException();
		this.tableParticipants = new String[nombreMaxParticipants];

		this.nombreInscrits = 0;
	}

	/**
	 * Construit un objet Participants en copiant tous les participants a partir
	 * de la table passee en parametre.
	 * 
	 * @param tableARecopier
	 *            table contenant les participants a ajouter
	 */
	public Participants(int nombreParticipants, String[] tableARecopier) {
		// A NE PAS MODIFIER
		// VA SERVIR POUR LES TESTS
		if (tableARecopier == null)
			throw new IllegalArgumentException();
		if (nombreParticipants < 1)
			throw new IllegalArgumentException();
		if (nombreParticipants < tableARecopier.length)
			throw new IllegalArgumentException();
		this.tableParticipants = new String[nombreParticipants];
		this.nombreInscrits = tableARecopier.length;
		for (int i = 0; i < nombreInscrits; i++)
			this.tableParticipants[i] = tableARecopier[i];
	}

	public String toString() {
		// A NE PAS MODIFIER
		// VA SERVIR POUR LES TESTS
		if (this.nombreInscrits == 0)
			return "aucun inscrit";
		String aRenvoyer = "\nLes inscrits :";
		for (int i = 0; i < nombreInscrits; i++)
			aRenvoyer = aRenvoyer + "\n    " + this.tableParticipants[i];
		return aRenvoyer;
	}

	/**
	 * renvoie le nombre de participants actuellement inscrits
	 * @return le nombre de participants actuellement inscrits
	 */
	public int getNombreInscrits() {
		return this.nombreInscrits;
	}

	/**
	 * ajoute un participant a la table des participants. On peut retrouver
	 * plusieurs fois le meme nom.
	 * @param participant
	 * @return false si le nombre maximum de participants est atteint, true
	 *         sinon
	 */
	public boolean ajouterUnParticipant(String participant) {
		if(participant==null||participant.length()==0)
			throw new IllegalArgumentException();
		if (tableParticipants.length > nombreInscrits) {
			tableParticipants[nombreInscrits] = participant;
			nombreInscrits++;
			return true;
		}
		return false;
	}

	/**
	 * recherche l'indice de la case de la table qui contient le participant passe en parametre
	 * @param participant le participant recherche
	 * @return l'indice du participant ou -1 si le participant n'est pas dans la table
	 */
	private int trouverIndiceParticipant(String participant){
		for (int i = 0; i < nombreInscrits; i++) {
			if(participant.equals(tableParticipants[i]))
				return i;
		}
		return -1;
	}

	/**
	 * supprime le participant passe en parametre
	 * Si le nom se trouve plusieurs fois, seule sa première occurrence est supprimee
	 * @param participant Le participant a supprimer
	 * @return false si la suppression n'a pas pu etre faite car la table ne
	 *         contient pas le participant, true sinon
	 */
	public boolean supprimerUnParticipant(String participant) {
		if(participant==null||participant.length()==0)
			throw new IllegalArgumentException();
		if (tableParticipants == null) return false;
		int i = trouverIndiceParticipant(participant);
		if (i >= 0) {
			tableParticipants[i] = tableParticipants[nombreInscrits-1];
			nombreInscrits--;
			return true;
		}
		return false;
	}
}