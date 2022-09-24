/*
	@author Corentin D'haeyere
 */
public class TestSudokuGeneral {
	
	public static void main(String[] args) {
		
		int [][] grille9x9 = {
				{4,0,0,	0,0,0, 0,0,0 },
				{0,0,0,	0,0,0, 0,0,0 },
				{0,0,0,	0,4,0, 0,0,0 },
				
				{0,7,0,	0,0,3, 4,5,0 },
				{2,0,0,	0,0,0, 9,8,7 },
				{0,0,0,	0,0,0, 1,3,2 },
				
				{0,0,0,	0,0,0, 0,0,0 },
				{0,0,1,	0,0,0, 0,0,0 },
				{0,0,0,	0,0,0, 0,0,0 }								
		};
		
		int [][] grille4x4 = {
				{3,0, 0,0 },
				{0,0, 1,0 },				
				
				{0,3, 4,0 },
				{2,0, 3,1 }		
		};
			
		SudokuGeneral grille;
		
		// COUP LEGAL
	
		System.out.println("TEST1: teste si un coup est legal sur la grille 9x9");

		grille = new SudokuGeneral(grille9x9);

		// Coup legal
		if (!grille.isCoupLegal(1, 5, 1))
			System.out.println("Le coup i=1, j=5, nombre=1 devrait etre legal et est indique comme illegal");
		else
			System.out.println("1, 5, 1 ok!");
		
		// Coup illegal colonne
		System.out.println("Test Coup illegal colonne");
		if (grille.isCoupLegal(5, 0, 4))
			System.out.println("Le coup i=5, j=0, nombre=4 devrait etre illegal et est indique comme legal");
		else
			System.out.println("5, 0, 4 ok!");
		
		// Coup illegal ligne
		System.out.println("Test Coup illegal ligne");
		if (grille.isCoupLegal(7, 7, 1))
			System.out.println("Le coup i=7, j=7, nombre=1 devrait etre illegal et est indique comme legal");
		else
			System.out.println("7, 7, 1 ok!");

		// Coup illegal region
		System.out.println("Test Coup illegal region");
		if (grille.isCoupLegal(3, 8, 9))
			System.out.println("Le coup i=3, j=8, nombre=9 devrait etre illegal et est indique comme legal");
		else
			System.out.println("3, 8, 9 ok!");
		
		
		System.out.println("\nTEST2: teste si un coup est legal sur la grille 4x4");
		
		grille = new SudokuGeneral(grille4x4);
		
		// Coup legal 4x4
		if (!grille.isCoupLegal(0, 1, 1))
			System.out.println("Le coup i=0, j=1, nombre=1 devrait etre legal et est indique comme illegal");
		else
			System.out.println("0, 1, 1 ok!");		
		
		// CHIFFRE LE PLUS PRESENT

		System.out.println("\nTEST3: teste le chiffre le plus present dans la grille 4x4");
				
		if (grille.nombreLePlusPresent()!=3 )
			System.out.println("Le chiffre le plus present devrait etre 3");
		else
			System.out.println("chiffrePlusPresent ok sur 4x4");
				
		System.out.println("\nTEST4: teste le chiffre le plus present dans la grille 9x9");
		
		grille = new SudokuGeneral(grille9x9);
		if (grille.nombreLePlusPresent()!=4 )
			System.out.println("Le chiffre le plus present devrait etre 4");
		else
			System.out.println("chiffrePlusPresent ok sur 9x9");
	}
}
