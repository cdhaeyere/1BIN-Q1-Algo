import java.util.Scanner;
/*
    @Author: Corentin D'haeyere
 */
public class CalculBMI {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Entrer votre taille :");
        double taille = scanner.nextDouble();
        System.out.println("Entrer votre poids :");
        int poids = scanner.nextInt();
        double taillecarré = taille * taille;
        double bmi = poids/taillecarré;
        if (bmi < 20) {
            System.out.println("Vous etes maigre");
        } else {
            if (bmi > 25) {
                if (bmi > 30) {
                    System.out.println("Vous etes obese");
                    return;
                }
                System.out.println("Vous etes en embonpoint");
            } else {
                System.out.println("Vous etes normal");
            }
        }
    }
}
