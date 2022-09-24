/*
    @Author: Corentin D'haeyere
 */
public class TestTableauTrieDEntiers{

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
                System.out.println("Revoyez cette methode!");
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
                System.out.println("Revoyez cette methode!");
                System.exit(0);
            }
        }
    }

    public static void main(String [] args){

        int choix;
        System.out.println("Exercices d'algorithmique et Java");
        System.out.println("1ere Informatique IPL");
        System.out.println("***************************************************");
        System.out.println("Programme Test pour la classe TableauTrieDEntiers :");
        System.out.println("***************************************************");
        System.out.println();
        do{
            System.out.println("1 -> Tester la methode 'ajouterUnEntier(int unEntier)'");
            System.out.println("2 -> Tester la methode 'contient(int unEntier)'");
            System.out.println("3 -> Tester la methode 'supprimerUneOccurrence(int unEntier)'");
            System.out.println("4 -> Tester la methode 'supprimerToutesLesOccurrences(int unEntier)'");
            System.out.println("5 -> Tester la methode 'supprimerEntre(int borneInf, int borneSup)'");
            System.out.println("6 -> Tester la methode 'contientExAequo()'");
            System.out.println("7 -> Tester la methode 'supprimerTousLesExAequos()'");
            System.out.print("\nEntrez votre choix : ");
            choix=scanner.nextInt();
            switch(choix){
                case 1: verifierAjout();
                    break;
                case 2: verifierContient();
                    break;
                case 3: supprimerUne();
                    break;
                case 4: supprimerTout();
                    break;
                case 5: supprimerEntre();
                    break;
                case 6: testerContientExAequo();
                    break;
                case 7: testerSupprimerTousLesExAequos();

            }
        } while (choix >=1 && choix<=6);
        System.out.println("Merci pour votre visite.");
    }


    private static void verifierAjout(){
        System.out.println();
        System.out.println("Test 1 : ajout dans une table vide");
        try{
            TableauTrieDEntiers tT1 = new TableauTrieDEntiers();
            int[] t1Sol = {5};
            TableauTrieDEntiers tT1Sol = new TableauTrieDEntiers(t1Sol);
            assertEquals("test 1 a echoue, booleen renvoye : ", true, tT1.ajouterUnEntier(5));
            assertEquals("test 1 a echoue, l'attribut nombreDEntiers non correct : ",1,tT1.getNombreDEntiers());
            assertEquals("test 1 a echoue, contenu table non correct : ", tT1Sol, tT1);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 1 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 1 a reussi");

        System.out.println();
        System.out.println("Test 2 : ajout a la fin d'une table non pleine");
        try{
            int[] t2 = {1,2,3,4,5,6,7,8,9};
            TableauTrieDEntiers tT2 = new TableauTrieDEntiers(t2);
            int[] t2Sol = {1,2,3,4,5,6,7,8,9,10};
            TableauTrieDEntiers tT2Sol = new TableauTrieDEntiers(t2Sol);
            assertEquals("test 2 a echoue, booleen renvoye : ", true, tT2.ajouterUnEntier(10));
            assertEquals("test 2 a echoue, l'attribut nombreDEntiers non correct : ",10,tT2.getNombreDEntiers());
            assertEquals("test 2 a echoue, contenu table non correct : ", tT2Sol, tT2);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 2 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("Test 2 a reussi");

        System.out.println();
        System.out.println("Test 3 : ajout au debut d'une table non pleine");
        try{
            int[] t3 = {2,3,4,5,6,7,8,9,10};
            TableauTrieDEntiers tT3 = new TableauTrieDEntiers(t3);
            int[] t3Sol = {1,2,3,4,5,6,7,8,9,10};
            TableauTrieDEntiers tT3Sol = new TableauTrieDEntiers(t3Sol);
            assertEquals("test 3 a echoue, booleen renvoye : ", true, tT3.ajouterUnEntier(1));
            assertEquals("test 3 a echoue, l'attribut nombreDEntiers non correct : ",10,tT3.getNombreDEntiers());
            assertEquals("test 3 a echoue, contenu table non correct : ", tT3Sol, tT3);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 3 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("Test 3 a reussi");

        System.out.println();
        System.out.println("Test 4 : ajout ni au debut, ni en fin d'une table non pleine");
        try{
            int[] t4 = {1,2,4,5,6,7,8,9,10};
            TableauTrieDEntiers tT4 = new TableauTrieDEntiers(t4);
            int[] t4Sol = {1,2,3,4,5,6,7,8,9,10};
            TableauTrieDEntiers tT4Sol=new TableauTrieDEntiers(t4Sol);
            assertEquals("test 4 a echoue, booleen renvoye : ", true, tT4.ajouterUnEntier(3));
            assertEquals("test 4 a echoue, l'attribut nombreDEntiers non correct : ",10,tT4.getNombreDEntiers());
            assertEquals("test 4 a echoue, contenu table non correct : ", tT4Sol, tT4);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 4 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("Test 4 a reussi");

        System.out.println();
        System.out.println("Test 5 : ajout dans une table pleine");
        try{
            int[] t5 = {1,2,3,4,5,6,7,8,9,10};
            TableauTrieDEntiers tT5 = new TableauTrieDEntiers(t5);
            int[] t5Sol = {1,2,3,4,5,6,7,8,9,10};
            TableauTrieDEntiers tT5Sol=new TableauTrieDEntiers(t5Sol);
            assertEquals("test 5 a echoue, booleen renvoye : ", false, tT5.ajouterUnEntier(3));
            assertEquals("test 5 a echoue, l'attribut nombreDEntiers non correct : ",10,tT5.getNombreDEntiers());
            assertEquals("test 5 a echoue, contenu table non correct : ", tT5Sol, tT5);


        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 5 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 5 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("Test 5 a reussi");

        System.out.println();
        System.out.println("Tous les tests ont reussi!");


    }




    private static void verifierContient(){

        System.out.println();
        System.out.println("Test 1 : contient dans une table vide");
        try{
            TableauTrieDEntiers tT = new TableauTrieDEntiers();
            int[] tSol = {};
            TableauTrieDEntiers tTSol = new TableauTrieDEntiers(tSol);
            assertEquals("test 1 a echoue", false, tT.contient(1));
            assertEquals("test 1 a echoue, contenu table modifie", tTSol, tT);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 1 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 1 a reussi");


        System.out.println();
        System.out.println("Test 2 : contient dans une table non vide et non pleine qui ne contient pas l'entier");
        try{
            int[] t = {3,4,5};
            TableauTrieDEntiers tT = new TableauTrieDEntiers(t);
            int[] tSol = {3,4,5};
            TableauTrieDEntiers tTSol = new TableauTrieDEntiers(tSol);
            assertEquals("test 2 a echoue", false, tT.contient(6));
            assertEquals("test 2 a echoue contenu table modifie", tTSol, tT);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 2 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 2 a reussi");


        System.out.println();
        System.out.println("Test 3 : contient dans une table pleine qui ne contient pas l'entier");
        try{
            int[] t = {0,1,2,3,4,5,6,7,8,9};
            TableauTrieDEntiers tT = new TableauTrieDEntiers(t);
            int[] tSol = {0,1,2,3,4,5,6,7,8,9};
            TableauTrieDEntiers tTSol = new TableauTrieDEntiers(tSol);
            assertEquals("test 3 a echoue", false, tT.contient(10));
            assertEquals("test 3 a echoue contenu table modifie", tTSol, tT);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 3 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 3 a reussi");


        System.out.println();
        System.out.println("Test 4 : contient dans une table non vide et non pleine qui contient l'entier");
        try{
            int[] t = {3,4,5};
            TableauTrieDEntiers tT = new TableauTrieDEntiers(t);
            int[] tSol = {3,4,5};
            TableauTrieDEntiers tTSol = new TableauTrieDEntiers(tSol);
            assertEquals("test 4 a echoue", true, tT.contient(4));
            assertEquals("test 4 a echoue contenu table modifie", tTSol, tT);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 4 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 4 a reussi");


        System.out.println();
        System.out.println("Test 5 : contient dans une table pleine qui contient l'entier");
        try{
            int[] t = {0,1,2,3,4,5,6,7,8,9};
            TableauTrieDEntiers tT = new TableauTrieDEntiers(t);
            int[] tSol = {0,1,2,3,4,5,6,7,8,9};
            TableauTrieDEntiers tTSol = new TableauTrieDEntiers(tSol);
            assertEquals("test 5 a echoue", true, tT.contient(2));
            assertEquals("test 5 a echoue contenu table modifie", tTSol, tT);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 5 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 5 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 5 a reussi");


        System.out.println();
        System.out.println("Test 6 : contient dans une table qui contient l'entier qui se trouve en dernier lieu");
        try{
            int[] t = {0,1,2,3,4,5,6,7,8,9};
            TableauTrieDEntiers tT = new TableauTrieDEntiers(t);
            int[] tSol = {0,1,2,3,4,5,6,7,8,9};
            TableauTrieDEntiers tTSol = new TableauTrieDEntiers(tSol);
            assertEquals("test 6 a echoue", true, tT.contient(9));
            assertEquals("test 6 a echoue contenu table modifie", tTSol, tT);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 6 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 6 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 6 a reussi");


        System.out.println();
        System.out.println("Test 7 : contient dans une table qui contient l'entier qui se trouve en premier lieu");
        try{
            int[] t = {0,1,2,3,4,5,6,7,8,9};
            TableauTrieDEntiers tT = new TableauTrieDEntiers(t);
            int[] tSol = {0,1,2,3,4,5,6,7,8,9};
            TableauTrieDEntiers tTSol = new TableauTrieDEntiers(tSol);
            assertEquals("test 7 a echoue", true, tT.contient(0));
            assertEquals("test 7 a echoue contenu table modifie", tTSol, tT);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 7 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 7 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 7 a reussi");


        System.out.println();
        System.out.println("Test 8 : contient de tous les entiers contenus dans la table");
        try{
            int[] t = {2,4,6,8,10,12,14,16,18,20};
            TableauTrieDEntiers tT = new TableauTrieDEntiers(t);
            int[] tSol = {2,4,6,8,10,12,14,16,18,20};
            TableauTrieDEntiers tTSol = new TableauTrieDEntiers(tSol);
            for (int i = 2 ; i<=20; i+=2){
                assertEquals("test 8 a echoue lors de la recherche de "+i, true, tT.contient(i));
            }
            assertEquals("test 8 a echoue contenu table modifie", tTSol, tT);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 8 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 8 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 8 a reussi");

        System.out.println();
        System.out.println("Test 9 : aucun des entiers recherches se trouvent dans la table");
        try{
            int[] t = {2,4,6,8,10,12,14,16,18,20};
            TableauTrieDEntiers tT = new TableauTrieDEntiers(t);
            int[] tSol = {2,4,6,8,10,12,14,16,18,20};
            TableauTrieDEntiers tTSol = new TableauTrieDEntiers(tSol);
            for (int i = 1 ; i<=21; i+=2){
                assertEquals("test 9 a echoue lors de la recherche de "+i, false, tT.contient(i));
            }
            assertEquals("test 9 a echoue contenu table modifie", tTSol, tT);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 9 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test 9 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 9 a reussi");


        System.out.println();
        System.out.println("Tous les tests ont reussi!");
        System.out.println();
    }



    private static void supprimerUne(){

        System.out.println();
        System.out.println("Test 1 : suppression dans une table vide");
        try{
            TableauTrieDEntiers tT1 = new TableauTrieDEntiers();
            int[] t1Sol = {};
            TableauTrieDEntiers tT1Sol = new TableauTrieDEntiers(t1Sol);
            assertEquals("test 1 a echoue, booleen renvoye : ", false, tT1.supprimerUneOccurrence(5));
            assertEquals("test 1 a echoue, l'attribut nombreDEntiers non correct : ",0,tT1.getNombreDEntiers());
            assertEquals("test 1 a echoue, contenu table non correct : ", tT1Sol, tT1);


        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 1 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 1 a reussi");


        System.out.println();
        System.out.println("Test 2 : suppression d'un entier qui n'appartient pas a la table");
        try{
            int[] t2 = {3,5,6};
            TableauTrieDEntiers tT2 = new TableauTrieDEntiers(t2);
            int[] t2Sol = {3,5,6};
            TableauTrieDEntiers tT2Sol = new TableauTrieDEntiers(t2Sol);
            assertEquals("test 1 a echoue, booleen renvoye : ", false, tT2.supprimerUneOccurrence(4));
            assertEquals("test 1 a echoue, l'attribut nombreDEntiers non correct : ",3,tT2.getNombreDEntiers());
            assertEquals("test 1 a echoue, contenu table non correct : ", tT2Sol, tT2);


        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 2 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 2 a reussi");



        System.out.println();
        System.out.println("Test 3 : suppression d'un entier qui appartient a la table non pleine");
        try{
            int[] t3 = {3,4,5};
            TableauTrieDEntiers tT3 = new TableauTrieDEntiers(t3);
            int[] t3Sol = {4,5};
            TableauTrieDEntiers tT3Sol = new TableauTrieDEntiers(t3Sol);
            assertEquals("test 3 a echoue, booleen renvoye : ", true, tT3.supprimerUneOccurrence(3));
            assertEquals("test 3 a echoue, l'attribut nombreDEntiers non correct : ",2,tT3.getNombreDEntiers());
            assertEquals("test 3 a echoue, contenu table non correct : ", tT3Sol, tT3);


        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 3 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 3 a reussi");

        System.out.println();
        System.out.println("Test 4 : suppression d'un entier qui appartient a la table pleine");
        try{
            int[] t4 = {0,1,2,3,4,5,6,7,8,9};
            TableauTrieDEntiers tT4 = new TableauTrieDEntiers(t4);
            int[] t4Sol = {1,2,3,4,5,6,7,8,9};
            TableauTrieDEntiers tT4Sol = new TableauTrieDEntiers(t4Sol);
            assertEquals("test 4 a echoue, booleen renvoye : ", true, tT4.supprimerUneOccurrence(0));
            assertEquals("test 4 a echoue, l'attribut nombreDEntiers non correct : ",9,tT4.getNombreDEntiers());
            assertEquals("test 4 a echoue, contenu table non correct : ", tT4Sol, tT4);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 4 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 4 a reussi");

        System.out.println();
        System.out.println("Test 5 : suppression d'un entier qui appartient plusieurs fois a la table");
        try{
            int[] t5 = {0,1,1,1,1,5};
            TableauTrieDEntiers tT5 = new TableauTrieDEntiers(t5);
            int[] t5Sol = {0,1,1,1,5};
            TableauTrieDEntiers tT5Sol = new TableauTrieDEntiers(t5Sol);
            assertEquals("test 5 a echoue, booleen renvoye : ", true, tT5.supprimerUneOccurrence(1));
            assertEquals("test 5 a echoue, l'attribut nombreDEntiers non correct : ",5,tT5.getNombreDEntiers());
            assertEquals("test 5 a echoue, contenu table non correct : ", tT5Sol, tT5);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 5 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 5 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 5 a reussi");


        System.out.println();
        System.out.println("Tous les tests ont reussi!");
        System.out.println();
    }


    private static void supprimerTout(){

        System.out.println();
        System.out.println("Test 1 : suppression dans une table vide");
        try{
            TableauTrieDEntiers tT1 = new TableauTrieDEntiers();
            int[] t1Sol = {};
            TableauTrieDEntiers tT1Sol = new TableauTrieDEntiers(t1Sol);
            assertEquals("test 1 a echoue, nombre suppressions renvoye : ", 0, tT1.supprimerToutesLesOccurrences(5));
            assertEquals("test 1 a echoue, l'attribut nombreDEntiers non correct : ",0,tT1.getNombreDEntiers());
            assertEquals("test 1 a echoue, contenu table non correct : ", tT1Sol, tT1);


        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 1 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 1 a reussi");

        System.out.println();
        System.out.println("Test 2 : suppression d'un entier qui n'appartient pas a la table");
        try{
            int[] t2 = {3,4,5};
            TableauTrieDEntiers tT2 = new TableauTrieDEntiers(t2);
            int[] t2Sol = {3,4,5};
            TableauTrieDEntiers tT2Sol = new TableauTrieDEntiers(t2Sol);
            assertEquals("test 2 a echoue, nombre suppressions renvoye : ", 0, tT2.supprimerToutesLesOccurrences(12));
            assertEquals("test 2 a echoue, l'attribut nombreDEntiers non correct : ",3,tT2.getNombreDEntiers());
            assertEquals("test 2 a echoue, contenu table non correct : ", tT2Sol, tT2);


        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 2 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 2 a reussi");


        System.out.println();
        System.out.println("Test 3 : suppression d'un entier qui appartient une fois a la table non pleine");
        try{
            int[] t3 = {3,4,5};
            TableauTrieDEntiers tT3 = new TableauTrieDEntiers(t3);
            int[] t3Sol = {4,5};
            TableauTrieDEntiers tT3Sol = new TableauTrieDEntiers(t3Sol);
            assertEquals("test 3 a echoue, nombre suppressions renvoye : ", 1, tT3.supprimerToutesLesOccurrences(3));
            assertEquals("test 3 a echoue, l'attribut nombreDEntiers non correct : ",2,tT3.getNombreDEntiers());
            assertEquals("test 3 a echoue, contenu table non correct : ", tT3Sol, tT3);


        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 3 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 3 a reussi");


        System.out.println();
        System.out.println("Test 4 : suppression d'un entier qui appartient 2 fois a la table pleine");
        try{
            int[] t4 = {1,1,4,5,6,6,7,8,9,10};
            TableauTrieDEntiers tT4 = new TableauTrieDEntiers(t4);
            int[] t4Sol = {4,5,6,6,7,8,9,10};
            TableauTrieDEntiers tT4Sol = new TableauTrieDEntiers(t4Sol);
            assertEquals("test 4 a echoue, nombre suppressions renvoye : ", 2, tT4.supprimerToutesLesOccurrences(1));
            assertEquals("test 4 a echoue, l'attribut nombreDEntiers non correct : ",8,tT4.getNombreDEntiers());
            assertEquals("test 4 a echoue, contenu table non correct : ", tT4Sol, tT4);


        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 4 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 4 a reussi");


        System.out.println();
        System.out.println("Test 5 : suppression d'un entier qui appartient plusieurs fois a la table non pleine");
        try{
            int[] t5 = {1,4,4,4,5,6,8};
            TableauTrieDEntiers tT5 = new TableauTrieDEntiers(t5);
            int[] t5Sol = {1,5,6,8};
            TableauTrieDEntiers tT5Sol = new TableauTrieDEntiers(t5Sol);
            assertEquals("test 5 a echoue, nombre suppressions renvoye : ", 3, tT5.supprimerToutesLesOccurrences(4));
            assertEquals("test 5 a echoue, l'attribut nombreDEntiers non correct : ",4,tT5.getNombreDEntiers());
            assertEquals("test 5 a echoue, contenu table non correct : ", tT5Sol, tT5);


        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 5 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 5 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 5 a reussi");


        System.out.println();
        System.out.println("Test 6 : la table contient plusieurs fois l'entier a supprimer et pas d'autre!");
        try{
            int[] t6 = {1,1,1,1,1,1,1,1,1,1};
            TableauTrieDEntiers tT6 = new TableauTrieDEntiers(t6);
            TableauTrieDEntiers tT6Sol = new TableauTrieDEntiers();
            assertEquals("test 6 a echoue, nombre suppressions renvoye : ", 10, tT6.supprimerToutesLesOccurrences(1));
            assertEquals("test 6 a echoue, l'attribut nombreDEntiers non correct : ",0,tT6.getNombreDEntiers());
            assertEquals("test 6 a echoue, contenu table non correct : ", tT6Sol, tT6);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 6 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 6 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 6 a reussi");


        System.out.println();
        System.out.println("Tous les tests ont reussi!");
        System.out.println();
    }


    private static void supprimerEntre(){

        System.out.println();
        System.out.println("Test 1 : suppression dans une table vide");
        try{
            TableauTrieDEntiers tT1 = new TableauTrieDEntiers();
            int[] t1Sol = {};
            TableauTrieDEntiers tT1Sol = new TableauTrieDEntiers(t1Sol);
            assertEquals("test 1 a echoue, nombre suppressions renvoye : ", 0, tT1.supprimerEntre(5, 10));
            assertEquals("test 1 a echoue, l'attribut nombreDEntiers non correct : ",0,tT1.getNombreDEntiers());
            assertEquals("test 1 a echoue, contenu table non correct : ", tT1Sol, tT1);


        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 1 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 1 a reussi");

        System.out.println();
        System.out.println("Test 2 : suppression d'un range qui n'appartient pas a la table car borneInf plus grand que tous les elements");
        try{
            int[] t2 = {3,4,5};
            TableauTrieDEntiers tT2 = new TableauTrieDEntiers(t2);
            int[] t2Sol = {3,4,5};
            TableauTrieDEntiers tT2Sol = new TableauTrieDEntiers(t2Sol);
            assertEquals("test 2 a echoue, nombre suppressions renvoye : ", 0, tT2.supprimerEntre(8, 10));
            assertEquals("test 2 a echoue, l'attribut nombreDEntiers non correct : ",3,tT2.getNombreDEntiers());
            assertEquals("test 2 a echoue, contenu table non correct : ", tT2Sol, tT2);


        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 2 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 2 a reussi");

        System.out.println();
        System.out.println("Test 3 : suppression d'un range qui n'appartient pas a la table car borneSup plus petit que tous les elements");
        try{
            int[] t2 = {3,4,5};
            TableauTrieDEntiers tT2 = new TableauTrieDEntiers(t2);
            int[] t2Sol = {3,4,5};
            TableauTrieDEntiers tT2Sol = new TableauTrieDEntiers(t2Sol);
            assertEquals("test 3 a echoue, nombre suppressions renvoye : ", 0, tT2.supprimerEntre(0, 2));
            assertEquals("test 3 a echoue, l'attribut nombreDEntiers non correct : ",3,tT2.getNombreDEntiers());
            assertEquals("test 3 a echoue, contenu table non correct : ", tT2Sol, tT2);


        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 3 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 3 a reussi");


        System.out.println();
        System.out.println("Test 4 : suppression d'un range qui appartient une fois a la table non pleine");
        try{
            int[] t3 = {3,4,5};
            TableauTrieDEntiers tT3 = new TableauTrieDEntiers(t3);
            int[] t3Sol = {4,5};
            TableauTrieDEntiers tT3Sol = new TableauTrieDEntiers(t3Sol);
            assertEquals("test 4 a echoue, nombre suppressions renvoye : ", 1, tT3.supprimerEntre(1, 3));
            assertEquals("test 4 a echoue, l'attribut nombreDEntiers non correct : ",2,tT3.getNombreDEntiers());
            assertEquals("test 4 a echoue, contenu table non correct : ", tT3Sol, tT3);


        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 4 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 4 a reussi");


        System.out.println();
        System.out.println("Test 5 : suppression d'un range qui appartient 2 fois a la table pleine");
        try{
            int[] t4 = {1,2,4,5,6,6,7,8,9,10};
            TableauTrieDEntiers tT4 = new TableauTrieDEntiers(t4);
            int[] t4Sol = {4,5,6,6,7,8,9,10};
            TableauTrieDEntiers tT4Sol = new TableauTrieDEntiers(t4Sol);
            assertEquals("test 5 a echoue, nombre suppressions renvoye : ", 2, tT4.supprimerEntre(1, 2));
            assertEquals("test 5 a echoue, l'attribut nombreDEntiers non correct : ",8,tT4.getNombreDEntiers());
            assertEquals("test 5 a echoue, contenu table non correct : ", tT4Sol, tT4);


        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 5 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 5 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 5 a reussi");


        System.out.println();
        System.out.println("Test 6 : suppression d'un entier qui appartient plusieurs fois a la table non pleine");
        try{
            int[] t5 = {1,2,4,4,5,6,8};
            TableauTrieDEntiers tT5 = new TableauTrieDEntiers(t5);
            int[] t5Sol = {1,5,6,8};
            TableauTrieDEntiers tT5Sol = new TableauTrieDEntiers(t5Sol);
            assertEquals("test 6 a echoue, nombre suppressions renvoye : ", 3, tT5.supprimerEntre(2, 4));
            assertEquals("test 6 a echoue, l'attribut nombreDEntiers non correct : ",4,tT5.getNombreDEntiers());
            assertEquals("test 6 a echoue, contenu table non correct : ", tT5Sol, tT5);


        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 6 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 6 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 6 a reussi");


        System.out.println();
        System.out.println("Test 7 : Le range supprime toute la table!");
        try{
            int[] t6 = {1,2,5,8,9,9,10,15,15,17};
            TableauTrieDEntiers tT6 = new TableauTrieDEntiers(t6);
            TableauTrieDEntiers tT6Sol = new TableauTrieDEntiers();
            assertEquals("test 7 a echoue, nombre suppressions renvoye : ", 10, tT6.supprimerEntre(0, 20));
            assertEquals("test 7 a echoue, l'attribut nombreDEntiers non correct : ",0,tT6.getNombreDEntiers());
            assertEquals("test 7 a echoue, contenu table non correct : ", tT6Sol, tT6);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 7 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 7 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 7 a reussi");


        System.out.println();
        System.out.println("Tous les tests ont reussi!");
        System.out.println();
    }


    private static void testerContientExAequo(){

        System.out.println();
        System.out.println("Test 1 : contient ex aequo dans une table vide");
        try{
            TableauTrieDEntiers tT = new TableauTrieDEntiers();
            int[] tSol = {};
            TableauTrieDEntiers tTSol = new TableauTrieDEntiers(tSol);
            assertEquals("test 1 a echoue", false, tT.contientExAequo());
            assertEquals("test 1 a echoue, contenu table modifie", tTSol, tT);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 1 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 1 a reussi");


        System.out.println();
        try{
            System.out.println("Test 2 : table avec 1 entier");
            int[] t2 = {1};
            TableauTrieDEntiers tT2 = new TableauTrieDEntiers(t2);
            int[] t2Sol = {1};
            TableauTrieDEntiers t2TSol = new TableauTrieDEntiers(t2Sol);
            assertEquals("test 2 a echoue", false, tT2.contientExAequo());
            assertEquals("test 2 a echoue, contenu table modifie", t2TSol, tT2);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 2 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 2 a reussi");

        System.out.println();
        try{
            System.out.println("Test 3 : table non pleine sans ex-aequo");
            int[] t3 = {1,2,3,4};
            TableauTrieDEntiers tT3 = new TableauTrieDEntiers(t3);
            int[] t3Sol = {1,2,3,4};
            TableauTrieDEntiers tT3Sol = new TableauTrieDEntiers(t3);
            assertEquals("test 3 a echoue", false, tT3.contientExAequo());
            assertEquals("test 3 a echoue, contenu table modifie", tT3Sol, tT3);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 3 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 3 a reussi");


        System.out.println();
        try{
            System.out.println("test 4 : table pleine sans ex-aequo");
            int[] t4 = {1,2,3,4,5,6,7,8,9,10};
            TableauTrieDEntiers tT4 = new TableauTrieDEntiers(t4);
            assertEquals("test 4 a echoue", false, tT4.contientExAequo());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 4 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 4 a reussi");


        System.out.println();
        try{
            System.out.println("test 5 : table non pleine avec ex-aequos");
            int[] t5 = {3,5,5,5};
            TableauTrieDEntiers tT5 = new TableauTrieDEntiers(t5);
            assertEquals("test 5 a echoue", true, tT5.contientExAequo());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 5 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 5 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 5 a reussi");

        System.out.println();
        try{
            System.out.println("Test 6 : table pleine avec ex-aequos");
            int[] t6 = {1,3,3,4,5,6,7,8,9,10};
            TableauTrieDEntiers tT6 = new TableauTrieDEntiers(t6);
            assertEquals("test 6 a echoue", true, tT6.contientExAequo());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 6 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 6 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 6 a reussi");

        System.out.println();
        try{
            System.out.println("test 7 : table pleine avec 2 ex-aequos a la fin");
            int[] t7 = {1,2,3,4,5,6,7,8,9,9};
            TableauTrieDEntiers tT7 = new TableauTrieDEntiers(t7);
            assertEquals("test 7 a echoue", true, tT7.contientExAequo());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 7 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 7 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 7 a reussi");

        System.out.println();
        try{
            System.out.println("Test 8 : table pleine avec 2 ex-aequos au debut");
            int[] t8 = {1,1,3,4,5,6,7,8,9,10};
            TableauTrieDEntiers tT8 = new TableauTrieDEntiers(t8);
            assertEquals("test 8 a echoue", true, tT8.contientExAequo());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 8 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 8 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 8 a reussi");

        System.out.println();
        System.out.println("Tous les tests ont reussi!");
        System.out.println();

    }


    private static void testerSupprimerTousLesExAequos(){

        System.out.println();
        System.out.println("Test 1 : suppression dans une table vide");
        try{
            TableauTrieDEntiers tT1 = new TableauTrieDEntiers();
            int[] t1Sol = {};
            TableauTrieDEntiers tT1Sol = new TableauTrieDEntiers(t1Sol);
            assertEquals("test 1 a echoue, nombre suppressions renvoye : ", 0, tT1.supprimerTousLesExAequos());
            assertEquals("test 1 a echoue, l'attribut nombreDEntiers non correct : ",0,tT1.getNombreDEntiers());
            assertEquals("test 1 a echoue, contenu table non correct : ", tT1Sol, tT1);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 1 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 1 a reussi");

        System.out.println();
        System.out.println("Test 2 : table avec 1 entier");
        try{
            int[] t2 = {3};
            TableauTrieDEntiers tT2 = new TableauTrieDEntiers(t2);
            int[] t2Sol = {3};
            TableauTrieDEntiers tT2Sol = new TableauTrieDEntiers(t2Sol);
            assertEquals("test 2 a echoue, nombre suppressions renvoye : ", 0, tT2.supprimerTousLesExAequos());
            assertEquals("test 2 a echoue, l'attribut nombreDEntiers non correct : ",1,tT2.getNombreDEntiers());
            assertEquals("test 2 a echoue, contenu table non correct : ", tT2Sol, tT2);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 2 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 2 a reussi");


        System.out.println();
        try{
            System.out.println("Test 3 : table non pleine sans ex-aequo");
            int[] t3 = {3,4,5};
            TableauTrieDEntiers tT3 = new TableauTrieDEntiers(t3);
            int[] t3Sol = {3,4,5};
            TableauTrieDEntiers tT3Sol = new TableauTrieDEntiers(t3Sol);
            assertEquals("test 3 a echoue, nombre suppressions renvoye : ", 0, tT3.supprimerTousLesExAequos());
            assertEquals("test 3 a echoue, l'attribut nombreDEntiers non correct : ",3,tT3.getNombreDEntiers());
            assertEquals("test 3 a echoue, contenu table non correct : ", tT3Sol, tT3);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 3 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 3 a reussi");


        System.out.println();
        try{
            System.out.println("Test 4 : table pleine sans ex-aequo");
            int[] t4 = {1,2,3,4,5,6,7,8,9,10};
            TableauTrieDEntiers tT4 = new TableauTrieDEntiers(t4);
            int[] t4Sol = {1,2,3,4,5,6,7,8,9,10};
            TableauTrieDEntiers tT4Sol = new TableauTrieDEntiers(t4Sol);
            assertEquals("test 4 a echoue, nombre suppressions renvoye : ", 0, tT4.supprimerTousLesExAequos());
            assertEquals("test 4 a echoue, l'attribut nombreDEntiers non correct : ",10,tT4.getNombreDEntiers());
            assertEquals("test 4 a echoue, contenu table non correct : ", tT4Sol, tT4);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 4 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 4 a reussi");



        System.out.println();
        try{
            System.out.println("Test 5 : table non pleine avec ex-aequos");
            int[] t5 = {1,2,2,4,4,4,7,7,9};
            TableauTrieDEntiers tT5 = new TableauTrieDEntiers(t5);
            int[] t5Sol = {1,2,4,7,9};
            TableauTrieDEntiers tT5Sol = new TableauTrieDEntiers(t5Sol);
            assertEquals("test 5 a echoue, nombre suppressions renvoye : ", 4, tT5.supprimerTousLesExAequos());
            assertEquals("test 5 a echoue, l'attribut nombreDEntiers non correct : ",5,tT5.getNombreDEntiers());
            assertEquals("test 5 a echoue, contenu table non correct : ", tT5Sol, tT5);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 5 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 5 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 5 a reussi");

        System.out.println();
        try{
            System.out.println("Test 6 : table pleine avec ex-aequos");
            int[] t6 = {1,1,1,1,1,1,1,1,1,1};
            TableauTrieDEntiers tT6 = new TableauTrieDEntiers(t6);
            int[] t6Sol = {1};
            TableauTrieDEntiers tT6Sol = new TableauTrieDEntiers(t6Sol);
            assertEquals("test 6 a echoue, nombre suppressions renvoye : ", 9, tT6.supprimerTousLesExAequos());
            assertEquals("test 6 a echoue, l'attribut nombreDEntiers non correct : ",1,tT6.getNombreDEntiers());
            assertEquals("test 6 a echoue, contenu table non correct : ", tT6Sol, tT6);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("test 6 a echoue : ArrayIndexOutOfBoundsException!!!");
            e.printStackTrace();
            System.exit(0);
        }catch(Exception e){
            System.out.println("test 6 a echoue : Exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test 6 a reussi");

        System.out.println();
        System.out.println("Tous les tests ont reussi!");
        System.out.println();
    }

}




