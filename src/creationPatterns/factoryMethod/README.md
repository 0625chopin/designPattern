# 팩토리 패턴 (Factory Pattern)

> 📁 상위 문서: [생성 패턴 목록](../README.md)

## 개요

팩토리 패턴은 **객체 생성 로직을 별도의 팩토리로 분리**하여, 클라이언트가 `new`로 구체 클래스를 직접 생성하지 않도록 하는 생성(Creational) 패턴이다.

이 예제는 결제 수단을 소재로 한다. 클라이언트는 `"CARD"`, `"NAVER"` 같은 문자열만 팩토리에 넘기고, 팩토리가 그에 맞는 결제 객체(`Payment`)를 만들어 돌려준다. 클라이언트는 반환된 객체가 구체적으로 무엇인지 몰라도 `Payment` 인터페이스의 `pay()`만 호출하면 된다.

> ⚠️ 폴더명은 `factoryMethod`지만, 실제 구현은 문자열을 `switch`로 분기하는 **단순 팩토리(Simple/Static Factory)** 형태다. 엄밀한 GoF 팩토리 메서드와의 차이는 아래 [참고](#참고) 참조.

## 왜 사용하는가

- **생성과 사용의 분리**: 객체를 만드는 코드(팩토리)와 쓰는 코드(클라이언트)를 떼어내 결합도를 낮춘다.
- **구체 클래스 은닉**: 클라이언트는 `Payment` 인터페이스에만 의존하고 `CardPayment`, `NaverPayment` 같은 구현체를 알 필요가 없다.
- **생성 로직 일원화**: 어떤 타입일 때 어떤 객체를 만들지에 대한 결정을 팩토리 한곳에 모아, 중복과 변경 지점을 줄인다.
- **미지원 타입 방어**: 알 수 없는 타입이 들어오면 예외를 던져 잘못된 생성을 조기에 차단한다.

## 구성 요소 (역할)

| 역할 | 클래스 / 파일 | 설명 |
|------|--------------|------|
| 제품 (Product) | `Payment` (interface) | 팩토리가 반환하는 객체들의 공통 타입. `pay()` 선언 |
| 구체 제품 (ConcreteProduct) | `CardPayment` | 카드 결제 구현. `"CARD"` 분기에서 생성 |
| 구체 제품 (ConcreteProduct) | `NaverPayment` | 네이버페이 결제 구현. `"NAVER"` 분기에서 생성 |
| 팩토리 (Factory) | `PaymentFactory` | `static create(String type)`에서 `switch`로 분기해 제품 생성, 미지원 타입은 예외 |
| 클라이언트 (Client) | `client.Main` | 진입점. 문자열로 객체를 요청하고 `pay()` 호출 |

## 핵심 포인트

- `PaymentFactory.create(type)`는 **정적 메서드**라 인스턴스 없이 호출한다.
- 내부에서 `type.toUpperCase()`로 대소문자를 정규화한 뒤 `switch`로 분기한다.
- 반환 타입이 인터페이스(`Payment`)이므로, 클라이언트 코드는 구체 타입에 묶이지 않는다.
- `default` 절에서 `IllegalArgumentException("지원하지 않는 결제 방식")`을 던져 미지원 타입을 막는다.
- 새 결제 수단을 추가하려면 새 `ConcreteProduct` 클래스와 `switch`의 `case`를 추가한다. (팩토리 코드 수정이 필요 → OCP 관점의 한계, [참고](#참고) 참조)

## 실행 흐름 예시

```java
// client.Main
Payment payment1 = PaymentFactory.create("CARD");   // -> CardPayment 반환
payment1.pay();

Payment payment3 = PaymentFactory.create("NAVER");  // -> NaverPayment 반환
payment3.pay();
```

예상 출력:

```
카드 결제
Naver 페이 결제
```

만약 지원하지 않는 타입을 넘기면:

```java
PaymentFactory.create("KAKAO"); // IllegalArgumentException: 지원하지 않는 결제 방식
```

## 참고

이 예제는 GoF의 **팩토리 메서드(Factory Method)** 패턴이 아니라 **단순 팩토리(Simple/Static Factory)** 관용구에 해당한다.

- **단순 팩토리 (이 예제)**: 하나의 팩토리 클래스가 `static create(String type)` 안에서 `switch`(문자열 분기)로 어떤 객체를 만들지 결정한다. 구현이 간단하지만, 결제 수단이 늘 때마다 팩토리의 분기문을 수정해야 하므로 **OCP(개방-폐쇄 원칙)를 완전히 만족하지 못한다.**
- **GoF 팩토리 메서드**: 객체 생성을 담당하는 메서드를 **추상 메서드로 선언**하고, 어떤 구체 객체를 만들지는 **서브클래스가 오버라이딩으로 결정**한다. 즉 "무엇을 생성할지"의 결정이 조건 분기가 아니라 **상속(다형성)** 으로 넘어간다. 새 제품을 추가할 때 기존 팩토리를 수정하는 대신 새 서브클래스를 만드는 방향이라 확장에 더 유연하다.

정리하면, 이 예제는 팩토리 패턴의 **핵심 아이디어(생성 로직의 캡슐화·구체 클래스 은닉)** 를 가장 단순한 형태로 보여주는 학습용 구현이며, 규모가 커지면 GoF 팩토리 메서드나 추상 팩토리로 발전시키는 것이 자연스럽다.
