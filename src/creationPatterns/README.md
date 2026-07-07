# 생성 패턴 (Creational Patterns)

> 📁 상위 문서: [프로젝트 루트 README](../../README.md)

생성 패턴은 **객체의 생성 과정을 캡슐화**하여, 객체를 생성하는 방식을 유연하게 만드는 디자인 패턴이다.
클라이언트가 구체 클래스에 직접 의존하지 않고 객체를 생성하도록 하여 결합도를 낮춘다.

## 패턴 목록

| 패턴 | 한 줄 요약 | 경로 |
|------|-----------|------|
| **싱글턴 (Singleton)** | 인스턴스를 하나만 생성해 공유. thread-safety를 3단계(v1~v3)로 발전시키며 비교 | [`singleton`](./singleton) |
| **팩토리 (Factory)** | 결제 객체 생성 로직을 팩토리로 분리해 `new` 없이 결제 수단 객체를 획득 | [`factoryMethod`](./factoryMethod) |
| **추상 팩토리 (Abstract Factory)** | 종족별(인간/오크) 연관 제품군(무기+갑옷)을 일관성 있게 생성 | [`abstractMethod`](./abstractMethod) |
| **빌더 (Builder)** | 선택적 필드가 많은 불변 PC 객체를 메서드 체이닝으로 단계적 조립 | [`builder`](./builder) |
| **프로토타입 (Prototype)** | `clone()`으로 기존 객체를 복제해 원본과 독립된 인스턴스 획득 | [`prototype`](./prototype) |

## 패턴별 상세

### 싱글턴 (Singleton) — [`singleton`](./singleton)
클래스 인스턴스를 오직 하나만 생성해 공유하는 패턴을 thread-safety 관점에서 3단계로 비교한다.
- `SingletonInstance_v1` — 기본형(lazy). thread-safe 하지 않음
- `SingletonInstance_v2` — `synchronized`로 동기화. 매 호출 lock 비용
- `SingletonInstance_v3` — 정적 내부 클래스 **Holder Idiom**. lazy + thread-safe
- 진입점: `SingletonMain_v1~v3` (v2·v3는 스레드 10개로 동시성 확인)

### 팩토리 (Factory) — [`factoryMethod`](./factoryMethod)
결제 수단 객체 생성을 팩토리로 분리한다. (문자열 분기 기반의 Simple/Static Factory 형태)
- `Payment`(Product) / `CardPayment`, `NaverPayment`(ConcreteProduct)
- `PaymentFactory` — `create(type)`에서 타입 분기 생성
- 진입점: `client.Main` — `"CARD"`, `"NAVER"`로 객체 생성 후 `pay()`

### 추상 팩토리 (Abstract Factory) — [`abstractMethod`](./abstractMethod)
서로 연관된 제품군(무기 + 갑옷)을 종족 단위로 일관성 있게 생성한다.
- `CharacterFactory`(AbstractFactory) / `HumanFacory`, `OrcFactory`(ConcreteFactory)
- `Weapon`, `Ammor`(AbstractProduct) 및 각 종족별 ConcreteProduct
- 진입점: `client.Main` — 팩토리만 교체하면 제품군 전체가 일관되게 바뀜을 시연

### 빌더 (Builder) — [`builder`](./builder)
필수/선택 필드가 섞인 불변 객체를 단계적으로 조립한다.
- `Pc`(Product, 모든 필드 `final`) / `Pc.Builder`(static 중첩 Builder)
- 필수값은 생성자로, 선택값은 체이닝 세터로 설정 후 `build()`
- 진입점: `Main` — `Pc.builder(...).cpuBrand(...)...build()`

### 프로토타입 (Prototype) — [`prototype`](./prototype)
기존 객체를 복제해 원본과 독립된 새 인스턴스를 만든다.
- `Student` — `Cloneable` 구현, `clone()`으로 자기 복제
- `Students` — 원본 리스트와 복제 리스트를 각각 반환
- 진입점: `Main` — 원본/복제 리스트의 참조 비교로 별개 인스턴스임을 확인

## 참고
- `abstractMethod` 폴더는 실제로는 **추상 팩토리 패턴**이다.
- `factoryMethod` 폴더는 엄밀한 GoF 팩토리 메서드보다는 **단순 팩토리(Simple Factory)** 형태에 가깝다.
