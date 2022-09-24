package utils;

import java.util.*;
import javax.swing.*; 
import java.awt.*;   
import java.awt.image.*;
import java.awt.geom.*;

public class Sheet extends JComponent {

  private final Image offscreen;
  private final Graphics2D gra;

  private final Collection<Turtle> turtles;

  private final int width;
  private final int height;

  public Sheet(int width, int height) {
      
    this.width = width;
    this.height = height;
    setPreferredSize(new Dimension(width,height));

    offscreen = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
    gra = (Graphics2D) offscreen.getGraphics();
    gra.translate(width/2,height/2); 
    gra.scale(1,-1);

    JFrame f = new JFrame("Drawing Algo");

    turtles = new LinkedList<Turtle>();

    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setBackground(Color.RED);
    f.setContentPane(this);
    f.pack();
    f.setVisible(true);
  }
 
  /* draw the sheet: the sheet image and all the turtles */
  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    
    /* draw the sheet image */ 
    g2.drawImage(offscreen,0,0,this);     

    /* set turtle coordinate system */
    g2.translate(width/2,height/2); 
    g2.scale(1,-1);

    /* draw each turtle */
    for (Turtle t : turtles) {
      t.drawTurtle(g2);
    }
  }

  protected void addTurtle(Turtle t) {
    turtles.add(t);
  }

  /* draw a line in the sheet image */
  protected void drawLine(double ax, double ay, double bx, double by, Color color) {
    gra.setColor(color);
    gra.draw(new Line2D.Double(ax,ay,bx,by));
  }
}
