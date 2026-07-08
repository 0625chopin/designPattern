package behavioralPatterns.iterator;

// [이터레이터 패턴 - Client(사용 예) 역할]
// 집합체에서 이터레이터를 받아 hasNext()/next()만으로 순회한다.
// 내부가 배열인지 리스트인지 전혀 몰라도 동일한 방식으로 접근할 수 있다.
public class Main {
    static void main() {
        // 1. 집합체 생성
        ConcreteAggregate aggregate = new ConcreteAggregate(5);
        aggregate.add(1);
        aggregate.add(2);
        aggregate.add(3);
        aggregate.add(4);
        aggregate.add(5);

        // 2. 집합체에서 이터레이터 객체 반환
        Iterator iter = aggregate.iterator();

        // 3. 이터레이터 내부 커서를 통해 순회
        while(iter.hasNext()) {
            System.out.printf("%s → ", iter.next());
        }
    }
}
