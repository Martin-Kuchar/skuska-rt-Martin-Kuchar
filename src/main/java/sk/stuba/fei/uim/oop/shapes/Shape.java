package sk.stuba.fei.uim.oop.shapes;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class Shape extends JPanel{
    
    protected Color c;

    public Shape(int radius) {
        this.setSize(radius, radius);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
