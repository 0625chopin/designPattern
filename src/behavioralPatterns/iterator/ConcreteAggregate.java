package behavioralPatterns.iterator;

// [이터레이터 패턴 - ConcreteAggregate(구체적인 집합체) 역할]
// 요소를 실제로 담는 집합체. 내부는 배열로 구현되어 있다.
// iterator() 호출 시 자신의 데이터를 순회할 ConcreteIterator를 만들어 넘긴다.
public class ConcreteAggregate implements  Aggreaget {

    Object[] arr;
    int index = 0;

    public ConcreteAggregate(int size) {
        this.arr = new Object[size];
    }

    public void add(Object o) {
        if(index < arr.length) {
            arr[index] = o;
            index++;
        }
    }

    // 자신의 내부 배열을 넘겨 순회 전용 이터레이터를 생성
    @Override
    public Iterator iterator() {
        return new ConcreteIterator(arr);
    }
}
