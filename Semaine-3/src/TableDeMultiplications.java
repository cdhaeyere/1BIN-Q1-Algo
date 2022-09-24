import java.util.Scanner;
/*
    @Author : Corentin D'haeyere
 */
public class TableDeMultiplications {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Entrer le multiplicateur souhaité :");
        int multiplicateur = scanner.nextInt();
        for (int i = 0; i <= 10; i++) {
            int nombre = multiplicateur*i;
            System.out.println(multiplicateur + "x" + i + "=" + nombre);
        }
    }
}
