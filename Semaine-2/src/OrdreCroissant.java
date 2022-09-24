import java.util.Scanner;
/*
    @Author: Corentin D'haeyere
 */
public class OrdreCroissant {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Entrer un nombre :");
        int first = scanner.nextInt();
        System.out.println("Entrer un second nombre");
        int second = scanner.nextInt();
        if (first < second) {
            System.out.println(first + "/" + second);
        } else {
            System.out.println(second + "," + first);
        }
    }
}
