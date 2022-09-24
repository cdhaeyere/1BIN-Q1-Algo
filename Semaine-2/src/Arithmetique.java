import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
    @Author: Corentin D'haeyere
 */
public class Arithmetique {

    public static Scanner scanner = new Scanner(System.in);
    public static List<Character> operations = new ArrayList<>();

    public static void main(String[] args) {

        //On demande les deux nombres à la personne
        System.out.println("Entrer deux nombres l'un à la suite de l'autre entre 1 et 100");
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        operations.add('+');
        operations.add('-');
        operations.add('*');
        operations.add('/');

        //On verifie s'ils sont compris entre 1 et 100
        if (0 < first && first < 101 && 0 < second && second < 101) {

            //On choisit une opération au hasard entre l'addition, la soustraction, la multiplication et la division
            Character cha = operations.get(unEntierAuHasardEntre(0,3));
            int result = 0;
            switch (cha) {
                case '+':
                    result = first + second;
                    System.out.println(first + " + " + second + " = " + result);
                    break;
                case '-':
                    result = first - second;
                    System.out.println(first + " - " + second + " = " + result);
                    break;
                case '*':
                    result = first * second;
                    System.out.println(first + " * " + second + " = " + result);
                    break;
                case '/':
                    result = first/second;
                    System.out.println(first + " / " + second + " = " + result);
                    break;
                default:
                    break;
                }
        } else {
            System.out.println("Vous deviez rentrer deux nombres compris entre 1 et 100");
        }
    }

    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        double nombreReel;
        int resultat;

        nombreReel = Math.random();
        resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
        return resultat;
    }
}
