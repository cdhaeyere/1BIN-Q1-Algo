/*
	@Author : Corentin D'haeyere
 */
public class TriParFusion {
	
	/**
	 * Cette methode fusionne les tableaux deja tries t1 et t2
	 * dans le tableau tFusion. 
	 * Le tableau tFusion a une taille suffisante pour contenir les elements fusionnes de t1 et t2.
	 * @param t1 tableau a fusionner
	 * @param t2 tableua a fusionner
	 * @param tFusion table contenant la fusion de t1 et t2
	 */
	public static void fusionner(int[] t1, int[] t2, int[] tFusion){
		int i = 0;
		int j = 0;
		int index = 0;

		while(i < t1.length && j < t2.length) {
			if(t1[i] <= t2[j]) {
				tFusion[index] = t1[i];
				i++;
			} else {
				tFusion[index] = t2[j];
				j++;
			}
			index++;
		}

		while(j < t2.length){
			tFusion[index] = t2[j];
			j++;
			index++;
		}
		while(i < t1.length){
			tFusion[index] = t1[i];
			i++;
			index++;
		}
	}

	public static void main(String[] args) {
		System.out.println("***************************************");
		System.out.println("Programme Test pour le tri par fusion :");
		System.out.println("***************************************");
		System.out.println();
		System.out.println("Ce programme commence par tester la methode fusionner");
		
		int[]t1 = {1,2,4,7,9};
		int[]t2 = {3,5,10,12};
		int[]tSol = {1,2,3,4,5,7,9,10,12};
		int[] tFusion12 = new int[t1.length+t2.length];
		fusionner(t1, t2, tFusion12);
		if(!sontIdentiques(tSol, tFusion12)){
			System.out.println("Attention! fusion des 2 tables");
			afficher(t1);
			afficher(t2);
			System.out.println("Votre methode donne la table");
			afficher(tFusion12);
			System.out.println("Corrigez votre methode");
			System.exit(0);
		}
		int[] tFusion21 = new int[t1.length+t2.length];
		fusionner(t2, t1, tFusion21);
		if(!sontIdentiques(tSol, tFusion12)){
			System.out.println("Attention! fusion des 2 tables");
			afficher(t2);
			afficher(t1);
			System.out.println("Votre methode donne la table");
			afficher(tFusion12);
			System.out.println("Corrigez votre methode");
			System.exit(0);
		}
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		
		System.out.println("Ce programme va maintenant trier une table avec 20 entiers pris au hasard");
		int[] tableau = new int[20];
		for (int i=0; i<20; i++){
			tableau[i]= (int) (Math.random()*100);
		}
		afficher(tableau);
		triFusion(tableau,0,tableau.length-1);  
		System.out.println("Apres tri la table contient");
		afficher(tableau);  
	}

	public static void triFusion(int[] t) {
		triFusion(t, 0, t.length - 1);
	}

	public static void triFusion(int[] t, int debut, int fin) {
		if (debut == fin) return;
		int milieu = (debut + fin) / 2;
		int[] t1 = sousTable(t,debut, milieu + 1);
		int[] t2 = sousTable(t,milieu + 1, fin + 1);
		triFusion(t1, 0, t1.length - 1);
		triFusion(t2, 0, t2.length - 1);
		fusionner(t1, t2, t);
	}

	private static void afficher(int[] tableau){
		for (int i = 0; i<tableau.length; i++){
			System.out.print(tableau[i]+" ");
		}
		System.out.println();
	}
	
	private static int[] sousTable(int[] t, int debut, int fin){
		int[] sousT = new int[fin-debut];
		for (int i = 0; i < sousT.length; i++) {
			sousT[i]= t[debut+i];
		}
		return sousT;
	}
	
	private static boolean sontIdentiques(int[] table1, int[] table2){
		if(table1.length != table2.length)
			return false;
		for(int i = 0 ; i < table1.length ; i++)
			if(table1[i]!=table2[i])
				return false;
		return true;
	}
}
