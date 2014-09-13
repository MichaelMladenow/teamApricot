public class Ship {
    private char sType;
    private char sPos, sRow, sCol;
    private int sDamage;
    
    public Ship(char type) {
        sType = type;
        sDamage = 0;
        sPos = 'V';
        sRow = 'A';
        sCol = 0;
    }
    
    public String getName() {
        switch (sType) {
            case 'A':
                return "Aircraft Carrier";
            case 'B':
                return "Battleship";
            case 'D':
                return "Destroyer";
            case 'S':
                return "Submarines";
            case 'P':
                return "Patrol Boat";
            default:
                System.out.println("Error, ship.getname!");
                return "sType error";
        }
    }
    
    public void setLocation(char row, char col, char pos) {
        sRow = row;
        sCol = col;
        sPos = pos;
    }
    
    private int getLength() {
         switch (sType) {
            case 'A':
                return 4;
            case 'B':
                return 3;
            case 'D':
                return 2;
            case 'S':
                return 2;
            case 'P':
                return 1;
            default:
                System.out.println("Error, ship.isInBoundary.length!");
                return 99;
        }
    }
    
    public boolean isInBoundary() {
        //This method returns true if the ship is within the boundary of the 10 × 10 grid;
        //returns false otherwise.
        
        int length = getLength();
        int Row = sRow;
        int Col = sCol;
        switch (sPos) {
            case 'V':
                Row += length;
                break;
            case 'H':
                Col += length;
                break;
            default:
                length = 99;
                break;     
        }
        if (Row >= 65 && Row <= 74 && Col >= 48 && Col <= 57)
            return true;
        else
            return false;
    }
    
    public boolean isOverlap(Ship neighbour) {
        //This method returns true if the ship overlaps with another ship passing in as 
        //parameter neighbour; returns false otherwise
        //A-17=0
        int[][] board = new int[99][99];
           for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                board[i][j] = 0;
        
        
        int _sRow = this.sRow;
        //System.out.println(_sRow);
        int _sCol = this.sCol;
        //System.out.println(_sCol);
        
        
        int sLength = this.getLength();        
        switch (sPos) {
            case 'V':
                for (int i=0; i < sLength; i++) {
                    board[_sRow++][_sCol] = 1;
                }
                break;
            case 'H':
                for (int i=0; i < sLength; i++) {
                    board[_sRow][_sCol++] = 1;
                }
                break;
            default:
                System.out.println("Error, ship.initBoard.sPos!");
                break;     
        }
        int _nRow = neighbour.sRow;
        //System.out.println(_nRow);
        int _nCol = neighbour.sCol; 
        //System.out.println(_nCol);
        int nLength = neighbour.getLength();
        //.out.println(nLength);
        
        switch (neighbour.sPos) {
            case 'V':
                for (int i=0; i < nLength; i++) {
                    if(board[_nRow++][_nCol] == 1)
                        return true;
                }
                return false;
            case 'H':
                for (int i=0; i < nLength; i++) {
                    if (board[_nRow][_nCol++] == 1)
                        return true;
                }
                return false;
            default:
                System.out.println("Error, ship.isOverlap.sPos!");
                return true;    
        }
    }
    
    public boolean getShot(char row, char col) {
        //This method determines if a shot hits the ship or not. If the ship is hit, this 
        //method should increment the instance variable sDamage by 1 and returns true;
        //returns false otherwise
           
        int[][] board = new int[99][99];
           for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                board[i][j] = 0;
        
        
            int _sRow = sRow;
        int _sCol = sCol;
        
        
        int sLength = this.getLength();        
        switch (sPos) {
            case 'V':
                for (int i=0; i < sLength; i++) {
                    board[_sRow++][_sCol] = 1;
                }
                break;
            case 'H':
                for (int i=0; i < sLength; i++) {
                    board[_sRow][_sCol++] = 1;
                }
                break;
            default:
                System.out.println("Error, ship.initBoard.sPos!");
                break;     
        }
        
        if (board[row][col] == 1) {
            sDamage++;
            return true;
        } else
            return false;
    }
    
    public boolean isSunk() {
        //This method returns true if the damage of the ship is equal to its size; returns false
        //otherwise.
        
        if (sDamage == this.getLength())
            return true;
        else
            return false;
    }
}
