package GUI;

import GUI.StarCreation.Vertical_Star;
import StudentClass.Student;
import StudentTester.Test;
import javax.swing.*;
import java.awt.*;

public class Vertical_View extends JFrame {
    public Vertical_View() {
        super("Overall Marks in Vertical Histogram");
        setSize(450, 350);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel);


        JPanel subPanel1 = new JPanel();
        subPanel1.setLayout(new GridLayout(1, 4));

        JLabel lbl1 = new JLabel(" 0 - 29");
        JLabel lbl2 = new JLabel("30 - 39");
        JLabel lbl3 = new JLabel("40 - 69");
        JLabel lbl4 = new JLabel("70 - 100");

        subPanel1.add(lbl1);
        subPanel1.add(lbl2);
        subPanel1.add(lbl3);
        subPanel1.add(lbl4);

        mainPanel.add(subPanel1, BorderLayout.PAGE_START);

        JPanel subPanel2 = new JPanel();
        subPanel2.setLayout(new GridLayout(1, 4));

        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        for (Student student : Test.students) {
            if (student.getFinalMarks() < 30) num1++;
            else if (student.getFinalMarks() < 40) num2++;
            else if (student.getFinalMarks() < 70) num3++;
            else num4++;
        }
        subPanel2.add(new Vertical_Star(num1));//Adding stars
        subPanel2.add(new Vertical_Star(num2));//Adding stars
        subPanel2.add(new Vertical_Star(num3));//Adding stars
        subPanel2.add(new Vertical_Star(num4));//Adding stars
        mainPanel.add(subPanel2, BorderLayout.CENTER);

        JLabel noOfStds = new JLabel("Total number of students : " + Test.students.size());
        mainPanel.add(noOfStds, BorderLayout.PAGE_END);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
