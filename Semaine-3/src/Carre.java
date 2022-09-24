import java.util.Scanner;
/*
    @Author : Corentin D'haeyere
 */
public class Carre {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Entrez la taille (n) : ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print('X');
            }
            System.out.println();
        }
    }
}
