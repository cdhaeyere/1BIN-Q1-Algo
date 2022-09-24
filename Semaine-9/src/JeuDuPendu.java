
public class JeuDuPendu {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args){

		System.out.print("Entrez le mot a trouver : ");
		String motATrouver = scanner.next();

		FenetrePendu fenetrePendu = new FenetrePendu();
		
		MotACompleter mot = new MotACompleter(motATrouver);
		
		int nbreMorceauxPendu = 0;

		fenetrePendu.afficherMot(mot.toString());

		//Boucle du jeu, tant que estComplet() est false on continue
		while (!mot.estComplet()) {

			//On récupère la lettre entrée
			char lettre = fenetrePendu.lireLettre();

			//verifie si la lettre a déja été rentrée
			if (mot.dejaLue(lettre)) {
				while (mot.dejaLue(lettre))
				fenetrePendu.afficherInformation("Vous avez déja entré cette lettre");
				return;
			} else {
				mot.ajouterLettreLue(lettre);
			}

			if (Character.isLetter(lettre)) {
				//On vérifie si le mot contient la lettre
				if (mot.contientLettre(lettre)) {

					//Si oui on l'ajoute
					mot.ajouterLettre(lettre);
					fenetrePendu.afficherMot(mot.toString());
					fenetrePendu.afficherInformation("La lettre " + lettre + " est dans le mot mystère");

				} else {
					//Si non on dessine le bonhomme
					nbreMorceauxPendu++;
					fenetrePendu.afficherPendu(nbreMorceauxPendu);
					fenetrePendu.afficherInformation("Le mot ne contient pas cette lettre : " + lettre);

					//Fin du jeu, défaite
					if (nbreMorceauxPendu == 6) {
						fenetrePendu.afficherInformation("Vous avez perdu");
						return;
					}
				}
			} else {
				fenetrePendu.afficherInformation("Le caractère entré n'est pas une lettre");
			}
		}

		//Fin du jeu, victoire
		fenetrePendu.afficherInformation("Vous avez gagné");
	}
}
