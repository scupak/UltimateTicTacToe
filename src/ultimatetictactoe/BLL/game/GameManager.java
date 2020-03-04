package ultimatetictactoe.BLL.game;

import ultimatetictactoe.BLL.bot.IBot;
import ultimatetictactoe.BLL.field.IField;
import ultimatetictactoe.BLL.move.IMove;
import ultimatetictactoe.BLL.move.Move;

/**
 * This is a proposed GameManager for Ultimate Tic-Tac-Toe, the implementation
 * of which is up to whoever uses this interface. Note that initializing a game
 * through the constructors means that you have to create a new instance of the
 * game manager for every new game of a different type (e.g. Human vs Human,
 * Human vs Bot or Bot vs Bot), which may not be ideal for your solution, so you
 * could consider refactoring that into an (re-)initialize method instead.
 *
 * @author mjl
 */
public class GameManager {

    

    /**
     * Three different game modes.
     */
    public enum GameMode {
        HumanVsHuman,
        HumanVsBot,
        BotVsBot
    }
    
    public enum GameOverState{
        Active,
        Win,
        Tie
    }
    
    private final String NON_AVAILABLE_MACRO_CELL = "-";
    private final IGameState currentState;
    private int currentPlayer = 0; //player0 == 0 && player1 == 1
    private GameMode mode = GameMode.HumanVsHuman;
    private IBot bot = null;
    private IBot bot2 = null;
    private volatile GameOverState gameOver = GameOverState.Active;
    

    public GameMode getMode() {
        return mode;
    }

    public void setMode(GameMode mode) {
        this.mode = mode;
    }

    public GameOverState getGameOver() {
        return gameOver;
    }

    public void setGameOver(GameOverState gameOver) {
        this.gameOver = gameOver;
    }
    
    public IGameState getCurrentState() {
        return currentState;
    }
    

    /**
     * Set's the currentState so the game can begin. Game expected to be played
     * Human vs Human
     *
     * @param currentState Current game state, usually an empty board, but could
     * load a saved game.
     */
    public GameManager(IGameState currentState) {
        this.currentState = currentState;
        mode = GameMode.HumanVsHuman;
    }

    /**
     * Set's the currentState so the game can begin. Game expected to be played
     * Human vs Bot
     *
     * @param currentState Current game state, usually an empty board, but could
     * load a saved game.
     * @param bot The bot to play against in vsBot mode.
     */
    public GameManager(IGameState currentState, IBot bot) {
        this.currentState = currentState;
        mode = GameMode.HumanVsBot;
        this.bot = bot;
    }

    /**
     * Set's the currentState so the game can begin. Game expected to be played
     * Bot vs Bot
     *
     * @param currentState Current game state, usually an empty board, but could
     * load a saved game.
     * @param bot The first bot to play.
     * @param bot2 The second bot to play.
     */
    public GameManager(IGameState currentState, IBot bot1, IBot bot2) {
        this.currentState = currentState;
        mode = GameMode.BotVsBot;
        this.bot = bot;
        this.bot2 = bot2;
    }

    /**
     * User input driven Update
     *
     * @param move The next user move
     * @return Returns true if the update was successful, false otherwise.
     */
    public Boolean updateGame(IMove move) {
        //Verify the new move
        if (!verifyMoveLegality(move)) {
            return false;
        }

        //Update the currentState
        updateBoard(move);
        updateMacroboard(move);

        //Update currentPlayer
        currentPlayer = (currentPlayer + 1) % 2;
        currentState.setMoveNumber(currentState.getMoveNumber() +1);

        return true;
    }

    /**
     * Non-User driven input, e.g. an update for playing a bot move.
     *
     * @return Returns true if the update was successful, false otherwise.
     */
    public Boolean updateGame() {
        //Check game mode is set to one of the bot modes.
        assert (mode != GameMode.HumanVsHuman);

        //Check if player is bot, if so, get bot input and update the state based on that.
        if (mode == GameMode.HumanVsBot && currentPlayer == 1) {
            //Check bot is not equal to null, and throw an exception if it is.
            assert (bot != null);

            IMove botMove = bot.doMove(currentState);
            
            

            //Be aware that your bots might perform illegal moves.
            return updateGame(botMove);
        }

        //Check bot is not equal to null, and throw an exception if it is.
        assert (bot != null);
        assert (bot2 != null);

        //TODO: Implement a bot vs bot Update.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private Boolean verifyMoveLegality(IMove move) {
        //Test if the move is legal   
        //NOTE: should also check whether the move is placed on an occupied spot.
        System.out.println("Checking move validity against macroboard available field");
        System.out.println("Not currently checking move validity actual board");
        
        
        boolean isInActiveMicroboard = currentState.getField().isInActiveMicroboard(move.getX(), move.getY());
        
        boolean IsAvailable = currentState.getField().getPlayerId(move.getX(),  move.getY() ).equals(IField.EMPTY_FIELD);
        
        return isInActiveMicroboard && IsAvailable;
    }

    private void updateBoard(IMove move) {
        //TODO: Update the board to the new state 

        currentState.getField().getBoard()[move.getX()][move.getY()] = "" + currentPlayer;
        checkAndUpdateIfWin(move);
        updateMacroboard(move);
    }
    
    private void checkAndUpdateIfWin(IMove move) {
        String[][] macroBoard = currentState.getField().getMacroboard();
        int macroX = move.getX()/3;
        int macroY = move.getY()/3;

        if(macroBoard[macroX][macroY].equals(IField.EMPTY_FIELD) ||
                macroBoard[macroX][macroY].equals(IField.AVAILABLE_FIELD) ) {

            String[][] board = getCurrentState().getField().getBoard();

            if(isWin(board,move, ""+currentPlayer))
                macroBoard[macroX][macroY] = currentPlayer + "";
            else if(isTie(board,move))
                macroBoard[macroX][macroY] = "TIE";
            
            //Check macro win
            if(isWin(macroBoard,new Move(macroX,macroY), ""+currentPlayer)){
                gameOver = GameOverState.Win; 
                System.out.println("win");
            }
            else if(isTie(macroBoard,new Move(macroX,macroY))){
                gameOver = GameOverState.Tie;
                 System.out.println("tie");
            }
        }

    }
    
    private boolean isTie(String[][] board, IMove move){
        int localX = move.getX() % 3;
        int localY = move.getY() % 3;
        int startX = move.getX() - (localX);
        int startY = move.getY() - (localY);

        for (int i = startX; i < startX+3; i++) {
            for (int k = startY; k < startY+3; k++) {
                if(board[i][k].equals(IField.AVAILABLE_FIELD) ||
                        board[i][k].equals(IField.EMPTY_FIELD) || board[i][k].equals(NON_AVAILABLE_MACRO_CELL) ){
                    return false;
                }
            }
        }
        return true;
    }
    
     public static boolean isWin(String[][] board, IMove move, String currentPlayer){
        int localX = move.getX() % 3;
        int localY = move.getY() % 3;
        int startX = move.getX() - (localX);
        int startY = move.getY() - (localY);

        //check col
        for (int i = startY; i < startY + 3; i++) {
            if (!board[move.getX()][i].equals(currentPlayer))
                break;
            if (i == startY + 3 - 1) return true;
        }

        //check row
        for (int i = startX; i < startX + 3; i++) {
            if (!board[i][move.getY()].equals(currentPlayer))
                break;
            if (i == startX + 3 - 1) return true;
        }

        //check diagonal
        if (localX == localY) {
            //we're on a diagonal
            int y = startY;
            for (int i = startX; i < startX + 3; i++) {
                if (!board[i][y++].equals(currentPlayer))
                    break;
                if (i == startX + 3 - 1) return true;
            }
        }

        //check anti diagonal
        if (localX + localY == 3 - 1) {
            int less = 0;
            for (int i = startX; i < startX + 3; i++) {
                if (!board[i][(startY + 2)-less++].equals(currentPlayer))
                    break;
                if (i == startX + 3 - 1) return true;
            }
        }
        return false;
    }

    private void updateMacroboard(IMove move) {
        //TODO: Update the macroboard to the new state 
        int macroX = move.getX() % 3;
        int macroY = move.getY() % 3;

        String[][] macroBoard = currentState.getField().getMacroboard();

        /*Checks of already won. if already won all macro cells available for play */
        if (currentState.getField().getMacroboard()[macroX][macroY] != IField.AVAILABLE_FIELD
                && currentState.getField().getMacroboard()[macroX][macroY] != NON_AVAILABLE_MACRO_CELL) {

            for (int x = 0; x < macroBoard.length; x++) {

                for (int y = 0; y < macroBoard[x].length; y++) {

                    if (currentState.getField().getMacroboard()[x][y] == NON_AVAILABLE_MACRO_CELL) {

                        macroBoard[x][y] = IField.AVAILABLE_FIELD;

                    }

                }

            }

        }
        /* if not already won, set all to non avail. and set only clicked to avail*/
        if (currentState.getField().getMacroboard()[macroX][macroY] == NON_AVAILABLE_MACRO_CELL
                || currentState.getField().getMacroboard()[macroX][macroY] == IField.AVAILABLE_FIELD) {

            
            for (int x = 0; x < macroBoard.length; x++) {

                for (int y = 0; y < macroBoard[x].length; y++) {
                    if (macroBoard[x][y] == IField.AVAILABLE_FIELD) {
                        macroBoard[x][y] = NON_AVAILABLE_MACRO_CELL; //making unavailable
                    }

                }

            }

            currentState.getField().getMacroboard()[macroX][macroY] = IField.AVAILABLE_FIELD;
        }
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public IBot getBot() {
        return bot;
    }

    public IBot getBot2() {
        return bot2;
    }

    
    
    
    
    
    

}
