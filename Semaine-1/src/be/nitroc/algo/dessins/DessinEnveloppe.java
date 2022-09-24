package be.nitroc.algo.dessins;

import utils.Tortue;
/*
    @Author: Nitroc
 */
public class DessinEnveloppe {

    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            tortue.avancer(100);
            tortue.tournerAGauche(120);
        }
        for (int i = 0; i < 4; i++) {
            tortue.avancer(100);
            tortue.tournerAGauche(90);
        }
    }
}
