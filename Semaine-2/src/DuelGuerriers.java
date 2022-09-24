import java.util.Scanner;
/*
    @Author: Corentin D'haeyere
 */
public class DuelGuerriers {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int frappefortFrappe = unEntierAuHasardEntre(1, 6);
		int cogneDurFrappe = unEntierAuHasardEntre(1, 6);
		int frappeFortPointVie = unEntierAuHasardEntre(1,6);
		int cogneDurPointVie = unEntierAuHasardEntre(1,6);

		System.out.println("FrappeFort a " + frappeFortPointVie + " points de vie et CogneDur a " + cogneDurPointVie + " points de vie.");
		int vieRestanteFrappeFort = cogneDurPointVie - frappefortFrappe;
		int vieRestanteCogneDur = frappeFortPointVie - cogneDurFrappe;

		if(vieRestanteFrappeFort <= 0){
			System.out.println("FrappeFort inflige " + frappefortFrappe + " de dégat a CogneDur.");
			System.out.println("CogneDur a " + vieRestanteFrappeFort + " point de vie.");
			System.out.println("FrappeFort est le vainqueur!");
		} else{
			System.out.println("FrappeFort inflige " + frappefortFrappe + " de dégat a CogneDur.");
			System.out.println("CogneDur a " + vieRestanteFrappeFort + " point de vie.");
			if(vieRestanteCogneDur <= 0){
				System.out.println("CogneDur inflige " + cogneDurFrappe+" de dégat à FrappeFort.");
				System.out.println("FrappeFort a " + vieRestanteCogneDur + " point de vie.");
				System.out.println("CogneDur est vainqueur!");
			} else{
				if (vieRestanteCogneDur == vieRestanteFrappeFort){
					System.out.println("CogneDur inflige " + cogneDurFrappe + " de dégat à FrappeFort.");
					System.out.println("FrappeFort a " + vieRestanteCogneDur + " point de vie.");
					System.out.println("FrappeFort et CogneDur termine ex-aequos!");
				} else{
					if(vieRestanteCogneDur < vieRestanteFrappeFort){
						System.out.println("CogneDur inflige " + cogneDurFrappe + " de dégat à FrappeFort.");
						System.out.println("FrappeFort a " + vieRestanteCogneDur + " point de vie.");
						System.out.println("CogneDur a plus de point de vie que FrappeFort, il est donc vainqueur!");
					} else{
						System.out.println("CogneDur inflige " + cogneDurFrappe + " de dégat à FrappeFort.");
						System.out.println("FrappeFort a " + vieRestanteCogneDur + " point de vie.");
						System.out.println("FrappeFort a plus de point de vie que CogneDur, il est donc vainqueur!");
					}
				}
			}
		}
	}
	
	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;

		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
		return resultat;
	}
}
