import java.util.Arrays;
import java.util.Scanner;

/*
	@author Corentin D'haeyere
 */
public class StatistiquesTemperatures {
	
	public static Scanner scanner = new java.util.Scanner(System.in);
	public static Temperatures temperatures;
	
	public static void main(String[] args) {
		
		chargerTemperatures();
		System.out.println(temperatures.toString());
		
		System.out.println("*****************************");
		System.out.println("Temperatures : Statistiques :");
		System.out.println("*****************************");
		int choix;
		do{
			System.out.println();
			System.out.println("1 -> afficher toutes les temperatures");	
			System.out.println("2 -> calculer la moyenne");	
			System.out.println("3 -> température la plus basse");
			System.out.println("4 -> température la plus haute");
			System.out.println("5 -> nombre de jours de gel");
			System.out.println("6 -> jours de gel");
			System.out.println("7 -> toutes les températures positives");
			System.out.println("8 -> au moins une température négative");
			System.out.println("9 -> jours au temp max");
			System.out.println("10 -> jours au temp min");
			System.out.print("Entrez votre choix : ");	
			choix = scanner.nextInt();
			switch(choix){	
				case 1:
					afficherTout();
					break;
				case 2:
					afficherMoyenne();
					break;
				case 3:
					afficherTempMin();
					break;
				case 4:
					afficherTempMax();
					break;
				case 5:
					afficherNbrJoursDeGel();
					break;
				case 6:
					afficherJoursDeGel();
					break;
				case 7:
					afficherToutesPositifes();
					break;
				case 8:
					afficherAuMoinsUneNegative();
					break;
				case 9:
					afficherJoursMax();
					break;
				case 10:
					afficherJoursMin();
					break;
				default:
					break;
			}
		}while(choix >=1 && choix<=2);
	}

	private static void afficherJoursMin() {
		System.out.println("Jours min : ");
		afficherTable(temperatures.joursMin());
	}

	private static void afficherJoursMax() {
		System.out.println("Jours max : ");
		afficherTable(temperatures.joursMax());
	}

	private static void afficherTempMax() {
		System.out.println("La temerature maximum est : " + temperatures.temperatureMax());
	}

	private static void afficherAuMoinsUneNegative() {
		System.out.println("Au moins une négative : " + temperatures.contientAuMoinsUnJourDeGel());
	}

	private static void afficherToutesPositifes() {
		System.out.println("Toutes positives : " + temperatures.toutesPositives());
	}

	private static void afficherJoursDeGel() {
		System.out.println("Jours de gel : "); afficherTable(temperatures.joursDeGel());
	}

	private static void afficherNbrJoursDeGel() {
		System.out.println("Nombre jours de gel" + temperatures.nombreJoursDeGel());
	}

	private static void afficherTout() {
		System.out.println(temperatures.toString());
	}

	private static void afficherMoyenne() {
		System.out.println("La moyenne est de : " + temperatures.moyenne());
	}

	private static void afficherTempMin() {
		System.out.println("La température minimum est " + temperatures.temperatureMin());
	}

	public static void chargerTemperatures(){
		double[]tableTemperatures = {-1,1,0,1,-1,-3,-3,-2,0,-1,0,1,1,3,5,4,2,0,1,1,5,3,2,0,-1,0,1,1,3,4,5};
		temperatures = new Temperatures("janvier",tableTemperatures);
	}
	
	public static void afficherTable(int[]table){
		System.out.println(Arrays.toString(table));
	}
	
}
