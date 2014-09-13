import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Battleships {
    
    private char hitSymbol, missSymbol, emptySymbol;
    private char[][] board;
    private Ship[] ships;
    public Battleships(char hit, char miss, char empty) {
        hitSymbol = hit;
        missSymbol = miss;
        emptySymbol = empty;
        
        board = new char[10][10];
    }
    public static void showError() {
        JOptionPane.showMessageDialog(null, "Error, invalid input, please try again!");
    }
    public Ship askForShip(char type, Ship[] _ships, int count, StringBuilder massage) {
        Ship newShip = new Ship(type);
        String sms = "";

        String poss;
        char first;
        char second;
        char third;
        
        if (count != 0) {
            sms += massage + "---\n";
        } 
        
        while(true) {

            
            String s = JOptionPane.showInputDialog(sms + "Commander, Please input the location for "+ newShip.getName() +"?\nEnter row[A-J], column[0-9] and position[H or V], e.g. [A1H]");
        
            if (s.length() != 3) {
                showError();
                continue;
            }
            first = s.charAt(0);
            second = s.charAt(1);
            third = s.charAt(2);
        
            if (first < 65 || first > 74) {
                //JOptionPane.showMessageDialog(null, "111Error, invalid input, please try again!");
                showError();
                continue;
            }
            if (second < 48 || second > 57) {
                //JOptionPane.showMessageDialog(null, "222Error, invalid input, please try again!");
                showError();
                continue;
            }
            if (third != 72 && third != 86) {
                //JOptionPane.showMessageDialog(null, "333Error, invalid input, please try again!");
                showError();
                continue;
            }
            
            newShip.setLocation(first, second, third);
            if (!newShip.isInBoundary()) {
                 showError();
                continue;
            }
            
            boolean ifOverlap;
            do {
            int i;
                ifOverlap = false;
                for (i=0; i < count; i++) {
                    if (newShip.isOverlap(_ships[i])) {
                      showError();
                       ifOverlap = true;
                    }
                }
                
                if (!ifOverlap) {
                       if (third == 'H')
                poss="Horizontal";
            else 
                poss="Vertical";
            
                   int count1 = count + 1;
        massage.append(count1 +". "+ newShip.getName() +" at row: " + first +", column: "+second+", position: "+poss+"\n"); 
        
        return newShip;
                }
            } while(!ifOverlap);
        } //end of while loop
    }
    public String getRadar(int shotsLeft) {
        String s = "Shots Left:" + shotsLeft + " \nRadar Screen:\n  ";
        for (int i = 0; i < 10; i++) {
            s += i + " ";
        }
        s += "\n";
        for (int i = 0; i < 10; i++) {
            s += ((char) (65 + i)) + " ";//print A-J
            
            for (int j = 0; j < 10; j++) {
                s += this.board[i][j] + " ";
            }
            s += "\n";
        }
        s += "---------------------\n";
        return s;
    }
    public void play(int numOfShots) {
        int shotCount = 0;
        int dead = 0;
        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 10; k++) {
                this.board[j][k] = this.emptySymbol;
            }
        }
        while (shotCount < numOfShots && dead != this.ships.length) {
       
            JTextArea textarea = new JTextArea(getRadar(numOfShots - shotCount)
                    + "Captain, please call your shot?\nEnter row [A-J] and column[0-9]\nFor example:D6");
            textarea.setFont(new Font("Monospaced", Font.PLAIN, 14));
            String s = (String) JOptionPane.showInputDialog( null, textarea, "Input", JOptionPane.QUESTION_MESSAGE, null, null, "");

            if (s.length() == 2 && (int) s.charAt(0) >= 65 && (int) s.charAt(0) <= 74
                    && (int) s.charAt(1) >= 48 && (int) s.charAt(1) <= 57
                    && this.board[(int) s.charAt(0) - 65][s.charAt(1)-48] == this.emptySymbol) {
                
                for (int j = 0; j < this.ships.length; j++) {
                    if (!this.ships[j].isSunk()) {
                        if (this.ships[j].getShot(s.charAt(0), s.charAt(1))) {
                            this.board[(int) s.charAt(0) - 65][s.charAt(1)-48] = this.hitSymbol;
                            if (this.ships[j].isSunk()) {
                            JOptionPane.showMessageDialog(null, this.ships[j].getName() + " Sunk!");
                            dead += 1;
                        }
                            break;
                        } else {
                            this.board[(int) s.charAt(0) - 65][s.charAt(1)-48] = this.missSymbol;
                        }                 
                    }
                }
                shotCount++;
            } else {
                showError();
            }

        }// end of shooting while loop
        
        if (this.ships.length == dead) {
            JOptionPane.showMessageDialog(null, "Game Over, You Win!");
        } else {
            JOptionPane.showMessageDialog(null, "Game Over, You Lose!");
        }
    }

    
    
    public void prepareForBattle(char[] fleet) {
        this.ships = new Ship[fleet.length];
        StringBuilder s = new StringBuilder("Your Fleet at Service:\n");

        
        for (int i=0; i < fleet.length; i++) {
           ships[i] = askForShip(fleet[i], ships, i, s);
        }//end of fleet fall in
        
        JOptionPane.showMessageDialog(null, s);
        
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        char[] fleetOfShips = {'A', 'B', 'D', 'S', 'P' }; 
        Battleships game = new Battleships('X', 'O', '.');
        game.prepareForBattle(fleetOfShips);
        game.play(30);
    }
}
