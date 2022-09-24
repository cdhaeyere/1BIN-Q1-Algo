/*
    @Author : Corentin D'haeyere
 */
public class DeuxMeilleuresCotes {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		int coteMax1 = Integer.MIN_VALUE;
		int coteMax2 = Integer.MIN_VALUE;
		
		for (int i = 1; i <= 5 ; i++) {
			System.out.print("Entrez la cote n°" + i + ": ");
			int cote = scanner.nextInt();
			if(cote > coteMax1){
				coteMax2 = coteMax1;
				coteMax1 = cote;
			} else {
				if(cote > coteMax2){
					coteMax2 = cote;
				}
			}		
		}
		
		System.out.println("La meilleure cote est "+coteMax1);
		System.out.println("La deuxieme meilleure cote est "+coteMax2);
			
	}
}
