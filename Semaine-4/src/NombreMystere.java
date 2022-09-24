import java.util.Scanner;
/*
    @Author : Corentin D'haeyere
 */
public class NombreMystere {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int nombre = unEntierAuHasardEntre(0, 100);
        int entry;
        System.out.println("Nombre mystere");
        do {
            System.out.println("Entrer un nombre :");
            entry = scanner.nextInt();
            if (entry > nombre) {
                System.out.println("Le nombre est inferieur à celui rentrer");
            } else if (entry < nombre) {
                System.out.println("Le nombre est supérieur à celui rentrer");
            }
        }
        while (nombre != entry);
        System.out.println("Félicitations, vous avez trouvé le nombre mystère");
    }

    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        double nombreReel;
        int resultat;

        nombreReel = Math.random();
        resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
        return resultat;
    }
}
