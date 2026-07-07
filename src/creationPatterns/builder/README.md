# 빌더 패턴 (Builder Pattern)

> 📁 상위 문서: [생성 패턴 목록](../README.md)

## 개요

빌더 패턴은 복잡한 객체의 **생성 과정과 표현을 분리**하여, 동일한 생성 절차로 서로 다른 구성의 객체를
만들 수 있게 하는 생성(Creational) 패턴이다.

이 예제에서는 여러 개의 필드(주문번호, PC 번호, CPU 제조사/모델, RAM 제조사/모델)를 가진 `Pc` 객체를
`Pc.Builder`를 통해 단계적으로 조립한다. `Pc`는 모든 필드가 `final`인 불변 객체이며, 생성자는 `private`으로
감춰져 있어 오직 빌더를 통해서만 생성할 수 있다.

## 왜 사용하는가

필드가 많은 객체를 생성할 때 흔히 겪는 문제를 해결한다.

- **점층적 생성자(텔레스코핑 생성자, Telescoping Constructor) 문제**
  선택 필드가 늘어날수록 `Pc(a, b)`, `Pc(a, b, c)`, `Pc(a, b, c, d)` … 처럼 매개변수 조합마다
  생성자를 오버로딩해야 하고, 개수가 많아질수록 조합 폭발과 가독성 저하가 발생한다.
- **매개변수 순서/의미 혼동**
  `new Pc(1, 1, "INTEG", "I9", "Hynix", "32G")`처럼 같은 타입(String)이 나열되면 어떤 인자가
  무엇인지 알기 어렵고, 순서를 바꿔 넣어도 컴파일 오류로 잡히지 않는다.
- **불변성 확보의 어려움**
  세터로 값을 채우면 객체가 완성된 뒤에도 상태가 바뀔 수 있다.

빌더 패턴은 필수값과 선택값을 구분하고, 이름이 드러나는 메서드 체이닝으로 값을 설정하며,
`build()` 시점에 불변 객체를 완성해 이러한 문제를 해결한다.

## 구성 요소 (역할)

| 역할 | 클래스 | 설명 |
| --- | --- | --- |
| 제품 (Product) | `Pc` | 최종 생성 대상 객체. 모든 필드가 `final`이며 생성자는 `private`. `builder(...)` 정적 진입점 제공 |
| 빌더 (Builder) | `Pc.Builder` | 정적 중첩 클래스. 필수값은 생성자로, 선택값은 `this`를 반환하는 세터로 설정 후 `build()`로 `Pc` 생성 |
| 클라이언트 (Client) | `Main` | 빌더를 사용하는 진입점. 체이닝으로 원하는 값만 설정하고 `build()` 호출 |

## 핵심 포인트

- **불변 객체(Immutable)**: `Pc`의 모든 필드는 `final`이고 세터가 없다. `private` 생성자는 `Builder`만
  호출할 수 있어, 완성된 이후에는 상태가 변하지 않는다.
- **메서드 체이닝(Fluent API)**: 각 선택값 세터가 `this`(Builder)를 반환하므로
  `.cpuBrand(...).cpuModel(...)...` 형태로 연속 호출할 수 있다.
- **필수값 / 선택값 구분**: 필수값(`pcOrderNo`, `pcNumber`)은 `Pc.builder(int, int)` 및 `Builder`
  생성자로 강제하고, 선택값(CPU/RAM 등)은 필요한 것만 세터로 설정한다.

## 실행 흐름 예시

```java
Pc pc1 = Pc.builder(1, 1)   // 필수값(주문번호, PC번호)을 생성자로 전달 → Builder 반환
        .cpuBrand("INTEG")  // 선택값을 체이닝으로 설정 (this 반환)
        .cpuModel("I9")
        .ramBrand("Hynix")
        .ramModel("32G")
        .build();           // 설정된 값으로 불변 Pc 객체 조립

System.out.println(pc1);
```

예상 출력:

```text
Pc{pcOrderNo=1, pcNumber=1, cpuBrand='INTEG', cpuModel='I9', ramBrand='Hynix', ramModel='32G'}
```

> 참고: 위 출력의 `INTEG`는 예제 코드(`Main.java`)에 작성된 문자열 그대로이다.
