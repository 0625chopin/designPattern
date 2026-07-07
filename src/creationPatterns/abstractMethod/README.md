# 추상 팩토리 패턴 (Abstract Factory Pattern)

> 📁 상위 문서: [생성 패턴 목록](../README.md)

## 개요

추상 팩토리 패턴은 서로 연관되거나 의존적인 객체들의 집합(제품군, Product Family)을
구체적인 클래스를 지정하지 않고 일관되게 생성할 수 있도록 인터페이스를 제공하는
생성(Creational) 디자인 패턴이다.

이 예제는 게임 캐릭터를 소재로 한다. 종족(인간 / 오크)마다 서로 어울리는
**무기(Weapon)** 와 **갑옷(Ammor)** 을 하나의 제품군으로 묶어서 생성한다.
클라이언트는 어떤 팩토리를 선택하느냐에 따라 그 종족에 맞는 무기와 갑옷을
한 번에, 그리고 서로 뒤섞이지 않게 얻는다.

> 핵심 한 줄 요약: "객체를 직접 `new` 하지 않고, 같은 계열의 객체들을 팩토리를 통해 일관성 있게 생성한다."

## 왜 사용하는가

- **제품군의 일관성 보장**: 인간 팩토리를 쓰면 무기도 갑옷도 모두 인간 것으로만 생성된다.
  인간 갑옷에 오크 무기가 섞이는 잘못된 조합을 구조적으로 막는다.
- **구체 클래스로부터의 분리**: 클라이언트는 `HumanWeapon`, `OrcAmmor` 같은 구체 타입을
  전혀 알 필요 없이 `Weapon`, `Ammor`, `CharacterFactory` 같은 추상 타입에만 의존한다.
- **확장 용이성(OCP)**: 새로운 종족(예: 엘프)을 추가하려면 `ElfFactory`와
  그에 맞는 제품 클래스를 추가하기만 하면 되고, 클라이언트 코드는 바꾸지 않아도 된다.
- **교체의 단순함**: 사용할 구체 팩토리 한 줄만 바꾸면 제품군 전체가 통째로 교체된다.

## 구성 요소 (역할)

| 역할 | 클래스 / 인터페이스 | 설명 |
| --- | --- | --- |
| AbstractFactory (추상 팩토리) | `CharacterFactory` | 제품군 생성 메서드 `wearAmmor()`, `equipWeapon()` 를 선언하는 인터페이스 |
| ConcreteFactory (구체 팩토리) | `HumanFacory`, `OrcFactory` | 특정 종족 제품군(무기 + 갑옷)을 실제로 생성 |
| AbstractProductA (추상 제품 A) | `Weapon` | 무기 제품군의 공통 인터페이스 (`equipWepon()`) |
| ConcreteProductA (구체 제품 A) | `HumanWeapon`, `OrcWeapon` | 종족별 무기 구체 제품 |
| AbstractProductB (추상 제품 B) | `Ammor` | 갑옷 제품군의 공통 인터페이스 (`wearAmmor()`) |
| ConcreteProductB (구체 제품 B) | `HumanAmmor`, `OrcAmmor` | 종족별 갑옷 구체 제품 |
| Client (클라이언트) | `client.Main` | 추상 팩토리와 추상 제품에만 의존하는 진입점 |

> 참고: 예제 코드에는 `Ammor`(armor), `HumanFacory`(HumanFactory), `equipWepon`(equipWeapon)
> 등의 오타가 있으나, 학습 원본을 그대로 보존하기 위해 수정하지 않았다.

## 구조

```
                +-----------------------+
   Client ----> |  CharacterFactory     |  (AbstractFactory)
   (Main)       +-----------------------+
                | + wearAmmor(): Ammor  |
                | + equipWeapon():Weapon|
                +-----------+-----------+
                            ^
              +-------------+-------------+
              |                           |
     +----------------+          +----------------+
     |  HumanFacory   |          |   OrcFactory   |  (ConcreteFactory)
     +----------------+          +----------------+
      | 생성           |          | 생성           |
      v                v          v                v
 +-----------+  +-----------+  +----------+  +----------+
 |HumanWeapon|  |HumanAmmor |  |OrcWeapon |  |OrcAmmor  |  (ConcreteProduct)
 +-----------+  +-----------+  +----------+  +----------+
      |              |             |             |
      v              v             v             v
   +--------+     +-------+     +--------+     +-------+
   | Weapon |     | Ammor |     | Weapon |     | Ammor |  (AbstractProduct)
   +--------+     +-------+     +--------+     +-------+
```

- 가로축(제품군): 하나의 팩토리가 무기 + 갑옷을 함께 만든다.
- 세로축(계열): 각 제품은 공통 추상 타입(Weapon / Ammor)을 구현한다.

## 핵심 포인트

- **제품 하나 vs 제품군 전체 — 팩토리 메서드 패턴과의 결정적 차이**
  - 팩토리 메서드 패턴은 팩토리 하나가 **단일 제품** 하나의 생성을 책임진다.
  - 추상 팩토리 패턴은 팩토리 하나가 서로 연관된 **제품군 전체(여기서는 무기 + 갑옷)** 를
    일관되게 생성한다. 즉 추상 팩토리는 "여러 개의 팩토리 메서드를 묶은 상위 개념"으로 볼 수 있다.
- **클라이언트는 추상 타입에만 의존한다.** `Main`은 `CharacterFactory`, `Weapon`, `Ammor`만
  참조하고 어떤 종족의 구체 클래스도 직접 알지 못한다.
- **교체 지점이 단 한 곳이다.** `factory = new HumanFacory();` 를 `new OrcFactory();` 로
  바꾸는 순간, 그 뒤의 무기와 갚옷이 모두 오크 제품군으로 일관되게 바뀐다.
- **잘못된 조합 방지.** 하나의 팩토리는 같은 계열 제품만 반환하므로,
  인간 갑옷 + 오크 무기 같은 섞인 조합이 애초에 생길 수 없다.

## 실행 흐름 예시

```java
CharacterFactory factory;

// 1) 인간 제품군 생성
factory = new HumanFacory();
Ammor wearAmmor = factory.wearAmmor();   // HumanAmmor
Weapon equipWeapon = factory.equipWeapon(); // HumanWeapon
wearAmmor.wearAmmor();
equipWeapon.equipWepon();

System.out.println("-------------------------------------");

// 2) 팩토리만 교체 -> 제품군 전체가 오크로 일관되게 변경
factory = new OrcFactory();
wearAmmor = factory.wearAmmor();     // OrcAmmor
equipWeapon = factory.equipWeapon(); // OrcWeapon
wearAmmor.wearAmmor();
equipWeapon.equipWepon();
```

### 예상 출력

```
인간은 판금 갑옷을 입었습니다.
인간은 한손검을 장착 했습니다.
-------------------------------------
오크는 가죽 갑옷을 입었습니다.
오크는 대형도끼를 장착 했습니다.
```

`factory` 변수에 대입하는 구체 팩토리만 바뀌었을 뿐인데,
갑옷과 무기가 종족별로 짝을 이루어 일관되게 생성되는 것을 확인할 수 있다.

## 참고

- 이 폴더의 이름은 `abstractMethod`이지만, 실제 구현 내용은
  **추상 팩토리 패턴(Abstract Factory Pattern)** 이다. (팩토리 메서드 패턴이 아니다.)
  폴더명과 패턴명이 다르므로 학습 시 혼동에 주의한다.
- 예제 소스의 오타(`Ammor`, `HumanFacory`, `equipWepon`)는 원본 보존을 위해 유지되었다.
