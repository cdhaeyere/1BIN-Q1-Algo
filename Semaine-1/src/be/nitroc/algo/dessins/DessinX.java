package be.nitroc.algo.dessins;

import utils.Tortue;
/*
    @Author: Nitroc
 */
public class DessinX {

    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        tortue.tournerADroite(45);
        tortue.avancer(150);
        tortue.tournerADroite(135);
        tortue.definirCouleur("NOIR");
        tortue.avancer(110);
        tortue.tournerADroite(135);
        tortue.definirCouleur("BLANC");
        tortue.avancer(150);
    }
}
