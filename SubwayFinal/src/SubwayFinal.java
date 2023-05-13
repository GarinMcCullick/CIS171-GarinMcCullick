//Garin McCullick
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SubwayFinal extends Application {

    @Override
    public void start(Stage primaryStage) {
        // UI elements
        //size
        ComboBox<String> sizeComboBox = new ComboBox<>();//creating a new combobox for size
        sizeComboBox.getItems().addAll("6-inch", "Footlong");//adding 2 items to combobox via the addAll method and getItems() gets all the items in the combobox
        sizeComboBox.setValue("6-inch");//setting default value
        
        //bread
        ComboBox<String> breadComboBox = new ComboBox<>();//creating a new combobox for bread
        breadComboBox.getItems().addAll("White", "Wheat", "Italian");
        breadComboBox.setValue("White");

        //meat
        ComboBox<String> meatComboBox = new ComboBox<>();//creating a new combobox for meat
        meatComboBox.getItems().addAll("Ham", "Turkey", "Chicken");
        meatComboBox.setValue("Ham");

        //cheese
        ComboBox<String> cheeseComboBox = new ComboBox<>();//creating a new combobox for cheese
        cheeseComboBox.getItems().addAll("American", "Cheddar", "Provolone");
        cheeseComboBox.setValue("American");

        //vegies
        TextField veggiesTextField = new TextField();//made a textfield for veggies just to change it up.

        //sauce
        ComboBox<String> sauceComboBox = new ComboBox<>();//creating a new combobox for sauce
        sauceComboBox.getItems().addAll("Mayonnaise", "Mustard", "Ketchup");
        sauceComboBox.setValue("Mayonnaise");

        //salt and pepper
        CheckBox saltPepperCheckBox = new CheckBox("Salt & Pepper");

        //order button
        Button orderButton = new Button("Order");
        orderButton.setOnAction(event -> {//event handler
            // on event send message
            String summary = String.format("Size: %s%nBread: %s%nMeat: %s%nCheese: %s%nVeggies: %s%nSauce: %s%nSalt & Pepper: %s",//listing out labels and getting values
                    sizeComboBox.getValue(), breadComboBox.getValue(), meatComboBox.getValue(), cheeseComboBox.getValue(),
                    veggiesTextField.getText(), sauceComboBox.getValue(), saltPepperCheckBox.isSelected() ? "Yes" : "No");

            // displaying message in an alert
            Alert summaryDialog = new Alert(Alert.AlertType.INFORMATION, summary, ButtonType.OK);//adding alert type, summary, and button
            summaryDialog.setHeaderText("Order Summary");//alert title
            summaryDialog.showAndWait();//show and wait method displays a new stage and waits for user to close it.
        });

        // Setting up the layout with gridpane
        GridPane layout = new GridPane();//new gridpane
        layout.setPadding(new Insets(10));//setting padding
        layout.setVgap(10);//verticle gap in the gridpane
        layout.setHgap(10);//horizontal gap in the gridpane
        //adding rows with labels and values to the layout
        layout.addRow(0, new Label("Size:"), sizeComboBox);
        layout.addRow(1, new Label("Bread:"), breadComboBox);
        layout.addRow(2, new Label("Meat:"), meatComboBox);
        layout.addRow(3, new Label("Cheese:"), cheeseComboBox);
        layout.addRow(4, new Label("Veggies:"), veggiesTextField);
        layout.addRow(5, new Label("Sauce:"), sauceComboBox);
        layout.addRow(6, saltPepperCheckBox);
        layout.addRow(7, orderButton);

        // creating stage
        primaryStage.setScene(new Scene(layout));
        primaryStage.setTitle("Your Sub Order");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
