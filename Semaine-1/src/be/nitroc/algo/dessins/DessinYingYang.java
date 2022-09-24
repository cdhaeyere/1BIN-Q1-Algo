package be.nitroc.algo.dessins;

import utils.Tortue;
/*
    @Author: Nitroc
 */
public class DessinYingYang {

    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        tortue.accelerer();
        for (int i = 0; i < 360 ; i++) {
            tortue.avancer(1);
            tortue.tournerADroite(1);
        }
        tortue.tournerADroite(180);
        for (int i = 0; i < 180 ; i++) {
            tortue.avancer(0.5);
            tortue.tournerAGauche(1);
        }
        for (int i = 0; i < 180 ; i++) {
            tortue.avancer(0.5);
            tortue.tournerADroite(1);
        }
        tortue.avancer(5);
        tortue.definirCouleur("BLACK");
        tortue.tournerADroite(90);
        tortue.avancer(30);
        tortue.definirCouleur("WHITE");
        for (int i = 0; i < 360 ; i++) {
            tortue.avancer(0.15);
            tortue.tournerADroite(1);
        }
        tortue.definirCouleur("BLACK");
        tortue.avancer(60);
        tortue.definirCouleur("WHITE");
        for (int i = 0; i < 360 ; i++) {
            tortue.avancer(0.15);
            tortue.tournerADroite(1);
        }
    }
}
