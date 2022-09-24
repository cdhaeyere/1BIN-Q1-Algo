import java.util.Scanner;
/*
    @Author: Corentin D'haeyere
 */
public class Age {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Entrer l'annee de naissance de la personne :");
        int anneeNaissance = scanner.nextInt();
        System.out.println("Entrer l'anne civile actuelle :");
        int anneeCivile = scanner.nextInt();
        int age = anneeCivile - anneeNaissance;
        System.out.println("La personne aura " + age + " ans en " + anneeCivile);
    }
}
