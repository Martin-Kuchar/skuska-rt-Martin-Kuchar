package sk.stuba.fei.uim.oop.logic;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

import lombok.Getter;
import sk.stuba.fei.uim.oop.gui.Render;
import sk.stuba.fei.uim.oop.shapes.Circle;
import sk.stuba.fei.uim.oop.shapes.Hourglass;
import sk.stuba.fei.uim.oop.shapes.Square;

public class Logic extends UniversalAdapter {
    @Getter
    private Render render;

    private int lenght;
    private int radius;
    private int spacing;
    private int shape;
    
    private ArrayList<Point> coords = new ArrayList<Point>();

    public Logic() {
        this.render = new Render();
        this.lenght = 50;
        this.radius = 10;
        this.spacing = 5;
        this.shape = 0;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider j = ((JSlider)e.getSource());

        if (j.getName().equals("Length")) {
            this.lenght = j.getValue();
        }
        
        if (j.getName().equals("Radius")) {
            this.radius = j.getValue()*2;
        }
        
        if (j.getName().equals("Spacing")) {
            this.spacing = j.getValue();
        }
        this.draw();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.coords.add(e.getPoint());
        this.draw();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox j = ((JComboBox)e.getSource());

        if (j.getSelectedItem().toString().equals("Circle")){
            this.shape = 0;
        }

        if (j.getSelectedItem().toString().equals("Square")){
            this.shape = 1;
        }

        if (j.getSelectedItem().toString().equals("Hourglass")){
            this.shape = 2;
        }
        this.draw();
    }

    private void draw() {
        this.removeExcessCoords();
        this.render.updateCoords(this.coords);
        this.addShapes();
        this.render.revalidate();
        this.render.repaint();
    }

    private void removeExcessCoords() {
        if (this.coords.size() > this.lenght) {
            for (int i = 0; i < this.coords.size() - this.lenght; i++) {
                this.coords.remove(0);
            }
        }
    }

    private void addShapes() {
        this.render.removeAll();
        this.render.repaint();
        for (int i = 0; i < this.coords.size(); i++) {
            Color c = new Color(0, 255, 0, i*(205/this.coords.size())+50);
            if(i % this.spacing == 0) {
                switch (this.shape) {
                    case 0:
                        this.render.add(new Circle(this.radius, ((int)this.coords.get(i).getX()), ((int)this.coords.get(i).getY()), c));
                        this.render.repaint();
                        break;

                    case 1:
                        this.render.add(new Square(this.radius, ((int)this.coords.get(i).getX()), ((int)this.coords.get(i).getY()), c));
                        this.render.repaint();
                        break;

                    case 2:
                        this.render.add(new Hourglass(this.radius, ((int)this.coords.get(i).getX()), ((int)this.coords.get(i).getY()), c));
                        this.render.repaint();
                        break;

                    default:
                        break;
                }
            }
        }
    }

}
