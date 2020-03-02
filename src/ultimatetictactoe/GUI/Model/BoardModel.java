/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimatetictactoe.GUI.Model;
import ultimatetictactoe.BLL.bot.IBot;
import ultimatetictactoe.BLL.game.GameManager;
import ultimatetictactoe.BLL.game.IGameState;
import ultimatetictactoe.Be.Currentplayer;

/**
 *
 * @author anton
 */
public class BoardModel {
   private GameManager gm;

    public BoardModel(IGameState gameState) {
        
        gm = new GameManager(gameState);
        
        
    }
    
    public BoardModel(IGameState gameState, IBot bot1) {
        
        gm = new GameManager(gameState ,bot1);
        
        
    }

    public Currentplayer getCurrentplayer() {
        return gm.getCurrentPlayer() == 0 ? Currentplayer.player_X: Currentplayer.player_O;
    }

    public GameManager getGm() {
        return gm;
    }

    

    
    
    
    
}
