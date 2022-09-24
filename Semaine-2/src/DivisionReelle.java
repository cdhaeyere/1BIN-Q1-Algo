/*
    @Author: Corentin D'haeyere
 */
public class DivisionReelle {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Entrez le reel 1 : ");
		double reel1 = scanner.nextDouble();
		System.out.print("Entrez le reel 2 : ");
		double reel2 = scanner.nextDouble();
		double quotient = reel1/reel2;
		System.out.println(reel1+"/"+reel2+" = "+quotient);
	}
}
