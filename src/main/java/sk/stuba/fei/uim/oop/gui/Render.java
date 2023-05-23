package sk.stuba.fei.uim.oop.gui;


import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Render extends JPanel {

    private ArrayList<Point> coords;

    public Render() {
        super();
        this.coords = new ArrayList<Point>();
        this.setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.coords.size() > 1) {

            for (int i = 1; i < coords.size(); i++) {

                int x1 = ((int)this.coords.get(i-1).getX());
                int y1 = ((int)this.coords.get(i-1).getY());
                int x2 = ((int)this.coords.get(i).getX());
                int y2 = ((int)this.coords.get(i).getY());

                g.drawLine(x1, y1, x2, y2);
            }

        }
    }

    public void updateCoords(ArrayList<Point> c) {
        this.coords = c;
    }
    
}
