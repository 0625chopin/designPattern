package structuralPattrens.composite;

import java.util.ArrayList;
import java.util.List;

public class ClazzInfo implements StudentInfo {

    private String ClazzName;  // 학급 이름
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
