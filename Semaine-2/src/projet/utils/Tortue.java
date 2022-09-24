package utils;

import java.awt.*;

public class Tortue {
	private Turtle t;
	
	public Tortue(){
		t = new Turtle(new Sheet(800, 800),1);
		t.penDown();
	}
	
	public void avancer(double pixel){
		t.advance(pixel);
	}
	
	public void tournerADroite(int degre){
		t.turn(360-degre);
	}
	
	public void tournerAGauche(int degre){
		t.turn(degre);
	}

	public void leverLeStylo() {
		t.penUp();
	}

	public void baisserLeStylo() {
		t.penDown();
	}
	
	public void definirCouleur(String couleur){
		if(couleur.equalsIgnoreCase("RED")){
			t.setPenColor(Color.RED);
			return;
		}
		if(couleur.equalsIgnoreCase("BLACK")){
			t.setPenColor(Color.BLACK);
			return;
		}
		if(couleur.equalsIgnoreCase("BLUE")){
			t.setPenColor(Color.BLUE);
			return;
		}
		if(couleur.equalsIgnoreCase("YELLOW")){
			t.setPenColor(Color.YELLOW);
			return;
		}
		if(couleur.equalsIgnoreCase("GREEN")){
			t.setPenColor(Color.GREEN);
			return;
		}
		t.setPenColor(Color.WHITE);
	}
	
	public void accelerer(){
		t.setSpeed(999);
	}
	
}
