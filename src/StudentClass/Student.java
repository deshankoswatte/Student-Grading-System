package StudentClass;

import Enum.*;
import java.io.Serializable;

public class Student implements Serializable {

    // Encapsulating data fields so they cannot be accessed directly
    private String fName;
    private String lName;
    private int regNo;
    private int ict_01_marks;
    private int ict_02_marks;
    private int cw_01_marks;
    private int cw_02_marks;
    private int finalMarks;
    private Grade grade;

    // Default Constructor. I have added this cause this improves coding standards
    public Student() {

    }

    // Non default constructor
    public Student(String fName, String lName, int regNo, int ict_01_marks,
                   int ict_02_marks, int cw_01_marks, int cw_02_marks) {
        this.fName = fName;
        this.lName = lName;
        this.regNo = regNo;
        this.ict_01_marks = ict_01_marks;
        this.ict_02_marks = ict_02_marks;
        this.cw_01_marks = cw_01_marks;
        this.cw_02_marks = cw_02_marks;
        this.finalMarks = this.getFinalMarks();
        this.grade = this.getGrade();
    }

    // Getter and Setter methods
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public int getIct_01_marks() {
        return ict_01_marks;
    }

    public int getIct_02_marks() {
        return ict_02_marks;
    }

    public int getCw_01_marks() {
        return cw_01_marks;
    }

    public int getCw_02_marks() {
        return cw_02_marks;
    }

    public int getFinalMarks() {
        this.finalMarks = (int) Math.round((this.ict_01_marks * 0.2) +
                (this.ict_02_marks * 0.2) + (this.cw_01_marks * 0.3) +
                (this.cw_02_marks * 0.3));
        return finalMarks;
    }

    public Grade getGrade() {
        if ((((this.ict_01_marks + this.ict_02_marks) / 2) >= 30) &&
                this.cw_01_marks >= 30 && this.cw_02_marks >= 30
                && this.finalMarks >= 40) {
            if (this.finalMarks >= 70) {
                this.grade = Grade.First_Class;
            } else if (this.finalMarks >= 60) {
                this.grade = Grade.Second_Upper_Class;
            } else if (this.finalMarks >= 50) {
                this.grade = Grade.Second_Lower_Class;
            } else {
                this.grade = Grade.General_Pass;
            }
        } else if (this.finalMarks >= 30) {
            this.grade = Grade.Fail_Resit;
        } else {
            this.grade = Grade.Fail_Retake;
        }
        return grade;
    }
}
