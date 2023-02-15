/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package pkg14_17.hangman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.layout.Pane;
import javafx.collections.ObservableList;

/**
 *
 * @author Garin McCullick
 */
public class Hangman extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //pane is a container that will allow me to manipulate the child nodes (ui controls)
        Pane pane = new Pane();//refferencing the Pane method
        pane.setStyle("-fx-background-color:BLACK;");
        //creating polylines. polylines have sets of points (x,y) that are connected in order to make lines.
        Polyline line1 = new Polyline();//referencing Polyline method to create new line
        pane.getChildren().add(line1);//adding line1 into the pane
        line1.setStroke(Color.WHITE);//setting line color property to white
        ObservableList list = line1.getPoints();//ObservableList creates a list of elements that is dynamic and displayed elements can respond to changes in realtime based off the list.
        double x1 = 20.0;//notes on these points are only for me trying to get the look right. Its not as simple as pole height etc... it draws from coordinate to coordinate
        double y1 = 190.0;//hanging pole height
        double y2 = 10.0;//hanging pole position
        double x3 = 100.0;//drawing across going out hanging pole
        list.addAll(x1,y1,x1,y2,x3,y2,x3,y1 * .62);//adding points to list .5 is for hangman rope/doubling line goes down to legs to look like torso
        
        
        Polyline line2 = new Polyline();//creating line2
        pane.getChildren().add(line2);//adding line2 to pane
        line2.setStroke(Color.WHITE);//set color white
        ObservableList list2 = line2.getPoints();
        list2.addAll((x1 + x3) * .5, y1 * .5, x3, y1 * .25, x3 + (x3-x1) * .5, y1 * .5);//adding modified points to list2 for polylines to draw to.
        
       Polyline line3 = new Polyline();//creating line3
        pane.getChildren().add(line3);//adding line3 to pane
        line3.setStroke(Color.WHITE);//set color white
        ObservableList list3 = line3.getPoints();//creating list 3
        list3.addAll((x1 + x3) * .6, y1 * .80, x3, y1 * .60, x3 + (x3-x1) * .3, y1 * .80);//adding modified points to list3 for polylines to draw to.
        
        Circle circle = new Circle(x3, y1 * .25, 15);//creating a circle
        circle.setFill(Color.WHITE);//setting color to white
        circle.setStroke(Color.WHITE);//circle line color to white
        pane.getChildren().add(circle);//adding circle to the pane
        
        Scene scene = new Scene(pane, 200,200);//creating scene size 200 by 200
        primaryStage.setScene(scene);//basically returning scene
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
