package creationPatterns.prototype;

import java.util.List;

/**
 * Prototype 패턴이 생겨난 배경
 *   객체 생성이 점점 무거워짐
 *   같은 형태의 객체를 계속 만들어야 함
 *   생성 로직을 캡슐화하고 싶음
 *
 *
 *  Prototype 패턴은 기존 객체를 복제하여 새로운 객체를 생성하는 생성 패턴이다.
 *    객체 생성 비용을 줄인다
 *    생성 과정을 단순화한다
 *    객체 생성 책임을 객체 자신에게 넘긴다
 *
 *  언제 사용되는가
 *     객체 생성이 비용이 클 때
 *     같은 구조의 객체를 반복 생성할 때
 *     런타임에 객체 종류가 결정될 때
 */
public class Main {
    static void main() throws CloneNotSupportedException {
        Student s1 = new Student(1, "김");
        Student s2 = new Student(2, "이");
        Student s3 = new Student(3, "최");
        Student s4 = new Student(4, "조");

        List<Student> studentList = List.of(s1, s2, s3, s4);

        Students ss = new Students(studentList);

        List<Student> originList = ss.getOriginList();  // 같은 인스턴스
        List<Student> cloneList = ss.getCloneList();  // clone 인스턴스

        System.out.println(studentList == originList);  // true
        System.out.println(studentList == cloneList);  //false

        Student originalStuedent = studentList.get(0);  // 같은 인스턴스의 0번째 student
        Student cloneStudent = cloneList.get(0);  // clone 인스턴스의 0번째 student

        System.out.println(originalStuedent == cloneStudent);  // false

    }
}
