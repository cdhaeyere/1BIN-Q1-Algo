package be.nitroc.guerriers.objects;
/*
    @Author: Corentin D'haeyere
 */
public class Dice {

    public static int rollDice(int valeurMinimale, int valeurMaximale){
        double nombreReel;
        int resultat;
        nombreReel = Math.random();
        resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
        return resultat;
    }
}
