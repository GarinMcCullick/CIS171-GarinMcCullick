/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package pkg24.pkg7animatedlinkedlists;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LinkedListSearch extends Application {

    private Node head;//first node (head)

    private static class Node {//static node class defining structure of each node in the list
        int data;//each node contains an int data.
        Node next;//this points to the next node which will be null if there is not another value in the list.

        Node(int data) {//this is a constructor for the node passing in int data this is called when a new node is created.
            this.data = data;//when data is passed in this.data=data sets the old data to data for the new node instance.
        }
    }

    public void addNode(int data){//this method adds a new node to the beginning of the linked list with the data value passed in.
        if (this.head == null) {//checks if the head is null if so it means the list is empty
            this.head = new Node(data);//if the list is empty it adds data to the new node
        } else { //if the list is not empty im making a new node setting the data passed in and setting the head to next
            Node newNode = new Node(data);
            newNode.next = this.head;
            this.head = newNode;
        }
    }

    public boolean contains(int data) { //here I am checking to see if there is a node with the correct data value to what im searching for
        Node curr = this.head;//setting curr to the head of the node
        while (curr != null) { //this while loop iterates through each node setting curr to the head until the end where it becomes null
            if (curr.data == data) { //if curr data = value im looking for it returns true
                return true;
            }
            curr = curr.next;//this sets the next node to curr
        }
        return false;//if curr is = null (at the end of the list)or there is no value that im looking for it will return false
    }

    public boolean deleteNode(int data) { //delete node function this will delete the first ocurance of a value in a list ex: delete 1 = 1 -> 1 -> 1 it will only delete 1 of the three 1 values returning 1->1
        if (this.head == null) { //if the list is empty returns false
            return false;
        }
        if (this.head.data == data) { //if the first head.data = the value i want to delete it will update the head to point to the next node since we are deleting that one
            this.head = this.head.next;//pointing to next head
            return true;//retuning true signaling delete success
        }
        Node prev = this.head;//prev is set to the current head to go to the next node which becomes curr
        Node curr = prev.next;
        while (curr != null) { //this while loop checks if the curr node has the value to delete
            if (curr.data == data) { //if current node has the right value
                prev.next = curr.next;//we set the last node to the next node removing the current node we are on with the value to delete.
                return true;//returning true to signal delete success.
            }
            prev = curr;//at the end of the list updating the prev node to the current node
            curr = curr.next;
        }
        return false;//and returing false if no value was deleted
    }

    public String printList() { //print list function goes through list starting at the fist node and turns the ints in the list to strings and then prints the list with -> to show connected nodes.
        StringBuilder sb = new StringBuilder();//StringBuider is a class in java and "builds" strings 
        Node curr = this.head; //setting node head as curr
        while (curr != null) { //while looping through the list as long as curr isnt null
            sb.append(curr.data);//using append to "append" the current data to string format with StringBuilder or sb
            if (curr.next != null) { //this is adding an arrow -> to show the node connections in the list. as long as next node isnt null
                sb.append(" -> ");
            }
            curr = curr.next;//changes the curr to the next node at end of list
        }
        return sb.toString();//returning a string from the sb object
    }

    // GUI section it's just the buttons and elements and stuff we've gone over.
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);

        Label prompt = new Label("Enter a number to add to the linked list:");
        TextField input = new TextField();
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> { //my add button onaction event handler with try and catch
            try {
                int data = Integer.parseInt(input.getText());
                this.addNode(data);
                input.clear();
            } catch (NumberFormatException ex) { 
            }
        });

        Label searchPrompt = new Label("Enter a number to search for:");
        TextField searchInput = new TextField();
        Button searchButton = new Button("Search");
        Label searchResult = new Label();
        searchButton.setOnAction(e -> {//my search button onaction event handler with try and catch
            try {
                int data = Integer.parseInt(searchInput.getText());
                if (this.contains(data)) {
                    searchResult.setText(data + " found");
                } else {
                    searchResult.setText(data + " not found");
                }
            } catch (NumberFormatException ex) {
            }
        });

        Label deletePrompt = new Label("Enter a number to delete:");
        TextField deleteInput = new TextField();
        Button deleteButton = new Button("Delete");
        Label deleteResult = new Label();
        deleteButton.setOnAction(e -> { //my delete button onaction event handler with try and catch
            try {
                int data = Integer.parseInt(deleteInput.getText());
                if (this.deleteNode(data)) {
                    deleteResult.setText(data + " deleted");//showing value that was deleted
                } else {
                    deleteResult.setText(data + " not found");//showing data that wasnt found ie couldnt be deleted
                }
            } catch (NumberFormatException ex) {
            }
        });
        Button printButton = new Button("Print list / update");
        Label listContents = new Label();
        printButton.setOnAction(e -> { //my print list / update list button onaction event handler
            listContents.setText(this.printList());//printing the list 
        });

        root.getChildren().addAll( //using root.getChildren to output my elements
                searchPrompt, searchInput, searchButton, searchResult,
                prompt, input, addButton,
                deletePrompt, deleteInput, deleteButton, deleteResult,
                printButton, listContents
        );

        Scene scene = new Scene(root, 400, 500);
        primaryStage.setTitle("Linked List");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}