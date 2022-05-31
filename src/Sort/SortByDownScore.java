package Sort;

import Model.Student;

import java.util.Comparator;

public class SortByDownScore implements Comparator<Student> {

    public int compare(Student o1, Student o2) {
        if (o1.getScore() - o2.getScore() < 0)
            return 1;
        else if (o1.getId() - o2.getId() == 0)
            return 0;
        else return -1;
    }

}


