import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Championnat {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> cotesRetenues = new ArrayList<>();
        int coteMax = 0;
        int coteMin = 10;
        int moyenne = 0;
        for (int i = 1; i <= 8; i++) {
            System.out.println("Entrer la cote n°" + i + " :");
            int cote = scanner.nextInt();
            moyenne = moyenne + cote;
            if (cote > coteMax) {
                coteMax = cote;
            }
            else if (cote < coteMin) {
                coteMin = cote;
            }
        }
        moyenne = moyenne - coteMin - coteMax;
        double moy = moyenne/8;
        System.out.println("Votre moyenne est de " + moy);
        if (moy >= 8) {
            System.out.println("Vous êtes qualifié pour la finale");
        } else {
            System.out.println("Vous n'êtes pas qualifié");
        }
    }
}
