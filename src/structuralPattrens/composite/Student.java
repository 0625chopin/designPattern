package structuralPattrens.composite;

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
