import utils.Tortue;
/*
    @Author : Corentin D'haeyere
 */
public class DessinFleur {

    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                tortue.avancer(100);
                tortue.tournerADroite(120);
            }
            tortue.tournerADroite(90);
        }
    }
}
