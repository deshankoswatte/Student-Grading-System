package Comparators;

import StudentClass.*;
import java.util.Comparator;

/* Comparator added as the Student class does not implement comparable
       so to compare a class which does not implement comparable you should
       add a comparator*/

public class FinalMarks implements Comparator<Student> {

    /* An overridden method in the super class Object.
       The method has two arguments where two objects
       of Student must be given then the method will
       compare the final marks of the compared students.
     */
    @Override
    public int compare (Student o1, Student o2){
        return o1.getFinalMarks() - o2.getFinalMarks();
    }
}
