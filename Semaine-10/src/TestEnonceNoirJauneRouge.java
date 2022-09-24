/*
	@Author: Corentin D'haeyere
 */
public class TestEnonceNoirJauneRouge {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    /**
     * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
     *
     * @param messageErreur
     *            message a afficher en cas de probleme
     * @param attendu
     *            la valeur qu'on s'attendait a recevoir
     * @param recu
     *            la valeur qu'on a re�u en realite
     */
    private static void assertEquals(String messageErreur, Object attendu, Object recu) {
        if (attendu == null) {
            if (recu != null) {
                System.out.println(messageErreur);
                System.out.println("Attendu : " + attendu);
                System.out.println("Re�u : " + recu);
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
                System.out.println("Re�u : " + recu);
                System.exit(0);
            }
        }

    }

    public static void main(String [] args){

        int choix;
        System.out.println("**********************************************");
        System.out.println("Programme Test pour la classe NoirJauneRouge :");
        System.out.println("**********************************************");
        System.out.println();
        do{
            System.out.println();
            System.out.println("1 -> Tester la methode 'ajouter()'");
            System.out.println("2 -> Tester la methode 'supprimer()'");

            System.out.print("\nEntrez votre choix : ");
            choix=scanner.nextInt();
            switch(choix){
                case 1: testAjouter();
                    break;
                case 2: testSupprimer();
                    break;
            }
        }while(choix >=1&&choix<=2);
        System.out.println("\nFin des tests");
    }



    private static void testAjouter() {

        System.out.println();

        Ecolier pN1 = new Ecolier("nora", 'n');
        Ecolier pN2 = new Ecolier("nico", 'n');
        Ecolier pN3 = new Ecolier("noel", 'n');
        Ecolier pN4 = new Ecolier("nestor", 'n');
        Ecolier pJ1 = new Ecolier("julie", 'j');
        Ecolier pJ2 = new Ecolier("jo", 'j');
        Ecolier pR1 = new Ecolier("rene", 'r');
        Ecolier pR2 = new Ecolier("remi", 'r');
        Ecolier pR3 = new Ecolier("robin", 'r');
        Ecolier[] tableTriee = new Ecolier[9];
        tableTriee[0]=pN1;
        tableTriee[1]=pN2;
        tableTriee[2]=pN3;
        tableTriee[3]=pN4;
        tableTriee[4]=pJ1;
        tableTriee[5]=pJ2;
        tableTriee[6]=pR1;
        tableTriee[7]=pR2;
        tableTriee[8]=pR3;


        System.out.println();
        System.out.print("Test 1 : exemple de l'enonce : cas 1  ");
        System.out.println();
        Ecolier[] tableCas1 = new Ecolier[10];
        tableCas1[0]=pN1;
        tableCas1[1]=pN2;
        tableCas1[2]=pN3;
        tableCas1[3]=pN4;
        tableCas1[4]=pJ1;
        tableCas1[5]=pJ2;
        tableCas1[6]=pR1;
        tableCas1[7]=pR2;
        tableCas1[8]=pR3;
        Ecolier pR4 = new Ecolier("ralph", 'r');
        tableCas1[9]=pR4;
        NoirJauneRouge njrEnonce1 = new NoirJauneRouge(tableTriee, 4, 2, 3);
        NoirJauneRouge njrEnonceCas1 = new NoirJauneRouge(tableCas1, 4, 2, 4);

        assertEquals("ko : booleen renvoye", true, njrEnonce1.ajouter("ralph", 'r'));
        assertEquals("ko : nombreRouges", 4, njrEnonce1.getNombreRouges());
        assertEquals("ko : contenu",njrEnonceCas1.toString(),njrEnonce1.toString());

        System.out.println("cas 1 : ok");


        System.out.println();
        System.out.print("Test 2 : exemple de l'enonce : cas 2  ");
        System.out.println();

        Ecolier[] tableCas2 = new Ecolier[10];
        Ecolier pJ3 = new Ecolier("jean", 'j');
        tableCas2[0]=pN1;
        tableCas2[1]=pN2;
        tableCas2[2]=pN3;
        tableCas2[3]=pN4;
        tableCas2[4]=pJ1;
        tableCas2[5]=pJ2;
        tableCas2[6]=pJ3;
        tableCas2[7]=pR2;
        tableCas2[8]=pR3;
        tableCas2[9]=pR1;
        NoirJauneRouge njrEnonce2 = new NoirJauneRouge(tableTriee, 4, 2, 3);
        NoirJauneRouge njrEnonceCas2 = new NoirJauneRouge(tableCas2, 4, 3, 3);

        assertEquals("ko : booleen renvoye", true, njrEnonce2.ajouter("jean", 'j'));
        assertEquals("ko : nombreJaunes", 3, njrEnonce2.getNombreJaunes());
        assertEquals("ko : contenu",njrEnonceCas2.toString(),njrEnonce2.toString());

        System.out.println("cas 2 : ok");

        System.out.println();
        System.out.print("Test 3 : exemple de l'enonce : cas 3  ");
        System.out.println();
        Ecolier[] tableCas3 = new Ecolier[10];
        Ecolier pN5 = new Ecolier("nick", 'n');
        tableCas3[0]=pN1;
        tableCas3[1]=pN2;
        tableCas3[2]=pN3;
        tableCas3[3]=pN4;
        tableCas3[4]=pN5;
        tableCas3[5]=pJ2;
        tableCas3[6]=pJ1;
        tableCas3[7]=pR2;
        tableCas3[8]=pR3;
        tableCas3[9]=pR1;
        NoirJauneRouge njrEnonce3 = new NoirJauneRouge(tableTriee, 4, 2, 3);
        NoirJauneRouge njrEnonceCas3 = new NoirJauneRouge(tableCas3, 5, 2, 3);

        assertEquals("ko : booleen renvoye", true, njrEnonce3.ajouter("nick", 'n'));
        assertEquals("ko : nombreNoirs", 5, njrEnonce3.getNombreNoirs());
        assertEquals("ko : contenu",njrEnonceCas3.toString(),njrEnonce3.toString());

        System.out.println("cas 3 : ok");

        System.out.println();
        System.out.println("Les 3 cas ont reussi!");
        System.out.println();
    }


    private static void testSupprimer() {

        System.out.println();

        Ecolier pN1 = new Ecolier("nora", 'n');
        Ecolier pN2 = new Ecolier("nico", 'n');
        Ecolier pN3 = new Ecolier("noel", 'n');
        Ecolier pN4 = new Ecolier("nestor", 'n');
        Ecolier pJ1 = new Ecolier("julie", 'j');
        Ecolier pJ2 = new Ecolier("jo", 'j');
        Ecolier pR1 = new Ecolier("rene", 'r');
        Ecolier pR2 = new Ecolier("remi", 'r');
        Ecolier pR3 = new Ecolier("robin", 'r');
        Ecolier[] tableTriee = new Ecolier[9];
        tableTriee[0]=pN1;
        tableTriee[1]=pN2;
        tableTriee[2]=pN3;
        tableTriee[3]=pN4;
        tableTriee[4]=pJ1;
        tableTriee[5]=pJ2;
        tableTriee[6]=pR1;
        tableTriee[7]=pR2;
        tableTriee[8]=pR3;



        System.out.println();
        System.out.print("Test 1 : exemple de l'enonce : cas 1  ");
        System.out.println();
        Ecolier[] tableTrieeCas1 = new Ecolier[8];
        tableTrieeCas1[0]=pN1;
        tableTrieeCas1[1]=pN2;
        tableTrieeCas1[2]=pN3;
        tableTrieeCas1[3]=pN4;
        tableTrieeCas1[4]=pJ1;
        tableTrieeCas1[5]=pJ2;
        tableTrieeCas1[6]=pR3;
        tableTrieeCas1[7]=pR2;

        NoirJauneRouge njrEnonce1 = new NoirJauneRouge(tableTriee, 4, 2, 3);
        NoirJauneRouge njrEnonceCas1 = new NoirJauneRouge(tableTrieeCas1, 4, 2, 2);

        assertEquals("ko : booleen renvoye", true, njrEnonce1.supprimer("rene"));
        assertEquals("ko : nombreRouges", 2, njrEnonce1.getNombreRouges());
        assertEquals("ko : contenu",njrEnonceCas1.toString(),njrEnonce1.toString());

        System.out.println("cas 1 : ok");


        System.out.println();
        System.out.print("Test 2 : exemple de l'enonce : cas 2  ");
        System.out.println();
        Ecolier[] tableTrieeCas2 = new Ecolier[8];
        tableTrieeCas2[0]=pN1;
        tableTrieeCas2[1]=pN2;
        tableTrieeCas2[2]=pN3;
        tableTrieeCas2[3]=pN4;
        tableTrieeCas2[4]=pJ2;
        tableTrieeCas2[5]=pR3;
        tableTrieeCas2[6]=pR1;
        tableTrieeCas2[7]=pR2;

        NoirJauneRouge njrEnonce2 = new NoirJauneRouge(tableTriee, 4, 2, 3);
        NoirJauneRouge njrEnonceCas2 = new NoirJauneRouge(tableTrieeCas2, 4, 1, 3);

        assertEquals("ko : booleen renvoye", true, njrEnonce2.supprimer("julie"));
        assertEquals("ko : nombreJaunes", 1, njrEnonce2.getNombreJaunes());
        assertEquals("ko : contenu",njrEnonceCas2.toString(),njrEnonce2.toString());

        System.out.println("cas 2 : ok");

        System.out.println();
        System.out.print("Test 3 : exemple de l'enonce : cas 3  ");
        System.out.println();
        Ecolier[] tableTrieeCas3 = new Ecolier[8];
        tableTrieeCas3[0]=pN1;
        tableTrieeCas3[1]=pN4;
        tableTrieeCas3[2]=pN3;
        tableTrieeCas3[3]=pJ2;
        tableTrieeCas3[4]=pJ1;
        tableTrieeCas3[5]=pR3;
        tableTrieeCas3[6]=pR1;
        tableTrieeCas3[7]=pR2;

        NoirJauneRouge njrEnonce3 = new NoirJauneRouge(tableTriee, 4, 2, 3);
        NoirJauneRouge njrEnonceCas3 = new NoirJauneRouge(tableTrieeCas3, 3, 2, 3);

        assertEquals("ko : booleen renvoye", true, njrEnonce3.supprimer("nico"));
        assertEquals("ko : nombreNoirs", 3, njrEnonce3.getNombreNoirs());
        assertEquals("ko : contenu",njrEnonceCas3.toString(),njrEnonce3.toString());

        System.out.println("cas 3 : ok");

        System.out.println();
        System.out.println("Les 3 cas ont reussi!");
        System.out.println();

    }



}
