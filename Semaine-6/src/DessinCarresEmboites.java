/*
    @Author Corentin D'haeyere
 */
public class DessinCarresEmboites {

    private static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        tortue.accelerer();
        for (int i = 0; i < 5; i++) {
            tortue.dessinerUnCarre(40 + i*5);
        }
    }
}
