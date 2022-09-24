/*
    @Author: Corentin D'haeyere
 */
public class RechercheMax2 {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Entrez l'entier 1 : ");
        int entier1 = scanner.nextInt();
        System.out.println("Entrez l'entier 2 : ");
        int entier2 = scanner.nextInt();

        if(entier1 < entier2) {
            System.out.println("Le plus grand entier est " + entier2);
        } else {
            System.out.println("Le plus grand entier est " + entier1);
        }
    }
}
