package structuralPattrens.composite;

// [컴포지트 패턴 - Component(공통 인터페이스) 역할]
// 개별 객체(Leaf)와 복합 객체(Composite)가 공통으로 구현하는 타입.
// 클라이언트는 이 인터페이스만 알면 되고, 상대가 학생인지 학급인지 구분할 필요가 없다.
// 이 "동일한 인터페이스"가 잎과 가지를 같은 방식으로 다룰 수 있게 하는 핵심이다.
public interface StudentInfo {
    String getName();
    int getMathScore();
    int getStudentCount();
}
