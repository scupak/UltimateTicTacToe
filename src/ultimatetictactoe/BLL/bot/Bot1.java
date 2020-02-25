/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimatetictactoe.BLL.bot;

import java.util.List;
import ultimatetictactoe.BLL.game.IGameState;
import ultimatetictactoe.BLL.move.IMove;

/**
 *
 * @author Zanaxdk
 */
public class Bot1 implements IBot
{
    private static final String BOTNAME = "Vlad the Inhaler";

    @Override
    public IMove doMove(IGameState state)
    {
        List<IMove> validMoves = state.getField().getAvailableMoves();
        return validMoves.get(0);
    }
    
}
