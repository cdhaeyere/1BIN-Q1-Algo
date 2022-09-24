/*
	@Author: Corentin D'haeyere
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
			System.out.println("2 -> Ajouter un participant");
			System.out.println("3 -> Supprimer un participant");
			System.out.print("\nEntrez votre choix : ");
			choix = scanner.nextInt();
			System.out.println();
			switch (choix) {
			case 1:
				afficher();
				break;
			case 2:
				ajouter();
				break;
			case 3:
				supprimerUn();
				break;
			}
		} while (choix >= 1 && choix <= 4);
		System.out.println("Merci pour votre visite.");
	}

	private static void supprimerUn() {
		System.out.print("Entrez le nom du participant a supprimer : ");
		String participant = scanner.next();

		if (p.supprimerUnParticipant(participant))
			System.out.println("Le participant a ete supprime avec succes");
		else
			System.out.println("Le participant n'a pas ete supprime car il n'est pas inscrit");

	}

	private static void ajouter() {
		System.out.print("Entrez le nom du participant : ");
		String participant = scanner.next();
		if (p.ajouterUnParticipant(participant))
			System.out.println("Le participant a ete ajoute avec succes");
		else
			System.out.println("Le participant n'a pas ete ajoute car le nombre maximum d'inscriptions est atteint");
	}

	private static void afficher() {
		System.out.println(p.toString());
		System.out.println();
	}

}
