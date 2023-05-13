import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;

//Garin McCullick

public class BlackJack extends Application {

    private final ArrayList<Integer> deck = new ArrayList<>(52); //making an array list for the deck with 52 cards.
    private final ArrayList<Integer> playerCards = new ArrayList<>();//player cards arraylist.
    private final ArrayList<Integer> dealerCards = new ArrayList<>();//dealer cards arraylist.
    private int playerScore = 0;//starting player score (total of both cards)
    private int dealerScore = 0;//starting dealer score (total of both cards)
    private boolean gameOver = false;//starting game over variable
    private int gamesWon = 0;//starting games won at 0
    private int gamesLost = 0;//starting games lost at 0

    private final Label playerScoreLabel = new Label("Player Score: 0");//creating player score label
    private final Label dealerScoreLabel = new Label("Dealer Score: 0");//creating dealer score label
    private final Label resultLabel = new Label("");//creating result label(who wins)

    private final VBox playerCardsBox = new VBox(10);//vbox for player cards
    private final VBox dealerCardsBox = new VBox(10);//vbox for dealer cards
    
    private final Label gamesWonLabel = new Label("Games won: 0");//games won label
    private final Label gamesLostLabel = new Label("Games lost: 0");//games lost label

    private final Button hitButton = new Button("Hit");//creating hit button
    private final Button standButton = new Button("Stand");//creating stand button
    private final Button resetButton = new Button("Reset");//creating reset button which will shuffle cards

    @Override
    public void start(Stage primaryStage) {
        // creating the deck of cards A is 1 so start at 2 add face cards after.
        for (int i = 2; i <= 10; i++) {
            deck.add(i);//do this four times to account for 4 diff suites
            deck.add(i);
            deck.add(i);
            deck.add(i);
        }
        deck.add(10);//adding in face cards and aces. 4 for each suites again.
        deck.add(10);
        deck.add(10);
        deck.add(10);
        deck.add(11);
        deck.add(11);
        deck.add(11);
        deck.add(11);
        Collections.shuffle(deck);//shuffling the deck

        // Set the actions for the buttons
        hitButton.setOnAction(e -> {//action handler for hit
            hit();
        });
        standButton.setOnAction(e -> {//action handler for stand
            stand();
        });
        resetButton.setOnAction(e -> {//action handler for reset
            resetGame();
        });

       
        HBox buttonBox = new HBox(10, hitButton, standButton, resetButton); // Add buttons to our buttonbox
        buttonBox.setAlignment(Pos.CENTER);//align buttons center

        
        VBox root = new VBox(20, dealerCardsBox, dealerScoreLabel, playerCardsBox, playerScoreLabel,resultLabel,gamesWonLabel, gamesLostLabel,  buttonBox);// adding the button box to the root pane
        root.setAlignment(Pos.CENTER);//aligning center
        root.setPadding(new Insets(20));//adding some padding

        // add scene and stage
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Blackjack");
        primaryStage.show();

        // deal() deals the initial cards
        deal();
    }

    private void deal() {
        playerCards.add(drawCard());//gives player first card
        dealerCards.add(drawCard());//same for dealer
        playerCards.add(drawCard());//gives player second card
        dealerCards.add(drawCard());//same for dealer

        updateScore();//update the score or the total of both cards
        updateCards();//updating the UI for both players cards
    }

    
    
    private Integer drawCard() {
    if (deck.isEmpty()) {//checking if the deck is empty if so return null
        return null;
    }
    Integer card = deck.get(0);//getting first card in the deck (index 0)
    deck.remove(0);//removing first card from deck
    return card;//return card
}

    private void hit() {
        if (!gameOver) {//if game is not over
            playerCards.add(drawCard());//add the card returned from drawCard()
            updateScore();//update the new score
            updateCards();//update the cards UI
            checkGameOver();//check if game is over
        }
    }

private void stand() {
    if (!gameOver) {//if game is not over
        while (dealerScore < 17) {//as long as the dealer is below 17
            dealerCards.add(drawCard());//add card from drawCard
            updateScore();//update the score
            updateCards();//update the cards UI
        }
        checkGameOver();//check if game is over
    }
}

    private void updateScore() {//update score
    playerScore = calculateScore(playerCards);//adding up players score
    playerScoreLabel.setText("Player: " + playerScore);//getting total and displaying it through playerscorelabel

    if (gameOver) {
        return;//if game is over just return or exit
    }

    dealerScore = calculateScore(dealerCards); // adding up dealers score
    dealerScoreLabel.setText("Dealer: " + dealerScore); // getting total and displaying it through dealerscorelabel

    if (dealerScore >= 17) { // if dealer is at or over 17 check if game is over
        checkGameOver();
    }
}

private boolean gameWonAdded = false;//tracking Games won and lost. if true in any of the win conditions it will not add but if it is false it will flip true and add 1.
private boolean gameLostAdded = false;

private void checkGameOver() {//win/loss rules
    gameOver = false;//setting game over to false to go through if statement rules.
    //im only doing first if statment as an example just continue the logic down in the following if statments nothing fancy its pretty much the same on every statement just with different conditions.
    if (playerScore > 21) {//condition
        gameOver = true;//set game over
        resultLabel.setText("Player busts. Dealer wins.");//update text
        if (!gameLostAdded) {//a nested condition to count the game as a win or loss. if gamelost not added then execute if statement...
            gamesLost++;//add gameslost/won
            gameLostAdded = true;//flip boolean to true
        }
    } else if (playerScore == dealerScore) {
        gameOver = true;
        resultLabel.setText("It's a tie!");
    } else if (playerScore == 21) {
        gameOver = true;
        resultLabel.setText("Player wins.");
        if (!gameWonAdded) {
            gamesWon++;
            gameWonAdded = true;
        }
    } else if (dealerScore > 21) {
        gameOver = true;
        resultLabel.setText("Dealer busts. Player wins.");
        if (!gameWonAdded) {
            gamesWon++;
            gameWonAdded = true;
        }
    } else if (gameOver || playerCards.size() == 5) {
        gameOver = true;
        if (playerScore > dealerScore) {
            resultLabel.setText("Player wins!");
            if (!gameWonAdded) {
                gamesWon++;
                gameWonAdded = true;
            }
        } else if (dealerScore > playerScore) {
            resultLabel.setText("Dealer wins!");
            if (!gameLostAdded) {
                gamesLost++;
                gameLostAdded = true;
            }
        } else {
            resultLabel.setText("It's a tie!");
        }
    }
    gamesWonLabel.setText("Games Won: " + gamesWon);//display games won
    gamesLostLabel.setText("Games lost: " + gamesLost);//display games lost
}

private void updateCards() {//updating cards
    playerCardsBox.getChildren().clear();//clear the playerCards box
    for (int card : playerCards) { //foreach loop going over each players cards
        playerCardsBox.getChildren().add(new Label(cardToString(card)));//and assigning it card value
    }

    dealerCardsBox.getChildren().clear();//clear the dealerCards box
    for (int i = 0; i < dealerCards.size(); i++) { //for loop counting the size of dealers cards box (# of cards)
        if (i == 0 && !gameOver) {//checking if its first card and if game is not over
            dealerCardsBox.getChildren().add(new Label("??"));//hiding the first card value from the player
        } else {
            Integer cardValue = dealerCards.get(i);//getting card value and assinging it to cardvalue
            if (cardValue != null) {//if its not null
                dealerCardsBox.getChildren().add(new Label(cardToString(cardValue)));//displaying the cards value
            }
        }
    }
}

private int calculateScore(ArrayList<Integer> cards) {//calculating the score of players/dealers hand takes an arraylist of integers (cards) as an argument
    int score = 0;//setting score to 0
    int numAces = 0;//setting number of aces to 0

    for (int card : cards) {//going through each card in the arraylist passed in
        if (card == 11) {//checking for aces
            numAces++;//if there is ace add 1 to numAces
        }
        score += Math.min(card, 10);//adding the value of the card to the score with 10 as the max (face cards)
    }

    while (numAces > 0 && score + 10 <= 21) {//this loop deals with the aces. if aces > 0 and score +10 <= 21
        score += 10;//add 10 to score aces can be 1 or 11
        numAces--;//after adding 10 one ace is removed in case of multiple aces
    }

    return score;//return the score
}

private String cardToString(int card) {//passing in card (integer)and turning it into a string
        return switch (card) {//switch statement
            case 2, 3, 4, 5, 6, 7, 8, 9, 10 -> Integer.toString(card);//2-10 get put into .toString method
            case 11 -> "A";//face cards get assigned a letter
            case 12 -> "K";
            case 13 -> "Q";
            case 14 -> "J";
            default -> "";
        };
}

private void resetGame() {//this will reset the game (effectivly shuffleing the deck)
    deck.clear();//clears deck
    playerCards.clear();//clears playercards
    dealerCards.clear();//clears dealercards
    playerScore = 0;//sets player score to 0
    dealerScore = 0;//sets dealer score to 0
    gameOver = false;//setting game over to false
    gameLostAdded = false;//setting games lost added to false
    gameWonAdded = false;//setting games won added to false
    resultLabel.setText("");//clearing our result label

    // recreating the deck of cards
    for (int i = 2; i <= 14; i++) {//2-14
        deck.add(i);//adding 4x to acc for suites
        deck.add(i);
        deck.add(i);
        deck.add(i);
    }
    Collections.shuffle(deck);//shuffle the deck on reset

    
    deal();// deals the initial cards
}

public static void main(String[] args) {
    launch(args);
}
}
