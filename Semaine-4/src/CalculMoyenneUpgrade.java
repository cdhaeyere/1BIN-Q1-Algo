import java.util.Scanner;
/*
    @Author : Corentin D'haeyere
 */
public class CalculMoyenneUpgrade {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int somme = 0;
        int number = 0;
        char reponse;
        System.out.println("Calculateur de moyenne");
        do {
            System.out.println("Rentrer une valeur :");
            int entry = scanner.nextInt();
            somme = somme + entry;
            System.out.println("Taper Y si vous voulez entrer une autre valeur sinon taper N !");
            reponse = scanner.next().charAt(0);
            number++;
        } while (reponse == 'Y' || reponse == 'y' || reponse == 'O' || reponse == 'o');
        System.out.println("La moyenne est de " + somme/number);
    }
}
