package behavioralPatterns.iterator;

// [이터레이터 패턴 - Iterator(반복자 인터페이스) 역할]
// 집합체의 요소를 순차적으로 접근하기 위한 공통 인터페이스.
// 클라이언트는 내부 구조(배열·리스트·트리)를 몰라도 이 두 메서드만으로 순회한다.
public interface Iterator {
    boolean hasNext();  // 순회할 다음 요소가 남아 있는지 여부
    Object next();      // 다음 요소를 반환하고 커서를 한 칸 이동
}
