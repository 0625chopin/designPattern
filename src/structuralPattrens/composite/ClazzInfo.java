package structuralPattrens.composite;

import java.util.ArrayList;
import java.util.List;

// [컴포지트 패턴 - Composite(복합 객체) 역할]
// 자식(StudentInfo) 목록을 가지며, 요청을 자식들에게 재귀적으로 위임한다.
// 자식 목록의 타입이 StudentInfo이므로 학생(Student)뿐 아니라
// 또 다른 학급(ClazzInfo)도 담을 수 있어 계층을 무한히 중첩할 수 있다.
public class ClazzInfo implements StudentInfo {

    private String ClazzName;  // 학급 이름
    // 자식 목록: Leaf(Student)와 Composite(ClazzInfo)를 함께 담을 수 있다
    private List<StudentInfo> studentInfoList = new ArrayList<>();

    public ClazzInfo(String ClazzName) {
        this.ClazzName = ClazzName;
    }

    // 리스트에 학생 & 클래스 추가
    public void addStudent(StudentInfo studentInfo) {
        studentInfoList.add(studentInfo);
    }

    public List<StudentInfo> getStudentInfoList() {
        return studentInfoList;
    }


    @Override
    public String getName() {
        return ClazzName;
    }

    @Override
    public int getMathScore() {
        int sum = 0;
        // 만일 리스트에서 가져온 요소가 student이면 정수값을 받을 것이고, ClassInfo '재귀 함수' 동작이 되게 된다
        for(StudentInfo s : studentInfoList) {
            sum += s.getMathScore();
        }
        return sum;
    }

    @Override
    public int getStudentCount() {
        int count = 0;
        // 만일 리스트에서 가져온 요소가 student이면 정수값을 받을 것이고, ClassInfo '재귀 함수' 동작이 되게 된다
        for(StudentInfo s : studentInfoList) {
            count += s.getStudentCount();
        }
        return count;
    }

    public double getAverageScore() {
        return (double)getMathScore() / getStudentCount();
    }
}
