# 컴포지트 패턴 (Composite Pattern)

## 개요
컴포지트 패턴은 **개별 객체(Leaf)** 와 **여러 객체를 담는 복합 객체(Composite)** 를
**동일한 인터페이스로 다룰 수 있게** 하는 구조(Structural) 패턴이다.

트리(계층) 구조를 표현하며, 클라이언트는 "잎"과 "가지"를 구분하지 않고
같은 방식으로 다룰 수 있다.

## 왜 사용하는가
- 개별 객체와 그룹을 **하나의 타입으로 일관되게 처리**할 수 있다.
- 트리 구조를 재귀적으로 순회하는 로직을 각 노드가 스스로 처리하므로,
  클라이언트 코드가 단순해진다.
- 학급 안에 학급이 들어가는 것처럼 **계층을 무한히 중첩**할 수 있다.

## 구성 요소 (역할)

| 역할 | 클래스 | 설명 |
|------|--------|------|
| **Component** (공통 인터페이스) | `StudentInfo` | Leaf와 Composite가 공통으로 구현하는 타입. 클라이언트는 이 타입만 알면 됨 |
| **Leaf** (잎 / 개별 객체) | `Student` | 더 이상 자식이 없는 말단 객체. 자기 값을 그대로 반환 |
| **Composite** (복합 객체) | `ClazzInfo` | 자식(`StudentInfo`) 목록을 가지며, 요청을 자식에게 재귀적으로 위임 |
| **Client** (사용 예) | `Main` | Leaf와 Composite를 구분 없이 동일하게 사용 |

## 구조

```
        StudentInfo (Component)
        - getName()
        - getMathScore()
        - getStudentCount()
              △
      ┌───────┴────────┐
   Student           ClazzInfo
   (Leaf)            (Composite)
                     └─ List<StudentInfo>  ← Student 또는 또 다른 ClazzInfo
```

## 핵심 포인트
- Leaf와 Composite가 **같은 인터페이스(`StudentInfo`)** 를 구현한다.
- `ClazzInfo`의 자식 목록은 `List<StudentInfo>` 타입이므로
  **학생(`Student`)뿐 아니라 또 다른 학급(`ClazzInfo`)도 담을 수 있다.**
- `getMathScore()`, `getStudentCount()`는 자식을 순회하며 호출하는데,
  자식이 `Student`면 자기 값을 반환하고 `ClazzInfo`면 다시 재귀 호출되어
  **트리 전체가 자연스럽게 재귀 집계**된다.

## 재귀 동작 예시
```
CLASS (Composite)
 ├─ A-CLASS (Composite)
 │   ├─ 원이(95)  ├─ 미나미(100)  ├─ 제나(85)  ├─ 리브(93)  └─ 메이(88)
 └─ B-CLASS (Composite)
     ├─ 장원영(95)  ├─ 카리나(100)  └─ 윈터(85)
```

- `A-CLASS.getMathScore()` → 95+100+85+93+88 = **461**
- `B-CLASS.getMathScore()` → 95+100+85 = **280**
- `CLASS.getMathScore()` → A-CLASS(461) + B-CLASS(280) = **741** (재귀 집계)
- `getStudentCount()`도 동일하게 재귀적으로 인원수를 합산 (Student는 1 반환)
- `getAverageScore()` = 전체 점수 합 / 전체 학생 수
