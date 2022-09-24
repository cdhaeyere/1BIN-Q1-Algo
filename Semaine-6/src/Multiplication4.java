/*
    @Author Corentin D'haeyere
 */
public class Multiplication4 {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Tu vas faire des multiplications de nombres compris entre 0 et 10");
		System.out.println("Tu peux choisir le nombre d'essais que tu auras pour chaque multiplication");
		System.out.println("Ce nombre sera le meme pour toutes les multiplications");
		System.out.println("Tu recevras la reponse, si tu ne l'as toujours pas trouvee au terme du nombre d'essais accorde");
		System.out.println("Apres chaque multiplication, le programme te demandera si tu en veux une autre");
	
		//A NE PAS COMPLETER
	}

	/**
	 * Faire une multiplication avec un nombre d'essais défini
	 * @param nbrEssais
	 */
	public static void faireUneMultiplication(int nbrEssais) {

	}

	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;
		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
		return resultat;
	}
}
