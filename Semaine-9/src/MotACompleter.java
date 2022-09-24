
public class MotACompleter {
	
	private char[] motATrouver;   // le mot a trouver
	private char[] motACompleter; // le mot a completer
	boolean[] lettresLues = new boolean[26];

	
	/**
	 * au depart le mot a completer contient uniquement des '_'
	 * @param motATrouver
	 */
	public MotACompleter(String motATrouver) {		
		this.motATrouver= motATrouver.toUpperCase().toCharArray();
		this.motACompleter = new char[motATrouver.length()];
		for (int i = 0; i < motACompleter.length; i++) {
			motACompleter[i] = '_';
		}		
	}

	/**
	 * renvoie une chaine de caracteres avec le mot a completer en mettant un espace entre chaque lettre
	 * @return le mot a completer pour affichage
	 */
	public String toString(){
		String aAfficher ="";
		for (int i = 0; i < motACompleter.length; i++) {
			aAfficher += " "+ motACompleter[i];
		}
		return aAfficher;
	}
	
	/**
	 * verifie si le mot a completer ne contient plus de _
	 * @return true si le mot est complet, false sinon
	 */
	public boolean estComplet() {
		for (int i = 0; i < motATrouver.length; i++) {
			if (!(motATrouver[i] == motACompleter[i])) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * verifie si le mot a trouver contient la lettre passee en parametre
	 * @param lettre la lettre recherchee
	 * @return true si la lettre a ete trouvee, false sinon 
	 */
	public boolean contientLettre(char lettre){
		lettre = Character.toUpperCase(lettre);
		for (char c : motATrouver) {
			if (Character.toUpperCase(c) == lettre) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * ajoute (ou ecrase) la lettre dans le mot a completer autant de fois qu'il se trouve
	 * dans le mot a trouver en respectant leur position
	 * ex : mot a trouver COLIBRI - mot a completer  C_L_BR_ - lettre I -mot a completer -> C_LIBRI
	 * @param lettre la lettre a ajouter
	 */
	public void ajouterLettre(char lettre){
		lettre = Character.toUpperCase(lettre);
		for (int i = 0; i < motATrouver.length; i++) {
			if (motATrouver[i] == lettre) {
				motACompleter[i] = lettre;
			}
		}
	}

	/**
	 * verifie si la lettre entree a deja ete entree auparavant
	 * @param lettre
	 * @return si la lettre a deja ete rentre
	 */
	public boolean dejaLue(char lettre) {
		lettre = Character.toUpperCase(lettre);
		if (lettresLues[lettre - 65] == false) {
			lettresLues[lettre - 65] = true;
			return false;
		}
		return true;
	}

	/**
	 * ajoute la lettre dans la liste de lettres lues
	 * @param lettre
	 */
	public void ajouterLettreLue(char lettre) {
		lettre = Character.toUpperCase(lettre);
		lettresLues[lettre - 65] = true;
	}
}
