package utils;

import java.awt.Color;

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
	
	public void definirCouleur(String couleur){
		if(couleur.equalsIgnoreCase("ROUGE")){
			t.setPenColor(Color.RED);
			return;
		}
		if(couleur.equalsIgnoreCase("NOIR")){
			t.setPenColor(Color.BLACK);
			return;
		}
		if(couleur.equalsIgnoreCase("BLEU")){
			t.setPenColor(Color.BLUE);
			return;
		}
		if(couleur.equalsIgnoreCase("JAUNE")){
			t.setPenColor(Color.YELLOW);
			return;
		}
		if(couleur.equalsIgnoreCase("VERT")){
			t.setPenColor(Color.GREEN);
			return;
		}
		t.setPenColor(Color.WHITE);
	}
	
	public void accelerer(){
		t.setSpeed(999);
	}

	
}
