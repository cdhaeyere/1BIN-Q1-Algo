/*
    @Author Corentin D'haeyere
 */
public class Multiplication1{

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Tu vas faire 5 multiplications");
		System.out.println("La valeur minimale des nombres a multiplier est 0, la valeur maximale est 10");
		System.out.println("Pour chaque multiplication, tu as droit a 1 essai");
		System.out.println("Tu recevras la reponse, si tu la rate");
		System.out.println("A la fin, le programme affichera le nombre de bonnes reponses.");
		// A NE PAS COMPLETER
	}

	/**
	 * Faire une multiplication jusqu'a donner la bonne réponse
	 * @param nbrEssai nombre d'essais que l'utilisateur a droit
	 * @param min nombre min pour les multiplications
	 * @param max nombre max pour les multiplications
	 */
	public static void faireUneMultiplication(int min, int max, int nbrEssai) {
		for (int i = 0; i < 5; i++) {
			int x = Utilitaires.unEntierAuHasardEntre(0, 10);
		}
	}
}