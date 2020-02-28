/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimatetictactoe.GUI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author anton
 */
public class MainViewController implements Initializable {
    
    private ObservableList<String> list;
    @FXML
    private Button playButton;
    @FXML
    private ChoiceBox<String> dropdownLeft;
    @FXML
    private ChoiceBox<String> dropdownRight;
    @FXML
    private Label label;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         ArrayList<String> categories = new ArrayList<>();
        list = FXCollections.observableArrayList(categories);
        
        
        list.add("player");
        list.add("Bot1");
        list.add("Bot2");
        
        dropdownLeft.setItems(list);
        dropdownRight.setItems(list);
    }    

    @FXML
    private void handlePlayButtonAction(ActionEvent event) throws IOException
    {
            Parent root = FXMLLoader.load(getClass().getResource("/ultimatetictactoe/GUI/View/Board.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show(); 
            close();
        
    }
    
     private void close()
    {
         Stage stage = (Stage) playButton.getScene().getWindow();
         stage.close();
         
    }
}
