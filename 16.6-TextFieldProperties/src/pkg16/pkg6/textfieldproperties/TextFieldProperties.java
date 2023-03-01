/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package pkg16.pkg6.textfieldproperties;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Garin McCullick
 */
public class TextFieldProperties extends Application {
    @Override
    public void start(Stage primaryStage){
    TextField tfTextField = new TextField();//creating textfield
    TextField tfColumnSize = new TextField();//creating textfield for column size
    tfTextField.setAlignment(Pos.BOTTOM_RIGHT);//using Pos class to set alignment
    tfColumnSize.setAlignment(Pos.BOTTOM_RIGHT);//using Pos class to set alignment
    
    //creating textfields
    tfTextField.setPrefColumnCount(13);//setting size of textfield
    tfColumnSize.setPrefColumnCount(3);//setting size of textfield 
    
    //creating hbox
    HBox hBox1 = new HBox(5);//creating hbox1 storing textfield with label (hbox is like a div)
    hBox1.setAlignment(Pos.CENTER);
    hBox1.getChildren().addAll(new Label("Text Field"), tfTextField);//adding in label to the textfield inside hbox1
    
    //creating buttons
    RadioButton rbLeft = new RadioButton("left");
    RadioButton rbCenter = new RadioButton("center");
    RadioButton rbRight = new RadioButton("right");
    
    //creating a toggle group for buttons
    ToggleGroup group = new ToggleGroup();
    rbLeft.setToggleGroup(group);
    rbCenter.setToggleGroup(group);
    rbRight.setToggleGroup(group);
    
    //creating hbox2
    HBox hBox2 = new HBox(2);
    hBox2.setAlignment(Pos.CENTER);
    hBox2.getChildren().addAll(rbLeft,rbCenter,rbRight);//adding radio buttons to hbox2
    
    //creating hbox3
    HBox hBox3 = new HBox(5);
    hBox3.getChildren().addAll(new Label("Column Size"), tfColumnSize);//adding width textfield (ColumnSize) to hbox 3 with label
    
    //creating hbox4
    HBox hBox4 = new HBox(15);
    hBox4.setAlignment(Pos.CENTER);
    hBox4.getChildren().addAll(hBox2,hBox3);//putting hbox2 and hbox3 inside hbox4
    
    //creating vbox
    VBox vBox = new VBox(5);
    vBox.getChildren().addAll(hBox1,hBox4);//adding hbox1 and hbox4 which contains hbox2 and hbox3 inside vbox
    
    Scene scene = new Scene(vBox);//create scene
    primaryStage.setTitle("Radio Test");//set title
    primaryStage.setScene(scene);//set scene
    primaryStage.show();//showing scene
    
    //setting size of textfield
    tfColumnSize.setOnAction(e -> {//using a lambda here to change the width of the text field
    tfTextField.setPrefColumnCount(Integer.parseInt(tfColumnSize.getText()));
    });
    
    //adding actions to radio buttons
    rbLeft.setOnAction(e -> tfTextField.setAlignment(Pos.BASELINE_LEFT));//sets the alignment to the left on radio button select
    rbCenter.setOnAction(e -> tfTextField.setAlignment(Pos.BASELINE_CENTER));//sets the alignment to the center on radio button select
    rbRight.setOnAction(e -> tfTextField.setAlignment(Pos.BASELINE_RIGHT));//sets the alignment to the right on radio button select
    
    }
        public static void main(String[] args) {
        launch(args);
    }
    
}
