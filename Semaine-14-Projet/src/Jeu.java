public class Jeu {

    private static final int TAILLE_MIN = 7;
    private static final int TAILLE_MAX = 10;

    private static final java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main (String[] args) {

        System.out.print("Entrez la taille de la grille (entre " +
                TAILLE_MIN + " et " + TAILLE_MAX + "): ");
        int taille = scanner.nextInt();
        if (taille<TAILLE_MIN || taille>TAILLE_MAX) {
            System.out.println("Erreur: Taille non valide");
            return;
        }
        Grille grille = new Grille(taille) ;
        PlateauDeJeu plateau = new PlateauDeJeu(grille);
        plateau.afficherInformations("Debut de la partie");

        int colonne;
        int ligne;
        int couleur = Grille.ROUGE;

        // Boucle de jeu, tant que la grille est pas pleine -> on continue
        while (!grille.grillePleine()) {
            // Premier joueur (rouge)
            plateau.afficherJetonSuivant(couleur);
            colonne = plateau.cliquerColonne();
            while (grille.colonnePleine(colonne)) {
                plateau.afficherInformations("Colonne pleine");
                colonne = plateau.cliquerColonne();
            }
            ligne = grille.placerJeton(couleur, colonne);
            plateau.actualiserGrille();

            // Différents cas ou le jeu s'arrete
            if (grille.grillePleine()) {
                plateau.afficherInformations("Aucun joueur n'a gagne :(");
                break;
            } else if (grille.verifier4JetonsCol(ligne, colonne)) {
                plateau.afficherInformations("Gagné ! 4 jetons dans colonne");
                break;
            } else if (grille.verifier4JetonsLig(ligne, colonne)) {
                plateau.afficherInformations("Gagné ! 4 jetons dans ligne");
                break;
            } else if (grille.verifier4JetonsDiag(ligne, colonne)) {
                plateau.afficherInformations("Gagné ! 4 jetons dans diagonale");
                break;
            }

            // Definition du prochain joueur à jouer
            couleur = couleur == Grille.ROUGE ? Grille.VERT : Grille.ROUGE;
        }
    }
}
