/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimatetictactoe.GUI.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

/**
 *
 * @author anton
 */
public class MainViewController implements Initializable {
    
    @FXML
    private Label label;
    private ChoiceBox<String> dropdownBot;
    private ObservableList<String> list;
    @FXML
    private ChoiceBox<String> dropdownBot1;
    @FXML
    private Button playButton;
    @FXML
    private ChoiceBox<?> dropdownBot2;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         ArrayList<String> categories = new ArrayList<>();
        list = FXCollections.observableArrayList(categories);
        
        
        list.add("player");
        list.add("AI");
        
        dropdownBot.setItems(list);
        dropdownBot1.setItems(list);
    }    

    @FXML
    private void handlePlayButtonAction(ActionEvent event)
    {
        
    }
    
}
