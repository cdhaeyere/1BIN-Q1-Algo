package be.nitroc.algo.dessins;

import utils.Tortue;
/*
    @Author: Nitroc
*/
public class DessinSpirographe {

    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        tortue.accelerer();
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 360 ; j++) {
                tortue.avancer(1);
                tortue.tournerADroite(1);
            }
            tortue.tournerAGauche(10);
            tortue.avancer(0.1);
        }
    }
}
