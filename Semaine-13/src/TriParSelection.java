import java.util.Scanner;
/*
	@Author : Corentin D'haeyere
 */
public class TriParSelection {
	
	public static Scanner scanner = new java.util.Scanner(System.in);

	/**
	 * Trie le tableau t en utilisant le tri par selection
	 * N'utilisez pas de tableau supplementaire!
	 * @param t tableau � trier
	 */
	public static void triSelf (int[] t) {
		int index = 0;
		int minimum = 0;
		for (int i = 0; i < t.length -1; i++) {
			minimum = t[i];
			for (int j = i+1; j < t.length; j++) {
				if (t[j] < minimum) {
					minimum = t[j];
					index = t[i];
					t[i] = t[j];
					t[j] = index;
				}
			}
		}
	}
	
	/**
	 * Renvoie une nouvelle table triee � partir du tableau t.
	 * Le tableau t ne peut pas etre modifie!
	 * @param t
	 * @return Une nouvelle table triee
	 */
	public static int[] tri (int[] t) {
		int[] tableau = new int[t.length];
		for (int i = 0; i < t.length; i++) {
			tableau[i] = t[i];
		}
		triSelf(tableau);
		return tableau;
	}
	
	/**
	 * Trie le tableau t entre les indices indiceMin et indiceMax (inclus)
	 * @param t
	 * @param indiceMin
	 * @param indiceMax
	 */
	public static void triPartiel (int[] t, int indiceMin, int indiceMax) {
		if(indiceMax > t.length) throw new IllegalArgumentException("La borne max dépasse la taille du tableau");

		for(int i = indiceMin; i <= indiceMax - 1; i++){
			int iMin = i;
			for(int j = i+1; j <= indiceMax; j++){
				if(t[j] < t[iMin]){
					iMin = j;
				}
			}

			int tmp = t[i];
			t[i] = t[iMin];
			t[iMin] = tmp;
		}
	}

	/**
	 * Renvoie une table de taille 5 contenant les 5 plus petits �l�ments de t.
	 * Si la table t contient moins de 5 �l�ments, la taille de la
	 * table renvoy�e sera �gale � la taille de t.
	 * @param t
	 * @return une table contenant les 5 plus petits �l�ments de t
	 */
	public static int[] tri5 (int[] t) {
		// PETIT DEFI !!!
		
		// TODO
		// Exercice defi
		
		// La table passee en parametre ne peut etre modifiee.
		// POUR UNE QUESTION D'EFFICACITE : IL NE FAUT PAS TRIER TOUTE LA TABLE ET 
		// ENSUITE PRENDRE LES 5 PREMIERS!!!
		// La table renvoyee contient 5 entiers ou moins.
		return null;
	}


	public static void main (String[] args) {
		int choix;			
		System.out.println("******************************************");
		System.out.println("Programme Test pour le tri par selection :");
		System.out.println("******************************************");
		System.out.println();
		do{
			System.out.println("1 -> Tester la methode 'triSelf()'");
			System.out.println("2 -> Tester la methode 'tri()'");
			System.out.println("3 -> Tester la methode 'triPartiel()'");
			System.out.println("4 -> [Tester la methode 'tri5()']");
			System.out.print("\nEntrez votre choix : ");
			choix=scanner.nextInt();
			switch(choix){

			case 1: testTriSelf(); 
			break;
			case 2: testTri();
			break;
			case 3: testTriPartiel();
			break;
			case 4: testTri5();
			}
		}while(choix >=1&&choix<=4);
		System.out.println("Merci pour votre visite.");
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

	private static void testTriSelf () {
		
		// test1 table tout a fait quelconque
		int[] t1 = {4,6,3,9,1,5,8,2,7,0};
		int[]t1Triee = {0,1,2,3,4,5,6,7,8,9};
		triSelf(t1);
		if(!sontIdentiques(t1, t1Triee)){
			System.out.println("\nAttention test 1 ko");
			System.out.println("La table a trier est 4 6 3 9 1 5 8 2 7 0");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t1);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);

		}
		// test 2 table vide
		int[] t2 = {};
		int[]t2Triee = {};
		triSelf(t2);
		if(!sontIdentiques(t2, t2Triee)){
			System.out.println("\nAttention test 2 ko");
			System.out.println("La table a trier est vide");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t2);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		// test 3 table avec 1 entier
		int[] t3 = {9};
		int[]t3Triee = {9};
		triSelf(t3);
		if(!sontIdentiques(t3, t3Triee)){
			System.out.println("\nAttention test 3 ko");
			System.out.println("La table a trier est : 9 ");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t3);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		// test 4 table deja triee
		int[] t4 = {1,2,3,4,5};
		int[]t4Triee = {1,2,3,4,5};
		triSelf(t4);
		if(!sontIdentiques(t4, t4Triee)){
			System.out.println("\nAttention test 4 ko");
			System.out.println("La table a trier est 1 2 3 4 5");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t4);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);

		}
		// test 5 table avec ex-aequo
		int[] t5 = {2,7,3,2,7,5,1,1,2};
		int[]t5Triee = {1,1,2,2,2,3,5,7,7};
		triSelf(t5);
		if(!sontIdentiques(t5, t5Triee)){
			System.out.println("\nAttention test 5 ko");
			System.out.println("La table a trier est 2 7 3 2 7 5 1 1 2");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t5);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}

	private static void testTri(){
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
	
	private static void testTriPartiel(){
		// test1 table tout a fait quelconque
		int[] t1 = {4,6,3,9,1,5,8,2,7,0};
		int[]t1Triee = {0,1,2,3,4,5,6,7,8,9};
		triPartiel(t1, 0, 9);
		if(!sontIdentiques(t1, t1Triee)){
			System.out.println("\nAttention test 1 ko");
			System.out.println("La table a trier est 4 6 3 9 1 5 8 2 7 0");
			System.out.print("Apres appel de votre methode avec borneInf=0 et borneSup=9, la table est ");
			afficher(t1);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		// test2 table tout a fait quelconque
		int[] t2 = {4,6,3,9,1,5,8,2,7,0};
		int[]t2Triee = {4,6,1,3,5,8,9,2,7,0};
		triPartiel(t2, 2, 6);
		if(!sontIdentiques(t2, t2Triee)){
			System.out.println("\nAttention test 2 ko");
			System.out.println("La table a trier est 4 6 3 9 1 5 8 2 7 0");
			System.out.print("Apres appel de votre methode avec borneInf=2 et borneSup=6, la table est ");
			afficher(t2);
			System.out.println("Cette table n'est pas triee partiellement!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}

	private static void testTri5(){
		// test1 table tout a fait quelconque
		int[] t1 = {4,6,3,9,1,5,8,2,7,0};
		int[] t1Recopiee = {4,6,3,9,1,5,8,2,7,0};
		int[]t1Triee = {0,1,2,3,4};
		int[] t1Renvoyee = tri5(t1);
		if(!sontIdentiques(t1Renvoyee, t1Triee)){
			System.out.println("\nAttention test 1 ko");
			System.out.println("La table a trier est 4 6 3 9 1 5 8 2 7 0");
			System.out.print("Votre methode fournit la table : ");
			afficher(t1Renvoyee);
			System.out.println("Cette table n'est pas triee et/ou ne contient pas 5 entiers!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		if(!sontIdentiques(t1, t1Recopiee)){
			System.out.println("\nAttention test 1 ko");
			System.out.println("La table a trier a ete modifiee");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		// test2 table avec 5 entiers
		int[] t2 = {4,1,3,5,2};
		int[] t2Recopiee = {4,1,3,5,2};
		int[]t2Triee = {1,2,3,4,5};
		int[] t2Renvoyee = tri5(t2);
		if(!sontIdentiques(t2Renvoyee, t2Triee)){
			System.out.println("\nAttention test 2 ko");
			System.out.println("La table a trier est 4 1 3 5 2");
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
		int[] t3Renvoyee = tri5(t3);
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
		int[]t4Triee = {1,1,2,2,2};
		int[] t4Recopiee = {2,7,3,2,7,5,1,1,2};
		int[] t4Renvoyee = tri5(t4);
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

}
