package sk.stuba.fei.uim.oop.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends Shape{

    public Square(int radius, int x, int y, Color c) {
        super(radius, x, y, c);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(this.c);

        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
}
