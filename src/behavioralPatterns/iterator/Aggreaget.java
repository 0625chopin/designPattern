package behavioralPatterns.iterator;

// [이터레이터 패턴 - Aggregate(집합체 인터페이스) 역할]
// 자신을 순회할 이터레이터를 생성하는 책임을 정의한다.
// 집합체와 순회 로직을 분리해, 집합체는 "이터레이터를 만든다"는 계약만 가진다.
interface Aggreaget {
    Iterator iterator();  // 자신에 맞는 ConcreteIterator를 생성해 반환
}
