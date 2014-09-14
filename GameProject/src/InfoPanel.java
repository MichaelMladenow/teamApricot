import javax.swing.ImageIcon;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Image;



/**
 * Creates a panel for displaying gameplay information.  Extends the JPanel class.
 */

public class InfoPanel extends JPanel
{
    /** integer represenging the number of guesses made*/
    int numberOfGuesses = 0;
    int numberLeftEnd= 20;

    /** JLabel containing the integer numberOfGuesses*/
    JLabel guesses;
    JLabel guessesLeft;

    /**
     * Class Constructor.
     */
    
    public InfoPanel()
    {        
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(400,100));        
        guesses = new JLabel("Wrong guesses:   " + numberOfGuesses);
        guesses.setForeground(Color.black);
        add(guesses);     
        guessesLeft = new JLabel(" Left: " +  numberLeftEnd);
        guessesLeft.setForeground(Color.red);
        add(guessesLeft);     
    }
    
    /**
     * Paints the panel with the necessary information
     * 
     * @param   g   the graphics instance to be painted
     */
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setBackground(Color.white);
        g.setColor(Color.white);
        g.drawRect(0,0,399,99);
        g.setColor(Color.black);
        g.fillRect(5,15,10,10);
        g.drawString("Miss",20,25); 
        g.setColor(Color.green);
        g.fillRect(5,30,10,10);
        g.setColor(Color.black);         
        ImageIcon two=new  ImageIcon("src/2.png");
        Image shiptwo=two.getImage();
        g.drawImage(shiptwo,115,30,null);
        g.drawString("Minesweeper (2)",20,40);
        g.setColor(Color.yellow);
        g.fillRect(5,45,10,10);
        g.setColor(Color.black);
        ImageIcon three=new  ImageIcon("src/3.png");
        Image shipthree=three.getImage();
        g.drawImage(shipthree,110,40,null);
        g.drawString("Frigate (3)",20,55);  
        g.setColor(Color.blue);
        g.fillRect(5,60,10,10);
        g.setColor(Color.black);     
        ImageIcon four=new  ImageIcon("src/4.png");
        Image shipfour=four.getImage();
        g.drawImage(shipfour,110,55,null);
        g.drawString("Cruiser (4)",20,70); 
        g.setColor(Color.red);        
        g.fillRect(5,75,10,10);
        g.setColor(Color.black);
        ImageIcon five=new  ImageIcon("src/5.png");
        Image shipfive=five.getImage();
        g.drawImage(shipfive,105,70,null);
        
        g.drawString("Battleship (5)",20,85);        
    }    
}