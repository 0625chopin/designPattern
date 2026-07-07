# 프록시 패턴 (Proxy Pattern)

## 개요
프록시 패턴은 실제 객체를 **대신하는 대리자(Proxy)** 를 두어,
실제 객체에 대한 **접근을 제어**하는 구조(Structural) 패턴이다.

클라이언트는 프록시를 실제 객체처럼 사용하고, 프록시는 요청을 실제 객체에 위임하기 전후로
지연 생성·접근 제어·캐싱·로깅 같은 부가 작업을 수행할 수 있다.

## 프록시의 종류
- **가상 프록시(Virtual Proxy)**: 생성 비용이 큰 객체의 **생성을 실제 필요 시점까지 지연** ← [`virtual`](./virtual) 예제
- **보호 프록시(Protection Proxy)**: 접근 권한을 검사해 접근 제어 ← [`protection`](./protection) 예제
- **원격 프록시(Remote Proxy)**: 다른 주소 공간(원격)의 객체를 대신 표현
- **캐싱 프록시(Caching Proxy)**: 결과를 캐싱해 재사용

---

# 예제 1 — 가상 프록시 (Virtual Proxy) · [`virtual`](./virtual)

## 왜 사용하는가 (가상 프록시)
- 실제 객체 생성 비용이 크다면(예: 로그인 확인에 시간이 걸림), 매번 미리 만들면 낭비다.
- 프록시를 대신 만들어 두고, **실제로 사용할 때만 진짜 객체를 생성**하면 비용을 아낀다.

## 구성 요소 (역할)

| 역할 | 클래스 | 설명 |
|------|--------|------|
| **Subject** (공통 인터페이스) | `ILogin` | 실제 객체와 프록시가 함께 구현하는 타입. 클라이언트는 이 타입만 사용 |
| **RealSubject** (실제 객체) | `LoginProcess` | 프록시가 감싸는 진짜 대상. 생성 비용이 큰 무거운 객체 |
| **Proxy** (대리자) | `LoginProxy` | Subject를 구현해 실제 객체를 대신하고, 필요 시점에 생성·위임 |
| **Client** (사용 예) | `Main` | 프록시를 실제 객체처럼 사용 |

## 구조

```
   Client ──▶ ILogin (Subject)
                 △
        ┌────────┴────────┐
   LoginProxy ───────▶ LoginProcess
    (Proxy)             (RealSubject)
   필요 시점에 생성·위임    무거운 실제 객체
```

## 핵심 포인트
- `LoginProxy`는 생성 시 무거운 `LoginProcess`를 만들지 않고 **필요한 정보만 보관**한다.
- `loginComplete()`가 **실제로 호출될 때** 비로소 `LoginProcess`를 생성한다. (지연 초기화)
- 프록시와 실제 객체가 **같은 인터페이스(`ILogin`)** 를 구현하므로,
  클라이언트는 둘을 구분하지 않고 동일하게 사용한다.

## 실행 흐름 예시
```java
ILogin login1 = new LoginProxy("user1");
ILogin login2 = new LoginProxy("user2");  // 프록시만 생성 (실제 객체 X)
ILogin login3 = new LoginProxy("user3");  // 프록시만 생성 (실제 객체 X)
login1.loginComplete();                   // 이때만 실제 LoginProcess 생성
```
```
로그인 회원 확인중.
로그인 성공
로그인이 완료 되었습니다.
```
- `login1`만 호출했으므로 **실제 객체(`LoginProcess`)는 한 번만 생성**된다.
- `login2`, `login3`는 프록시만 존재하고 호출되지 않아 **무거운 생성 비용이 발생하지 않는다.**

---

# 예제 2 — 보호 프록시 (Protection Proxy) · [`protection`](./protection)

## 왜 사용하는가 (보호 프록시)
- 실제 객체에 접근하기 전에 **권한을 검사**해, 자격이 없는 요청은 차단하고 싶다.
- 실제 객체(`Employee`)와 클라이언트 코드를 수정하지 않고, **접근 제어 책임을 프록시로 분리**한다.
- 예제: 회사 인사 정보를 조회할 때, **조회자의 직책(권한)에 따라 열람 범위를 제한**한다.

## 구성 요소 (역할)

| 역할 | 클래스 | 설명 |
|------|--------|------|
| **Subject** (공통 인터페이스) | `IEmployee` | 실제 객체와 프록시가 함께 구현하는 타입 |
| **RealSubject** (실제 객체) | `Employee` | 실제 인사 정보를 가진 대상. 권한 검사 없이 정보 반환 |
| **Proxy** (대리자) | `ProtectedEmployee` | 조회자의 직책을 검사해 권한이 있을 때만 실제 객체에 위임 |
| **Client** (사용 예) | `Main`, `PrintEmployeeInfo` | 실제 객체를 프록시로 감싸 사용 |
| (보조) | `RESPONSIBILITY` | 직책(권한 등급) 열거형: DIRECTOR > MANAGER > STAFF |

## 권한 규칙
- **상무(DIRECTOR)**: 과장·사원 등 모든 인사 정보 조회 가능
- **과장(MANAGER)**: 자신과 같거나 아래(과장·사원) 조회 가능, 상무 정보는 불가
- **사원(STAFF)**: 같은 사원 정보만 조회 가능, 과장·상무 정보는 불가

## 핵심 포인트
- `ProtectedEmployee`는 `getInfo()` 호출 시 **조회자(viewer)의 직책과 대상의 직책을 비교**해 접근을 제어한다.
- 실제 객체(`Employee`)는 접근 제어 로직을 전혀 갖지 않는다. **권한 검사 책임이 프록시로 분리**되어 있다.
- 기존 `Employee` 리스트를 수정하지 않고 **동적으로 프록시로 감싸** 접근 제어를 입힌다.

## 실행 흐름 예시
```java
// 실제 직원들을 보호 프록시로 감싼다
for (Employee e : employees) {
    protectedEmployees.add(new ProtectedEmployee((IEmployee) e));
}
// 조회자의 직책을 바꿔가며 같은 목록을 조회
new PrintEmployeeInfo(staff).printAllInfo(protectedEmployees);    // 사원 시점
new PrintEmployeeInfo(manager).printAllInfo(protectedEmployees);  // 과장 시점
new PrintEmployeeInfo(director).printAllInfo(protectedEmployees); // 상무 시점
```
같은 직원 목록이라도 **조회자의 직책에 따라 열람 가능한 정보가 달라진다.**
사원은 사원 정보만, 과장은 과장·사원까지, 상무는 전체를 볼 수 있고, 권한이 없으면
"다른 사람의 인사정보를 조회 할수 없습니다"가 출력된다.
