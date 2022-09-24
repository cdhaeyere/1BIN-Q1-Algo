import java.util.Scanner;
/*
    @Author Corentin D'haeyere
 */
public class OperationArithmetique {

   public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("1 : Addition ");
        System.out.println("2 : Soustraction ");
        System.out.println("3 : Multiplication ");
        System.out.println("Faites votre choix :");
        double choix = Utilitaires.lireReelComprisEntre(1, 3);
        switch ((int) choix) {
            case 1:
                faireUneAddition();
                break;
            case 2:
                faireUneSoustraction();
                break;
            case 3:
                faireUneMultiplication();
                break;
            default:
                break;
        }
    }

    public static void faireUneAddition() {
        int x = Utilitaires.unEntierAuHasardEntre(0, 10);
        int y = Utilitaires.unEntierAuHasardEntre(0, 10);
        System.out.println(x + "+" + y + "= ?");
        int entry = scanner.nextInt();
        while (entry != x+y) {
            System.out.println("Mauvaise réponse, recommencer");
            entry = scanner.nextInt();
        }
        System.out.println("Bonne réponse !");
    }

    public static void faireUneSoustraction() {
        int x = Utilitaires.unEntierAuHasardEntre(0, 10);
        int y = Utilitaires.unEntierAuHasardEntre(0, 10);
        System.out.println(x + "-" + y + "= ?");
        int entry = scanner.nextInt();
        while (entry != x-y) {
            System.out.println("Mauvaise réponse, recommencer");
            entry = scanner.nextInt();
        }
        System.out.println("Bonne réponse !");
    }

    public static void faireUneMultiplication() {
        int x = Utilitaires.unEntierAuHasardEntre(0, 10);
        int y = Utilitaires.unEntierAuHasardEntre(0, 10);
        System.out.println(x + "*" + y + "= ?");
        int entry = scanner.nextInt();
        while (entry != x*y) {
            System.out.println("Mauvaise réponse, recommencer");
            entry = scanner.nextInt();
        }
        System.out.println("Bonne réponse !");
    }
}
