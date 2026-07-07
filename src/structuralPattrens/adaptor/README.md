# 어댑터 패턴 (Adapter Pattern)

## 개요
어댑터 패턴은 **서로 호환되지 않는 인터페이스를 연결**하여
**기존 코드를 수정하지 않고 함께 사용**할 수 있게 하는 구조(Structural) 패턴이다.

콘센트 모양이 달라 바로 꽂을 수 없을 때 "변환 어댑터"를 끼우는 것과 같은 원리다.

## 왜 사용하는가
- 이미 사용 중인 기존 시스템(Legacy)이 있고, 새 시스템은 다른 인터페이스를 쓴다.
- 기존 코드를 수정하기 어렵거나, 수정하면 영향 범위가 크다.
- 인터페이스가 달라 직접 사용할 수 없는 두 코드를 **어댑터(변환기)** 로 이어 붙인다.

## 구성 요소 (역할)

| 역할 | 설명 |
|------|------|
| **Target** (원하는 형태) | 클라이언트가 사용하고자 하는 인터페이스 |
| **Adaptee** (기존 시스템) | 실제 기능은 있지만 Target과 형태가 달라 직접 못 쓰는 대상 |
| **Adapter** (변환기) | Target을 구현하면서 Adaptee를 참조해, 호출을 변환/위임 |
| **Client** (사용 예) | Target 인터페이스만 알고 사용 |

## 구조

```
   Client ──▶ Target (원하는 인터페이스)
                 △
                 │ implements
              Adapter ──────▶ Adaptee (기존 시스템)
                    (Target 호출을 Adaptee 호출로 변환·위임)
```

---

## 예제 1 — type1 (USB 변환)
기존 프로그램(UsbB)은 그대로 두고 UsbC 장치를 연결하고 싶은 상황.

| 역할 | 클래스 |
|------|--------|
| **Target** | `UsbB` |
| **Adaptee** | `UsbC` |
| **Adapter** | `UsbAdaptor` |
| **Client** | `UsbAdaptorMain` |

`UsbAdaptor`는 `UsbB`를 구현하면서 `UsbC`를 참조하고,
`usbB()` 호출을 내부에서 `usbC.usbC()`로 변환한다.

## 예제 2 — type2 (MotorCycle → Car)
`MotorCycle`만 쓰던 Legacy 시스템을 재사용해 새로운 `Car` 시스템에서 쓰고 싶은 상황.

| 역할 | 클래스 |
|------|--------|
| **Target** | `Car` |
| **Adaptee** | `MotorCycle` |
| **Concrete Adaptee** | `LegacyMove` |
| **Adapter** | `AdaptorMove` |
| **Client** | `MainMove` |

`AdaptorMove`는 `Car`를 구현하면서 `MotorCycle`을 참조하고,
`getCarModelNm()` 같은 Car 호출을 `getModelNm()` 등 MotorCycle 호출로 변환한다.
어댑터를 통해 값을 바꾸면 **실제 Legacy 객체의 상태도 함께 변경**되는 것이 특징이다.

## 핵심 포인트
- 어댑터는 **Target을 구현(implements)** 하고 **Adaptee를 합성(참조)** 한다.
- 기존 코드(Adaptee)와 클라이언트 코드를 **수정하지 않고** 둘을 연결한다.
- 위 두 예제처럼 어느 방향(UsbC→UsbB, MotorCycle→Car)이든 변환기를 끼워 재사용할 수 있다.
