/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimatetictactoe.GUI.Controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javax.imageio.ImageIO;
import ultimatetictactoe.BLL.field.IField;
import ultimatetictactoe.BLL.game.GameManager;
import ultimatetictactoe.BLL.game.GameState;
import ultimatetictactoe.BLL.game.IGameState;
import ultimatetictactoe.BLL.move.Move;
import ultimatetictactoe.Be.Currentplayer;
import ultimatetictactoe.GUI.Model.BoardModel;

/**
 * FXML Controller class
 *
 * @author kacpe
 */
public class BoardController implements Initializable {

    @FXML
    private GridPane MacroBoard;
    private TilePane[][] TilePanes = new TilePane[3][3];
    private ArrayList<UTTTButton> buttons;

    BoardModel model;
    IGameState gameState;
    @FXML
    private Label HeaderLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttons = new ArrayList();
        gameState = new GameState();
        model = new BoardModel(gameState);
        createCells();
        updateBoard();

    }

    private void Buttonclik(MouseEvent event) {
        
         int currentPlayer = model.getGm().getCurrentPlayer();

        UTTTButton b = (UTTTButton) event.getSource();

        boolean isSucces = model.getGm().updateGame(b.getMove());

        if (isSucces) {

            if (gameState.getMoveNumber() % 2 == 0) {
                b.setText("X");
            } else {
                b.setText("O");
            }

            updateBoard();
            checkAndLockIfGameEnd(currentPlayer);
            System.out.println(b.getMove());

        }

    }
    
    private void checkAndLockIfGameEnd(int currentPlayer) {
        if (model.getGm().getGameOver() != GameManager.GameOverState.Active) {
            String[][] macroboard = model.getGm().getCurrentState().getField().getMacroboard();
            // Lock game
            for (int i = 0; i < 3; i++) {
                for (int k = 0; k < 3; k++) {
                    if (macroboard[i][k].equals(IField.AVAILABLE_FIELD)) {
                        macroboard[i][k] = IField.EMPTY_FIELD;
                    }
                }
            }
            if (model.getGm().getGameOver().equals(GameManager.GameOverState.Tie)) {
                
                /*TODO add text for tie*/
            }
            else {
                 /*TODO add text for the player that has won*/
            }
        }
    }

    private void createCells() {
        ArrayList<TilePane> panes = new ArrayList<>();

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {

                TilePanes[x][y] = new TilePane();
               

                TilePanes[x][y].getStyleClass().add("TileBlack");

                createMicroboard(x, y);
                MacroBoard.add(TilePanes[x][y], x, y);
                

            }
        }
        /*
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                
                UTTTButton btn = new UTTTButton();
                btn.setPrefSize(65, 65);
                btn.setMove(new Move(x, y));
                btn.setOnMouseClicked(event -> {

                    Buttonclik(event);

                });
              
                tpane.getChildren().add(btn);
         */

    }

    private void createMicroboard(int microboardX, int microboardY) {

        // board (9x9) coordinates for the first button in given microboard (top left)
        int buttonX = microboardX * 3;
        int buttonY = microboardY * 3;

        // create the microboards 9 buttons
        for (int y = buttonY; y < buttonY + 3; y++) {
            for (int x = buttonX; x < buttonX + 3; x++) {

                UTTTButton btn = new UTTTButton();
                btn.setPrefSize(64, 64);
                btn.setMove(new Move(x, y));
                btn.setOnMouseClicked(event -> {

                    Buttonclik(event);

                });
                TilePanes[microboardX][microboardY].getChildren().add(btn);
            }

        }
    }

    private void updateBoard() {
        highlightActiveMicroboards();
    }

    private void highlightActiveMicroboards() {
        String[][] macroBoard = gameState.getField().getMacroboard();

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {

                if (macroBoard[x][y].equals(IField.AVAILABLE_FIELD)) {
                    TilePanes[x][y].getStyleClass().add("TileRed");
                    //System.out.println("TilePane[" + x + "][" + y + "] is active");
                } else {
                    TilePanes[x][y].getStyleClass().clear();
                    //System.out.println("TilePane[" + x + "][" + y + "] is not");
                }

            }

        }
    }
}
