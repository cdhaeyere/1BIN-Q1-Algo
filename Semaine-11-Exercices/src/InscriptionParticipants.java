/*
	@Author : Corentin D'haeyere
 */
public class InscriptionParticipants {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	public static Participants p;

	public static void main(String[] args) {

		int choix;
		System.out.println("Exercices d'algorithmique et Java");
		System.out.println("1ere Informatique IPL");
		System.out.println();
		System.out.println("******************************");
		System.out.println("Inscription des participants :");
		System.out.println("******************************");
		System.out.println();
		System.out.print("Entrez le nombre maximum de participants : ");
		int nombreMax = scanner.nextInt();
		p = new Participants(nombreMax);
		do {
			System.out.println();
			System.out.println("1 -> Afficher tous les inscrits");
			System.out.println("2 -> Ajouter un participant en fin de liste");
			System.out.println("3 -> Ajouter un participant apres un autre participant");
			System.out.println("4 -> Verifier l'appartenance d'un participant");
			System.out.println("5 -> Supprimer un participant via son nom");
			System.out.println("6 -> Supprimer tous les participants via leur nom");
			System.out.print("\nEntrez votre choix : ");
			choix = scanner.nextInt();
			System.out.println();
			switch (choix) {
				case 1:
					afficher();
					break;
				case 2:
					ajouterFin();
					break;
				case 3:
					ajouterApres();
					break;
				case 4:
					verifierExistence();
					break;
				case 5:
					supprimerViaNom();
					break;
				case 6:
					supprimerTous();
					break;
			}
		} while (choix >= 1 && choix <= 9);
		System.out.println("Merci pour votre visite.");
	}

	private static void afficher() {
		System.out.println(p.toString());
		System.out.println();
	}

	private static void ajouterFin() {
		System.out.println("Entrez le nom du participant : ");
		String participant = scanner.next();
		if (p.ajouterParticipant(participant))
			System.out.println("Le participant a ete ajoute avec succes");
		else
			System.out.println("Le participant n'a pas ete ajoute car le nombre maximum d'inscriptions est atteint");
	}

	private static void ajouterApres() {
		System.out.println("Entrez le nom du participant : ");
		String participant = scanner.next();
		System.out.println("Entrez l'index du participant :");
		int index = scanner.nextInt();
		if (p.ajouterParticipant(index, participant))
			System.out.println("Le participant a ete ajoute avec succes");
		else
			System.out.println("Le participant n'a pas ete ajoute car le nombre maximum d'inscriptions est atteint");
	}

	private static void verifierExistence() {
		System.out.println("Entrez le nom du participant : ");
		String participant = scanner.next();
		System.out.println("Participant dans la table ? : " + p.contient(participant));
	}

	private static void supprimerViaNom() {
		System.out.println("Entrez le nom du participant : ");
		String participant = scanner.next();
		if (p.supprimerParticipant(participant))
			System.out.println("Le participant a ete supprime avec succes");
		else
			System.out.println("Le participant n'est pas dans la table");
	}

	private static void supprimerTous() {
		System.out.println("Entrez le nom du participant : ");
		String participant = scanner.next();
		System.out.println("Le participant " + participant + " a été supprimé : " + p.supprimerTousLesParticipants(participant) + " fois");
	}

}
