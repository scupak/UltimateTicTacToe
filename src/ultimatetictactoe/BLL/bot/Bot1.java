package ultimatetictactoe.BLL.bot;

import java.util.List;
import ultimatetictactoe.BLL.game.GameManager;
import ultimatetictactoe.BLL.game.IGameState;
import ultimatetictactoe.BLL.move.IMove;
import ultimatetictactoe.BLL.move.Move;

/**
 *
 * @author Zanaxdk
 * https://github.com/scupak/UltimateTicTacToe
 */
public class Bot1 implements IBot
{
    private static final String BOTNAME = "Vlad the (bagel) Inhaler";
    private IMove bestMove;
    

    @Override
    public IMove doMove(IGameState state)
    {
       int bestScore = -10000;
       
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if(board[i][j] == "-1")
                {
                    board[i][j] = state;
                    int score = minimax(board);
                    if(score > bestScore)
                    {
                        bestScore = score;
                        bestMove = new Move(i , j);
                        
                    
                }
            }   
        }
//        List<IMove> validMoves = state.getField().getAvailableMoves();
        
        
        return bestMove;
    }
    
}
