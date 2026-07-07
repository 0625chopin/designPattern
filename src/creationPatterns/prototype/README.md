# 프로토타입 패턴 (Prototype Pattern)

> 📁 상위 문서: [생성 패턴 목록](../README.md)

## 개요

프로토타입 패턴은 **기존 객체(프로토타입)를 복제(clone)** 하여 새로운 객체를 생성하는 생성 패턴이다.
`new`로 처음부터 객체를 만드는 대신, 이미 만들어진 객체를 본떠 같은 상태의 새 인스턴스를 얻는다.
이 예제에서는 `Student`가 `Cloneable`을 구현하고 `clone()`으로 자기 자신을 복제하며,
`Students`가 원본 리스트와 복제 리스트를 각각 제공한다. `Main`은 참조 비교로 복제본이 별개 인스턴스임을 확인한다.

## 왜 사용하는가

- **생성 비용이 큰 객체를 저렴하게 복제**: 객체 생성 과정이 무겁거나(초기화 로직, 외부 자원 접근 등) 복잡할 때, 이미 만들어진 객체를 복제하는 편이 처음부터 생성하는 것보다 효율적이다.
- **같은 구조의 객체를 반복 생성**: 동일한 형태의 객체를 여러 개 만들어야 할 때 프로토타입 하나를 복제해 재사용한다.
- **생성 책임을 객체 자신에게 위임**: 어떻게 복제할지를 객체 스스로(`clone()`)가 알고 있어, 클라이언트가 구체 클래스의 생성 로직을 알 필요가 없다.
- **런타임에 객체 종류 결정**: 어떤 객체를 만들지 실행 시점에 정해질 때, 프로토타입을 교체하는 것만으로 생성 대상을 바꿀 수 있다.

## 구성 요소 (역할)

| 역할 | 클래스 | 설명 |
|------|--------|------|
| Prototype / ConcretePrototype | [`Student`](./Student.java) | `Cloneable` 구현. `clone()`이 `super.clone()`으로 자기 자신을 복제(얕은 복사)한다. 필드: `no`, `name` |
| 집합 관리자 (클라이언트 보조) | [`Students`](./Students.java) | 학생 프로토타입 리스트를 보관. `getOriginList()`는 원본 리스트를, `getCloneList()`는 각 요소를 `clone()`한 새 리스트를 반환 |
| Client (진입점) | [`Main`](./Main.java) | 원본/복제 리스트를 참조 비교(`==`)하여 복제본이 별개 인스턴스임을 확인 |

## 핵심 포인트

- **`Cloneable` + `clone()`**: 자바에서 `Object.clone()`을 사용하려면 마커 인터페이스 `Cloneable`을 구현해야 한다. 그렇지 않으면 `CloneNotSupportedException`이 발생한다. `clone()`은 `super.clone()`을 호출해 실제 복제를 위임한다.
- **얕은 복사(shallow copy)**: `super.clone()`은 필드 값을 그대로 복사한다. `no`(원시 타입), `name`(String, 불변)처럼 값/불변 객체만 있는 경우 얕은 복사로도 충분하다. **복제본과 원본은 서로 다른 인스턴스**가 된다.
- **깊은 복사(deep copy) 주의**: 만약 필드가 **가변 참조 객체**(예: `List`, 사용자 정의 가변 객체)라면, 얕은 복사는 참조만 복사하므로 원본과 복제본이 **같은 내부 객체를 공유**하게 된다. 이때 한쪽에서 내부 객체를 변경하면 다른 쪽에도 영향을 준다. 독립성이 필요하면 `clone()` 안에서 참조 필드까지 새로 복제하는 **깊은 복사**를 직접 구현해야 한다.
- **리스트 복제와 요소 복제는 별개**: `getCloneList()`는 새 `ArrayList`를 만들고 그 안에 각 학생의 `clone()`을 담는다. 따라서 리스트 객체도, 그 안의 요소들도 원본과 다른 인스턴스가 된다.

## 실행 흐름 예시

```java
Student s1 = new Student(1, "김");
Student s2 = new Student(2, "이");
Student s3 = new Student(3, "최");
Student s4 = new Student(4, "조");

List<Student> studentList = List.of(s1, s2, s3, s4);
Students ss = new Students(studentList);

List<Student> originList = ss.getOriginList();  // 원본 리스트 참조 그대로 반환
List<Student> cloneList = ss.getCloneList();    // 각 요소를 clone()한 새 리스트

System.out.println(studentList == originList);  // true  (같은 리스트 인스턴스)
System.out.println(studentList == cloneList);   // false (새로 만든 리스트)

Student originalStudent = studentList.get(0);   // 원본 리스트의 0번째 요소
Student cloneStudent = cloneList.get(0);        // 복제 리스트의 0번째 요소

System.out.println(originalStudent == cloneStudent);  // false (clone()으로 복제된 별개 인스턴스)
```

### 예상 출력

```
true
false
false
```

### 참조 비교 결과 정리

| 비교 | 결과 | 이유 |
|------|------|------|
| `studentList == originList` | `true` | `getOriginList()`가 원본 리스트 참조를 그대로 반환 |
| `studentList == cloneList` | `false` | `getCloneList()`가 새 `ArrayList`를 생성 |
| `originalStudent == cloneStudent` | `false` | 요소가 `clone()`으로 복제된 별개 인스턴스 |
