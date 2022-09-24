import java.util.Scanner;
/*
    @Author: Corentin D'haeyere
 */
public class TVA {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Entrer le prix hors TVA :");
        double prix = scanner.nextDouble();
        double tva = (prix/100)*21;
        double prixtva = prix + tva;
        System.out.println("Le prix avec TVA est de : " + prixtva);
    }
}
