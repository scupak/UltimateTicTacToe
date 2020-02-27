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
    
    

    private AnchorPane MacroBoard;
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
