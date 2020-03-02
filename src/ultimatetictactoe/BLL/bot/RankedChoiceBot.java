/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimatetictactoe.BLL.bot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ultimatetictactoe.BLL.game.IGameState;
import ultimatetictactoe.BLL.move.IMove;
import ultimatetictactoe.BLL.move.Move;

/**
 *
 * @author kacpe
 */
public class RankedChoiceBot implements IBot
{
    private static final String BOTNAME = "Ranked choice bot";
    private IMove lastmove;
    private List<IMove> possibleMoves;
    private List<IMove> MicroBoardSpaces;
    private Random ran;
    private IGameState gamestate;
    private long starttime;
    private long endtime;
    private int FirstChoicedMove = 4;
    private int SecondChoicedMove = 8;
   

    @Override
    public IMove doMove(IGameState state)
    {
        starttime = System.currentTimeMillis();
        ran = new Random();
        possibleMoves = state.getField().getAvailableMoves();
        gamestate = state;
        getAvailableMovesMicroBoard();
        checkIfPossibleWinOnMicroBoard();
        endtime = System.currentTimeMillis() - starttime;
        System.out.println("Ranked choice bot thunk for" + endtime + "miliseconds");
        return lastmove;

        
    }

    @Override
    public IMove getLastMove() {
       return lastmove;
    }
    
    /**
     * Checks if there is a possible win on the board.
     */
    private void checkIfPossibleWinOnMicroBoard()
    {
        boolean centreIsAvailable = false;
        boolean secondIsAvailable = false;
        
        for (IMove move : possibleMoves)
        {
            if (MicroBoardSpaces.get(FirstChoicedMove).getX() == move.getX() && MicroBoardSpaces.get(FirstChoicedMove).getY() == move.getY())
            {
                centreIsAvailable = true;
                
            }
            
        }
        
         for (IMove move : possibleMoves)
        {
            if (MicroBoardSpaces.get(SecondChoicedMove).getX() == move.getX() && MicroBoardSpaces.get(SecondChoicedMove).getY() == move.getY())
            {
               secondIsAvailable = true;
                
            }
            
        }
        if (centreIsAvailable == true)
        {
            lastmove = MicroBoardSpaces.get(FirstChoicedMove);
        }
        else if (secondIsAvailable == true)
        {
            lastmove = MicroBoardSpaces.get(SecondChoicedMove);
            
        }
        else
        {
            lastmove = possibleMoves.get(ran.nextInt(possibleMoves.size()));
            System.out.println("CentristBot did a random move");
        }
        
                
       
    }
    
    public void getAvailableMovesMicroBoard() {
        
        MicroBoardSpaces = new ArrayList<>();
        
        for (int x = 0; x < gamestate.getField().getBoard().length; x++) {
            
            for (int y = 0; y < gamestate.getField().getBoard().length; y++) {
                
              
               
             if( gamestate.getField().isInActiveMicroboard(x, y)){
             
                 MicroBoardSpaces.add(new Move(x, y));
             
             }
                
            }
            
    }
        
        
        
        

    }
}
