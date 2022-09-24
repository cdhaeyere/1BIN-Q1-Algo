import java.util.Scanner;
/*
    @Author : Corentin D'haeyere
 */
public class CalculMoyenne {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int somme = 0;
        int number = 0;
        System.out.println("Calculateur de moyenne");
        do {
            System.out.println("Rentrer une valeur :");
            int entry = scanner.nextInt();
            somme = somme + entry;
            number++;
            System.out.println("Taper Y si vous voulez entrer une autre valeur sinon taper N !");
        } while (scanner.next().charAt(0) == 'Y');
        System.out.println("La moyenne est de " + somme/number);
    }
}
