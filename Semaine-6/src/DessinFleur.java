/*
    @Author Corentin D'haeyere
 */
public class DessinFleur {

    private static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        tortue.accelerer();
        for (int i = 0; i < 4; i++) {
            tortue.dessinerUnTriangle(100);
            tortue.tournerADroite(90);
        }
    }
}
