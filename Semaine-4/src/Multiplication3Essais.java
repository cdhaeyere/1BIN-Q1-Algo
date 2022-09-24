/*
    @Author : Corentin D'haeyere
 */
public class Multiplication3Essais {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Entrainement aux multiplications. Voici une multiplication :");
		System.out.println("Tu as droit a 3 essais");
		int premierNombre = unEntierAuHasardEntre (0, 10);
		int secondNombre = unEntierAuHasardEntre (0, 10);
		System.out.println("Calculez : " + premierNombre + " x " + secondNombre + " = ");
		int reponse;
		int entry;
		int essais=3;

		do{
			entry=scanner.nextInt();
			reponse=premierNombre*secondNombre;
			essais--;
			if(reponse != entry) System.out.println("Mauvaise reponse plus que " + essais + " essais");
			if(essais==0) System.out.println("Vous n'avez plus de tentative");
		}while(entry!=reponse && essais!=0);

		if(reponse==entry) System.out.println("Bravo la reponse est juste");
	}

	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;

		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
		return resultat;
	}
}
