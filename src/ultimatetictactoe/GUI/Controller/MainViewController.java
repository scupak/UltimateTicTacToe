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
import ultimatetictactoe.BLL.bot.IBot;
import ultimatetictactoe.BLL.bot.Bot2;

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
    
    private IBot bot1;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         ArrayList<String> categories = new ArrayList<>();
        list = FXCollections.observableArrayList(categories);
        
        
        list.add("human");
        list.add("Vlad The Inhaler");
        list.add("Hideyoshi");
        
        dropdownLeft.setItems(list);
        dropdownRight.setItems(list);
    }    

    @FXML
    private void handlePlayButtonAction(ActionEvent event) throws IOException
    {
         FXMLLoader fxLoader = new FXMLLoader(
                    getClass().getResource("/ultimatetictactoe/GUI/View/Board.fxml"));
         
            Parent root = fxLoader.load();
            BoardController controller = ((BoardController) fxLoader.getController() );
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            
            if (dropdownLeft.getSelectionModel().getSelectedItem().equals("human") && dropdownRight.getSelectionModel().getSelectedItem().equals("human")) {
                
                controller.setHeaderLabel("Human VS Human");
                controller.setGame();
            
        }
            else if(dropdownLeft.getSelectionModel().getSelectedItem().equals("human") && dropdownRight.getSelectionModel().getSelectedItem().equals("Vlad The Inhaler")){
                
                IBot bot = new Bot2();
                controller.setHeaderLabel("Human VS Vlad the Inhaler");
                controller.setGame(bot);
            
            
            
            
            }
            else if(dropdownLeft.getSelectionModel().getSelectedItem().equals("human") && dropdownRight.getSelectionModel().getSelectedItem().equals("Hideyoshi")){
                
                IBot bot = new Bot2();
                controller.setHeaderLabel("Human VS Hideyoshi");
                controller.setGame(bot);
            
            
            
            
            }
            
            stage.setResizable(false);
            stage.show(); 
            close();
        
    }
    
     private void close()
    {
         Stage stage = (Stage) playButton.getScene().getWindow();
         stage.close();
         
    }

    public String getDropdownLeft()
    {
        return dropdownLeft.getSelectionModel().getSelectedItem();
    }

    public String getDropdownRight()
    {
        return dropdownRight.getSelectionModel().getSelectedItem();
    }
     
     
}
