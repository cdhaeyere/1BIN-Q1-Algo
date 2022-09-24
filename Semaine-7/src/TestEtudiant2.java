/*
	@author Corentin D'haeyere
 */
public class TestEtudiant2 {
	
	
	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * 
	 * @param messageErreur
	 *            message a afficher en cas de probleme
	 * @param attendu
	 *            la valeur qu'on s'attendait a recevoir
	 * @param recu
	 *            la valeur qu'on a re�u en realite
	 */
	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu == null) {
			if (recu != null) {
				System.out.println(messageErreur);
				System.out.println("Attendu : " + attendu);
				System.out.println("Re�u : " + recu);
				System.exit(0);
			}
		} else {
			if (attendu instanceof Character && recu instanceof String) {
				attendu = "" + attendu;
			}
			if (attendu instanceof String && recu instanceof Character) {
				recu = "" + recu;
			}
			if (!attendu.equals(recu)) {
				System.out.println(messageErreur);
				System.out.println("Attendu : " + attendu);
				System.out.println("Re�u : " + recu);
				System.exit(0);
			}
		}
		
	}
	
	public static void main(String [] args){

		System.out.println("**************************************");
		System.out.println("Programme Test pour la classe Etudiant");
		System.out.println("**************************************");
		Etudiant etudiant;
		
		// test moyenne()

		// test1 : etudiant avec 4 cotes
		double[] tableTestee = {10,12,14,16};
		etudiant = new Etudiant(1,tableTestee);
		assertEquals("test1 ko", 13.0, etudiant.moyenne());

		// test2 : etudiant avec 5 cotes
		double[] tableTestee2 = {10,12,14,16,18};
		etudiant = new Etudiant(2,tableTestee2);
		assertEquals("test2 ko", 14.0, etudiant.moyenne());


		
		// test nombreEchecs

		// test3 : 4 cotes, 0 echec
		double[] tableTestee3 = {10,10,10,10};
		etudiant = new Etudiant(1,tableTestee3);
		assertEquals("test3 ko", 0, etudiant.nombreEchecs());

		// test4 : 3 cotes, 0 echec
		double[] tableTestee4 = {10,10,10};
		etudiant = new Etudiant(2,tableTestee4);
		assertEquals("test4 ko", 0, etudiant.nombreEchecs());

		// test5 : 3 cotes, 3 echecs
		double[] tableTestee5 = {9,9,9};
		etudiant = new Etudiant(3,tableTestee5);
		assertEquals("test5 ko", 3, etudiant.nombreEchecs());

		// test6 : 5 cotes, 2 echecs
		double[] tableTestee6 = {10,10,9,10,9};
		etudiant = new Etudiant(4,tableTestee6);
		assertEquals("test6 ko", 2, etudiant.nombreEchecs());


		
		// test methode min

		// Test7 : 3 cotes - min est la premiere
		double[] tableTestee7 = {3,14,6};
		etudiant = new Etudiant(1,tableTestee7);
		assertEquals("test7 ko", 3.0, etudiant.min());

		// Test8 : 5 cotes - min est la derniere
		double[] tableTestee8 = {13,14,16,8,7};
		etudiant = new Etudiant(2,tableTestee8);
		assertEquals("test8 ko", 7.0, etudiant.min());

		// Test9 : 5 cotes - min au mileu
		double[] tableTestee9 = {13,14,6,8,7};
		etudiant = new Etudiant(3,tableTestee9);
		assertEquals("test9 ko", 6.0, etudiant.min());



		// test max

		// Test10 : 3 cotes - max est la premiere
		double[] tableTestee10 = {17,14,6};
		etudiant = new Etudiant(1,tableTestee10);
		assertEquals("test10 ko", 17.0, etudiant.max());

		// Test11 : 5 cotes - max est la derniere
		double[] tableTestee11 = {13,14,16,8,17};
		etudiant = new Etudiant(17,tableTestee11);
		assertEquals("test11 ko", 17.0, etudiant.max());

		// Test12 : 5 cotes - max au mileu
		double[] tableTestee12 = {13,14,16,8,7};
		etudiant = new Etudiant(3,tableTestee12);
		assertEquals("test12 ko", 16.0, etudiant.max());

		System.out.println("Tous les tests ont reussi.");

	}
}
