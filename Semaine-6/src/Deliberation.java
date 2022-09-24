/*
    @Author Corentin D'haeyere
 */
public class Deliberation {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	
	public static void main(String[] args) {
		double moyenne = moyenneClasse();
		System.out.println("La moyenne de la classe est de " + moyenne + "/20");
	}

	/**
	 * lit les cotes, calcule et renvoie la moyenne d'un etudiant
	 * @return le resultat d'un etudiant
	*/
	public static double moyenneUnEtudiant() {
		double totalCotes = 0;
		for (int i = 0; i < 10; i++) {
			System.out.print("Entrez une cote (sur 20) : ");
			totalCotes += Utilitaires.lireReelComprisEntre(0, 20);
		}
		return totalCotes/10;
	}

	/**
	 * Lis les cotes de tous les étudiants de la classe
	 * @return moyenne classe
	 */
	public static double moyenneClasse() {
		double totalMoyennes = 0;
		for (int i = 1; i < 26; i++) {
			System.out.println("Etudiant " + i);
			double moyenne = moyenneUnEtudiant();
			totalMoyennes += moyenne;
		}
		return totalMoyennes/25;
	}

}
