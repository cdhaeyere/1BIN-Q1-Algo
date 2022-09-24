/*
    @Author: Corentin D'haeyere
 */
public class Client {

    private String nom;
    private String prenom;
    private double[] tableMontants;
    private static final int TAILLE = 10;

    /**
     * construit un client avec ses 10 meilleurs montants = 0
     * @param nom nom du client
     * @param prenom prenom
     */
    public Client (String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.tableMontants = new double[TAILLE];
    }

    /**
     * ajoute le montant si celui-ci fait partie des 10 meilleurs montants
     * le tri de la table doit etre respecte
     * @param montant le montant a eventuellement ajouter
     * @return true si le montant a ete ajoute, false sinon
     */
    public boolean ajouter(double montant) {
        if (tableMontants[TAILLE-1] >= montant) {
            return false;
        }
        for (int i = TAILLE-2; i >= 0; i--) {
            if (tableMontants[i] < montant) {
                tableMontants[i+1] = tableMontants[i];
            } else {
                tableMontants[i+1] = montant;
                return true;
            }
        }
        tableMontants[0] = montant;
        return true;
    }

    @Override
    public String toString() {
        String aRenvoyer = "" + nom + " " + prenom + "  montants : ";
        for (int i = 0; i < TAILLE; i++) {
            aRenvoyer += " "+tableMontants[i];
        }
        return aRenvoyer;
    }
}
