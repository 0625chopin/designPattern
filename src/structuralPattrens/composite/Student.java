package structuralPattrens.composite;

// [컴포지트 패턴 - Leaf(잎 / 개별 객체) 역할]
// 더 이상 자식이 없는 트리의 말단 객체.
// Composite처럼 재귀하지 않고 자기 자신의 값을 그대로 반환한다.
// (getStudentCount()는 학생 한 명이므로 항상 1을 반환한다.)
public class Student implements StudentInfo {
    private String name;
    private int mathScore;


    public Student(String name, int mathScore) {
        this.name = name;
        this.mathScore = mathScore;
    }

    @Override
    public int getMathScore() {
        return mathScore;
    }

    @Override
    public int getStudentCount() {
        return 1;
    }

    @Override
    public String getName() {
        return name;
    }
}
