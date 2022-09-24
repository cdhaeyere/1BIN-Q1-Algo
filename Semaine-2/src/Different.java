import java.util.Scanner;
/*
    @Author: Corentin D'haeyere
 */
public class Different {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Entrer trois nombres entiers l'un à la suite de l'autre");
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int third = scanner.nextInt();
        if (first != second && first != third && second != third) {
            System.out.println("Les nombres entrés sont tous différents");
        } else {
            System.out.println("Les nombres entrés ne sont pas différents");
        }
    }
}
