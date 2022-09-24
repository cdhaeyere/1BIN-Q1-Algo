import java.util.Scanner;
/*
    @Author : Corentin D'haeyere
 */
public class SommeCentEntiers {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int somme = 0;
        for (int i = 0; i < 100; i++) {
            System.out.println("Entrer l'entier "+ i +" :");
            int entier = scanner.nextInt();
            somme = somme + entier;
        }
    }
}
