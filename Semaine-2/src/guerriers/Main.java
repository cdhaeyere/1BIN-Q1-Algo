package be.nitroc.guerriers;

import be.nitroc.guerriers.objects.Dice;
import be.nitroc.guerriers.objects.Guerrier;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
    @Author: Corentin D'haeyere
*/
public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static List<Guerrier> guerriers = new ArrayList<>();

    public static void main(String[] args) {

        //On demande au joueur de rentrer le nom de ces joueurs pour ensuite les instancier
        System.out.println("Entrer le nom du premier guerrier :");
        String name1 = scanner.nextLine();
        System.out.println("Entrer le nom du deuxieme guerrier :");
        String name2 = scanner.nextLine();
        Guerrier guerrier1 = new Guerrier(name1, Dice.rollDice(1, 10), Dice.rollDice(1, 4));
        Guerrier guerrier2 = new Guerrier(name2, Dice.rollDice(1, 10), Dice.rollDice(1, 4));

        //On ajoute nos deux joueurs aux joueurs register par le jeu
        guerriers.add(guerrier1);
        guerriers.add(guerrier2);

        //On sélectionne lequel des deux joueurs va commencer en premier et lequel en deuxieme
        System.out.println("La partie va maintenant commencer !");
        Guerrier first = guerriers.get(Dice.rollDice(0, 1));
        guerriers.remove(first);
        Guerrier second = guerriers.get(0);

        //On lance la partie jusqu'à ce qu'un des joueurs n'aient plus de vie
        while (first.getHealth() > 0 && second.getHealth() > 0) {
            System.out.println("Au tour du premier joueur de frapper");
            System.out.println(first.getName() + " frappe le premier et inflige " + first.getPunch() + " de dégats à " + second.getName());
            second.setHealth(second.getHealth() - first.getPunch());
            if (second.getHealth() <= 0) {
                System.out.println("La partie est remportée par le joueur " + first.getName());
                return;
            } else {
                System.out.println("Au tour du second joueur de frapper !");
                System.out.println(second.getName() + " frappe le premier et inflige " + second.getPunch() + " de dégats à " + first.getName());
                first.setHealth(first.getHealth() - second.getPunch());
                if (first.getHealth() <= 0) {
                    System.out.println("La partie est remportée par le joueur " + second.getName());
                    return;
                }
            }
        }
    }
}
