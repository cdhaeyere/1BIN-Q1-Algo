import java.util.Scanner;
/*
    @Author : Corentin D'haeyere
 */
public class NombreMystereInverse {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Nombre Mystere inversé");
        int max = 100;
        int min = 0;
        int guess = 0;
        int guesses = 0;
        char userInput = ' ';
        while (userInput != '=') {
            if (userInput == '+') min = guess + 1;
            else if (userInput == '-') max = guess - 1;
            guess = min + ((max - min) / 2);
            System.out.println("Est-ce que " + guess + " est votre nombre mystere ?");
            userInput = lireChar();
            guesses++;
        }
        System.out.println("Je suis trop fort pour toi, j'ai trouvé ton nombre mystère en " + guesses + " essais !");
    }

    public static char lireChar() {
        char input = '3';
        while (input != '+' && input != '-' && input != '=') {
            System.out.print("Entrez '+', '-' ou '=' : ");
            input = scanner.next().charAt(0);
        }
        return input;
    }
}
