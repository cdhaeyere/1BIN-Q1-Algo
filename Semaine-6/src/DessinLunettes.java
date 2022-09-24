/*
    @Author Corentin D'haeyere
 */
public class DessinLunettes {

    private static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        tortue.accelerer();
        tortue.dessinerUnCarre(100);
        tortue.tournerAGauche(180);
        tortue.avancer(50);
        tortue.tournerAGauche(90);
        tortue.dessinerUnCarre(100);
    }
}
