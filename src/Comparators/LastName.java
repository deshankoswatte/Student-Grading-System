package Comparators;

import java.util.Comparator;
import StudentClass.*;

/* Comparator added as the Student class does not implement comparable
       so to compare a class which does not implement comparable you should
       add a comparator*/

public class LastName implements Comparator <Student> {

    /* An overridden method in the super class Object.
       The method has two arguments where two objects
       of Student must be given then the method will
       compare the last name of the compared students.
     */
    @Override
    public int compare (Student o1, Student o2){
        return o1.getlName().compareTo(o2.getlName());
    }
}
