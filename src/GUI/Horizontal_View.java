package GUI;

import GUI.StarCreation.Horizontal_Star;
import StudentClass.Student;
import StudentTester.Test;

import javax.swing.*;
import java.awt.*;

public class Horizontal_View extends JFrame {
    public Horizontal_View() {
        super("Overall Marks in Horizontal Histogram");
        setSize(450, 350);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel);

        JPanel subPanel1 = new JPanel();
        JLabel header = new JLabel("Horizontal Histogram");
        subPanel1.add(header);
        mainPanel.add(subPanel1, BorderLayout.PAGE_START);

        JPanel subPanel2 = new JPanel();
        subPanel2.setLayout(new GridLayout(4, 1));

        JLabel lbl1 = new JLabel(" 0 - 29");
        JLabel lbl2 = new JLabel("30 - 39");
        JLabel lbl3 = new JLabel("40 - 69");
        JLabel lbl4 = new JLabel("70 - 100");

        subPanel2.add(lbl1);
        subPanel2.add(lbl2);
        subPanel2.add(lbl3);
        subPanel2.add(lbl4);

        mainPanel.add(subPanel2, BorderLayout.LINE_START);

        JPanel subPanel3 = new JPanel();
        subPanel3.setLayout(new GridLayout(4, 1));

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
        subPanel3.add(new Horizontal_Star(num1));//Adding stars
        subPanel3.add(new Horizontal_Star(num2));//Adding stars
        subPanel3.add(new Horizontal_Star(num3));//Adding stars
        subPanel3.add(new Horizontal_Star(num4));//Adding stars
        mainPanel.add(subPanel3, BorderLayout.CENTER);

        JLabel noOfStds = new JLabel("Total number of students : " + Test.students.size());
        mainPanel.add(noOfStds, BorderLayout.PAGE_END);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
