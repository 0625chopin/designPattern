package structuralPattrens.composite;

// [컴포지트 패턴 - Client(사용 예)]
// Leaf(Student)와 Composite(ClazzInfo)를 구분 없이 동일한 방식으로 다룬다.
// 학급 안에 학급(A-CLASS, B-CLASS)을 넣어 트리를 구성하고,
// 최상위 학급의 점수를 요청하면 트리 전체가 재귀적으로 집계된다.
public class Main {
    static void main() {
        // 1. 학급 인스턴스 생성
        ClazzInfo clazzInfoA = new ClazzInfo("A-CLASS");

        // 2. 학생 인스턴스 생성
        Student student1 = new Student("원이", 95);
        Student student2 = new Student("미나미", 100);
        Student student3 = new Student("제나", 85);
        Student student4 = new Student("리브", 93);
        Student student5 = new Student("메이", 88);

        clazzInfoA.addStudent(student1);
        clazzInfoA.addStudent(student2);
        clazzInfoA.addStudent(student3);
        clazzInfoA.addStudent(student4);
        clazzInfoA.addStudent(student5);


        // 3. 학급 인스턴스 생성
        ClazzInfo clazzInfoB = new ClazzInfo("B-CLASS");
        Student student6 = new Student("장원영", 95);
        Student student7 = new Student("카리나", 100);
        Student student8 = new Student("윈터", 85);

        clazzInfoB.addStudent(student6);
        clazzInfoB.addStudent(student7);
        clazzInfoB.addStudent(student8);


        ClazzInfo clazzInfo = new ClazzInfo("CLASS");
        clazzInfo.addStudent(clazzInfoA);
        clazzInfo.addStudent(clazzInfoB);

        Main m = new Main();
        m.printScore(clazzInfoA);
        m.printScore(clazzInfoB);
        m.printScore(clazzInfo);

    }

    public void printScore(ClazzInfo classInfo) {
        int mathScore = classInfo.getMathScore();
        double avg = classInfo.getAverageScore();
        System.out.println(classInfo.getName() +" 의 수학 점수의 합 : " +  mathScore + " 평균 : " + avg);
    }

}
