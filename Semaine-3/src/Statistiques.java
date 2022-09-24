/*
    @Author : Corentin D'haeyere
 */
public class Statistiques {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Entrez le nombre de cotes : ");
		int nombreCotes = scanner.nextInt();
		double somme = 0;
		double coteMax = -Double.MAX_VALUE; // le plus petit reel
		double coteMin = Double.MAX_VALUE;
		double moyenne = 0;
		for (int i = 1; i <= nombreCotes ; i++) {
			System.out.print("Entrez la cote n°" + i + ": ");
			double cote = scanner.nextDouble();
			if(cote>coteMax){
				coteMax = cote;
			}
			if (cote<coteMin) {
				coteMin = cote;
			}
			somme = somme + cote;
			moyenne = somme/nombreCotes;
		}
		System.out.println("La cote la plus elevee est "+ coteMax);
		System.out.println("La cote la plus petite est "+ coteMin);
		System.out.println("La moyenne des cotes est " + moyenne);
	}
}
