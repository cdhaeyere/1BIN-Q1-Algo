import java.util.Scanner;
/*
    @Author : Corentin D'haeyere
 */
public class SommeNegatifsEtPositifs {
    
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Entrer 5 entiers l'un à la suite de l'autre :");
        int sommePositifs = 0;
        int sommeNegatifs = 0;
        for (int i = 0; i < 5; i++) {
            int nombre = scanner.nextInt();
            if (nombre < 0) {
                sommeNegatifs = sommeNegatifs + nombre;
            } else {
                sommePositifs = sommePositifs + nombre;
            }
        }
        System.out.println("La somme des positifs est de : " + sommePositifs);
        System.out.println("La somme des négatifs est de : " + sommeNegatifs);
    }
}
