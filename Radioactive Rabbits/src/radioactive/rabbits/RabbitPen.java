/**
 * Name: David Turnbough
 * Date: Monday January 11, 2020
 */
package radioactive.rabbits;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class RabbitPen extends JFrame
{
    /**
     * Variable Declarations
     */
    JFrame frame;
    
    /**
     * Default Constructor
     */
    RabbitPen()
    {
        // Generate a JFrame
        this.frame = new JFrame("Radioactive Rabbits");
        this.frame.pack();

        // Stop the JFrame from running when the exit button is clicked
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Determine the size of the screen, and set the size of the JFrame to
        //  me maximized 
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        this.frame.setSize(width, height);

        // Set the location of the JFrame to the center of the screen
        this.frame.setLocationRelativeTo(null);

        // Makes the JFrame visible
        this.frame.setVisible(true);
    }
}
