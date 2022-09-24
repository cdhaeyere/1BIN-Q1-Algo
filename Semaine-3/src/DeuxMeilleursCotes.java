import java.util.Scanner;

public class DeuxMeilleursCotes {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int coteSup1 = 0;
        int coteSup2 = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.println("Entrer la " + i + " cote :");
            int nombre = scanner.nextInt();
            if (nombre>coteSup1) {
                coteSup1 = nombre;
            }
            if (nombre > coteSup2 && nombre < coteSup1) {
                coteSup2 = nombre;
            }
        }
        System.out.println("La premiere cote est de " + coteSup1);
        System.out.println("La deuxeime cote est de " + coteSup2);
    }
}
