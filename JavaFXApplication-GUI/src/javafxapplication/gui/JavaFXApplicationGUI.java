/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafxapplication.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Garin McCullick
 */
public class JavaFXApplicationGUI extends Application {
    
    @Override
  public void start(Stage Stage) {
    
    Label heading = new Label("Selling My Sailboat!");//heres the heading
    heading.setFont(Font.font("Arial", FontWeight.BOLD, 16));//setting font styles
    
    Image image = new Image("https://images.unsplash.com/photo-1611195715369-f51eb50b6722?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8c2FpbGJvYXR8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60");//heres the image
    ImageView imageView = new ImageView(image);//ImageView is like the container for the image 
    
    
    
    
    
    TextArea textArea = new TextArea("this is my 1998 monohaul. \n I'm hoping to sell to an adventurous person who can get more use out of it!");// this is a text area
    
    Button button = new Button("More Info");// heres a button
    //////////////////////////////////////////tieing together in vbox
    VBox root = new VBox(heading, imageView, textArea,button);// this is the root node and add all the elements are tied into it; Vbox is like a parent container that arranges the children into a column
    
    root.setPrefWidth(500);
    root.setPrefHeight(500);
    /////////////////////////////////////////////////////////////////////// creating the scene and stage
    Scene scene = new Scene(root);//scene is the top level container basically or like the body of html almost and stage is like the <html> tag or container for comparison
    Stage.setScene(scene);
    Stage.show();
  }
  
  public static void main(String[] args) {
    launch(args);
    
}}
