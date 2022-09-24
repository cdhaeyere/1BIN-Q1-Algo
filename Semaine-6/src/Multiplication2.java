/*
    @Author Corentin D'haeyere
 */
public class Multiplication2 {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Tu vas faire des multiplications.");
		System.out.println("La valeur minimale des 2 nombres a multiplier est 0.");
		System.out.println("Tu peux choisir la valeur maximale de ces 2 nombres.");
		System.out.println("Cette valeur sera la meme pour tous les exercices");
		System.out.println("Pour chaque multiplication, tant que tu n'auras pas donne la bonne reponse, tu devras la recommencer");
		System.out.println("Le programme termine lorsque tu auras reussi 3 multiplications du premier coup");
	
		// A NE PAS COMPLETER
	}

	/**
	 * Faire une multiplication de deux nombres plusieurs fois juqu'a avoir 3 bonnes réponses
	 * @param max
	 * @param bonneRéponse
	 */
	public static void faireUneMultiplication(int max, int bonneRéponse) {

	}

	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;
		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
		return resultat;
	}
}
