package behavioralPatterns.iterator;

// [이터레이터 패턴 - ConcreteIterator(구체적인 반복자) 역할]
// 실제 순회 로직을 구현한다. 커서(nextIndex)로 현재 위치를 기억하므로,
// 하나의 집합체에 대해 여러 이터레이터가 서로 독립적으로 순회할 수 있다.
public class ConcreteIterator implements Iterator {
    Object[] arr;
    private int nextIndex = 0; // 커서 (for문의 i 변수 역할)

    // 생성자로 순회할 컬렉션을 받아 필드에 참조 시킴
    public ConcreteIterator(Object[] arr) {
        this.arr = arr;
    }

    // 순회할 다음 요소가 있는지 true / false
    @Override
    public boolean hasNext() {
        return nextIndex < arr.length;
    }



    // 다음 요소를 반환하고 커서를 증가시켜 다음 요소를 바라보도록 한다.
    @Override
    public Object next() {
        return arr[nextIndex++];
    }
}
