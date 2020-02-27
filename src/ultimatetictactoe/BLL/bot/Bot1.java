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
 * 
 * 
 */ /*
public class Bot1 implements IBot
{
   
}
    private static final String BOTNAME = "Vlad the (bagel) Inhaler";
    private IMove bestMove;
    private String[][] simulationBoard;
    

    @Override
    public IMove doMove(IGameState state)
    {
        simulationBoard = new String[3][3];
        
        
        for (int x = 0; x < state.getField().getBoard().length; x++) {
           
            for (int y = 0; y < state.getField().getBoard()[0].length; y++) {
           
            
            
        }
            
        }
        
        int bestScore = -10000;
       
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if(state.getField().getBoard()[i][j] == "-1")
                {
                    state.getField().getBoard()[i][j] = state; //AI
                    int score = minimax(board, 0, true);
                    board[i][j] = "-1";
                    if(score > bestScore)
                    {
                        bestScore = score;
                        bestMove = new Move(i , j);
                        
                    }
                    
                }
            }  
            
        }
        board[bestMove.i][bestMove.j] = state;
        currentplayer = state; //human
//        List<IMove> validMoves = state.getField().getAvailableMoves();
        
        
        return bestMove;
    }
    
    int[] scores ={
    int X = 1;
    int O = -1
    int Tie = 0;
    }
    
    public int minmax(board, int depth, boolean isMaximizing){
    result  = checkWinner();
    if(result != null){
    int score = scores[result];
    return score;

    }
    if(isMaximizing){
        int bestScore = -10000;
        for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            if(board[i][j] == "-1") {
                board[i][j] = state; //AI
                score = minimax(board, depth +1, false);
                board[i][j] = "-1";
                if(score > bestScore) {
                bestScore = score;
                }
                }
            }
        }
        return bestScore;       

    }
    else{
     int bestScore = 10000;
        for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
            if(board[i][j] == "-1") {
                board[i][j] = state; //Human
                score = minimax(board, depth +1, true);
                board[i][j] = "-1";
                if(score > bestScore) {
                bestScore = score;
    }
}
}
}
return bestScore;
}
    
}
*/