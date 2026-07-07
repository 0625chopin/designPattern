# 브릿지 패턴 (Bridge Pattern)

## 개요
브릿지 패턴은 **추상화(기능 계층)** 와 **구현(구현 계층)** 을 분리하여
두 계층을 **독립적으로 확장**할 수 있게 하는 구조(Structural) 패턴이다.

두 계층은 상속이 아닌 **합성(참조)** 으로 연결되며, 이 참조가 곧 두 계층을 잇는 "다리(Bridge)"다.

## 왜 사용하는가
상속만으로 조합을 표현하면 클래스가 폭증한다.

- 상속 방식: `메인보드 종류 x CPU 종류 x RAM 종류` 만큼 클래스 필요
- 브릿지 방식: 각 계층을 **독립적으로 확장**하고, 조합은 **런타임에 자유롭게 구성**

## 구성 요소 (역할)

| 역할 | 클래스 | 설명 |
|------|--------|------|
| **Abstraction** (추상화 계층) | `MotherBoard` | 구현체(Cpu, Ram)를 필드로 참조하는 상위 수준 기능. 이 참조가 "다리" |
| **RefinedAbstraction** (구체적 추상화) | `GigabyteMotherBoard` | 추상화 계층을 확장한 구체 클래스. 구현 계층과 무관하게 추가 가능 |
| **Implementor** (구현자) | `Cpu`, `Ram` | 구현 계층의 인터페이스. 추상화 계층은 이 인터페이스에만 의존 |
| **ConcreteImplementor** (구체적 구현자) | `IntelCup`, `SamsungRam` | 구현 계층의 실제 구현체. 세부 동작만 책임 |
| **Client** (사용 예) | `Main` | 추상화와 구현을 런타임에 원하는 대로 조합 |

## 구조

```
      [ 추상화 계층 ]              [ 구현 계층 ]

      MotherBoard  ────(다리)────▶  Cpu (interface)
          △                            △
          │                            │
   GigabyteMotherBoard             IntelCup

      MotherBoard  ────(다리)────▶  Ram (interface)
                                       △
                                       │
                                   SamsungRam
```

## 핵심 포인트
- **상속 대신 합성**으로 계층을 연결해 조합 폭증을 방지한다.
- 추상화 계층(메인보드 종류)과 구현 계층(CPU/RAM 제조사)을 **서로 영향 없이 독립적으로 확장**할 수 있다.
- 구현 계층을 여러 축(`Cpu`, `Ram`)으로 나눠 각각 독립적으로 확장할 수 있다.
- 클라이언트는 조립 부분만 바꾸면 되고, 각 계층 클래스는 수정할 필요가 없다.

## 예제 실행 흐름
```java
MotherBoard mb = new GigabyteMotherBoard(new IntelCup(), new SamsungRam());
mb.boot();
```
```
부팅 시작!
SANSUNG RAM 체크   // ram.load()  -> SamsungRam
Integ Cpu 체크     // cpu.execute() -> IntelCup
```
