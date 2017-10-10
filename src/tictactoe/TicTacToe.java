/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import static javafx.scene.input.MouseEvent.MOUSE_RELEASED;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author paari
 */

public class TicTacToe extends Application {
    int count = 0;
    Board board=new Board();
    Stage newStage;
    @Override
    public void start(Stage primaryStage) {
        newStage=primaryStage;
        createBoard(primaryStage);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
        EventHandler<MouseEvent> circleOnMousePressedEventHandler = 
        new EventHandler<MouseEvent>() {
 
        @Override
        public void handle(MouseEvent t) {
            int col=(int)t.getSceneX()/300;
            int row=(int)t.getSceneY()/300;
            if(board.getValue(col, row)==-1&&count%2==0){
                board.addX(col, row);
                count++;
                createBoard(newStage);
            }
            else if(board.getValue(col, row)==-1&&count%2==1){
                board.addO(col, row);
                count++;
                createBoard(newStage);
            }
            else{
                
            }
            if(board.Owins()){
                gameOver(newStage, "Player 2 wins!");
            }
            else if(board.Xwins()){
                gameOver(newStage, "Player 1 wins!");
            }
            else if(board.gameIsDone()){
                gameOver(newStage, "Nobody wins!");
            }
        }
    };
     


    public void createBoard(Stage stage) {
        
        GridPane root = new GridPane();
        GridPane.setConstraints(root,3,3);
        
        

        Image x = new Image("X.png", 100, 100, false, false);
        Image o = new Image("O.png", 100, 100, false, false);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Rectangle r = new Rectangle(j * 300, i * 300, 300, 300);
                if ((i + j) % 2 == 0) {
                    r.setFill(Color.BLACK);
                } else {
                    r.setFill(Color.WHITE);
                }
                r.setOnMousePressed(circleOnMousePressedEventHandler);                
                root.add(r,i,j);

            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (board.getValue(i, j)) {
                    case 0:
                        ImageView oView = new ImageView();
                        oView.setImage(o);
                        oView.setX(i * 100);
                        oView.setY(j * 100);
                        oView.setFitHeight(300);
                        oView.setFitWidth(300);
                        oView.setPreserveRatio(true);
                        GridPane.setConstraints(oView, i, j);
                        root.getChildren().add(oView);
                        break;
                    case 1:
                        ImageView xView = new ImageView();
                        xView.setImage(x);
                        xView.setX(i * 100);
                        xView.setY(j * 100);
                        xView.setFitHeight(300);
                        xView.setFitWidth(300);
                        xView.setPreserveRatio(true);
                        GridPane.setConstraints(xView, i, j);
                        root.getChildren().add(xView);
                        break;
                    default:
                        break;
                }

            }
        }
        stage.setResizable(false);
        
        Scene scene = new Scene(root, 900, 900);
        
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.show();
    }
    
    public void gameOver(Stage stage, String s){
        StackPane root = new StackPane();
        Button b = new Button();
        b.setLayoutY(700);
        b.setText("Click here to play again");
        Text t = new Text();
        t.setX(200);
        t.setText(s);
        t.setFont(new Font(20));
        root.getChildren().add(b);
        root.getChildren().add(t);
        
        stage.setResizable(false);
        
        Scene scene = new Scene(root, 900, 900);
        
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.show();        
    }

}
