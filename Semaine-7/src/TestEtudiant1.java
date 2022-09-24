/*
	@author Corentin D'haeyere
 */
public class TestEtudiant1 {
	

   	public static void main(String [] args){

		System.out.println("**************************************");
		System.out.println("Programme Test pour la classe Etudiant");
		System.out.println("**************************************");
		Etudiant etudiant;
		System.out.println("\n A VOUS DE VERIFIER LES RESULTATS!!!");

		// test moyenne
		System.out.println("\n\n\nTest moyenne() :");
		double moyenne;
		
		// test1 : etudiant avec 4 cotes
		double[] tableTestee = {10,12,14,16};
		etudiant = new Etudiant(1,tableTestee);
		moyenne = etudiant.moyenne();
		System.out.print("\n Test1 : votre methode a trouve la moyenne "+ moyenne);
		System.out.println(" pour l'etudiant : "+ etudiant);
		
		// test2 : etudiant avec 5 cotes
		double[] tableTestee2 = {10,12,14,16,18};
		etudiant = new Etudiant(2,tableTestee2);
		moyenne = etudiant.moyenne();
		System.out.print("\nTest2 : votre methode a trouve la moyenne "+ moyenne);
		System.out.println(" pour l'etudiant : "+ etudiant);
		

		// test nombreEchecs
		System.out.println("\n\n\nTest nombreEchecs() :");
		int nombreEchecs;

		// test3 : 4 cotes, 0 echec
		double[] tableTestee3 = {10,10,10,10};
		etudiant = new Etudiant(1,tableTestee3);
		nombreEchecs = etudiant.nombreEchecs();
		System.out.print("\nTest3 : votre methode a trouve "+ nombreEchecs +" echec(s)");
		System.out.println(" pour l'etudiant : "+ etudiant);

		// test4 : 3 cotes, 0 echec
		double[] tableTestee4 = {10,10,10};
		etudiant = new Etudiant(2,tableTestee4);
		nombreEchecs = etudiant.nombreEchecs();

		System.out.print("\nTest4 : votre methode a trouve "+ nombreEchecs +" echec(s)");
		System.out.println(" pour l'etudiant : "+ etudiant);

		// test5 : 3 cotes, 3 echecs
		double[] tableTestee5 = {9,9,9};
		etudiant = new Etudiant(3,tableTestee5);
		nombreEchecs = etudiant.nombreEchecs();
		System.out.print("\nTest5 : votre methode a trouve "+ nombreEchecs +" echec(s)");
		System.out.println(" pour l'etudiant : "+ etudiant);


		// test6 : 5 cotes, 2 echecs
		double[] tableTestee6 = {10,10,9,10,9};
		etudiant = new Etudiant(4,tableTestee6);
		nombreEchecs = etudiant.nombreEchecs();
		System.out.print("\nTest6 : votre methode a trouve "+ nombreEchecs +" echec(s)");
		System.out.println(" pour l'etudiant : "+ etudiant);
		


		// test methode min()
		System.out.println("\n\n\nTest min() :");
		double min;

		// Test7 : 3 cotes - min est la premiere
		double[] tableTestee7 = {3,14,6};
		etudiant = new Etudiant(1,tableTestee7);
		min = etudiant.min();
		System.out.print("\nTest7 : votre methode a trouve "+ min +" comme la plus petite cote");
		System.out.println(" pour l'etudiant : "+ etudiant);

		// Test8 : 5 cotes - min est la derniere
		double[] tableTestee8 = {13,14,16,8,7};
		etudiant = new Etudiant(2,tableTestee8);
		min = etudiant.min();
		System.out.print("\nTest8 : votre methode a trouve "+ min +" comme la plus petite cote");
		System.out.println(" pour l'etudiant : "+ etudiant);

		// Test9 : 5 cotes - min au mileu
		double[] tableTestee9 = {13,14,6,8,7};
		etudiant = new Etudiant(3,tableTestee9);
		min = etudiant.min();
		System.out.print("\nTest9 : votre methode a trouve "+ min +" comme la plus petite cote");
		System.out.println(" pour l'etudiant : "+ etudiant);


		
		// test max()
		System.out.println("\n\n\nTest max : ");
		double max;

		// Test10 : 3 cotes - max est la premiere
		double[] tableTestee10 = {17,14,6};
		etudiant = new Etudiant(1,tableTestee10);
		max = etudiant.max();
		System.out.print("\nTest10 : votre methode a trouve "+ max +" comme la plus grande cote");
		System.out.println(" pour l'etudiant : "+ etudiant);
	
		// Test11 : 5 cotes - max est la derniere
		double[] tableTestee11 = {13,14,16,8,17};
		etudiant = new Etudiant(2,tableTestee11);
		max = etudiant.max();
		System.out.print("\nTest11 : votre methode a trouve "+ max +" comme la plus grande cote");
		System.out.println(" pour l'etudiant : "+ etudiant);
			
		// Test12 : 5 cotes - max au mileu
		double[] tableTestee12 = {13,14,16,8,7};
		etudiant = new Etudiant(3,tableTestee12);
		max = etudiant.max();
		System.out.print("\nTest12 : Votre methode a trouve "+ max +" comme la plus grande cote");
		System.out.println(" pour l'etudiant : "+ etudiant);
	
	}
}
