package creationPatterns.prototype;

// [프로토타입 패턴 - 프로토타입(ConcretePrototype) 역할]
// 복제 대상이 되는 실제 객체다. Cloneable을 구현하고 clone()에서
// super.clone()으로 자기 자신을 복제(얕은 복사)해 반환한다.
public class Student implements Cloneable {

    private int no;
    private String name;

    public Student(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        // super.clone()은 필드 값을 그대로 복사하는 얕은 복사(shallow copy)를 수행한다.
        return (Student) super.clone();
    }
}
