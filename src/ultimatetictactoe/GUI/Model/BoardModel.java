/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimatetictactoe.GUI.Model;
import ultimatetictactoe.Be.Currentplayer;

/**
 *
 * @author anton
 */
public class BoardModel {
  
   private Currentplayer currentplayer;

    public BoardModel() {
        
        currentplayer = Currentplayer.player_O;
    }

    public Currentplayer getCurrentplayer() {
        return currentplayer;
    }

    public void setCurrentplayer(Currentplayer currentplayer) {
        this.currentplayer = currentplayer;
    }
    
    
    
}
