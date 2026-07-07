# 싱글턴 패턴 (Singleton Pattern)

> 📁 상위 문서: [생성 패턴 목록](../README.md)

## 개요
싱글턴 패턴은 어떤 클래스의 인스턴스가 **오직 하나만 생성되도록 보장**하고,
그 유일한 인스턴스에 대한 **전역 접근점(getInstance())** 을 제공하는 생성(Creational) 패턴이다.

생성자를 `private`으로 막아 외부에서 `new`로 만들 수 없게 하고,
클래스 내부에서 자신을 정적 필드로 보관하며 하나의 인스턴스만 반환한다.

이 예제는 하나의 싱글턴을 **thread-safety 관점에서 3단계(v1 → v2 → v3)** 로 발전시키며 비교한다.

## 왜 사용하는가
- 설정 정보, 로그, 커넥션 풀처럼 **애플리케이션 전체에서 하나만 있으면 되는 객체**의 중복 생성을 막는다.
- 인스턴스를 여러 번 만들 필요가 없어 **메모리·자원 낭비를 줄인다.**
- 전역 접근점을 통해 **어디서든 동일한 인스턴스를 공유**할 수 있다.
- 단, 멀티스레드 환경에서는 "정말 하나만" 만들어지도록 **생성 시점의 동기화**를 신경 써야 한다. (이 예제의 핵심 주제)

## 구성 요소 (역할)

| 역할 | 클래스 | 설명 |
|------|--------|------|
| **Singleton** (단일 인스턴스) | `SingletonInstance_v1`, `SingletonInstance_v2`, `SingletonInstance_v3` | 자신의 유일한 인스턴스를 정적 필드로 보관하고, `private` 생성자로 외부 생성을 막으며 `getInstance()`로만 제공한다. thread-safety 처리 방식만 다른 3가지 버전 |
| **Client** (사용 예) | `SingletonMain_v1`, `SingletonMain_v2`, `SingletonMain_v3` | 각 버전의 `getInstance()`를 호출해 항상 같은 인스턴스가 반환되는지 검증한다. v2·v3는 스레드 10개로 동시성까지 확인 |

## 버전별 비교

| 버전 | 방식 | 초기화 시점 | thread-safe | 특징 / 한계 |
|------|------|-------------|:-----------:|-------------|
| **v1** `SingletonInstance_v1` | 기본형 (lazy) | 최초 `getInstance()` 호출 시 | ❌ | 가장 단순하지만 동기화가 없다. 여러 스레드가 동시에 `null` 검사를 통과하면 인스턴스가 2개 이상 생성될 수 있다 |
| **v2** `SingletonInstance_v2` | `synchronized` 동기화형 | 최초 `getInstance()` 호출 시 | ✅ | 메서드 전체에 락을 걸어 중복 생성을 막는다. 그러나 인스턴스 생성 후에도 **매 호출마다 락 비용**이 발생한다 |
| **v3** `SingletonInstance_v3` | 정적 내부 클래스 **Holder Idiom** | 최초 `Holder` 참조 시 (lazy) | ✅ | JVM의 클래스 초기화가 단 한 번·스레드 안전하게 보장됨을 이용한다. **락 비용 없이 lazy + thread-safe**를 동시에 만족하는 권장 방식 |

### 핵심 차이 요약
- v1 → v2: **동기화를 추가**해 thread-safety 확보 (대신 성능 비용 발생)
- v2 → v3: **동기화 비용을 제거**하면서도 lazy + thread-safe 유지 (JVM 클래스 로딩 메커니즘 활용)

## 핵심 포인트
- 생성자를 `private`으로 만들어 외부의 `new` 생성을 원천 차단한다.
- 유일 인스턴스는 클래스 내부의 **정적 필드**로 보관한다.
- v3의 `Holder`는 `getInstance()`가 처음 호출되어 참조되는 순간에만 초기화되므로 **지연 초기화(lazy)** 이면서,
  클래스 초기화 자체를 JVM이 한 번만 보장하므로 **별도의 `synchronized` 없이 thread-safe**하다.
- "인스턴스가 같은지"는 출력된 **참조 주소(hashcode)** 가 모두 동일한지로 확인한다.

## 실행 흐름 예시

### v1 — 단일 스레드에서 동일 인스턴스 확인 (`SingletonMain_v1`)
```java
SingletonInstance_v1 instance1 = SingletonInstance_v1.getInstance();
SingletonInstance_v1 instance2 = SingletonInstance_v1.getInstance();
SingletonInstance_v1 instance3 = SingletonInstance_v1.getInstance();

System.out.println("instance1 = " + instance1);
System.out.println("instance2 = " + instance2);
System.out.println("instance3 = " + instance3);
```
```
instance1 = creationPatterns.singleton.SingletonInstance_v1@1b6d3586
instance2 = creationPatterns.singleton.SingletonInstance_v1@1b6d3586
instance3 = creationPatterns.singleton.SingletonInstance_v1@1b6d3586
```
세 참조 주소가 모두 같으므로 하나의 인스턴스만 공유됨을 확인할 수 있다. (단, 단일 스레드 기준)

### v2 · v3 — 스레드 10개로 동시성 확인 (`SingletonMain_v2`, `SingletonMain_v3`)
```java
for (int i = 0; i < 10; i++) {
    new Thread(() -> {
        SingletonInstance_v3 instance = SingletonInstance_v3.getInstance();
        System.out.println(instance);
    }).start();
}
```
```
creationPatterns.singleton.SingletonInstance_v3@6f2c410d
creationPatterns.singleton.SingletonInstance_v3@6f2c410d
creationPatterns.singleton.SingletonInstance_v3@6f2c410d
... (10개 스레드 모두 동일한 주소 출력)
```
10개의 스레드가 동시에 `getInstance()`를 호출해도 모두 같은 주소가 출력되면 thread-safe하게 하나만 생성된 것이다.
(출력 순서는 스레드 스케줄링에 따라 매번 달라질 수 있다.)
