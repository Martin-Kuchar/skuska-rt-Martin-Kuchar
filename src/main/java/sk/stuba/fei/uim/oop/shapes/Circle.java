package sk.stuba.fei.uim.oop.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {

    public Circle(int radius, int x, int y) {
        super(radius, x, y);
        
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.red);

        g.fillOval(0, 0, this.getWidth(), this.getHeight());
    }
}
