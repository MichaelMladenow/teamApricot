import java.util.Random;

/**
 * Contains the main method and calls methods to initialize the game
 */

public class PlayGame{

    /** integer representing the lenght of the longest ship*/
    final static int BATTLESHIP = 5;    
    
    /**
     * Main method, initializes the game.
     * 
     * @param   args    array of strings
     */
    
    public static void main (String args[])
    {        
        BattleshipFrame battleshipBoard = new BattleshipFrame();       
        
        battleshipBoard.eraseBoard();        

        for (int i = 2; i <= BATTLESHIP; i++)
        {
            battleshipBoard.populateBoard(i);
        }                      
    }   
}    