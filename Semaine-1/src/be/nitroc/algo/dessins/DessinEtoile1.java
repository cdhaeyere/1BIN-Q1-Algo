package be.nitroc.algo.dessins;

import utils.Tortue;
/*
    @Author: Nitroc
*/
public class DessinEtoile1 {

    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        tortue.accelerer();
        for (int i = 0; i < 3; i++) {
            tortue.avancer(100);
            tortue.tournerADroite(120);
        }
        tortue.tournerADroite(90);
        tortue.definirCouleur("NOIR");
        tortue.avancer(50);
        tortue.definirCouleur("BLANC");
        tortue.tournerAGauche(90);
        for (int i = 0; i < 3; i++) {
            tortue.avancer(100);
            tortue.tournerAGauche(120);
        }
    }
}
