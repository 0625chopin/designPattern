package creationPatterns.prototype;

import java.util.ArrayList;
import java.util.List;

public class Students {
    private final List<Student> studentsList;

    public Students(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public List<Student> getCloneList() throws CloneNotSupportedException {
        List<Student> clone = new ArrayList<>();

        for(Student s : studentsList) {
            Student cloneStudent = s.clone();
            clone.add(cloneStudent);
        }
        return clone;
    }

    public List<Student> getOriginList() {
        return studentsList;
    }
}
