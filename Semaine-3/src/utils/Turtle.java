package utils;

import java.awt.*; 
import java.lang.*;

public class Turtle {
  /* shape and color of this turtle */
  private Polygon turtleShape;
  private Color turtleColor = Color.BLUE;
  private Color penColor = Color.WHITE;

  private int speed;
  
  /* position and orientation of this turtle */
  private double x = 0;
  private double y = 0;
  private double theta = 0;
  private boolean pen_down = false;
  
  /* the sheet in which this turtle draws */
  private Sheet sheet = null;
  
  public Turtle(Sheet sheet, int speed) {
    this.sheet = sheet;
    this.speed = speed;
    sheet.addTurtle(this);
    turtleShape = new Polygon(new int[] {0,0,10}, new int[] {3,-3,0}, 3);
  }
  public void turn(double degrees) {
    double radians = degrees / 180 * Math.PI;
    theta += radians; 
    sheet.repaint();
    try {
		Thread.sleep(1000 - speed);
	} catch (InterruptedException e) {
		
	}
  }
  
  public void advance(double steps) {
    double newx = x + steps*Math.cos(theta);
    double newy = y + steps*Math.sin(theta);
    if (pen_down && sheet != null) {
      sheet.drawLine(x,y,newx,newy, penColor);
    }
    x = newx;
    y = newy;
    sheet.repaint();
    try {
		Thread.sleep(1000 - speed);
	} catch (InterruptedException e) {
		
	}
  }

  public void penDown() { pen_down = true; }
  public void penUp() { pen_down = false; }
  public void setPenColor(Color color) { penColor = color; }
  

  public void setSpeed(int speed) {
	  this.speed = speed;
  }
  
protected void drawTurtle(Graphics2D graphics) {
    graphics.setColor(turtleColor);
    graphics.translate(x,y);     
    graphics.rotate(theta);
    graphics.fill(turtleShape);
  }
  
  
}
