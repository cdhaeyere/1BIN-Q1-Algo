public class TestGrille {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    /**
     * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
     *
     * @param messageErreur
     *            message a afficher en cas de probleme
     * @param attendu
     *            la valeur qu'on s'attendait a recevoir
     * @param recu
     *            la valeur qu'on a reçu en realite
     * @return true si le resultat attendu correspond au résultat obtenu ; false sinon
     */
    private static boolean assertEquals (String messageErreur, Object attendu, Object recu) {
        if (attendu == null) {
            if (recu != null) {
                System.out.println();
                System.out.println(messageErreur);
                System.out.println("\nAttendu : " + attendu);
                System.out.println("\nReçu : " + recu);
                return false;
            }
        } else {
            if (attendu instanceof Character && recu instanceof String) {
                attendu = "" + attendu;
            }
            if (attendu instanceof String && recu instanceof Character) {
                recu = "" + recu;
            }
            if (!attendu.equals(recu)) {
                System.out.println();
                System.out.println(messageErreur);
                System.out.println("\nAttendu : " + attendu);
                System.out.println("\nReçu : " + recu);
                return false;
            }
        }
        return true;
    }


    public static void main (String[] args) {

        int choix;
        System.out.println("Projet Puissance 4");
        System.out.println("********************************************");
        System.out.println("Programme Test pour la classe EtatJeu :");
        System.out.println("********************************************");
        do {
            System.out.println("\n1 -> Tester la methode 'placerJeton()'");
            System.out.println("2 -> Tester la methode 'verifier4JetonsCol()'");
            System.out.println("3 -> Tester la methode 'verifier4JetonsLig()'");
            System.out.println("4 -> Tester la methode 'verifier4JetonsDiag()'");

            System.out.print("\nEntrez votre choix : ");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    placer();
                    break;
                case 2:
                    verifierCol();
                    break;
                case 3:
                    verifierLig();
                    break;
                case 4:
                    verifierDiag();
                    break;
            }
        } while (choix >= 1 && choix <= 4);
        System.out.println("Merci pour votre visite.");
    }

    private static void placer () {

        Grille grille = new Grille(7);
        Grille grilleOK = new Grille(7);

        // test 1 : ajout dans colonne 0 vide
        try {
            int[][] m =
                    {
                            {0,0,0,0,0,0,0}, // m[0]
                            {0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0}
                    };
            grille.setGrilleTest(m);
            int ligne = grille.placerJeton(Grille.VERT, 0);
            int[][] mOK =
                    {
                            {2,0,0,0,0,0,0}, // m[0]
                            {0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0}
                    };
            grilleOK.setGrilleTest(mOK);
            if (!assertEquals("test 1 a echoue - placerJeton(VERT,0)",
                    grilleOK.toString(), grille.toString())) {
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 2 : ajout dans dernière colonne ayant déjà des jetons de l'autre couleur
        try {
            int[][] m =
                    {
                            {0,0,0,0,0,2,1}, // m[0]
                            {0,0,0,0,0,0,1},
                            {0,0,0,0,0,0,1},
                            {0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0}
                    };
            grille.setGrilleTest(m);
            int ligne = grille.placerJeton(Grille.VERT, 6);
            int[][] mOK =
                    {
                            {0,0,0,0,0,2,1}, // m[0]
                            {0,0,0,0,0,0,1},
                            {0,0,0,0,0,0,1},
                            {0,0,0,0,0,0,2},
                            {0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0},
                            {0,0,0,0,0,0,0}
                    };
            grilleOK.setGrilleTest(mOK);
            if (!assertEquals("test 2 a echoue - placerJeton(VERT,6)",
                    grilleOK.toString(), grille.toString())) {
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 3 : ajout dans colonne ayant une case vide
        try {
            int[][] m =
                    {
                            {0,1,1,0,0,0,0}, // m[0]
                            {0,0,2,0,0,0,0},
                            {0,0,1,0,0,0,0},
                            {0,0,2,0,0,0,0},
                            {0,0,1,0,0,0,0},
                            {0,0,2,0,0,0,0},
                            {0,0,0,0,0,0,0}
                    };
            grille.setGrilleTest(m);
            int ligne = grille.placerJeton(Grille.ROUGE, 2);
            int[][] mOK =
                    {
                            {0,1,1,0,0,0,0}, // m[0]
                            {0,0,2,0,0,0,0},
                            {0,0,1,0,0,0,0},
                            {0,0,2,0,0,0,0},
                            {0,0,1,0,0,0,0},
                            {0,0,2,0,0,0,0},
                            {0,0,1,0,0,0,0}
                    };
            grilleOK.setGrilleTest(mOK);
            if (!assertEquals("test 3 a echoue - placerJeton(ROUGE,2)",
                    grilleOK.toString(), grille.toString())) {
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        System.out.println("\nTous les tests ont réussi!\n");
    }

    private static void verifierCol() {

        Grille grille = new Grille(8);

        // test 1 : colonne vide
        try {
            int[][] m =
                    {
                            {1, 0, 0, 1, 0, 0, 0, 0}, // m[0]
                            {0, 0, 0, 2, 0, 0, 0, 0},
                            {0, 0, 0, 1, 0, 0, 0, 0},
                            {0, 0, 0, 2, 0, 0, 0, 0},
                            {0, 0, 0, 1, 0, 0, 0, 0},
                            {0, 0, 0, 2, 0, 0, 0, 0},
                            {0, 0, 0, 1, 0, 0, 0, 0},
                            {0, 0, 0, 2, 0, 0, 0, 0}
                    };
            grille.setGrilleTest(m);
            if (!assertEquals("test 1 a echoue - grille.verifier4JetonsCol(0,0)",
                    false, grille.verifier4JetonsCol(0, 0))) {
                System.out.println(grille);
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 2 : colonne pleine
        try {
            int[][] m =
                    {
                            {0, 0, 0, 1, 0, 0, 0, 0}, // m[0]
                            {0, 0, 0, 2, 0, 0, 0, 0},
                            {0, 0, 0, 1, 0, 0, 0, 0},
                            {0, 0, 0, 2, 0, 0, 0, 0},
                            {0, 0, 0, 1, 0, 0, 0, 0},
                            {0, 0, 0, 2, 0, 0, 0, 0},
                            {0, 0, 0, 1, 0, 0, 0, 0},
                            {0, 0, 0, 2, 0, 0, 0, 0}
                    };
            grille.setGrilleTest(m);
            if (!assertEquals("test 2 a echoue - grille.verifier4JetonsCol(7,3)",
                    false, grille.verifier4JetonsCol(7,3))){
                System.out.println(grille);
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 3 : colonne ayant 4 jetons successifs de la même couleur
        try {
            int[][] m =
                    {
                            {0, 1, 0, 1, 0, 0, 0, 2}, // m[0]
                            {0, 1, 0, 2, 0, 0, 0, 2},
                            {0, 1, 0, 1, 0, 0, 0, 2},
                            {0, 0, 0, 2, 0, 0, 0, 1},
                            {0, 0, 0, 2, 0, 0, 0, 2},
                            {0, 0, 0, 2, 0, 0, 0, 0},
                            {0, 0, 0, 2, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0}
                    };
            grille.setGrilleTest(m);
            if (!assertEquals("test 3 a echoue - grille.verifier4JetonsCol(6,3)",
                    true, grille.verifier4JetonsCol(6,3))){
                System.out.println(grille);
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 4 : colonne pleine ayant 4 jetons successifs de la même couleur au sommet de la colonne
        try {
            int[][] m =
                    {
                            {0, 1, 0, 1, 0, 0, 0, 2}, // m[0]
                            {0, 1, 0, 2, 0, 0, 0, 2},
                            {0, 1, 0, 1, 0, 0, 0, 2},
                            {0, 0, 0, 1, 0, 0, 0, 1},
                            {0, 0, 0, 2, 0, 0, 0, 2},
                            {0, 0, 0, 2, 0, 0, 0, 0},
                            {0, 0, 0, 2, 0, 0, 0, 0},
                            {0, 0, 0, 2, 0, 0, 0, 0}
                    };
            grille.setGrilleTest(m);
            if (!assertEquals("test 4 a echoue - grille.verifier4JetonsCol(7,3)",
                    true, grille.verifier4JetonsCol(7,3))){
                System.out.println(grille);
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 5 : colonne plaine ayant des jetons des deux couleurs
        try {
            int[][] m =
                    {
                            {0, 1, 0, 2, 0, 0, 0, 2}, // m[0]
                            {0, 1, 0, 1, 0, 0, 0, 2},
                            {0, 1, 0, 1, 0, 0, 0, 2},
                            {0, 0, 0, 1, 0, 0, 0, 1},
                            {0, 0, 0, 2, 0, 0, 0, 2},
                            {0, 0, 0, 1, 0, 0, 0, 0},
                            {0, 0, 0, 1, 0, 0, 0, 0},
                            {0, 0, 0, 1, 0, 0, 0, 0}
                    };
            grille.setGrilleTest(m);
            if (!assertEquals("test 5 a echoue - grille.verifier4JetonsCol(7,3)",
                    false, grille.verifier4JetonsCol(7,3))){
                System.out.println(grille);
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 5 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        System.out.println("\nTous les tests ont réussi!\n");
    }


    private static void verifierLig() {

        Grille grille = new Grille(7);

        // test 1 : ligne vide
        try {
            int[][] m =
                    {
                            {0, 1, 1, 2, 2, 2, 1}, // m[0]
                            {0, 0, 0, 1, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0}
                    };
            grille.setGrilleTest(m);
            if (!assertEquals("test 1 a echoue - grille.verifier4JetonsLig(1,3)",
                    false, grille.verifier4JetonsLig(1, 3))) {
                System.out.println(grille);
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 2 : ligne pleine
        try {
            int[][] m =
                    {
                            {1, 1, 1, 2, 2, 2, 1}, // m[0]
                            {0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0}
                    };
            grille.setGrilleTest(m);
            if (!assertEquals("test 2 a echoue - grille.verifier4JetonsLig(0,6)",
                    false, grille.verifier4JetonsLig(0,6))){
                System.out.println(grille);
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 3 : ligne ayant 4 jetons successifs de la même couleur
        try {
            int[][] m =
                    {
                            {1, 1, 1, 2, 2, 2, 1}, // m[0]
                            {2, 1, 1, 1, 1, 2, 0},
                            {0, 2, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0}
                    };
            grille.setGrilleTest(m);
            if (!assertEquals("test 3 a echoue - grille.verifier4JetonsLig(1,3)",
                    true, grille.verifier4JetonsLig(1,3))){
                System.out.println(grille);
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 4 : ligne pleine ayant 4 jetons successifs de la même couleur
        try {
            int[][] m =
                    {
                            {1, 1, 1, 2, 2, 2, 1}, // m[0]
                            {2, 1, 1, 1, 2, 2, 1},
                            {2, 2, 2, 2, 1, 1, 1},
                            {0, 0, 0, 0, 0, 0, 2},
                            {0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0}
                    };
            grille.setGrilleTest(m);
            if (!assertEquals("test 4 a echoue - grille.verifier4JetonsLig(2,3)",
                    true, grille.verifier4JetonsLig(2,3))){
                System.out.println(grille);
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 5 : ligne pleine ayant tous des jetons de la même couleur
        try {
            int[][] m =
                    {
                            {1, 1, 1, 2, 1, 2, 1}, // m[0]
                            {1, 2, 1, 1, 1, 2, 1},
                            {2, 2, 2, 2, 2, 2, 2},
                            {0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0}
                    };
            grille.setGrilleTest(m);
            if (!assertEquals("test 5 a echoue - grille.verifier4JetonsLig(2,3)",
                    true, grille.verifier4JetonsLig(2,3))){
                System.out.println(grille);
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 5 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 6 : ligne pleine ayant presque tous des jetons de la même couleur
        try {
            int[][] m =
                    {
                            {1, 1, 1, 2, 1, 2, 1}, // m[0]
                            {1, 1, 1, 1, 1, 2, 1},
                            {2, 2, 2, 1, 2, 2, 2},
                            {0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0}
                    };
            grille.setGrilleTest(m);
            if (!assertEquals("test 6 a echoue - grille.verifier4JetonsLig(2,0)",
                    false, grille.verifier4JetonsLig(2,0))){
                System.out.println(grille);
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 6 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 7 : grille pleine
        try {
            int[][] m =
                    {
                            {1, 2, 1, 2, 1, 2, 1}, // m[0]
                            {2, 1, 2, 1, 2, 1, 2},
                            {1, 2, 1, 2, 1, 2, 1},
                            {2, 1, 2, 1, 2, 1, 2},
                            {1, 2, 1, 2, 1, 2, 1},
                            {2, 1, 2, 1, 2, 1, 2},
                            {1, 2, 1, 2, 1, 2, 1}
                    };
            grille.setGrilleTest(m);
            if (!assertEquals("test 7 a echoue - grille.verifier4JetonsLig(6,6)",
                    false, grille.verifier4JetonsLig(6,6))){
                System.out.println(grille);
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 7 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 8 : grille pleine avec succession de 4 jetons de même couleur sur dernière ligne
        try {
            int[][] m =
                    {
                            {1, 2, 1, 2, 1, 2, 1}, // m[0]
                            {2, 1, 2, 1, 2, 1, 2},
                            {1, 2, 1, 2, 1, 2, 1},
                            {2, 1, 2, 1, 2, 1, 2},
                            {1, 2, 1, 2, 1, 2, 1},
                            {2, 1, 2, 1, 2, 1, 2},
                            {1, 2, 2, 2, 2, 1, 1}
                    };
            grille.setGrilleTest(m);
            if (!assertEquals("test 8 a echoue - grille.verifier4JetonsLig(6,1)",
                    true, grille.verifier4JetonsLig(6,1))){
                System.out.println(grille);
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 8 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        System.out.println("\nTous les tests ont réussi!\n");
    }


    private static void verifierDiag() {

        Grille grille = new Grille(8);

        // test 1 : diagonale gauche contenant 4 jetons successifs
        try {
            int[][] m =
                    {
                            {1, 2, 2, 1, 0, 0, 0, 0}, // m[0]
                            {2, 2, 1, 0, 0, 0, 0, 0},
                            {2, 1, 0, 0, 0, 0, 0, 0},
                            {1, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0}
                    };
            grille.setGrilleTest(m);
            if (!assertEquals("test 1 a echoue - grille.verifier4JetonsDiag(3,0)",
                    true, grille.verifier4JetonsDiag(3, 0))) {
                System.out.println(grille);
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 2 : même grille que test 1
        try {
            if (!assertEquals("test 2 a echoue - grille.verifier4JetonsDiag(1,2)",
                    true, grille.verifier4JetonsDiag(1, 2))) {
                System.out.println(grille);
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 3 : même grille que test 1
        try {
            if (!assertEquals("test 3 a echoue - grille.verifier4JetonsDiag(0,3)",
                    true, grille.verifier4JetonsDiag(0, 3))) {
                System.out.println(grille);
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 4 : diagonale droite ne contenant pas 4 jetons successifs
        try {
            int[][] m =
                    {
                            {0, 2, 1, 1, 1, 2, 1, 2}, // m[0]
                            {0, 0, 2, 1, 1, 1, 2, 1},
                            {0, 0, 1, 2, 2, 2, 1, 2},
                            {0, 0, 0, 0, 0, 1, 2, 1},
                            {0, 0, 0, 0, 0, 2, 1, 2},
                            {0, 0, 0, 0, 0, 0, 2, 1},
                            {0, 0, 0, 0, 0, 0, 0, 2},
                            {0, 0, 0, 0, 0, 0, 0, 0}
                    };
            grille.setGrilleTest(m);
            if (!assertEquals("test 4 a echoue - grille.verifier4JetonsDiag(4,5)",
                    false, grille.verifier4JetonsDiag(4, 5))) {
                System.out.println(grille);
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 5 : même grille que test 4
        try {
            if (!assertEquals("test 5 a echoue - grille.verifier4JetonsDiag(0,1)",
                    false, grille.verifier4JetonsDiag(0, 1))) {
                System.out.println(grille);
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 5 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 6 : diagonale droite en haut de grille contenant 4 jetons successifs
        try {
            int[][] m =
                    {
                            {0, 0, 1, 2, 1, 2, 0, 0}, // m[0]
                            {0, 0, 1, 2, 1, 2, 0, 0},
                            {0, 0, 2, 1, 2, 1, 0, 0},
                            {0, 0, 1, 1, 2, 1, 0, 0},
                            {0, 0, 1, 2, 1, 2, 0, 0},
                            {0, 0, 0, 1, 2, 1, 0, 0},
                            {0, 0, 0, 0, 1, 2, 0, 0},
                            {0, 0, 0, 0, 0, 1, 0, 0}
                    };
            grille.setGrilleTest(m);
            if (!assertEquals("test 6 a echoue - grille.verifier4JetonsDiag(6,4)",
                    true, grille.verifier4JetonsDiag(6, 4))) {
                System.out.println(grille);
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 6 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 7 : diagonale droite en haut de grille ne contenant pas 4 jetons successifs
        try {
            int[][] m =
                    {
                            {0, 2, 1, 2, 1, 2, 0, 0}, // m[0]
                            {0, 1, 1, 2, 1, 2, 0, 0},
                            {0, 2, 2, 1, 2, 1, 0, 0},
                            {0, 1, 1, 1, 2, 1, 0, 0},
                            {0, 0, 1, 2, 1, 2, 0, 0},
                            {0, 0, 0, 1, 2, 1, 0, 0},
                            {0, 0, 0, 0, 0, 2, 0, 0},
                            {0, 0, 0, 0, 0, 1, 0, 0}
                    };
            grille.setGrilleTest(m);
            if (!assertEquals("test 7 a echoue - grille.verifier4JetonsDiag(7,5)",
                    false, grille.verifier4JetonsDiag(7, 5))) {
                System.out.println(grille);
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 7 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 8 : double diagonale ne contenant pas 4 jetons successifs
        try {
            grille = new Grille(7);

            int[][] m =
                    {
                            {0, 2, 1, 1, 1, 2, 0}, // m[0]
                            {0, 1, 1, 2, 1, 1, 0},
                            {0, 2, 2, 1, 2, 2, 0},
                            {0, 2, 2, 1, 2, 2, 0},
                            {0, 1, 1, 0, 1, 1, 0},
                            {0, 1, 0, 0, 0, 1, 0},
                            {0, 0, 0, 0, 0, 0, 0}
                    };
            grille.setGrilleTest(m);
            if (!assertEquals("test 8 a echoue - grille.verifier4JetonsDiag(3,3)",
                    false, grille.verifier4JetonsDiag(3, 3))) {
                System.out.println(grille);
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 8 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 9 : double diagonale contenant 4 jetons successifs
        try {
            grille = new Grille(7);

            int[][] m =
                    {
                            {0, 2, 1, 1, 1, 2, 0}, // m[0]
                            {0, 1, 1, 2, 1, 1, 0},
                            {0, 2, 1, 1, 1, 2, 0},
                            {0, 2, 2, 1, 2, 2, 0},
                            {0, 1, 1, 0, 1, 1, 0},
                            {0, 1, 0, 0, 0, 1, 0},
                            {0, 0, 0, 0, 0, 0, 0}
                    };
            grille.setGrilleTest(m);
            if (!assertEquals("test 9 a echoue - grille.verifier4JetonsDiag(3,3)",
                    true, grille.verifier4JetonsDiag(3, 3))) {
                System.out.println(grille);
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 9 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        System.out.println("\nTous les tests ont réussi!\n");
    }
}