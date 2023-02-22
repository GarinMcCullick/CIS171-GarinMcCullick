/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package pkg15.pkg29.racecar;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 *
 * @author Garin McCullick
 */
public class RaceCar extends Application {
    
    private static final int CAR_WIDTH = 100;//car width
    private static final int CAR_HEIGHT = 60;//car height
    private static final int SCENE_WIDTH = 600;//window width
    private static final int SCENE_HEIGHT = 400;//window height
    private static final int SPEED = 5;//sets the speed of the car

        // Create a pane to hold the car image
           private ImageView car;
    private Timeline timeline;//using timeline class that will allow me to use keyframes and animations.
    
    @Override
    public void start(Stage stage) {
        
        Image carImage = new Image(getClass().getResourceAsStream("car.png"));// get the car image
        car = new ImageView(carImage);//sets image to the view
        car.setFitWidth(CAR_WIDTH);//fits the car inside the window this method keeps aspect ratio as well.
        car.setFitHeight(CAR_HEIGHT);
        
        // Creates a pane and add the car to it
        Pane root = new Pane(car);
        
        // Creates a scene with the pane and puts it in the stage
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        stage.setScene(scene);
        stage.setTitle("RACE CAR GO VROOOM");
        stage.show();
        
        // Create a timeline to update the car's position
        timeline = new Timeline(//using the timeline built in class here. it takes a keyframe object
                new KeyFrame(Duration.millis(16), event -> {//keyframe takes a duration in ms as well as an action
                    
                    car.setLayoutX(car.getLayoutX() + SPEED);// Moves the car to the right
                    
                    // If the car goes off the right edge, wrap it to the left edge
                    if (car.getLayoutX() > SCENE_WIDTH) {
                        car.setLayoutX(CAR_WIDTH);
                    }
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);//goes for infinity
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
