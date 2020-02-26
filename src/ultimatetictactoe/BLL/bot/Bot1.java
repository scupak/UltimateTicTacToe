package ultimatetictactoe.BLL.bot;

import java.util.List;
import ultimatetictactoe.BLL.game.IGameState;
import ultimatetictactoe.BLL.move.IMove;

/**
 *
 * @author Zanaxdk
 * https://github.com/scupak/UltimateTicTacToe
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
