package sk.stuba.fei.uim.oop.shapes;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class Shape extends JPanel{
    
    protected Color c;

    public Shape(int radius, int x, int y, Color c) {
        this.c = c;
        this.setSize(radius, radius);
        this.setLocation(x-radius/2, y-radius/2);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
