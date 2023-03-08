/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package pkg16.pkg13.compareloans;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
/**
 *
 * @author Garin McCullick
 */
public class CompareLoans extends Application {
     TextField loanCost = new TextField();//creating my textfields
     TextField years = new TextField();
     TextArea textArea = new TextArea();

    @Override
    public void start(Stage primaryStage) {
	years.setPrefColumnCount(2);//setting the column count for years textfield
	loanCost.setPrefColumnCount(7);//setting the column count for loanCost textfield
	textArea.setPrefColumnCount(30);//setting the column count for textArea textfield
	Button btShow = new Button("Show Table");//Creating my "submit" button
	HBox paneForControls = new HBox(10);//creating an Hbox
	paneForControls.setAlignment(Pos.CENTER);//aligning my Hbox
	paneForControls.getChildren().addAll(new Label("Loan Amount"), loanCost, new Label("Number of Years"), years, btShow);//adding labels to my Hbox
	BorderPane pane = new BorderPane();//creating a pane
	pane.setTop(paneForControls);//aligning pane to the top
	pane.setCenter(textArea);//centering pane
	btShow.setOnAction(e -> {//setting an action to do this math when I click btShow button.
          double interestRate;//interest rate variable
          double monthlyPayment;//monthlyPayment variable	
          String output = "Interest Rate       Monthly Payment          Total Payment\n";//creating a string for output headings (3 columns)	
          for (double i = 5.0; i <= 8; i += 0.125) {//for loop starts at 5 goes to 8 increasing at a rate of 0.125 each time
              interestRate = i / 1200;//whatever I is starting from 5 dividing that by 1200 for the monthly interest this is the same as 0.05 * 12
              monthlyPayment = Double.parseDouble(loanCost.getText()) * interestRate / (1 - 1 / Math.pow(1 + interestRate, Double.parseDouble(years.getText()) * 12));//calculating monthly payment. parseDouble converts the loanCost and years to double values. math.pow is a method that returns a value raised to the power of a value that you can pass in as a parameter in this case 1.
              output += String.format("%-24.3f%-34.2f%-8.2f\n", i, monthlyPayment, (monthlyPayment * 12) * Double.parseDouble(years.getText()));//the += sign here allows me to append the output string with the formatted results.
        }
        textArea.setText(output);//setting the output to the text area
	});
	Scene scene = new Scene(pane);//creating the scene
	primaryStage.setTitle("Exercise16-13");//setting the title
	primaryStage.setScene(scene);//setting the scene
	primaryStage.show();   //displaying
    }
 
    public static void main(String[] args) {
        Application.launch(args);
    } 
}
