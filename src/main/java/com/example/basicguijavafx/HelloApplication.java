package com.example.basicguijavafx;

import javafx.animation.Transition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//    }

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        double val = 0;
        // Create a scene and place a button in the scene
        MyGroup g = new MyGroup();
        //animate g by rotating the shape 90 degrees it needs to be slow animation

        Transition t = new Transition() {
            {
                setCycleDuration(javafx.util.Duration.seconds(3));
            }

            @Override
            protected void interpolate(double frac) {
                g.setRotate(frac * 90);
            }
        };
        //t.play();
        g.setLayoutY(100);
        //rct.setStyle("");
        Scene scene = new Scene(g, 500, 250);
        primaryStage.setTitle("First Demo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }


    public static void main(String[] args) {
        launch();
    }
}

class MyGroup extends Group {
    public MyGroup() {

        Circle c = new Circle(100, 100, 50);
        Line l = new Line(10, 10, 100, 100);
        l.setStrokeWidth(5);
        Rectangle rct = new Rectangle(50, 50, 200, 100);
        ProgressBar pb = new ProgressBar(0);
        pb.setLayoutX(150);
        pb.setLayoutY(200);

        rct.setFill(Color.YELLOW);
        rct.setStroke(Color.BLUE);
        rct.setStrokeWidth(3);
        rct.setArcWidth(20);
        rct.setArcHeight(20);
        rct.setOnMousePressed(e -> {
            //rct.setFill(Color.RED);
            rct.setEffect(new DropShadow(10, 2, 2, Color.BLUEVIOLET));
            pb.setProgress(pb.getProgress() + 0.1);
        });
        rct.setOnMouseReleased(e -> {
            // rct.setFill(Color.YELLOW);
            rct.setEffect(null);
            if (pb.getProgress() >= 1) {
                System.exit(0);
            }
        });
        getChildren().addAll(l, rct, c);
    }

}