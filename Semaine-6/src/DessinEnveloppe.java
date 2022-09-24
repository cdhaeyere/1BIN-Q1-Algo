/*
    @Author Corentin D'haeyere
 */
public class DessinEnveloppe {

    private static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        tortue.accelerer();
        tortue.dessinerUnTriangle(100);
        tortue.dessinerUnCarre(100);
    }
}
