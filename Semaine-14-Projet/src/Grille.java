public class Grille {
    // Types de jetons
    public static final int VIDE       = 0;   // case vide
    public static final int ROUGE      = 1;
    public static final int VERT       = 2;
    public static final int BOMBE      = 3;

    public int[][] table ;        // grille du jeu
    private int taille ;          // taille de la grille
    private int nbreJetons;       // nombre de jetons dans la grille


    public Grille (int taille) {
        this.taille = taille ;
        this.nbreJetons = 0;
        this.table = new int[taille][taille] ;
    }

    // ========================== //
    //   METHODES A IMPLEMENTER   //
    // ========================== //

    /**
     * place un jeton dans une colonne
     * @param couleur
     *          la couleur du jeton � placer
     * @param colonne
     *          la colonne o� le jeton doit �tre plac�
     * @return l'indice de la ligne o� le jeton est tomb�
     * @throws IllegalArgumentException
     *          si la couleur ou l'indice de colonne
     *          sont invalides ou si la colonne est pleine
     */
    public int placerJeton (int couleur, int colonne) {
        if (couleur < VIDE || couleur > VERT)
            throw new IllegalArgumentException();
        if (colonne < 0 || colonne >= taille)
            throw new IllegalArgumentException();
        if (colonnePleine(colonne))
            throw new IllegalArgumentException();

        for (int i = 0; i < taille; i++) {
            if (table[i][colonne] == VIDE) {
                table[i][colonne] = couleur;
                nbreJetons++;
                return i;
            }
        }
        return 0;
    }

    /**
     * v�rifie si une colonne contient une succession de 4 jetons de m�me couleur
     * @param lig
     *          la ligne o� le dernier jeton a �t� plac�
     * @param col
     *          la colonne o� le dernier jeton a �t� plac�
     * @return true si la colonne col contient une succession de 4 jetons de m�me couleur
     *         dont le dernier se trouve � la ligne lig ; false sinon
     * @throws IllegalArgumentException
     *          si l'indice de ligne ou de colonne est invalide
     */
    public boolean verifier4JetonsCol (int lig, int col) {
        if (lig < 0 || lig >= taille || col < 0 || col >= taille)
            throw new IllegalArgumentException();
        if (lig < 3) return false;
        int index = 1;
        for (int i = 1; i < taille; i++) {
            if (table[lig - i][col] == table[lig][col])
                index++;
        }
        return (index == 4);
    }

    /**
     * v�rifie si une ligne contient une succession de 4 jetons de m�me couleur
     * @param lig
     *          la ligne o� le dernier jeton a �t� plac�
     * @param col
     *          la colonne o� le dernier jeton a �t� plac�
     * @return true si la ligne lig contient une succession de 4 jetons de m�me couleur
     *         dont un jeton se trouvant � la colonne col ; false sinon
     * @throws IllegalArgumentException
     *          si l'indice de ligne ou de colonne est invalide
     */
    public boolean verifier4JetonsLig (int lig, int col) {
        if (lig < 0 || lig >= taille || col < 0 || col >= taille)
            throw new IllegalArgumentException();
        if (col < 3) return false;
        int index = 0;
        for (int i = 0; i < taille; i++) {
            if (table[lig][i] == table[lig][col]) {
                index++;
                if (index == 4) return true;
            } else
                index = 0;
        }
        return false;
    }

    /**
     * v�rifie si une diagonale contient une succession de 4 jetons de m�me couleur
     * @param lig
     *          la ligne o� le dernier jeton a �t� plac�
     * @param col
     *          la colonne o� le dernier jeton a �t� plac�
     * @return true si une des deux diagonales passant par la case (lig,col) contient
     *         une succession de 4 jetons de m�me couleur, dont le jeton se trouvant
     *         � la colonne col et la ligne lig ; false sinon
     * @throws IllegalArgumentException
     *          si l'indice de ligne ou de colonne est invalide
     */
    public boolean verifier4JetonsDiag (int lig, int col) {
        if (lig < 0 || lig >= taille || col < 0 || col >= taille)
            throw new IllegalArgumentException();
        int nbMemeCouleurPentePostive = 1;
        int couleurJeton = table[lig][col];
        int i = 1;
        while (lig - i >= 0 && col - i >= 0 && couleurJeton == table[lig - i][col - i]) {
            nbMemeCouleurPentePostive++;
            i++;
        }
        i = 1;
        while (lig + i < taille && col + i < taille && couleurJeton == table[lig + i][col + i]) {
            nbMemeCouleurPentePostive++;
            i++;
        }
        if (nbMemeCouleurPentePostive >= 4) {
            return true;
        }

        int nbMemeCouleurPenteNegative = 1;
        i = 1;
        while (lig - i >= 0 && col + i < taille && couleurJeton == table[lig - i][col + i]) {
            nbMemeCouleurPenteNegative++;
            i++;
        }
        i = 1;
        while (lig + i < taille && col - i >= 0 && couleurJeton == table[lig + i][col - i]) {
            nbMemeCouleurPenteNegative++;
            i++;
        }
        return nbMemeCouleurPenteNegative >= 4;
    }

    // ====================================== //
    //   METHODES FOURNIES (NE PAS MODIFIER)  //
    // ====================================== //

    public int getTaille(){
        return taille;
    }

    public int getNombreJetons () {
        return nbreJetons;
    }

    public boolean grillePleine () {
        return nbreJetons == taille*taille;
    }

    public boolean colonnePleine (int colonne) {
        return table[taille-1][colonne] != VIDE;
    }

    public String toString() {
        String st = "\nNombre de jetons dans la grille: " + nbreJetons + " (max: " + taille*taille + ")\n";
        st += "    ";
        for (int c=0 ; c<taille ; c++)
            st += c + " ";
        st += "\n   ";
        for (int c=0 ; c<taille ; c++)
            st += "--";
        st += "\n";
        for (int l=taille-1 ; l>=0 ; l--) {
            st += l + "|  ";
            for (int c=0 ; c<taille ; c++) {
                st = st+table[l][c]+" " ;
            }
            st += '\n' ;
        }
        return st ;
    }

    // M�thode d�finie pour les tests - NE PAS MODIFIER
    public void setGrilleTest (int[][] testGrille) {
        table = testGrille;
        nbreJetons = 0;
        for (int l=0; l<taille; l++)
            for (int c=0; c<taille; c++)
                if (table[l][c] != VIDE)
                    nbreJetons++;
    }
}
