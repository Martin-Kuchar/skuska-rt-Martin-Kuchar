package sk.stuba.fei.uim.oop.logic;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

import lombok.Getter;
import sk.stuba.fei.uim.oop.gui.Render;
import sk.stuba.fei.uim.oop.shapes.Circle;

public class Logic extends UniversalAdapter {
    @Getter
    private Render render;

    private int lenght;
    private int radius;
    private int spacing;
    

    private ArrayList<Point> coords = new ArrayList<Point>();

    public Logic() {
        this.render = new Render();
        render.add(new Circle(this.radius));
    }


    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider j = ((JSlider)e.getSource());

        if (j.getName().equals("Length")) {
            this.lenght = j.getValue();
        }
        
        if (j.getName().equals("Radius")) {
            this.radius = j.getValue();
            

        }
        
        if (j.getName().equals("Spacing")) {
            this.spacing = j.getValue();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

}