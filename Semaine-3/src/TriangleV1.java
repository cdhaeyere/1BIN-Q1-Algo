import java.util.Scanner;
/*
    @Author : Corentin D'haeyere
 */
public class TriangleV1 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Entrez la taille (n) : ");
        int n = scanner.nextInt();
        for (int µ = 1; µ <= n; µ++) {
            for (int i = 1; i <= µ; i++) {
                System.out.print('X');
            }
            System.out.println();
        }
    }
}
