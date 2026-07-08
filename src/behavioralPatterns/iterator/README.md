# 이터레이터 (Iterator) 패턴

> 📁 상위 문서: [행위 패턴 README](../README.md)

컬렉션(집합체)의 **내부 표현 방식을 노출하지 않고** 그 요소들에 순차적으로 접근하는 방법을 제공하는 행위 패턴이다.
순회 로직을 이터레이터라는 별도 객체로 분리하여, 집합체의 구조(배열·리스트·트리 등)가 바뀌어도 클라이언트 코드는 동일한 방식(`hasNext` / `next`)으로 순회할 수 있다.

## 구성 요소 (역할)

| 역할 | 클래스 | 설명 |
|------|--------|------|
| **Iterator** | [`Iterator`](./Iterator.java) | 순회 인터페이스. 다음 요소 존재 여부(`hasNext`)와 다음 요소 반환(`next`)을 정의 |
| **ConcreteIterator** | [`ConcreteIterator`](./ConcreteIterator.java) | 실제 순회 구현. 내부 커서(`nextIndex`)로 현재 위치를 기억하며 요소를 하나씩 반환 |
| **Aggregate** | [`Aggreaget`](./Aggreaget.java) | 집합체 인터페이스. 자신을 순회할 이터레이터를 생성(`iterator`)하는 책임 정의 |
| **ConcreteAggregate** | [`ConcreteAggregate`](./ConcreteAggregate.java) | 실제 집합체. 요소를 담고, 자신에 맞는 `ConcreteIterator`를 생성해 반환 |
| **Client** | [`Main`](./Main.java) | 집합체에서 이터레이터를 얻어 내부 구조를 모른 채 순회 |

## 실행 흐름

```
1. 집합체 생성 후 요소 추가        ConcreteAggregate.add(...)
2. 집합체에서 이터레이터 반환      aggregate.iterator() → ConcreteIterator
3. 커서로 순차 순회                while(iter.hasNext()) iter.next()
```

실행 결과:

```
1 → 2 → 3 → 4 → 5 →
```

## 핵심 정리

- 집합체의 **순회 책임을 이터레이터로 분리**해 단일 책임 원칙(SRP)을 지킨다.
- 커서 상태를 이터레이터가 보유하므로, 하나의 집합체에 대해 **여러 순회를 독립적으로** 진행할 수 있다.
- 클라이언트는 내부가 배열인지 리스트인지 몰라도 `hasNext` / `next`만으로 순회 가능하다.
