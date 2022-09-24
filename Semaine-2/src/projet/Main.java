import utils.Tortue;

public class Main {

    //On initialise la variable tortue
    public static Tortue tortue = new Tortue();

    //Notre méthode main, qui permet de compiler et run notre magnifique code
    public static void main(String[] args) {
        tortue.accelerer();

        //On commence notre phare par dessiner des vagues
        tortue.tournerAGauche(90);
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 180; i++) {
                tortue.accelerer();
                tortue.avancer(0.2);
                tortue.tournerADroite(1);
            }
            for (int i = 0; i < 180; i++) {
                tortue.accelerer();
                tortue.avancer(0.2);
                tortue.tournerAGauche(1);
            }
        }
        tortue.tournerADroite(90);

        //On commence par la base du phare, un trapèze
        tortue.avancer(60);
        tortue.tournerAGauche(93);
        tortue.avancer(150);
        tortue.tournerADroite(93);

        //On fait la barriere sur la platerforme du phare
        tortue.avancer(10);
        tortue.tournerAGauche(82);
        tortue.avancer(10);
        tortue.tournerAGauche(98);
        tortue.avancer(65);
        tortue.tournerAGauche(98);
        tortue.avancer(10);
        tortue.tournerAGauche(82);
        tortue.avancer(55);

        //On fait la deuxieme partie de notre trapèze
        tortue.avancer(-45);
        tortue.tournerADroite(93);
        tortue.avancer(150);
        tortue.avancer(-150);
        tortue.definirCouleur("BLACK");
        tortue.avancer(-12);
        tortue.definirCouleur("WHITE");

        //On rajoute la partie au dessus de phare
        tortue.avancer(-40);
        tortue.tournerAGauche(93);
        tortue.avancer(35);
        tortue.tournerADroite(86);
        tortue.avancer(38);
        tortue.avancer(-38);
        tortue.tournerADroite(155);

        //On améliore notre phare en y ajoutant
        tortue.avancer(35);
        tortue.tournerAGauche(120);
        tortue.avancer(35);
        tortue.avancer(-35);
        tortue.tournerADroite(30);

        //On rajoute un cercle au dessus comme la petite cerise sur le gateau
        for (int i = 0; i < 360 ; i++) {
            tortue.avancer(0.1);
            tortue.tournerADroite(1);
        }
        tortue.definirCouleur("BLACK");
        tortue.tournerAGauche(60);
        tortue.avancer(50);
        tortue.definirCouleur("WHITE");

        //On finit par un petite fenêtre
        for (int i = 0; i <4;i++) {
            tortue.avancer(10);
            tortue.tournerADroite(90);
        }
    }
}