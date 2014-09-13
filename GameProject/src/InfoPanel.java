import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Creates a panel for displaying gameplay information. Extends the JPanel
 * class.
 */

public class InfoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** integer represenging the number of guesses made */
	int numberOfGuesses = 0;

	/** JLabel containing the integer numberOfGuesses */
	JLabel guesses;

	/**
	 * Class Constructor.
	 */

	public InfoPanel() {
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(400, 100));
		guesses = new JLabel("Guesses: " + numberOfGuesses);
		guesses.setForeground(Color.red);
		add(guesses);
	}

	/**
	 * Paints the panel with the necessary information
	 * 
	 * @param g
	 *            the graphics instance to be painted
	 */

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.white);
		g.setColor(Color.black);
		g.drawRect(0, 0, 399, 99);
		g.fillRect(5, 15, 10, 10);
		g.drawString("Miss", 20, 25);
		g.setColor(Color.green);
		g.fillRect(5, 30, 10, 10);
		g.setColor(Color.black);
		g.drawString("Minesweeper (2)", 20, 40);
		g.setColor(Color.blue);
		g.fillRect(5, 45, 10, 10);
		g.setColor(Color.black);
		g.drawString("Frigate (3)", 20, 55);
		g.setColor(Color.red);
		g.fillRect(5, 60, 10, 10);
		g.setColor(Color.black);
		g.drawString("Cruiser (4)", 20, 70);
		g.setColor(Color.yellow);
		g.fillRect(5, 75, 10, 10);
		g.setColor(Color.black);
		g.drawString("Battleship (5)", 20, 85);
	}
}