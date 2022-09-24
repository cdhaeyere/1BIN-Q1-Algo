package be.nitroc.algo.dessins;

import utils.Tortue;
/*
    @Author: Nitroc
 */
public class DessinV {

    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        tortue.tournerADroite(60);
        tortue.avancer(100);
        tortue.tournerAGauche(120);
        tortue.avancer(100);
    }
}
