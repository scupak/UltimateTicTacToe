package ultimatetictactoe.BLL.move;

/**
 *
 * @author Zanaxdk <https://github.com/zanaxdk>
 */
public class Move implements IMove
{
    private int x = 0;
    private int y = 0;
    
    public Move(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX()
    {
        return x;
    }

    @Override
    public int getY()
    {
        return y;
    }
}


    

