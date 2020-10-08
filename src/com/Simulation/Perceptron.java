package com.Simulation;

import java.util.ArrayList;

public class Perceptron {
    double[] weights;
    private double learningRate = 0.1;
    public Perceptron() {
        weights = new double[]{(Math.random()*2)-1, (Math.random()*2)-1};
    }

    public int guess(double[] input) {
        //I have used a simple sign function, but should really have used a sigmoid function
        return sign(input[0]*weights[0] + input[1]*weights[1]);
    }

    private int sign(double n) {
        return n >= 0 ? 1 : -1;
    }

    public void train(double[] input, int expectedValue) {
        //Try to guess
        int guessedValue = guess(input);

        //Calculate the error
        int error = expectedValue - guessedValue;

        //Tune the weights
        for (int i = 0; i < weights.length; i++) {
            weights[i] += error * learningRate * input[i];
        }
    }
}
