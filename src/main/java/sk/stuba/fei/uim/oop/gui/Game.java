package sk.stuba.fei.uim.oop.gui;

import javax.swing.*;

import sk.stuba.fei.uim.oop.logic.Logic;

import java.awt.*;

public class Game {
    
    public Game() {

        JFrame frame = new JFrame("RT-Skuska");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setResizable(true);
        frame.setFocusable(true);
        frame.requestFocusInWindow();
        frame.setLayout(new BorderLayout());

        Logic logic = new Logic();

        logic.getRender().addMouseMotionListener(logic);

        JPanel menu = new JPanel(new BorderLayout());

        JLabel l = new JLabel("Lenght");
        JLabel r = new JLabel("Radius");
        JLabel s = new JLabel("Spacing");

        JSlider len = new JSlider(JSlider.VERTICAL, 20, 200, 50);
        len.setSnapToTicks(true);
        len.setFocusable(false);
        len.setMinorTickSpacing(10);
        len.setMajorTickSpacing(10);
        len.setSnapToTicks(true);
        len.setPaintTicks(true);
        len.setPaintLabels(true);

        JSlider rad = new JSlider(JSlider.VERTICAL, 1, 20, 5);
        rad.setSnapToTicks(true);
        rad.setFocusable(false);
        rad.setMinorTickSpacing(1);
        rad.setMajorTickSpacing(1);
        rad.setSnapToTicks(true);
        rad.setPaintTicks(true);
        rad.setPaintLabels(true);

        JSlider spac = new JSlider(JSlider.VERTICAL, 1, 20, 5);
        spac.setSnapToTicks(true);
        spac.setFocusable(false);
        spac.setMinorTickSpacing(1);
        spac.setMajorTickSpacing(1);
        spac.setSnapToTicks(true);
        spac.setPaintTicks(true);
        spac.setPaintLabels(true);

        JPanel labels = new JPanel();

        labels.add(l);
        labels.add(r);
        labels.add(s);

        len.setName("Length");
        rad.setName("Radius");
        spac.setName("Spacing");

        String items[] = {"Circle","Square","Hourglass"};
        JComboBox box = new JComboBox(items);
        box.setFocusable(false);

        box.addActionListener(logic);

        menu.add(labels, BorderLayout.NORTH);
        menu.add(len, BorderLayout.WEST);
        menu.add(rad, BorderLayout.CENTER);
        menu.add(spac, BorderLayout.EAST);
        menu.add(box, BorderLayout.SOUTH);

        len.addChangeListener(logic);
        rad.addChangeListener(logic);
        spac.addChangeListener(logic);

        frame.add(menu, BorderLayout.WEST);
        frame.add(logic.getRender());
        
        frame.setVisible(true);
    }
}
