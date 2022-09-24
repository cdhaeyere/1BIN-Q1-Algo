/*
    @Author Corentin D'haeyere
 */
public class CalculMoyenne {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int nombreCotes = 0;
        double totalCotes = 0;
        char reponse;
        do {
            System.out.print("Entrez une cote (sur 20) : ");
            totalCotes += Utilitaires.lireReelComprisEntre(0, 20);
            nombreCotes++;
            System.out.print("Encore une cote (o/n) ? ");
            reponse = Utilitaires.lireOouN();
        } while (reponse == 'o');
        System.out.print("La moyenne des cotes : " + totalCotes/nombreCotes);
    }

}
