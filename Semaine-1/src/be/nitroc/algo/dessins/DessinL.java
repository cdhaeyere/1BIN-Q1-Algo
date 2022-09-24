package be.nitroc.algo.dessins;

import utils.Tortue;
/*
    @Author: Nitroc
 */
public class DessinL {

    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        tortue.tournerADroite(90);
        tortue.avancer(100);
        tortue.tournerAGauche(90);
        tortue.avancer(50);
    }
}
