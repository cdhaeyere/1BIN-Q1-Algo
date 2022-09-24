/*
	@Author: Corentin D'haeyere
 */
public class TestTableauNonTrieDEntiers {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    /**
     * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
     *
     * @param messageErreur
     *            message a afficher en cas de probleme
     * @param attendu
     *            la valeur qu'on s'attendait a recevoir
     * @param recu
     *            la valeur qu'on a recu en realite
     */
    private static void assertEquals(String messageErreur, Object attendu, Object recu) {
        if (attendu == null) {
            if (recu != null) {
                System.out.println(messageErreur);
                System.out.println("Attendu : " + attendu);
                System.out.println("Recu : " + recu);
                System.exit(0);
            }
        } else {
            if (attendu instanceof Character && recu instanceof String) {
                attendu = "" + attendu;
            }
            if (attendu instanceof String && recu instanceof Character) {
                recu = "" + recu;
            }
            if (!attendu.equals(recu)) {
                System.out.println(messageErreur);
                System.out.println("Attendu : " + attendu);
                System.out.println("Recu : " + recu);
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {

        int choix;
        System.out.println("Exercices d'algorithmique et Java");
        System.out.println("1ere Informatique IPL");
        System.out.println("******************************************************");
        System.out.println("Programme Test pour la classe TableauNonTrieDEntiers :");
        System.out.println("******************************************************");
        System.out.println();
        do {
            System.out.println("1 -> Tester la methode 'ajouterUnEntier(int entier)'");
            System.out.println("2 -> Tester la methode 'contient()'");
            System.out.println("3 -> Tester la methode 'nombreOccurrences(int entier)'");
            System.out.println("4 -> Tester la methode 'memeContenu(TableauNonTrieDEntiers autreTable)'");
            System.out.println("5 -> Tester la methode 'supprimerLaPremiereOccurrence(int entier)'");
            System.out.println("6 -> Tester la methode 'supprimerToutesLesOccurrences(int entier)'");
            System.out.println("7 -> Tester la methode 'estTrie()'");
            System.out.println("8 -> Tester la methode 'contientExAequo()'");
            System.out.println("9 -> Tester la methode 'supprimerTousLesExAequos()'(ex defi)");

            System.out.print("\nEntrez votre choix : ");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    ajouterUne();
                    break;
                case 2:
                    verifierContient();
                    break;
                case 3:
                    verifierNombreOccurrences();
                    break;
                case 4:
                    verifierMemeContenu();
                    break;
                case 5:
                    supprimerUne();
                    break;
                case 6:
                    supprimerTout();
                    break;
                case 7:
                    verifierEstTrie();
                    break;
                case 8:
                    testerContientExAequo();
                    break;
                case 9:
                    testerSupprimerTousLesExAequos();
                    break;
            }
        } while (choix >= 1 && choix <= 9);
        System.out.println("\nFin des tests");
    }



    private static void ajouterUne() {

        // test 1 : ajout dans une table vide
        try {
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers();
            int[] tSol = { 1 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 1 a echoue", true, tNt.ajouterUnEntier(1));
            assertEquals("test 1 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }
        // test 2 : ajout dans une table non vide et non pleine
        try {
            int[] t = { 3, 4, 5 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 3, 4, 5, 6 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 2 a echoue", true, tNt.ajouterUnEntier(6));
            assertEquals("test 2 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 3 : ajout dans une table pleine
        try {
            int[] t = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 3 a echoue", false, tNt.ajouterUnEntier(10));
            assertEquals("test 3 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        System.out.println("Tous les tests ont reussi!");
        System.out.println();
    }

    private static void verifierContient() {

        // test 1 : contient dans une table vide
        try {
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers();
            int[] tSol = {};
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 1 a echoue", false, tNt.contient(1));
            assertEquals("test 1 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 2 : contient dans une table non vide et non pleine qui ne
        // contient pas l'entier
        try {
            int[] t = { 3, 4, 5 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 3, 4, 5 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 2 a echoue", true, tNt.contient(0));
            assertEquals("test 2 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 3 : contient dans une table pleine qui ne contient pas l'entier
        try {
            int[] t = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 3 a echoue", false, tNt.contient(10));
            assertEquals("test 3 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 4 : contient dans une table non vide et non pleine qui contient
        // l'entier
        try {
            int[] t = { 3, 4, 5 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 3, 4, 5 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 4 a echoue", true, tNt.contient(4));
            assertEquals("test 4 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 5 : contient dans une table pleine qui contient l'entier
        try {
            int[] t = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 5 a echoue", true, tNt.contient(2));
            assertEquals("test 5 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 5 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 6 : contient dans une table qui contient l'entier qui se trouve
        // en dernier lieu
        try {
            int[] t = { 0, 1, 2, 3, 2, 5, 6, 2, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 0, 1, 2, 3, 2, 5, 6, 2, 8, 9 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 6 a echoue", true, tNt.contient(9));
            assertEquals("test 6 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 6 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 7 : contient dans une table qui contient l'entier qui se trouve
        // en premier lieu
        try {
            int[] t = { 0, 1, 2, 3, 2, 5, 6, 2, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 0, 1, 2, 3, 2, 5, 6, 2, 8, 9 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 7 a echoue", true, tNt.contient(0));
            assertEquals("test 7 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 7 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        System.out.println("Tous les tests ont reussi!");
        System.out.println();

    }


    private static void verifierNombreOccurrences() {
        // test 1 : nombre occurrences dans une table vide
        try {
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers();
            int[] tSol = {};
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 1 a echoue", 0, tNt.nombreOccurrences(1));
            assertEquals("test 1 a echoue (contenu modifie)", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 2 : nombre occurrences dans une table non vide et non pleine qui ne
        // contient pas l'entier
        try {
            int[] t = { 3, 4, 5 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 3, 4, 5 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 2 a echoue", 0, tNt.nombreOccurrences(1));
            assertEquals("test 2 a echoue (contenu modifie)", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 3 : nombreOccurrences dans une table pleine qui ne contient pas l'entier
        try {
            int[] t = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 3 a echoue", 0, tNt.nombreOccurrences(10));
            assertEquals("test 3 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 4 : nombreOccurrences dans une table non vide et non pleine qui contient
        // l'entier
        try {
            int[] t = { 3, 4, 5, 3, 3, 5, 3 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            assertEquals("test 4 a echoue", 4, tNt.nombreOccurrences(3));

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 5 : nombreOccurrences dans une table pleine qui contient l'entier
        try {
            int[] t = { 0, 1, 9, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            assertEquals("test 5 a echoue", 2, tNt.nombreOccurrences(9));
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 5 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 6 : nombre occurrences de 0 dans une table non pleine qui ne contient pas de 0
        try{
            int[] t = { 5, 6, 2, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            assertEquals("test 6 a echoue", 0, tNt.nombreOccurrences(0));

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 6 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        System.out.println("Tous les tests ont reussi!");
        System.out.println();


    }
    private static void verifierMemeContenu() {
        // test 1 : les 2 tables sont vides
        try {
            TableauNonTrieDEntiers tNt1 = new TableauNonTrieDEntiers();
            TableauNonTrieDEntiers tNt2 = new TableauNonTrieDEntiers();
            assertEquals("test 1 a echoue", true, tNt1.memeContenu(tNt2));
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 2 : une table est vide, l'autre pas
        try {
            int[] t = {1,2,3};
            TableauNonTrieDEntiers tNt1 = new TableauNonTrieDEntiers(t);
            TableauNonTrieDEntiers tNt2 = new TableauNonTrieDEntiers();
            assertEquals("test 2 a echoue", false, tNt1.memeContenu(tNt2));
            assertEquals("test 2 a echoue", false, tNt2.memeContenu(tNt1));
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 3 : memes entiers, mais pas dans le meme nombre - tailles logiques differentes
        try {
            int[] t1 = {1,2,3};
            int[] t2 = {1,2,3,2};
            TableauNonTrieDEntiers tNt1 = new TableauNonTrieDEntiers(t1);
            TableauNonTrieDEntiers tNt2 = new TableauNonTrieDEntiers(t2);
            assertEquals("test 3 a echoue", false, tNt1.memeContenu(tNt2));
            assertEquals("test 3 a echoue", false, tNt2.memeContenu(tNt1));
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 4 : memes entiers, mais pas dans le meme nombre - tailles logiques identiques
        try {
            int[] t1 = {1,2,3,1};
            int[] t2 = {1,2,3,2};
            TableauNonTrieDEntiers tNt1 = new TableauNonTrieDEntiers(t1);
            TableauNonTrieDEntiers tNt2 = new TableauNonTrieDEntiers(t2);
            assertEquals("test 4 a echoue", false, tNt1.memeContenu(tNt2));
            assertEquals("test 4 a echoue", false, tNt2.memeContenu(tNt1));
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 5 : memes entiers, en meme nombre, pas dans le meme ordre, tables non pleines
        try {
            int[] t1 = {1567987,2,3,1,2,2};
            int[] t2 = {1,2,3,2,1567987,2};

            TableauNonTrieDEntiers tNt1 = new TableauNonTrieDEntiers(t1);
            TableauNonTrieDEntiers tNt2 = new TableauNonTrieDEntiers(t2);
            TableauNonTrieDEntiers tNt1Copie = new TableauNonTrieDEntiers(t1);
            TableauNonTrieDEntiers tNt2Copie = new TableauNonTrieDEntiers(t2);

            assertEquals("test 5 a echoue", true, tNt1.memeContenu(tNt2));
            assertEquals("test 5 a echoue", true, tNt2.memeContenu(tNt1));
            assertEquals("test 5 a echoue (contenu this modifie", tNt1, tNt1Copie);
            assertEquals("test 5 a echoue (contenu parametre modifie", tNt2, tNt2Copie);

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 5 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 6 : memes entiers, en meme nombre, pas dans le meme ordre, tables pleines
        try {
            int[] t1 = {1567987,2,3,1,2,2,2,2,2,1};
            int[] t2 = {2,2,1,1,2,3,2,1567987,2,2};

            TableauNonTrieDEntiers tNt1 = new TableauNonTrieDEntiers(t1);
            TableauNonTrieDEntiers tNt2 = new TableauNonTrieDEntiers(t2);
            TableauNonTrieDEntiers tNt1Copie = new TableauNonTrieDEntiers(t1);
            TableauNonTrieDEntiers tNt2Copie = new TableauNonTrieDEntiers(t2);

            assertEquals("test 6 a echoue", true, tNt1.memeContenu(tNt2));
            assertEquals("test 6 a echoue", true, tNt2.memeContenu(tNt1));
            assertEquals("test 6 a echoue (contenu this modifie", tNt1, tNt1Copie);
            assertEquals("test 6 a echoue (contenu parametre modifie", tNt2, tNt2Copie);

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 6 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        System.out.println("Tous les tests ont reussi!");
        System.out.println();

    }


    private static void supprimerUne() {
        // test 1 : suppression dans une table vide
        try {
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers();
            int[] tSol = {};
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 1 a echoue", false, tNt.supprimerLaPremiereOccurrence(1));
            assertEquals("test 1 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 2 : suppression dans une table non vide et non pleine qui ne
        // contient pas l'entier
        try {
            int[] t = { 3, 4, 5 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 3, 4, 5 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 2 a echoue", false, tNt.supprimerLaPremiereOccurrence(6));
            assertEquals("test 2 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 3 : suppression dans une table pleine qui ne contient pas
        // l'entier
        try {
            int[] t = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 3 a echoue", false, tNt.supprimerLaPremiereOccurrence(10));
            assertEquals("test 3 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 4 : suppression dans une table non vide et non pleine qui
        // contient l'entier
        try {
            int[] t = { 3, 4, 5 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 5, 4 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 4 a echoue", true, tNt.supprimerLaPremiereOccurrence(3));
            assertEquals("test 4 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 5 : suppression dans une table pleine qui contient l'entier
        try {
            int[] t = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 0, 1, 9, 3, 4, 5, 6, 7, 8 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 5 a echoue", true, tNt.supprimerLaPremiereOccurrence(2));
            assertEquals("test 5 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 5 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 6 : suppression dans une table qui contient plusieurs X l'entier
        try {
            int[] t = { 0, 1, 2, 3, 2, 5, 6, 2, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 0, 1, 9, 3, 2, 5, 6, 2, 8 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 6 a echoue", true, tNt.supprimerLaPremiereOccurrence(2));
            assertEquals("test 6 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 6 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 7 : suppression dans une table pleine qui contient l'entier en
        // dernier lieu
        try {
            int[] t = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 7 a echoue", true, tNt.supprimerLaPremiereOccurrence(9));
            assertEquals("test 7 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 7 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 8 : suppression dans une table pleine qui contient l'entier en
        // premier lieu
        try {
            int[] t = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 9, 1, 2, 3, 4, 5, 6, 7, 8 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 8 a echoue", true, tNt.supprimerLaPremiereOccurrence(0));
            assertEquals("test 8 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 8 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 9
        try {
            int[] t = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t, 4);
            int[] tSol = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol, 4);
            assertEquals("test 9 a echoue", false, tNt.supprimerLaPremiereOccurrence(4));
            assertEquals("test 9 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 8 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 10
        try {
            int[] t = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 10 a echoue", true, tNt.supprimerLaPremiereOccurrence(1));
            assertEquals("test 10 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 10 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        System.out.println("Tous les tests ont reussi!");
        System.out.println();
    }

    private static void supprimerTout() {
        // test 1 : suppression dans une table vide
        try {
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers();
            int[] tSol = {};
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 1 a echoue", 0, tNt.supprimerToutesLesOccurrences(1));
            assertEquals("test 1 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 2 : suppression dans une table non vide et non pleine qui ne
        // contient pas l'entier
        try {
            int[] t = { 3, 4, 5 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 3, 4, 5 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 2 a echoue", 0, tNt.supprimerToutesLesOccurrences(6));
            assertEquals("test 2 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 3 : suppression dans une table pleine qui ne contient pas
        // l'entier
        try {
            int[] t = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 3 a echoue", 0, tNt.supprimerToutesLesOccurrences(10));
            assertEquals("test 3 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 4 : suppression dans une table non vide et non pleine qui
        // contient l'entier
        try {
            int[] t = { 3, 4, 5 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 5, 4 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 4 a echoue", 1, tNt.supprimerToutesLesOccurrences(3));
            assertEquals("test 4 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 5 : suppression dans une table pleine qui contient 2 x l'entier
        try {
            int[] t = { 0, 1, 2, 3, 4, 5, 2, 7, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 0, 1, 9, 3, 4, 5, 8, 7 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 5 a echoue", 2, tNt.supprimerToutesLesOccurrences(2));
            assertEquals("test 5 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 5 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 6 : suppression dans une table qui contient plusieurs X l'entier
        // dont 1x au debut
        try {
            int[] t = { 0, 1, 2, 0, 2, 5, 6, 0, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 9, 1, 2, 8, 2, 5, 6 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 6 a echoue", 3, tNt.supprimerToutesLesOccurrences(0));
            assertEquals("test 6 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 6 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 7 : suppression dans une table pleine qui contient plusieurs X
        // l'entier dont 1x en dernier lieu
        try {
            int[] t = { 0, 1, 2, 3, 2, 5, 6, 7, 8, 2 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 0, 1, 8, 3, 7, 5, 6 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 7 a echoue", 3, tNt.supprimerToutesLesOccurrences(2));
            assertEquals("test 7 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 7 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 8 : suppression dans une table pleine qui contient 10 x l'entier
        try {
            int[] t = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = {};
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 8 a echoue", 10, tNt.supprimerToutesLesOccurrences(1));
            assertEquals("test 8 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 8 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        System.out.println("Tous les tests ont reussi!");
        System.out.println();
    }

    private static void verifierEstTrie() {
        // test 1 : table vide
        try {
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers();
            int[] tSol = {};
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 1 a echoue", true, tNt.estTrie());
            assertEquals("test 1 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 4 : table pleine qui est triee
        try {
            int[] t = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 4 a echoue", true, tNt.estTrie());
            assertEquals("test 4 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 2 : table non vide et non pleine qui est triee
        try {
            int[] t = { 3, 4, 5 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 3, 4, 5 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 2 a echoue", true, tNt.estTrie());
            assertEquals("test 2 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 3 : table non vide et non pleine qui est non triee
        try {
            int[] t = { 3, 4, 3, 7 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 3, 4, 3, 7 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 3 a echoue", false, tNt.estTrie());
            assertEquals("test 3 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 5 : table pleine qui est non triee
        try {
            int[] t = { 0, 1, 2, 3, 2, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 0, 1, 2, 3, 2, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 5 a echoue", false, tNt.estTrie());
            assertEquals("test 5 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 5 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 6 : table pleine qui est non triee (probleme au debut)
        try {
            int[] t = { 1, 0, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 1, 0, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 6 a echoue", false, tNt.estTrie());
            assertEquals("test 6 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 6 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 7 : table pleine qui est non triee (probleme a la fin)
        try {
            int[] t = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 0 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 0 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 7 a echoue", false, tNt.estTrie());
            assertEquals("test 7 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 7 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 8 : table avec 1 entier
        try {
            int[] t = { 0 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 0 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 8 a echoue", true, tNt.estTrie());
            assertEquals("test 8 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 8 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        System.out.println("Tous les tests ont reussi!");
        System.out.println();
    }

    private static void testerContientExAequo() {

        // test 1 : contient ex aequo dans une table vide
        try {
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers();
            int[] tSol = {};
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 1 a echoue", false, tNt.contientExAequo());
            assertEquals("test 1 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 2 : contient ex aequo dans une table non vide et non pleine qui ne
        // contient pas d'ex-aequo
        try {
            int[] t = { 3, 4, 5 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 3, 4, 5 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 2 a echoue", false, tNt.contientExAequo());
            assertEquals("test 2 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 3 : contient ex aequo dans une table pleine qui ne contient pas d'ex-aequo
        try {
            int[] t = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 3 a echoue", false, tNt.contientExAequo());
            assertEquals("test 3 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 4 : contient ex aequo dans une table non vide et non pleine qui contient
        // un ex-aequo
        try {
            int[] t = { 1, 2, 3, 4, 3, 5 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 1, 2, 3, 4, 3, 5 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 4 a echoue", true, tNt.contientExAequo());
            assertEquals("test 4 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 5 : contient ex auequo dans une table pleine qui contient un ex-aequo
        try {
            int[] t = { 0, 1, 2, 3, 4, 5, 6, 7, 4, 8 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 0, 1, 2, 3, 4, 5, 6, 7, 4, 8 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 5 a echoue", true, tNt.contientExAequo());
            assertEquals("test 5 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 5 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 6 : contient ex aequo dans une table qui contient 2x un entier dont un
        // en dernier lieu
        try {
            int[] t = { 0, 1, 2, 3, 2, 5, 6, 2, 8, 3 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 0, 1, 2, 3, 2, 5, 6, 2, 8, 3 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 6 a echoue", true, tNt.contientExAequo());
            assertEquals("test 6 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 6 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 7 : contient ex-aequo dans une table qui contient 2x un entier dont un
        // en premier lieu
        try {
            int[] t = { 0, 1, 2, 3, 2, 5, 6, 0, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 0, 1, 2, 3, 2, 5, 6, 0, 8, 9 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 7 a echoue", true, tNt.contientExAequo());
            assertEquals("test 7 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 7 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        System.out.println("Tous les tests ont reussi!");
        System.out.println();
    }

    private static void testerSupprimerTousLesExAequos() {
        // test 1 : suppression dans une table vide
        try {
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers();
            int[] tSol = {};
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 1 a echoue", 0, tNt.supprimerTousLesExAequos());
            assertEquals("test 1 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 2 : suppression dans une table non vide et non pleine qui ne
        // contient pas d'ex-aequos
        try {
            int[] t = { 3, 4, 5 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 3, 4, 5 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 2 a echoue", 0, tNt.supprimerTousLesExAequos());
            assertEquals("test 2 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 3 : suppression dans une table pleine qui ne contient pas
        // l'entier
        try {
            int[] t = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 3 a echoue", 0, tNt.supprimerTousLesExAequos());
            assertEquals("test 3 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 4 : suppression dans une table non vide et non pleine qui
        // contient des ex-aequos.
        // Un entier n'y est que 2 x maximum
        try {
            int[] t = { 3, 4, 3, 4 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol1 = { 3, 4 };
            int[] tSol2 = { 4, 3 };
            TableauNonTrieDEntiers tNtSol1 = new TableauNonTrieDEntiers(tSol1);
            TableauNonTrieDEntiers tNtSol2 = new TableauNonTrieDEntiers(tSol2);
            assertEquals("test 4 a echoue", 2, tNt.supprimerTousLesExAequos());
            if (!tNtSol1.equals(tNt) && !tNtSol2.equals(tNt)) {
                System.out.println("test 4 a echoue");
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 5 : suppression dans une table pleine qui contient des ex-aequos
        try {
            int[] t = { 1, 4, 4, 4, 1, 4, 1, 4, 1, 1 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol1 = { 1, 4 };
            TableauNonTrieDEntiers tNtSol1 = new TableauNonTrieDEntiers(tSol1);
            int[] tSol2 = { 4, 1 };
            TableauNonTrieDEntiers tNtSol2 = new TableauNonTrieDEntiers(tSol2);
            assertEquals("test 5 a echoue", 8, tNt.supprimerTousLesExAequos());
            if (!tNtSol1.equals(tNt) && !tNtSol2.equals(tNt)) {
                System.out.println("test 5 a echoue");
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 5 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        // test 8 : suppression dans une table pleine qui contient 10 x le meme
        // entier
        try {
            int[] t = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
            TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
            int[] tSol = { 1 };
            TableauNonTrieDEntiers tNtSol = new TableauNonTrieDEntiers(tSol);
            assertEquals("test 8 a echoue", 9, tNt.supprimerTousLesExAequos());
            assertEquals("test 8 a echoue", tNtSol, tNt);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("test 8 a echoue : ArrayIndexOutOfBoundsException!!!");
            System.exit(0);
        }

        System.out.println("Tous les tests ont reussi!");
        System.out.println();
    }

}
