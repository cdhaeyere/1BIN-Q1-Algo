import java.util.Scanner;
/*
	@Author : Corentin D'haeyere
 */
public class TriParInsertion {

	public static Scanner scanner = new java.util.Scanner(System.in);
	
	public static int[] tri (int[] t) {
		int[] entiers = new int[t.length];

		for (int i = 0; i < t.length; i++) {
			entiers[i] = t[i];
		}

		for (int i = 1; i < entiers.length; i++) {
			int elementInsert = entiers[i];
			int j = i-1;
			while (j >= 0 && entiers[j] > elementInsert) {
				entiers[j+1] = entiers[j];
				j--;
			}
			entiers[j+1] = elementInsert;
		}
		return entiers;
	}
	
	public static void main (String[] args) {
		System.out.println("******************************************");
		System.out.println("Programme Test pour le tri par insertion :");
		System.out.println("******************************************");
		System.out.println();
		// test1 table tout a fait quelconque
		int[] t1 = {4,6,3,9,1,5,8,2,7,0};
		int[] t1Recopiee = {4,6,3,9,1,5,8,2,7,0};
		int[]t1Triee = {0,1,2,3,4,5,6,7,8,9};
		int[] t1Renvoyee = tri(t1);
		if(!sontIdentiques(t1Renvoyee, t1Triee)){
			System.out.println("\nAttention test 1 ko");
			System.out.println("La table a trier est 4 6 3 9 1 5 8 2 7 0");
			System.out.print("Votre methode fournit la table : ");
			afficher(t1Renvoyee);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		if(!sontIdentiques(t1, t1Recopiee)){
			System.out.println("\nAttention test 1 ko");
			System.out.println("La table a trier a ete modifiee");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		// test2 table vide
		int[] t2 = {};
		int[] t2Recopiee = {};
		int[]t2Triee = {};
		int[] t2Renvoyee = tri(t2);
		if(!sontIdentiques(t2Renvoyee, t2Triee)){
			System.out.println("\nAttention test 2 ko");
			System.out.println("La table a trier est vide");
			System.out.print("Votre methode fournit la table : ");
			afficher(t2Renvoyee);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		if(!sontIdentiques(t2, t2Recopiee)){
			System.out.println("\nAttention test 2 ko");
			System.out.println("La table a trier a ete modifiee");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		// test3 table avec 1 entier
		int[] t3 = {4};
		int[] t3Recopiee = {4};
		int[]t3Triee = {4};
		int[] t3Renvoyee = tri(t3);
		if(!sontIdentiques(t3Renvoyee, t3Triee)){
			System.out.println("\nAttention test 3 ko");
			System.out.println("La table a trier est 4");
			System.out.print("Votre methode fournit la table : ");
			afficher(t3Renvoyee);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		if(!sontIdentiques(t3, t3Recopiee)){
			System.out.println("\nAttention test 3 ko");
			System.out.println("La table a trier a ete modifiee");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		// test 4 table avec ex-aequo
		int[] t4 = {2,7,3,2,7,5,1,1,2};
		int[]t4Triee = {1,1,2,2,2,3,5,7,7};
		int[] t4Recopiee = {2,7,3,2,7,5,1,1,2};
		int[] t4Renvoyee = tri(t4);
		if(!sontIdentiques(t4Renvoyee, t4Triee)){
			System.out.println("\nAttention test 4 ko");
			System.out.println("La table a trier est 2 7 3 2 7 5 1 1 2");
			System.out.print("Votre methode fournit la table : ");
			afficher(t4Renvoyee);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		if(!sontIdentiques(t4, t4Recopiee)){
			System.out.println("\nAttention test 4 ko");
			System.out.println("La table a trier a ete modifiee");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}
	
	private static void afficher (int[] table) {
		for(int i = 0 ; i < table.length ; i++)
			System.out.print(" "+ table[i]);
		System.out.println();

	}

	private static boolean sontIdentiques (int[] table1, int[] table2) {
		if(table1.length != table2.length)
			return false;
		for(int i = 0 ; i < table1.length ; i++)
			if(table1[i]!=table2[i])
				return false;
		return true;

	}

}
