package GUI.StarCreation;

import javax.swing.*;
import java.awt.*;

public class Vertical_Star extends JPanel {

    private int nStars = 0;

    // Overridden paint method to paint our own string
    @Override
    public void paint(Graphics g) {//Using graphics to display the stars
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < nStars; i++) {
            g2d.setFont(new Font("TimesRoman", Font.BOLD, 20));
            g2d.setColor(Color.BLACK);
            g2d.drawString("*", 15, 20 + (i * 10));
        }
    }

    // Non Default constructor
    public Vertical_Star(int list) {
        this.nStars = list;
    }
}
