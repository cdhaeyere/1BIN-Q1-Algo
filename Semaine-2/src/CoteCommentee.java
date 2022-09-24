import java.util.Scanner;
/*
    @Author: Corentin D'haeyere
 */
public class CoteCommentee {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Entrer la cote de l'elève");
        int cote = scanner.nextInt();
        if (cote < 10) {
            System.out.println("L'étudiant n'a pas validé l'UE");
        }
        else if (cote <= 14) {
            System.out.println("L'étudiant a validé l'UE");
        }
        else if (cote <= 16) {
            System.out.println("L'étudiant a validé l'UE avec une belle cote");
        }
        else {
            System.out.println("L'étudiant a validé l'UE avec une très belle cote");
        }
    }
}
