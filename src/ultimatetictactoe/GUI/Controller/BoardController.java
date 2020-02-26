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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javax.imageio.ImageIO;
import ultimatetictactoe.Be.Currentplayer;
import ultimatetictactoe.GUI.Model.BoardModel;

/**
 * FXML Controller class
 *
 * @author kacpe
 */
public class BoardController implements Initializable
{
    
    

    @FXML
    private AnchorPane MacroBoard;
    @FXML
    private AnchorPane MicroboardOneThree;
    @FXML
    private AnchorPane TileOneOneMicroboardOneThree;        
    @FXML
    private AnchorPane TileOneThreeMicroboardOneThree;
    @FXML
    private AnchorPane TileOneTwoMicroboardOneThree;
    @FXML
    private AnchorPane TileTwoOneMicroboardOneThree;
    @FXML
    private AnchorPane TileThreeTwoMicroboardOneThree;
    @FXML
    private AnchorPane TileTwoThreeMicroboardOneThree;
    @FXML
    private AnchorPane TileThreeThreeMicroboardOneThree;
    @FXML
    private AnchorPane TileTwoTwoMicroboardOneThree;
    @FXML
    private AnchorPane TileThreeOneMicroboardOneThree;
    @FXML
    private AnchorPane MicroboardTwoThree;
    @FXML
    private AnchorPane TileOneOneMicroboardTwoThree;
    @FXML
    private AnchorPane TileOneThreeMicroboardTwoThree;
    @FXML
    private AnchorPane TileOneTwoMicroboardTwoThree;
    @FXML
    private AnchorPane TileTwoOneMicroboardOneThree2;
    @FXML
    private AnchorPane TileThreeTwoMicroboardTwoThree;
    @FXML
    private AnchorPane TileTwoThreeMicroboardTwoThree;
    @FXML
    private AnchorPane TileThreeThreeMicroboardTwoThree;
    @FXML
    private AnchorPane TileTwoTwoMicroboardTwoThree;
    @FXML
    private AnchorPane TileThreeOneMicroboardTwoThree;
    @FXML
    private AnchorPane MicroboardThreeThree;
    @FXML
    private AnchorPane TileOneOneMicroboardThreeThree;
    @FXML
    private AnchorPane TileOneThreeMicroboardThreeThree;
    @FXML
    private AnchorPane TileOneTwoMicroboardThreeThree;
    @FXML
    private AnchorPane TileTwoOneMicroboardThreeThree;
    @FXML
    private AnchorPane TileThreeTwoMicroboardThreeThree;
    @FXML
    private AnchorPane TileTwoThreeMicroboardThreeThree;
    @FXML
    private AnchorPane TileThreeThreeMicroboardThreeThree;
    @FXML
    private AnchorPane TileTwoTwoMicroboardThreeThree;
    @FXML
    private AnchorPane TileThreeOneMicroboardThreeThree;
    @FXML
    private AnchorPane MicroboardOneTwo;
    @FXML
    private AnchorPane TileOneOneMicroboardOneTwo;
    @FXML
    private AnchorPane TileOneThreeMicroboardOneTwo;
    @FXML
    private AnchorPane TileOneTwoMicroboardOneTwo;
    @FXML
    private AnchorPane TileTwoOneMicroboardOneThree1;
    @FXML
    private AnchorPane TileThreeTwoMicroboardOneTwo;
    @FXML
    private AnchorPane TileTwoThreeMicroboardOneTwo;
    @FXML
    private AnchorPane TileThreeThreeMicroboardOneTwo;
    @FXML
    private AnchorPane TileTwoTwoMicroboardOneTwo;
    @FXML
    private AnchorPane TileThreeOneMicroboardOneTwo;
    @FXML
    private AnchorPane MicroboardTwoTwo;
    @FXML
    private AnchorPane TileOneOneMicroboardTwoTwo;
    @FXML
    private AnchorPane TileOneThreeMicroboardTwoTwo;
    @FXML
    private AnchorPane TileOneTwoMicroboardTwoTwo;
    @FXML
    private AnchorPane TileTwoOneMicroboardTwoTwo;
    @FXML
    private AnchorPane TileThreeTwoMicroboardTwoTwo;
    @FXML
    private AnchorPane TileTwoThreeMicroboardTwoTwo;
    @FXML
    private AnchorPane TileThreeThreeMicroboardTwoTwo;
    @FXML
    private AnchorPane TileTwoTwoMicroboardTwoTwo;
    @FXML
    private AnchorPane TileThreeOneMicroboardTwoTwo;
    @FXML
    private AnchorPane MicroboardThreeTwo;
    @FXML
    private AnchorPane TileOneOneMicroboardThreeTwo;
    @FXML
    private AnchorPane TileOneThreeMicroboardThreeTwo;
    @FXML
    private AnchorPane TileOneTwoMicroboardThreeTwo;
    @FXML
    private AnchorPane TileTwoOneMicroboardThreeTwo;
    @FXML
    private AnchorPane TileThreeTwoMicroboardThreeTwo;
    @FXML
    private AnchorPane TileTwoThreeMicroboardThreeTwo;
    @FXML
    private AnchorPane TileThreeThreeMicroboardThreeTwo;
    @FXML
    private AnchorPane TileTwoTwoMicroboardThreeTwo;
    @FXML
    private AnchorPane TileThreeOneMicroboardThreeTwo;
    @FXML
    private AnchorPane MicroboardOneOne;
    @FXML
    private AnchorPane TileOneOneMicroboardOneThree3;
    @FXML
    private AnchorPane TileOneThreeMicroboardOneOne;
    @FXML
    private AnchorPane TileOneTwoMicroboardOneOne;
    @FXML
    private AnchorPane TileTwoOneMicroboardOneOne;
    @FXML
    private AnchorPane TileThreeTwoMicroboardOneThree3;
    @FXML
    private AnchorPane TileTwoThreeMicroboardOneOne;
    @FXML
    private AnchorPane TileThreeThreeMicroboardOneOne;
    @FXML
    private AnchorPane TileTwoTwoMicroboardOneThree3;
    @FXML
    private AnchorPane TileThreeOneMicroboardOneOne;
    @FXML
    private AnchorPane MicroboardTwoOne;
    @FXML
    private AnchorPane TileOneOneMicroboardOneThree5;
    @FXML
    private AnchorPane TileOneThreeMicroboardTwoOne;
    @FXML
    private AnchorPane TileOneTwoMicroboardTwoOne;
    @FXML
    private AnchorPane TileTwoOneMicroboardTwoOne;
    @FXML
    private AnchorPane TileThreeTwoMicroboardOneThree5;
    @FXML
    private AnchorPane TileTwoThreeMicroboardTwoOne;
    @FXML
    private AnchorPane TileThreeThreeMicroboardTwoOne;
    @FXML
    private AnchorPane TileTwoTwoMicroboardOneThree5;
    @FXML
    private AnchorPane TileThreeOneMicroboardTwoOne;
    @FXML
    private AnchorPane MicroboardThreeOne;
    @FXML
    private AnchorPane TileOneOneMicroboardThreeOne;
    @FXML
    private AnchorPane TileOneThreeMicroboardThreeOne;
    @FXML
    private AnchorPane TileOneTwoMicroboardThreeOne;
    @FXML
    private AnchorPane TileTwoOneMicroboardThreeOne;
    @FXML
    private AnchorPane TileThreeTwoMicroboardThreeOne;
    @FXML
    private AnchorPane TileTwoThreeMicroboardThreeOne;
    @FXML
    private AnchorPane TileThreeThreeMicroboardThreeOne;
    @FXML
    private AnchorPane TileTwoTwoMicroboardThreeOne;
    @FXML
    private AnchorPane TileThreeOneMicroboardThreeOne;
    private ArrayList<AnchorPane> panes; 
    private ArrayList<AnchorPane> tiles;
    private Image o;
    private Image x;
    private Image currentMarkerImage;
    
    
     BoardModel model;

    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        model = new BoardModel();
        
       
        try {
           
            o = new Image(new FileInputStream("src/O.png"));
            x = new Image(new FileInputStream("src/X.png"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
      
      
        panes = new ArrayList<>();
        tiles = new ArrayList<>();
        
        for (Node node : MacroBoard.getChildren()) {
            
            if (node instanceof AnchorPane) 
                panes.add((AnchorPane)node);
                
            
            
            
        }
    
        for (AnchorPane pane : panes) {
            
            for(Node node : pane.getChildren()){
        
                if (node instanceof AnchorPane)
                    tiles.add((AnchorPane)node);
            }
           
    }
         
        
         for (AnchorPane tile : tiles) {
             
             tile.setOnMouseClicked(e -> Buttonclik(e));
             
             
              
    }


    }

    private void Buttonclik(MouseEvent e) {
        
        if (model.getCurrentplayer() == Currentplayer.player_O ) {
            
            currentMarkerImage = o;
            model.setCurrentplayer(Currentplayer.player_X);
            
        }
        else {
        
        
            currentMarkerImage = x;
            model.setCurrentplayer(Currentplayer.player_O);
        
        
        }
           
        
       
        
      AnchorPane a = (AnchorPane)e.getSource();
        a.setBackground(new Background(new BackgroundImage(currentMarkerImage , BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER, new BackgroundSize(0, 0, true, true, true, true))));
        System.out.println("fisk");
    }
    
    
}
