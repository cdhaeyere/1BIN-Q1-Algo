import java.util.Scanner;
/*
	@Author : Corentin D'haeyere
 */
public class TriParComptage {
	
	public static Scanner scanner = new java.util.Scanner(System.in);

	/**
	 * Trie le tableau t en utilisant le tri par comptage
	 * @param t
	 * @param borneSup Les entiers contenus dans la table sont compris entre 0 et borneSup
	 */
	public static void tri (int[] t, int borneSup) {
		int[] nombres = new int[borneSup +1];
		for (int k : t) {
			nombres[k]++;
		}

		int i = 0;
		int j = 0;

		while (i < t.length || j < nombres.length) {
			if (nombres[j] == 0) j++;
			else {
				t[i] = j;
				nombres[j]--;
				i++;
			}
		}
	}
   
   /**
	 * Trie le tableau t en utilisant le tri par comptage
	 * @param t
	 * @param borneInf 
	 * @param borneSup Les entiers contenus dans la table sont compris entre borneInf et borneSup
	 */
   public static void tri (int[] t, int borneInf, int borneSup) {

		// Les entiers contenus dans la table sont compris entre borneInf et borneSup
		// A ne pas verifier

		// TODO
	    //(Exercice supplementaire)



   }
   
   /**
	 * Trie le tableau t en utilisant le tri par comptage
	 * @param t
	 */
   public static void tri (int[] t) {
	   
	    // TODO 
	    //(Exercice supplementaire)
		
   }
	
   private static void afficher(int[] table){
		for(int i = 0 ; i < table.length ; i++)
			System.out.print(" "+ table[i]);
		System.out.println();
	}

	private static boolean sontIdentiques(int[] table1, int[] table2){
		if(table1.length != table2.length)
			return false;
		for(int i = 0 ; i < table1.length ; i++)
			if(table1[i]!=table2[i])
				return false;
		return true;

	}

	public static void testTri0Max() {
		int[] t = {4,2,2,7,2,0,2,5,0,9,2,7,5,2,5,5};
		int[] tTriee = {0,0,2,2,2,2,2,2,4,5,5,5,5,7,7,9};
		TriParComptage.tri(t,9);
		if(!sontIdentiques(t, tTriee)){
			System.out.println("\nAttention test 1 ko");
			System.out.println("La table a trier est 4 2 2 7 2 0 2 5 0 9 2 7 5 2 5 5");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 1 a reussi!");

		int[] t2 = {};
		int[] tTriee2 = {};
		TriParComptage.tri(t2,9);
		if(!sontIdentiques(t2, tTriee2)){
			System.out.println("\nAttention test 2 ko");
			System.out.println("La table a trier est vide ");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t2);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 2 a reussi!");

		int[] t3 = {8};
		int[] tTriee3 = {8};
		TriParComptage.tri(t3,8);
		if(!sontIdentiques(t3, tTriee3)){
			System.out.println("\nAttention test 3 ko");
			System.out.println("La table a trier est vide ");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t3);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 3 a reussi!");


	}

	public static void testTriMinMax() {
		int[] t = {4,2,2,7,2,0,2,5,0,9,2,7,5,2,5,5};
		int[] tTriee = {0,0,2,2,2,2,2,2,4,5,5,5,5,7,7,9};
		TriParComptage.tri(t,0,9);
		if(!sontIdentiques(t, tTriee)){
			System.out.println("\nAttention test 1 ko");
			System.out.println("La table a trier est 4 2 2 7 2 0 2 5 0 9 2 7 5 2 5 5");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 1 a reussi!");

		int[] t2 = {4,2,2,7,2,2,5,9,2,7,5,2,5,5};
		int[] tTriee2 = {2,2,2,2,2,2,4,5,5,5,5,7,7,9};
		TriParComptage.tri(t2,2,9);
		if(!sontIdentiques(t2, tTriee2)){
			System.out.println("\nAttention test 2 ko");
			System.out.println("La table a trier est 4 2 2 7 2 2 5 9 2 7 5 2 5 5");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t2);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 2 a reussi!");

		int[] t3 = {4,2,-2,7,-2,2,5,9,2,7,5,2,5,5};
		int[] tTriee3 = {-2,-2,2,2,2,2,4,5,5,5,5,7,7,9};
		TriParComptage.tri(t3,-2,9);
		if(!sontIdentiques(t3, tTriee3)){
			System.out.println("\nAttention test 3 ko");
			System.out.println("La table a trier est 4 2 -2 7 -2 2 5 9 2 7 5 2 5 5");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t3);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 3 a reussi!");

		int[] t4 = {};
		int[] tTriee4 = {};
		TriParComptage.tri(t4,7,8);
		if(!sontIdentiques(t4, tTriee4)){
			System.out.println("\nAttention test 4 ko");
			System.out.println("La table a trier est vide ");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t4);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 4 a reussi!");

		int[] t5 = {8};
		int[] tTriee5 = {8};
		TriParComptage.tri(t5,8,8);
		if(!sontIdentiques(t5, tTriee5)){
			System.out.println("\nAttention test 5 ko");
			System.out.println("La table a trier est vide ");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t5);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 5 a reussi!");

	}

	public static void testTri() {
		int[] t = {4,2,2,7,2,0,2,5,0,9,2,7,5,2,5,5};
		int[] tTriee = {0,0,2,2,2,2,2,2,4,5,5,5,5,7,7,9};
		TriParComptage.tri(t);
		if(!sontIdentiques(t, tTriee)){
			System.out.println("\nAttention test 1 ko");
			System.out.println("La table a trier est 4 2 2 7 2 0 2 5 0 9 2 7 5 2 5 5");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);

		}
		System.out.println("Le test 1 a reussi!");

		int[] t2 = {4,2,2,7,2,0,2,5,0,9,2,7,5,2,5,5};
		int[] tTriee2 = {0,0,2,2,2,2,2,2,4,5,5,5,5,7,7,9};
		TriParComptage.tri(t2);
		if(!sontIdentiques(t2, tTriee2)){
			System.out.println("\nAttention test 2 ko");
			System.out.println("La table a trier est 4 2 2 7 2 0 2 5 0 9 2 7 5 2 5 5");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t2);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 2 a reussi!");
		int[] t3 = {4,2,2,7,2,2,5,9,2,7,5,2,5,5};
		int[]tTriee3 = {2,2,2,2,2,2,4,5,5,5,5,7,7,9};
		TriParComptage.tri(t3);
		if(!sontIdentiques(t3, tTriee3)){
			System.out.println("\nAttention test 3 ko");
			System.out.println("La table a trier est 4 2 2 7 2 2 5 9 2 7 5 2 5 5");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t3);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 3 a reussi!");
		int[] t4 = {4,2,-2,7,-2,2,5,9,2,7,5,2,5,5};
		int[]tTriee4 = {-2,-2,2,2,2,2,4,5,5,5,5,7,7,9};
		TriParComptage.tri(t4);
		if(!sontIdentiques(t4, tTriee4)){
			System.out.println("\nAttention test 4 ko");
			System.out.println("La table a trier est 4 2 -2 7 -2 2 5 9 2 7 5 2 5 5");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t4);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(4);
		}
		System.out.println("Le test 4 a reussi!");

		int[] t5 = {};
		int[]tTriee5 = {};
		TriParComptage.tri(t5);
		if(!sontIdentiques(t5, tTriee5)){
			System.out.println("\nAttention test 5 ko");
			System.out.println("La table a trier est vide ");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t5);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 5 a reussi!");

		int[] t6 = {8};
		int[]tTriee6 = {8};
		TriParComptage.tri(t6);
		if(!sontIdentiques(t6, tTriee6)){
			System.out.println("\nAttention test 6 ko");
			System.out.println("La table a trier est vide ");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t6);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 6 a reussi!");
	}

	public static void main(String[] args) {
		int choix;			
		System.out.println("*****************************************");
		System.out.println("Programme Test pour le tri par comptage :");
		System.out.println("*****************************************");
		System.out.println();

		do{
			System.out.println("1 -> Tester la methode 'tri(int[] t, int borneSup)'");
			System.out.println("2 -> [Tester la methode 'tri(int[] t, int borneInf, int borneSup)']");
			System.out.println("3 -> [Tester la methode 'tri()']");
			System.out.print("\nEntrez votre choix : ");
			choix=scanner.nextInt();
			switch(choix){

			case 1: testTri0Max(); 
			break;
			case 2: testTriMinMax();
			break;
			case 3: testTri();
			break;
			}
		}while(choix >=1&&choix<=3);
		System.out.println("Merci pour votre visite.");
	}
	
}
