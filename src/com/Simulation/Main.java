package com.Simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Main {

    public static void main(String[] args) {
	    //Creating the window
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        //8 and 32 offset exists because of window's decoration being included in the window bounds
        Rectangle windowSize = new Rectangle(800 + 8 + 8, 800 + 31 + 8);
        Rectangle panelBounds = new Rectangle(0, 0, 800, 800);

        JFrame window = new JFrame("Perceptron");
        //window.setBounds((int) (screenSize.width/2 - windowSize.getWidth()/2), (int) (screenSize.height/2 - windowSize.getHeight()/2)
        //                ,(int) windowSize.getWidth(), (int) windowSize.getHeight());
        window.setBounds(windowSize);
        window.setLayout(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Creating the JPanel
        RenderingPanel renderingPanel = new RenderingPanel();
        renderingPanel.setBounds(panelBounds);
        renderingPanel.setBackground(Color.BLACK);
        renderingPanel.addMouseListener(renderingPanel);
        window.add(renderingPanel);

        window.setVisible(true);
    }
}
