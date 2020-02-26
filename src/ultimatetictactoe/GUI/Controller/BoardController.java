/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimatetictactoe.GUI.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;

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
    private Button TileOneThreeMicroboardOneThree;
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
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    


    @FXML
    private void HandleClickTileOneThreeMicroboardOneThree(ActionEvent event)
    {
       
    }
    
}
