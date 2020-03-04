/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimatetictactoe.BLL.bot;

import java.util.List;
import java.util.Random;
import ultimatetictactoe.BLL.game.IGameState;
import ultimatetictactoe.BLL.move.IMove;

/**
 *
 * @author lumby
 */
public class Bot2 implements IBot{
    private static final String BOTNAME = "Hideyoshi";
    private IMove latmove;


    @Override
    public IMove doMove(IGameState state)
    {
        Random ran = new Random();
        List<IMove> possibleMoves = state.getField().getAvailableMoves();
        
        latmove = possibleMoves.get(ran.nextInt(possibleMoves.size()));
        return latmove;

        
    }

    @Override
    public IMove getLastMove() {
       return latmove;
    }

    @Override
    public String getBotName()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
