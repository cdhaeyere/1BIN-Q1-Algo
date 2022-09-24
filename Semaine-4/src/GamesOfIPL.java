/*
    @Author : Corentin D'haeyere
 */
public class GamesOfIPL {

    public static void main(String[] args) {
        Guerrier guerrier1 = new Guerrier("FrappeFort", 25);
        Guerrier guerrier2 = new Guerrier("CogneDur", 25);
        System.out.println(" /* Bienvenue au combat de FrappeFort et CogneDur */");
        System.out.println("----------------------------------------------------------------------");
        while (guerrier1.getPointsDeVie() > 0 && guerrier2.getPointsDeVie() > 0) {
            int degat1 = unEntierAuHasardEntre(0, 6);
            int degat2 = unEntierAuHasardEntre(0, 6);
            System.out.println("Au tour de CogneDur de frapper :");
            System.out.println("CogneDur inflige " + degat1 + " points de dégat à FrappeFort");
            guerrier1.setPointsDeVie(guerrier1.getPointsDeVie() - degat1);
            System.out.println("Il reste " + guerrier1.getPointsDeVie() + " points de vie à FrappeFort");
            System.out.println("----------------------------------------------------------------------");
            if (guerrier1.getPointsDeVie() > 0) {
                System.out.println("Au tour de FrappeFort de frapper :");
                System.out.println("FrappeFort inflige " + degat2 + " points de dégat à CogneDur");
                guerrier2.setPointsDeVie(guerrier2.getPointsDeVie() - degat2);
                System.out.println("Il reste " + guerrier2.getPointsDeVie() + " points de vie à FrappeFort");
                System.out.println("----------------------------------------------------------------------");
            }
        }
        System.out.println("Le combat est terminé");
    }

    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        double nombreReel;
        int resultat;

        nombreReel = Math.random();
        resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
        return resultat;
    }
}
