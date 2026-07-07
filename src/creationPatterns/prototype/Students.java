package creationPatterns.prototype;

import java.util.ArrayList;
import java.util.List;

// [프로토타입 패턴 - 집합 관리자(클라이언트 보조) 역할]
// 학생 프로토타입들의 리스트를 보관한다. getOriginList()는 원본 리스트를 그대로,
// getCloneList()는 각 요소를 clone()한 새 리스트를 만들어 반환한다.
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
