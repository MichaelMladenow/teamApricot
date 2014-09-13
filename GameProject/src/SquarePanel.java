import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Creates a new JPanel that will be placed on each possible guess position
 */

public class SquarePanel extends JPanel
{
    
    /**
     * Class Constructor
     */
    
    public SquarePanel()
    {
        setPreferredSize(new Dimension(50,50));
        setBackground(Color.white);      
    }
    
    /**
     * Paints the Panel.
     * 
     * @param   g   the Graphics instance to be painted
     */
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.drawRect(0,0,49,49);   
    }  
}