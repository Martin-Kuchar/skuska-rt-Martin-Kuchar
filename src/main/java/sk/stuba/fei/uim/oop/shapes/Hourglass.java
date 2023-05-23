package sk.stuba.fei.uim.oop.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Hourglass extends Shape {
    
    public Hourglass(int radius, int x, int y, Color c) {
        super(radius, x, y, c);
        
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(this.c);

        int xPoints[] = {0, this.getWidth(), this.getWidth()/2};
        int yPoints[] = {0, 0, this.getHeight()/2};
        g.fillPolygon(xPoints, yPoints, 3);

        int xPoints2[] = {0, this.getWidth(), this.getWidth()/2};
        int yPoints2[] = {this.getHeight(), this.getHeight(), this.getHeight()/2};
        g.fillPolygon(xPoints2, yPoints2, 3);
    }
}
