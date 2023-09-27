package com.example.cirklerderhopper;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Bold extends Circle {
    private Pane canvas;
    private int xStep, yStep;

    public Bold(int centerX, int centerY, int xStep, int yStep, int radius, Color c, Pane canvas) {
        super(centerX, centerY, radius, c);
        this.canvas = canvas;
        this.xStep = xStep;
        this.yStep = yStep;
        setOpacity(Math.random());
    }

    public void flyt() {
        int centerX = (int)getCenterX();
        int centerY = (int)getCenterY();
        int radius = (int)getRadius();
        centerX += xStep;
        centerY += yStep;
        if (centerX + radius > (int)canvas.getWidth() || centerX - radius < 0) {
            xStep = -xStep;
        }
        if (centerY + radius > (int)canvas.getHeight() || centerY - radius < 0) {
            yStep = -yStep;
        }
        setCenterX(centerX);
        setCenterY(centerY);
    }

}
