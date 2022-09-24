/*
    @Author Corentin D'haeyere
 */
public class Multiplication3 {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Tu vas faire 5 multiplications");
		System.out.println("Au depart la valeur minimale des nombres a multiplier est 1 et la valeur maximale est 10");
		System.out.println("Ces 2 bornes augmenteront de 10 a chaque multiplication reussie");
		System.out.println("Pour chaque multiplication, tu as droit a 1 essai");
		System.out.println("Tu recevras la reponse, si tu la rate");
		// A NE PAS COMPLETER
	}

	/**
	 * Faire une multiplication avec deux bornes qui augmentent de 10 à chaque multiplication
	 * @param nbrMultiplications
	 * @param essais
	 * @param min
	 * @param max
	 */
	public static void faireUneMultiplication(int nbrMultiplications, int essais, int min, int max) {

	}

	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;
		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
		return resultat;
	}
}
