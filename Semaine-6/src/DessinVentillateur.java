/*
    @Author Corentin D'haeyere
 */
public class DessinVentillateur {

    private static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        tortue.accelerer();
        for (int i = 0; i < 3; i++) {
            tortue.dessinerUnCarre(100);
            tortue.tournerADroite(120);
        }
    }
}
