/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package exam2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;


/**
 *
 * @author Garin McCullick
 */
public class Exam2 extends Application {
    
    private final double rate = 1.37; // US dollar value compared to canadian if 1 usd = 0.73 then 1.37X that would be 1 dollar in canadian declared as private and as a double

    @Override
    public void start(Stage primaryStage) {

        Label USLabel = new Label("US Dollars");//creating us Dollars label
        TextField USTextField = new TextField();//creating us currency text field
        USTextField.setAlignment(Pos.BASELINE_RIGHT);//setting the alignment to right like the exam example

        Label CanadianLabel = new Label("Canadian Dollars");//creating canadian currency label
        TextField CanadianTextField = new TextField();//creating canadian currency textfield
        CanadianTextField.setAlignment(Pos.BASELINE_RIGHT);//setting position to the right like exam example
        CanadianTextField.setEditable(false);//not allowing them to edit the canadian textfield because it is a us to canadian converter strictly

        Button convertButton = new Button("Convert");//creating convert button
        convertButton.setOnAction(event -> {//event handler for the  using try and catch where try will run and it will catch any error such as a numberformating issue and will set the output as an empty string until it doesnt catch an error
            try {
                double us = Double.parseDouble(USTextField.getText());//creating us double and getting the input
                double canadian = us * rate;//creating canadian and setting the output = to us * rate (input * 1.37)
                CanadianTextField.setText(String.format("%.2f", canadian));//setting canadian textfield with formating to round to nearest 2nd decimal place ("%.2f")
            } catch (NumberFormatException e) {//numberformatexception is an exception in java
                CanadianTextField.setText("");//if it catches setting output to empty string
            }
        });

        //creating pane and all the elements
        GridPane pane = new GridPane(); //new GridPane grid pane allows me to place elements in columns and rows
        pane.setAlignment(Pos.CENTER);//setting pane alignment to center. all elements will be center of the pane
        pane.add(USLabel, 0, 1);//adding label element to pane as well as setting column and row positions
        pane.add(USTextField, 1, 1);//adding ustextfield element to pane as well as setting column and row positions
        pane.add(CanadianLabel, 0, 2);//adding canadianlabel element to pane as well as setting column and row positions
        pane.add(CanadianTextField, 1, 2);//adding canadiantextfield element to pane as well as setting column and row positions
        pane.add(convertButton, 1, 3);//adding button element to pane as well as setting column and row positions
        
        //moving the button to the bottom right corner like in the example
        GridPane.setConstraints(convertButton, 1, 3);//column 1 for right side of the pane and row 3 for the bottom of the scene
        GridPane.setHalignment(convertButton, javafx.geometry.HPos.RIGHT);//setting it to the end of the column instead of the begining otherwise it would be right below the start of the textfields.
        
        //optimizing the pane to auto width and height. kind of like width:auto, and height:auto in css
        pane.prefWidth(Region.USE_COMPUTED_SIZE);//calculate height
        pane.prefHeight(Region.USE_COMPUTED_SIZE);//calculate width
        
        // Create scene and show stage
        Scene scene = new Scene(pane);//creating scene
        primaryStage.setTitle("Convert US Dollars to Canadian Dollars");//setting the title for the stage
        primaryStage.setScene(scene);//placing the scene in the stage
        primaryStage.show();//showing stage
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
