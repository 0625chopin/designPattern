# 데코레이터 패턴 (Decorator Pattern)

## 개요
데코레이터 패턴은 원본 객체를 **장식자(Decorator)로 겹겹이 감싸서**
**기존 코드를 수정하지 않고 기능을 동적으로 추가**하는 구조(Structural) 패턴이다.

상속으로 기능을 확장하면 조합마다 새 클래스가 필요하지만,
데코레이터는 **런타임에 원하는 기능을 원하는 순서로 조합**할 수 있다.

## 왜 사용하는가
- 원본 객체(Login)와 기존 데코레이터 코드를 **수정하지 않고** 기능을 추가한다. (OCP 준수)
- 필요한 기능만 골라 **동적으로 조합**할 수 있다. (ID만, ID+비밀번호, ID+비밀번호+블랙리스트 …)
- 상속 조합의 클래스 폭증(`IdPwdCheck`, `IdPwdBlackListCheck` …)을 피한다.

## 구성 요소 (역할)

| 역할 | 클래스 | 설명 |
|------|--------|------|
| **Component** (공통 인터페이스) | `LoginProcess` | 원본과 장식자가 공통으로 구현하는 타입. 클라이언트는 이 타입만 사용 |
| **ConcreteComponent** (원본 객체) | `Login` | 장식의 대상이 되는 핵심 객체. 체인의 가장 안쪽에 위치 |
| **Decorator** (추상 장식자) | `LoginCheckAbstract` | Component를 구현하면서 다른 Component를 참조(감싸기)하고 위임 |
| **ConcreteDecorator** (구체적 장식자) | `IdCheck`, `PwdCheck`, `CheckBlackList` | 감싼 대상에 부가 기능(각종 체크)을 덧붙임 |
| **Client** (사용 예) | `Main` | 원본을 데코레이터로 겹겹이 감싸 기능을 조합 |

## 구조

```
        LoginProcess (Component)
        - validationCheck_and_login()
              △
      ┌───────┴──────────────┐
   Login              LoginCheckAbstract (Decorator)
 (ConcreteComponent)  - LoginProcess loginProcess  ← 다른 Component를 감쌈
                            △
          ┌─────────────────┼─────────────────┐
       IdCheck          PwdCheck          CheckBlackList
                    (ConcreteDecorator)
```

## 핵심 포인트
- `LoginCheckAbstract`가 **자기 타입(`LoginProcess`)을 필드로 참조**하기 때문에
  데코레이터를 여러 겹으로 중첩(체인)할 수 있다.
- 각 구체 데코레이터는 부가 기능을 실행한 뒤 `super.validationCheck_and_login()`으로
  **감싼 대상에게 동작을 위임**한다.
- **바깥쪽 데코레이터부터 실행**되고, 위임을 따라 안쪽으로 들어가 마지막에 원본이 실행된다.

## 실행 흐름 예시
```java
new IdCheck(new PwdCheck(new CheckBlackList(new Login())))
        .validationCheck_and_login();
```
```
사용자 ID 체크 성공          // IdCheck (가장 바깥)
사용자 비밀번호 체크 성공      // PwdCheck
사용자 블랙리스트 체크 성공    // CheckBlackList
로그인이 완료 되었습니다.      // Login (가장 안쪽 원본)
```
바깥쪽(`IdCheck`) → 안쪽(`Login`) 순으로 감싼 껍질을 차례로 통과하며 실행된다.
