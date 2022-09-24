/*
    @Author: Corentin D'haeyere
 */
public class DivisionEntiere {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Entrez l'entier 1 : ");
		int entier1 = scanner.nextInt();
		System.out.print("Entrez l'entier 2 : ");
		int entier2 = scanner.nextInt();
		int quotient = 0;
		try {
			quotient = entier1 / entier2;
		} catch (ArithmeticException e) {
			System.out.println("Division par 0");
			return;
		}
		System.out.println(entier1+"/"+entier2+" = "+quotient);
	}
}
