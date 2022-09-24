import java.util.Scanner;
/*
    @Author : Corentin D'haeyere
 */
public class NombreNegatifsParmi10 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int negatifs = 0;
        System.out.println("Entrer 10 entiers l'un à la suite de l'autre pour déterminer le nombre de négatifs présents :");
        for (int i = 0; i < 10; i++) {
            int nombre = scanner.nextInt();
            if (nombre < 0) {
                negatifs++;
            }
        }
        System.out.println("Il n'y a que " + negatifs + "négatifs dans le série de nombre rentrée");
    }
}
