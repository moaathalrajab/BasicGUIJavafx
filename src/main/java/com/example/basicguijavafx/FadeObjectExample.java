package com.example.basicguijavafx;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FadeObjectExample extends Application {
    int varx=10;

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a circle and set its properties
        Circle circle = new Circle();
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(50);
        circle.setStroke(Color.BLACK); // Set circle stroke color
        circle.setFill(Color.RED);

        // Create a pane to hold the circle
        Pane pane = new Pane();
        pane.getChildren().add(circle);


        FadeTransition ft = new FadeTransition();
        ft.setDuration(Duration.millis(5000));
        ft.setNode(circle);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.play();

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("ShowCircle"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
