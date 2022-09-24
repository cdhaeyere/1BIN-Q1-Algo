import utils.Tortue;
/*
    @Author : Corentin D'haeyere
 */
public class DessinVentillateur {

    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                tortue.avancer(100);
                tortue.tournerADroite(90);
            }
            tortue.tournerADroite(120);
        }
    }
}
