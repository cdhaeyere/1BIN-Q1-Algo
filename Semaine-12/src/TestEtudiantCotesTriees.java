/*
    @Author: Corentin D'haeyere
 */
public class TestEtudiantCotesTriees{

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String [] args){
		int choix;
		System.out.println("******************************************************");
		System.out.println("Programme Test pour la classe Etudiant avec table triee");
		System.out.println("*******************************************************");
		System.out.println();
		do{
			System.out.println();
			System.out.println("1 -> Tester la methode moyenne");
			System.out.println("2 -> Tester la methode nombreEchecs");
			System.out.println("3 -> Tester la methode min");
			System.out.println("4 -> Tester la methode max");
			System.out.println();
			System.out.print("Entrez votre choix : ");
			choix=scanner.nextInt();
			switch(choix){

			case 1: verifierMoyenne(); 
			break;
			case 2: verifierNombreEchecs();
			break;
			case 3: verifierMin(); 
			break;
			case 4: verifierMax(); 
			break;
			}
		}while(choix >=1&&choix<=4);
		System.out.println("Merci pour votre visite.");
	}


	private static void verifierMoyenne(){
		double[] tableTestee = {10,12,14,16};
		EtudiantCotesTriees etudiant = new EtudiantCotesTriees(1,tableTestee);
		double moyenne = etudiant.moyenne();
		if(moyenne == 13)
			System.out.println("Tous les tests ont reussi!");
		else {
			System.out.println("Attention! Votre methode a trouve la moyenne "+ moyenne);
			System.out.println(" pour l'etudiant : "+ etudiant.toString());
		}
	}

	private static void verifierNombreEchecs(){

		boolean tousReussi = true;
		System.out.println("Cas 1 : 2 echecs parmi 4 cotes");

		double[] tableTestee = {1,6,14,16};
		EtudiantCotesTriees etudiant = new EtudiantCotesTriees(1,tableTestee);
		double nombreEchecs = etudiant.nombreEchecs();
		if(nombreEchecs != 2){ 
			System.out.println("Attention! Votre methode a trouve un nombre d'echecs : "+ nombreEchecs);
			System.out.println(" pour l'etudiant : "+ etudiant.toString());
			tousReussi = false;
		}
		System.out.println("Cas 2 : 4 echecs parmi 4 cotes");
		double[] tableTestee2 = {1,2,5,6};
		EtudiantCotesTriees etudiant2 = new EtudiantCotesTriees(1,tableTestee2);
		nombreEchecs = etudiant2.nombreEchecs();
		if(nombreEchecs != 4){ 
			System.out.println("Attention! Votre methode a trouve un nombre d'echecs : "+ nombreEchecs);
			System.out.println(" pour l'etudiant : "+ etudiant2.toString());
			tousReussi = false;
		}
		
		System.out.println("Cas 3 : 0 echecs parmi 4 cotes");
		double[] tableTestee3 = {17,18,18,19};
		EtudiantCotesTriees etudiant3 = new EtudiantCotesTriees(1,tableTestee3);
		nombreEchecs = etudiant3.nombreEchecs();
		if(nombreEchecs != 0){ 
			System.out.println("Attention! Votre methode a trouve un nombre d'echecs : "+ nombreEchecs);
			System.out.println(" pour l'etudiant : "+ etudiant3.toString());
			tousReussi = false;
		}
		
		System.out.println("Cas 4 : 0 echecs parmi 1 cote");
		double[] tableTestee4 = {17};
		EtudiantCotesTriees etudiant4 = new EtudiantCotesTriees(1,tableTestee4);
		nombreEchecs = etudiant4.nombreEchecs();
		if(nombreEchecs != 0){ 
			System.out.println("Attention! Votre methode a trouve un nombre d'echecs : "+ nombreEchecs);
			System.out.println(" pour l'etudiant : "+ etudiant4.toString());
			tousReussi = false;
		}
		
		if (tousReussi)
			System.out.println("Tous les tests ont reussi!");
	}	


	private static void verifierMin(){
		double[] tableTestee = {2,6,14,16};
		EtudiantCotesTriees etudiant = new EtudiantCotesTriees(1,tableTestee);
		double min = etudiant.min();
		if(min == 2)System.out.println("Tous les tests ont reussi!");
		else {
			System.out.println("Attention! Votre methode a trouve la cote min "+ min);
			System.out.println(" pour l'etudiant : "+ etudiant.toString());
		}
	}

	private static void verifierMax(){
		double[] tableTestee = {1,6,14,16};
		EtudiantCotesTriees etudiant = new EtudiantCotesTriees(1,tableTestee);
		double max = etudiant.max();
		if(max == 16)System.out.println("Tous les tests ont reussi!");
		else {
			System.out.println("Attention! Votre methode a trouve la cote max "+ max);
			System.out.println(" pour l'etudiant : "+ etudiant. toString());
		}
	}
	
}
