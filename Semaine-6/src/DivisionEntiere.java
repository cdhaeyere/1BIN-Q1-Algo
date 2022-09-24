/*
    @Author Corentin D'haeyere
 */
public class DivisionEntiere {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Entrez l'entier 1 : ");
        int entier1 = Utilitaires.lireEntierNonNul("Entrer un entier non-nul");
        System.out.print("Entrez l'entier 2 : ");
        int entier2 = Utilitaires.lireEntierNonNul("Entrer un entier non-nul");
        int quotient = entier1/entier2;
        System.out.println(entier1+"/"+entier2+" = "+quotient);
    }
}
