package com.Simulation;

import java.awt.*;

public class LabeledPoint extends Point {
    private int expectedValue;    //1 = Above the line, -1 = Below the line
    private final int diameter = 15;

    public LabeledPoint(int x, int y) {
        super(x, y);
        this.expectedValue = x>y ? 1 : -1;
    }

    public void show(Graphics g, Color color) {
        g.setColor(color);
        if(expectedValue == 1)
            g.drawOval(x, y, diameter, diameter);
        else
            g.fillOval(x, y, diameter, diameter);
    }

    public int getExpectedValue() {
        return expectedValue;
    }
}
