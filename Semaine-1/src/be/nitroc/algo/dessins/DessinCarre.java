package be.nitroc.algo.dessins;

import utils.Tortue;
/*
    @Author: Nitroc
 */
public class DessinCarre {

    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            tortue.avancer(100);
            tortue.tournerAGauche(90);
        }
    }
}
