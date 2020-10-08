package com.Simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class RenderingPanel extends JPanel implements MouseListener, KeyListener {
    private ArrayList<LabeledPoint> points;
    private Perceptron brain;

    public RenderingPanel() {
        points = new ArrayList<LabeledPoint>();
        brain = new Perceptron();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //The line that marks which point is above or beneath
        g.setColor(Color.WHITE);
        g.drawLine(0, 0, getWidth(), getHeight());

        for (LabeledPoint p : points) {
            int guess = brain.guess(new double[]{(double)p.x, (double)p.y});
            //Create the color based on the guess: If it's right, then green. Else red
            Color color = guess == p.getExpectedValue() ? Color.GREEN : Color.RED;
            p.show(g, color);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //mouse.x = e.getX();
        //mouse.y = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
         for(LabeledPoint p : points) {
             brain.train(new double[]{(double)p.x, (double)p.y}, p.getExpectedValue());
         }
         repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == ' ') {
            points.add(new LabeledPoint((int)(Math.random()*getWidth()), (int)(Math.random()*getHeight())));
        }

        repaint();
    }
}
