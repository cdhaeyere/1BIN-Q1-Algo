import java.util.Scanner;
/*
    @Author : Corentin D'haeyere
 */
public class RecitationTableMultiplication {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int random = unEntierAuHasardEntre(1, 20);
        System.out.println("Tu vas donner la table de " + random);
        int multiplicateur = 0;
        System.out.println(random + "x" + multiplicateur + "= ?");
        while (random * multiplicateur == scanner.nextInt() && multiplicateur <= 10) {
            multiplicateur++;
            if (multiplicateur > 10) {
                System.out.println("Félicitations");
            } else {
                System.out.println(random + "x" + multiplicateur + "= ?");
            }
        }
        System.out.println("Non c'est faux, la bonne réponse était " + random * multiplicateur);
    }

    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        double nombreReel;
        int resultat;

        nombreReel = Math.random();
        resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
        return resultat;
    }
}
