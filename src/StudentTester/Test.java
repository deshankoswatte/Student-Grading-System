package StudentTester;

import GUI.Horizontal_View;
import GUI.Vertical_View;
import StudentClass.*;
import Comparators.*;

import java.util.*;

import static Enum.Grade.Fail_Resit;
import static Enum.Grade.Fail_Retake;

public class Test {

    /* Class level variables so that they can be used anywhere in the class
       referring to the name of it*/
    public static List<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    // Method to get the average of the four components
    private static List<Double> getComponentAverage() {
        List<Double> average = new ArrayList<>();

        double ict_01 = 0;
        double ict_02 = 0;
        double cw_01 = 0;
        double cw_02 = 0;

        for (Student member : students) {
            ict_01 = ict_01 + member.getIct_01_marks();
            ict_02 = ict_02 + member.getIct_02_marks();
            cw_01 = cw_01 + member.getCw_01_marks();
            cw_02 = cw_02 + member.getCw_02_marks();
        }

        ict_01 = ict_01 / students.size();
        ict_02 = ict_02 / students.size();
        cw_01 = cw_01 / students.size();
        cw_02 = cw_02 / students.size();

        average.add(ict_01);
        average.add(ict_02);
        average.add(cw_01);
        average.add(cw_02);

        return average;
    }

    // Method to get the no: of students who has scores below 30 for the 4 components
    private static List<Integer> getComponentScoreBelow_30() {
        List<Integer> number = new ArrayList<>();

        int ict_01 = 0;
        int ict_02 = 0;
        int cw_01 = 0;
        int cw_02 = 0;

        for (Student member : students) {
            if (member.getIct_01_marks() < 30) {
                ict_01 = ict_01 + 1;
            }
            if (member.getIct_02_marks() < 30) {
                ict_02 = ict_02 + 1;
            }
            if (member.getCw_01_marks() < 30) {
                cw_01 = cw_01 + 1;
            }
            if (member.getCw_02_marks() < 30) {
                cw_02 = cw_02 + 1;
            }
        }

        number.add(ict_01);
        number.add(ict_02);
        number.add(cw_01);
        number.add(cw_02);

        return number;
    }

    // Method to get the overall average(final score)
    private static double overallAverage() {
        int avg = 0;

        for (Student member : students) {
            avg = avg + member.getFinalMarks();
        }

        avg = avg / students.size();
        return avg;
    }

    // Method to get the list of students who are below the overall average
    private static List<Student> belowAverageStudents() {
        List<Student> belowAverage = new ArrayList<>();

        for (Student member : students) {
            if (member.getFinalMarks() < overallAverage()) {
                belowAverage.add(member);
            }
        }

        return belowAverage;
    }

    // Method to get the list of students who are above the overall average
    private static List<Student> aboveAverageStudents() {
        ArrayList<Student> aboveAverage = new ArrayList<>();

        for (Student member : students) {
            if (member.getFinalMarks() > overallAverage()) {
                aboveAverage.add(member);
            }
        }

        aboveAverage = bubbleSort(aboveAverage, new LastName());

        return aboveAverage;
    }

    // Method to get the highest scorers for the four components and the overall module
    private static List<List<Student>> highestScorer() {

        List<List<Student>> highScorer = new ArrayList<>();
        List<Student> ict_01 = new ArrayList<>();
        List<Student> ict_02 = new ArrayList<>();
        List<Student> cw_01 = new ArrayList<>();
        List<Student> cw_02 = new ArrayList<>();
        List<Student> overall = new ArrayList<>();

        int ict_1_high_score = 0;
        int ict_2_high_score = 0;
        int cw_1_high_score = 0;
        int cw_2_high_score = 0;
        int overall_high_score = 0;

        for (Student member : students) {
            if (member.getIct_01_marks() > ict_1_high_score) {
                ict_1_high_score = member.getIct_01_marks();
            }
            if (member.getIct_02_marks() > ict_2_high_score) {
                ict_2_high_score = member.getIct_02_marks();
            }
            if (member.getCw_01_marks() > cw_1_high_score) {
                cw_1_high_score = member.getCw_01_marks();
            }
            if (member.getCw_02_marks() > cw_2_high_score) {
                cw_2_high_score = member.getCw_02_marks();
            }
            if (member.getFinalMarks() > overall_high_score) {
                overall_high_score = member.getFinalMarks();
            }
        }

        for (Student member : students) {
            if (member.getIct_01_marks() == ict_1_high_score) {
                ict_01.add(member);
            }
            if (member.getIct_02_marks() == ict_2_high_score) {
                ict_02.add(member);
            }
            if (member.getCw_01_marks() == cw_1_high_score) {
                cw_01.add(member);
            }
            if (member.getCw_02_marks() == cw_2_high_score) {
                cw_02.add(member);
            }
            if (member.getFinalMarks() == overall_high_score) {
                overall.add(member);
            }
        }

        highScorer.add(ict_01);
        highScorer.add(ict_02);
        highScorer.add(cw_01);
        highScorer.add(cw_02);
        highScorer.add(overall);

        return highScorer;
    }

    // Method to get the lowest overall scorer
    private static List<Student> lowestScorer() {
        List<Student> lowestScorer = new ArrayList<>();
        Student lScorer = students.get(0);

        for (Student member : students) {
            if (member.getFinalMarks() < lScorer.getFinalMarks()) {
                lScorer = member;
            }
        }

        for (Student member : students) {
            if (lScorer.getFinalMarks() == member.getFinalMarks()) {
                lowestScorer.add(member);
            }
        }

        return lowestScorer;
    }

    // Method to get the list of retake students
    private static List<Student> retakeStudents() {
        List<Student> retake = new ArrayList<>();

        for (Student member : students) {
            if (member.getGrade().equals(Fail_Retake)) {
                retake.add(member);
            }
        }

        return retake;
    }

    // Method to get the list of resit students for each component
    private static List<List<Student>> resitStudents() {

        List<List<Student>> all = new ArrayList<>();
        ArrayList<Student> ict = new ArrayList<>();
        ArrayList<Student> cw_1 = new ArrayList<>();
        ArrayList<Student> cw_2 = new ArrayList<>();

        for (Student member : students) {
            if (member.getGrade().equals(Fail_Resit) && ((member.getIct_01_marks() + member.getIct_02_marks()) / 2) < 40) {
                ict.add(member);
            }
            if (member.getGrade().equals(Fail_Resit) && member.getCw_01_marks() < 40) {
                cw_1.add(member);
            }
            if (member.getGrade().equals(Fail_Resit) && member.getCw_02_marks() < 40) {
                cw_2.add(member);
            }
        }

        bubbleSort(ict, new LastName());
        bubbleSort(cw_1, new LastName());
        bubbleSort(cw_1, new LastName());

        all.add(ict);
        all.add(cw_1);
        all.add(cw_2);

        return all;
    }

    // Method to get back to the menu after each selection from the main menu
    private static void backToMenu() {
        System.out.print("Press enter to go back to the menu");
        sc.nextLine();
        System.out.println();
    }

    // Method to validate the marks which are entered by the user to the system
    private static int marksValidation(Scanner sc, String message) {
        int number;
        do {
            System.out.print(message);
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input format. Please enter an integer" + "\n");
                System.out.print(message);
                sc.next();
            }
            number = sc.nextInt();
            if (number < 0 || number > 100) {
                System.out.println("Number Range should be between 0-100 inclusive");
            }
        } while (number < 0 || number > 100);
        return number;
    }

    // Method to sort an array list with the help of a comparator and return the result as an array list
    private static ArrayList<Student> bubbleSort(ArrayList<Student> arrayList, Comparator<Student> comparator) {
        Student temp;

        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 1; j < (arrayList.size() - i); j++) {
                if (comparator.compare(arrayList.get(j - 1), arrayList.get(j)) < 0) {
                    temp = arrayList.get(j - 1);
                    arrayList.set(j - 1, arrayList.get(j));
                    arrayList.set(j, temp);
                }
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {

        System.out.println("Made by        : Dehami Deshan Koswatte");
        System.out.println("IIT No         : 2016198");
        System.out.println("Westminster No : w1673620\n");

        // To keep repeating the loop
        while (true) {

            // Variables which are used to show and clear messages as they are used repetitively
            ArrayList<String> messages = new ArrayList<>();
            int count = 0;

            // The menu which is shown to the user for selection
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("<<<< ||||    1. Enter Student Data                                 |||| >>>>");
            System.out.println("<<<< ||||    2. Component Average                                  |||| >>>>");
            System.out.println("<<<< ||||    3. Overall Average                                    |||| >>>>");
            System.out.println("<<<< ||||    4. Highest Component Scorer                           |||| >>>>");
            System.out.println("<<<< ||||    5. Lowest Overall Scorer                              |||| >>>>");
            System.out.println("<<<< ||||    6. Students Above Average                             |||| >>>>");
            System.out.println("<<<< ||||    7. Students Below Average                             |||| >>>>");
            System.out.println("<<<< ||||    8. No:of Students Below Average for each Component    |||| >>>>");
            System.out.println("<<<< ||||    9. Resit Students for each Component                  |||| >>>>");
            System.out.println("<<<< ||||    10. Retake Students                                   |||| >>>>");
            System.out.println("<<<< ||||    11. Horizontal Histogram                              |||| >>>>");
            System.out.println("<<<< ||||    12. Vertical Histogram                                |||| >>>>");
            System.out.println("<<<< ||||    13. Exit                                              |||| >>>>");
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

            System.out.print("\nPlease select a number from the above menu : ");

            String choice = sc.nextLine();

            // Switch case would allow to direct to the certain case which the user would select from the menu
            switch (choice) {
                case "1":

                    char cont;
                    System.out.println("\nYou selected number 1 Enter Student Data");

                    // Keep getting information until the user wants to stop
                    do {
                        System.out.println();
                        System.out.print("Student Registration Number : ");
                        int regNo = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Student First Name          : ");
                        String fName = sc.nextLine();
                        System.out.print("Student Last Name           : ");
                        String lName = sc.nextLine();
                        int ict_01 = marksValidation(sc, "ICT 01 Score                : ");
                        int ict_02 = marksValidation(sc, "ICT 02 Score                : ");
                        int cw_01 = marksValidation(sc, "CW 01 Score                 : ");
                        int cw_02 = marksValidation(sc, "CW 02 Score                 : ");

                        Student student = new Student(fName, lName, regNo, ict_01, ict_02, cw_01, cw_02);
                        students.add(student);

                        System.out.println("Grade Obtained              : " + student.getGrade());
                        System.out.println("Overall Marks               : " + student.getFinalMarks());

                        System.out.print("\nPress 1 to continue and 0 to go back to main menu : ");
                        cont = sc.next().charAt(0);
                    } while (cont != '0');

                    backToMenu();
                    break;

                case "2":

                    messages.add("ICT 01 Average : ");
                    messages.add("ICT 02 Average : ");
                    messages.add("CW 01  Average : ");
                    messages.add("CW 02  Average : ");

                    System.out.println("\nYou selected number 2 Component Average\n");

                    // Ensure that data is available before processing
                    if (students.size() != 0) {
                        for (double member : getComponentAverage()) {
                            System.out.print(messages.get(count));
                            System.out.println(member);
                            count = count + 1;
                        }
                        System.out.println();
                        messages.clear();
                        count = 0;
                    } else {
                        System.out.println("Cannot perform process due " +
                                "to the unavailability of data \n");
                    }

                    backToMenu();
                    break;

                case "3":

                    System.out.println("\nYou selected number 3 Overall Average\n");

                    // Ensure that data is available before processing
                    if (students.size() != 0) {
                        System.out.println("Overall Average : " + overallAverage() + "\n");
                    } else {
                        System.out.println("Cannot perform process due " +
                                "to the unavailability of data \n");
                    }

                    backToMenu();
                    break;

                case "4":

                    System.out.println("\nYou selected number 4 Highest Component Scorer\n");

                    int rep = 0;

                    // Ensure that data is available before processing
                    if (students.size() != 0 && highestScorer().size() != 0) {
                        for (List<Student> member : highestScorer()){
                            for (Student student : member){
                                if (rep == 0) {
                                    System.out.println("ICT_1 Highest Scorer/s     ; \n");
                                } else if (rep == 1) {
                                    System.out.println("ICT_2 Highest Scorer/s     ; \n");
                                } else if (rep == 2){
                                    System.out.println("CW_1 Highest Scorer/s      ; \n");
                                }else if (rep == 3){
                                    System.out.println("CW_2 Highest Scorer/s      ; \n");
                                }else {
                                    System.out.println("Overall Highest Scorer/s   ; \n");
                                }
                                System.out.println("Registration No : " + student.getRegNo());
                                System.out.println("First Name      : " + student.getfName());
                                System.out.println("Last Name       : " + student.getlName());
                                System.out.println("ICT 01 Score    : " + student.getIct_01_marks());
                                System.out.println("ICT 02 Score    : " + student.getIct_02_marks());
                                System.out.println("CW 01 Score     : " + student.getCw_01_marks());
                                System.out.println("CW 02 Score     : " + student.getCw_02_marks());
                                System.out.println("Grade Obtained  : " + student.getGrade());
                                System.out.println("Class Average   : " + overallAverage());
                                System.out.println("Overall Score   : " + student.getFinalMarks() + "\n");
                            }
                            System.out.println("========================================================");
                            rep++;
                        }
                    } else {
                        System.out.println("Cannot perform process due " +
                                "to the unavailability of data \n");
                    }

                    backToMenu();
                    break;

                case "5":

                    System.out.println("\nYou selected number 5 Lowest Overall Scorer\n");

                    // Ensure that data is available before processing
                    if (students.size() != 0 && lowestScorer().size() != 0) {
                        for (Student member : lowestScorer()) {
                            System.out.println("Registration No : " + member.getRegNo());
                            System.out.println("First Name      : " + member.getfName());
                            System.out.println("Last Name       : " + member.getlName());
                            System.out.println("ICT 01 Score    : " + member.getIct_01_marks());
                            System.out.println("ICT 02 Score    : " + member.getIct_02_marks());
                            System.out.println("CW 01 Score     : " + member.getCw_01_marks());
                            System.out.println("CW 02 Score     : " + member.getCw_02_marks());
                            System.out.println("Grade Obtained  : " + member.getGrade());
                            System.out.println("Class Average   : " + overallAverage());
                            System.out.println("Overall Score   : " + member.getFinalMarks() + "\n");
                        }
                    } else {
                        System.out.println("Cannot perform process due " +
                                "to the unavailability of data \n");
                    }

                    backToMenu();
                    break;

                case "6":

                    System.out.println("\nYou selected number 6 Students Above Average\n");

                    // Ensure that data is available before processing
                    if (students.size() != 0 && aboveAverageStudents().size() != 0) {
                        for (Student member : aboveAverageStudents()) {
                            System.out.println("Registration No : " + member.getRegNo());
                            System.out.println("First Name      : " + member.getfName());
                            System.out.println("Last Name       : " + member.getlName());
                            System.out.println("Grade Obtained  : " + member.getGrade());
                            System.out.println("Class Average   : " + overallAverage());
                            System.out.println("Overall Score   : " + member.getFinalMarks() + "\n");
                        }
                    } else {
                        System.out.println("Cannot perform process due " +
                                "to the unavailability of data \n");
                    }

                    backToMenu();
                    break;

                case "7":

                    System.out.println("\nYou selected number 7 Students Below Average\n");

                    // Ensure that data is available before processing
                    if (students.size() != 0 && belowAverageStudents().size() != 0) {
                        for (Student member : belowAverageStudents()) {
                            System.out.println("Registration No : " + member.getRegNo());
                            System.out.println("First Name      : " + member.getfName());
                            System.out.println("Last Name       : " + member.getlName());
                            System.out.println("Grade Obtained  : " + member.getGrade());
                            System.out.println("Class Average   : " + overallAverage());
                            System.out.println("Overall Score   : " + member.getFinalMarks() + "\n");
                        }
                    } else {
                        System.out.println("Cannot perform process due " +
                                "to the unavailability of data \n");
                    }

                    backToMenu();
                    break;

                case "8":

                    System.out.println("\nYou selected number 8 No:of Students " +
                            "Below Average for each Component\n");

                    messages.add("ICT 01 : ");
                    messages.add("ICT 02 : ");
                    messages.add("CW 01  : ");
                    messages.add("CW 02  : ");

                    // Ensure that data is available before processing
                    if (students.size() != 0 && getComponentScoreBelow_30().size() != 0) {
                        for (int member : getComponentScoreBelow_30()) {
                            System.out.print(messages.get(count));
                            System.out.println(member);
                            count = count + 1;
                        }
                        System.out.println();
                        messages.clear();
                        count = 0;
                    } else {
                        System.out.println("Cannot perform process due " +
                                "to the unavailability of data \n");
                    }

                    backToMenu();
                    break;

                case "9":

                    System.out.println("\n You selected number 9 Resit Students for each " +
                            "Component\n");

                    int counter = 0;

                    // Ensure that data is available before processing
                    if (students.size() != 0 && resitStudents().size() != 0) {
                        for (List<Student> member : resitStudents()) {
                            if (counter == 0) {
                                System.out.println("ICT Resit Students  ; \n");
                            } else if (counter == 1) {
                                System.out.println("CW_1 Resit Students ; \n");
                            } else {
                                System.out.println("CW_2 Resit Students ; \n");
                            }
                            for (Student student : member) {
                                System.out.println("Registration No : " + student.getRegNo());
                                System.out.println("First Name      : " + student.getfName());
                                System.out.println("Last Name       : " + student.getlName());
                                System.out.println("ICT 01 Score    : " + student.getIct_01_marks());
                                System.out.println("ICT 02 Score    : " + student.getIct_02_marks());
                                System.out.println("CW 01 Score     : " + student.getCw_01_marks());
                                System.out.println("CW 02 Score     : " + student.getCw_02_marks());
                                System.out.println("Class Average   : " + overallAverage());
                                System.out.println("Overall Score   : " + student.getFinalMarks() + "\n");
                            }
                            System.out.println("========================================================");
                            counter++;
                        }
                    }else {
                        System.out.println("Cannot perform process due " +
                                "to the unavailability of data \n");
                    }


                    backToMenu();
                    break;

                case "10":

                    System.out.println("\nYou selected number 10 Retake Students\n");

                    // Ensure that data is available before processing
                    if (students.size() != 0 && retakeStudents().size() != 0) {
                        for (Student member : retakeStudents()) {
                            System.out.println("Registration No : " + member.getRegNo());
                            System.out.println("First Name      : " + member.getfName());
                            System.out.println("Last Name       : " + member.getlName());
                            System.out.println("Overall Score   : " + member.getFinalMarks() + "\n");
                        }
                    } else {
                        System.out.println("Cannot perform process due " +
                                "to the unavailability of data \n");
                    }

                    backToMenu();
                    break;

                case "11":

                    System.out.println("\nYou selected number 11 Horizontal Histogram\n");

                    new Horizontal_View();

                    backToMenu();
                    break;

                case "12":

                    System.out.println("\nYou selected number 12 Vertical Histogram\n");

                    new Vertical_View();

                    backToMenu();
                    break;

                case "13":

                    System.out.println("\nYou selected number 13 Exit\n");

                    // Exiting from the system
                    System.exit(0);
                    break;

                default:
                    // If an invalid selection is made at the main menu
                    System.out.println("\nInvalid selection through menu. Please try again\n");
                    break;
            }
        }
    }
}
