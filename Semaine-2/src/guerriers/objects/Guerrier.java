package be.nitroc.guerriers.objects;

import be.nitroc.guerriers.Main;
/*
    @Author: Corentin D'haeyere
 */
public class Guerrier {

    private String name;
    private int health;
    private int punch;

    public Guerrier(String name, int health, int punch) {
        this.name = name;
        this.health = health;
        this.punch = punch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPunch() {
        return punch;
    }

    public void setPunch(int punch) {
        this.punch = punch;
    }
}
