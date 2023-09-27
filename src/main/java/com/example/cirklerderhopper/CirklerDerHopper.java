package com.example.cirklerderhopper;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CirklerDerHopper extends Application {
    private static final int CANVAS_WIDTH = 640;
    private static final int CANVAS_HEIGHT = 480;
    private static final int UPDATE_PERIOD = 10; // milliseconds per frame

    // Hoppende cirkels definition
    private Bold ball;
    private int centerX = 280, centerY = 220;
    private int radius = 30;
    private int xStep = 3, yStep = 5; // skridtlængde
    private ArrayList<Bold> bolde;

    @Override
    public void start(final Stage primaryStage)
    {
        // Klargør scene med sort baggrund og salen "stage"
        Pane canvas = new Pane();
        canvas.setPrefSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        canvas.setBackground(new Background(
                new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        primaryStage.setScene(new Scene(canvas));
        primaryStage.setTitle("JavaFX Hoppende bold");
        primaryStage.show();

        // Lav bolde
        //bolde = new ArrayList<Bold>();
        //for (int i=0; i<10; i++) {
            ball = new Bold(centerX, centerY, (int)(Math.random()*10)-5, (int)(Math.random()*10)-5, (int)(Math.random()*10)+10, Color.RED, canvas);
            //bolde.add(ball);
            canvas.getChildren().addAll(ball);
        //}

        // Lav gameloop og start det
        Timeline loop = new Timeline(new KeyFrame(Duration.millis(UPDATE_PERIOD), evt ->
        {
            gameloop();
        }));
        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
    }

    private void gameloop() {
        //for (Bold ball : bolde)
            ball.flyt();
    }

    public static void main(final String[] args)
    {
        launch(args);
    }
}