/*
	@author Corentin D'haeyere
 */
public class TestEtudiant3{
   	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

   	public static void main(String [] args){
		int choix;
		System.out.println("**************************************");
		System.out.println("Programme Test pour la classe Etudiant");
		System.out.println("**************************************");
		do{
			System.out.println();
			System.out.println("1 -> Tester la methode moyenne");
			System.out.println("2 -> Tester la methode nombreEchecs");
			System.out.println("3 -> Tester la methode min");
			System.out.println("4 -> Tester la methode max");
			System.out.println("5 -> Tester la methode nombreUEValidées");
			System.out.print("\nEntrez votre choix : ");
			choix=scanner.nextInt();
			switch(choix){
				case 1:
					verifierMoyenne();
					break;
				case 2:
					verifierNombreEchecs();
					break;
				case 3:
					verifierMin();
					break;
				case 4:
					verifierMax();
					break;
				case 5:
					verifierNombreUEValidees();
					break;
				default:
					break;
				}
			}while(choix >=1&&choix<=5);
			System.out.println("Merci pour votre visite.");
		}

	private static void verifierNombreUEValidees() {
		boolean tousReussis = true;
		Etudiant etudiant;
		int nbrUEValidees;

		// test1 : etudiant avec 4 cotes
		double[] tableTestee = {10,12,14,16};
		etudiant = new Etudiant(1,tableTestee);
		nbrUEValidees = etudiant.nombreUEValidees();
		if(nbrUEValidees != 4){
			System.out.print("\nAttention! Test1 ko : votre methode a trouve "+ nbrUEValidees);
			System.out.println(" pour l'etudiant : "+ etudiant);
			tousReussis = false;
		}

		// test2 : etudiant avec 5 cotes
		double[] tableTestee2 = {10,12,14,16,18};
		etudiant = new Etudiant(2,tableTestee2);
		nbrUEValidees = etudiant.nombreUEValidees();
		if(nbrUEValidees != 5){
			System.out.print("\nAttention! Test2 ko : votre methode a trouve "+ nbrUEValidees + " comme ");
			System.out.println(" pour l'etudiant : "+ etudiant);
			tousReussis = false;
		}
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}

	private static void verifierMoyenne(){
		boolean tousReussis = true;
		Etudiant etudiant;
		double moyenne;
		
		// test1 : etudiant avec 4 cotes
		double[] tableTestee = {10,12,14,16};
		etudiant = new Etudiant(1,tableTestee);
		moyenne = etudiant.moyenne();
		if(moyenne != 13){
			System.out.print("\nAttention! Test1 ko : votre methode a trouve la moyenne "+ moyenne);
			System.out.println(" pour l'etudiant : "+ etudiant);
			tousReussis = false;
		}
		
		// test2 : etudiant avec 5 cotes
		double[] tableTestee2 = {10,12,14,16,18};
		etudiant = new Etudiant(2,tableTestee2);
		moyenne = etudiant.moyenne();
		if(moyenne != 14){
			System.out.print("\nAttention! Test2 ko : votre methode a trouve la moyenne "+ moyenne);
			System.out.println(" pour l'etudiant : "+ etudiant);
			tousReussis = false;
		}
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}

	private static void verifierNombreEchecs(){
		boolean tousReussis = true;
		Etudiant etudiant; 
		int nombreEchecs;
		
		// test1 : 4 cotes, 0 echec
		double[] tableTestee1 = {10,10,10,10};
		etudiant = new Etudiant(1,tableTestee1);
		nombreEchecs = etudiant.nombreEchecs();
		if(nombreEchecs != 0){
			System.out.print("\nAttention! Test1 ko : votre methode a trouve "+ nombreEchecs +" echec(s)");
			System.out.println(" pour l'etudiant : "+ etudiant);
			tousReussis = false;	
		}
		
		// test2 : 3 cotes, 0 echec
		double[] tableTestee2 = {10,10,10};
		etudiant = new Etudiant(2,tableTestee2);
		nombreEchecs = etudiant.nombreEchecs();
		if(nombreEchecs != 0){
			System.out.print("\nAttention! Test2 ko : votre methode a trouve "+ nombreEchecs +" echec(s)");
			System.out.println(" pour l'etudiant : "+ etudiant);
			tousReussis = false;	
		}
		
		// test3 : 3 cotes, 3 echecs
		double[] tableTestee3 = {9,9,9};
		etudiant = new Etudiant(3,tableTestee3);
		nombreEchecs = etudiant.nombreEchecs();
		if(nombreEchecs != 3){
			System.out.print("\nAttention! Test3 ko : votre methode a trouve "+ nombreEchecs +" echec(s)");
			System.out.println(" pour l'etudiant : "+ etudiant);
			tousReussis = false;	
		}
		
		// test4 : 5 cotes, 2 echecs
		double[] tableTestee4 = {10,10,9,10,9};
		etudiant = new Etudiant(4,tableTestee4);
		nombreEchecs = etudiant.nombreEchecs();
		if(nombreEchecs != 2){
			System.out.print("\nAttention! Test4 ko : Votre methode a trouve "+ nombreEchecs +" echec(s)");
			System.out.println(" pour l'etudiant : "+ etudiant);
			tousReussis = false;	
		}
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}	
			

	private static void verifierMin(){
		boolean tousReussis = true;
		Etudiant etudiant;
		double min;
		
		// Test1 : 3 cotes - min est la premiere
		double[] tableTestee1 = {3,14,6};
		etudiant = new Etudiant(1,tableTestee1);
		min = etudiant.min();
		if(min != 3){
			System.out.print("\nAttention! Test1 ko : votre methode a trouve "+ min +" comme la plus petite cote");
			System.out.println(" pour l'etudiant : "+ etudiant);
			tousReussis = false;	
		}
		
		// Test2 : 5 cotes - min est la derniere
		double[] tableTestee2 = {13,14,16,8,7};
		etudiant = new Etudiant(2,tableTestee2);
		min = etudiant.min();
		if(min != 7){
			System.out.print("\nAttention! Test2 ko : votre methode a trouve "+ min +" comme la plus petite cote");
			System.out.println(" pour l'etudiant : "+ etudiant);
			tousReussis = false;	
		}
		
		// Test3 : 5 cotes - min au mileu
		double[] tableTestee3 = {13,14,6,8,7};
		etudiant = new Etudiant(3,tableTestee3);
		min = etudiant.min();
		if(min != 6){
			System.out.print("\nAttention! Test3 ko : votre methode a trouve "+ min +" comme la plus petite cote");
			System.out.println(" pour l'etudiant : "+ etudiant);
			tousReussis = false;	
		}
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}

	private static void verifierMax(){
		boolean tousReussis = true;
		Etudiant etudiant;
		double max;
		
		// Test1 : 3 cotes - max est la premiere
		double[] tableTestee1 = {17,14,6};
		etudiant = new Etudiant(1,tableTestee1);
		max = etudiant.max();
		if(max != 17){
			System.out.print("\nAttention! Test1 ko : votre methode a trouve "+ max +" comme la plus grande cote");
			System.out.println(" pour l'etudiant : "+ etudiant);
			tousReussis = false;	
		}
		
		// Test2 : 5 cotes - max est la derniere
		double[] tableTestee2 = {13,14,16,8,17};
		etudiant = new Etudiant(2,tableTestee2);
		max = etudiant.max();
		if(max != 17){
			System.out.print("\nAttention! Test2 ko : votre methode a trouve "+ max +" comme la plus grande cote");
			System.out.println(" pour l'etudiant : "+ etudiant);
			tousReussis = false;	
		}
		
		// Test3 : 5 cotes - max au mileu
		double[] tableTestee3 = {13,14,16,8,7};
		etudiant = new Etudiant(3,tableTestee3);
		max = etudiant.max();
		if(max != 16){
			System.out.print("\nAttention! Test3 ko : Votre methode a trouve "+ max +" comme la plus grande cote");
			System.out.println(" pour l'etudiant : "+ etudiant);
			tousReussis = false;	
		}
		if(tousReussis)
			System.out.println("Tous les tests ont reussi.");
	}

	
}
