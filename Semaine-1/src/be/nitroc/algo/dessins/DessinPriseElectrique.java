package be.nitroc.algo.dessins;

import utils.Tortue;
/*
    @Author: Nitroc
 */
public class DessinPriseElectrique {

    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        tortue.accelerer();
        for (int i = 0; i < 360 ; i++) {
            tortue.avancer(0.1);
            tortue.tournerADroite(1);
        }
        tortue.leverLeStylo();
        tortue.avancer(40);
        tortue.baisserLeStylo();
        for (int i = 0; i < 360 ; i++) {
            tortue.avancer(0.1);
            tortue.tournerADroite(1);
        }
        tortue.leverLeStylo();
        tortue.avancer(35);
        tortue.tournerADroite(90);
        tortue.baisserLeStylo();
        for (int i = 0; i < 360 ; i++) {
            tortue.avancer(1);
            tortue.tournerADroite(1);
        }
    }
}
