# 디자인 패턴 (Design Patterns)

Java로 GoF 디자인 패턴을 학습하며 정리한 예제 모음이다.
각 패턴은 실행 가능한 예제 코드와 함께 역할 주석 및 설명 문서(README)로 정리되어 있다.

디자인 패턴은 목적에 따라 **생성 / 구조 / 행위** 세 가지로 분류된다.

## 패턴 분류

### 생성 패턴 (Creational Patterns)
객체의 생성 과정을 캡슐화하여 유연하게 만드는 패턴.

| 패턴 | 경로 |
|------|------|
| 싱글턴 (Singleton) | [`src/creationPatterns/singleton`](./src/creationPatterns/singleton) |
| 팩토리 메서드 (Factory Method) | [`src/creationPatterns/factoryMethod`](./src/creationPatterns/factoryMethod) |
| 추상 팩토리 (Abstract Factory) | [`src/creationPatterns/abstractMethod`](./src/creationPatterns/abstractMethod) |
| 빌더 (Builder) | [`src/creationPatterns/builder`](./src/creationPatterns/builder) |
| 프로토타입 (Prototype) | [`src/creationPatterns/prototype`](./src/creationPatterns/prototype) |

### 구조 패턴 (Structural Patterns)
클래스와 객체를 조합해 더 큰 구조를 만드는 패턴. **→ [상세 목록 문서](./src/structuralPattrens/README.md)**

| 패턴 | 경로 |
|------|------|
| 어댑터 (Adapter) | [`src/structuralPattrens/adaptor`](./src/structuralPattrens/adaptor/README.md) |
| 브릿지 (Bridge) | [`src/structuralPattrens/bridge`](./src/structuralPattrens/bridge/README.md) |
| 컴포지트 (Composite) | [`src/structuralPattrens/composite`](./src/structuralPattrens/composite/README.md) |
| 데코레이터 (Decorator) | [`src/structuralPattrens/decorator`](./src/structuralPattrens/decorator/README.md) |
| 파사드 (Facade) | [`src/structuralPattrens/facade`](./src/structuralPattrens/facade/README.md) |
| 플라이웨이트 (Flyweight) | [`src/structuralPattrens/flyweight`](./src/structuralPattrens/flyweight/README.md) |
| 프록시 (Proxy) | [`src/structuralPattrens/proxy`](./src/structuralPattrens/proxy/README.md) |

### 행위 패턴 (Behavioral Patterns)
객체 간의 책임 분배와 상호작용(알고리즘, 흐름)을 다루는 패턴.

| 패턴 | 경로 |
|------|------|
| 커맨드 (Command) | [`src/behavioralPatterns/command`](./src/behavioralPatterns/command) |
| 인터프리터 (Interpreter) | [`src/behavioralPatterns/interpreter`](./src/behavioralPatterns/interpreter) |
| 이터레이터 (Iterator) | [`src/behavioralPatterns/iterator`](./src/behavioralPatterns/iterator) |
| 중재자 (Mediator) | [`src/behavioralPatterns/mediator`](./src/behavioralPatterns/mediator) |
| 메멘토 (Memento) | [`src/behavioralPatterns/memento`](./src/behavioralPatterns/memento) |
| 옵서버 (Observer) | [`src/behavioralPatterns/observer`](./src/behavioralPatterns/observer) |
| 상태 (State) | [`src/behavioralPatterns/state`](./src/behavioralPatterns/state) |
| 전략 (Strategy) | [`src/behavioralPatterns/strategy`](./src/behavioralPatterns/strategy) |
| 템플릿 메서드 (Template Method) | [`src/behavioralPatterns/templateMethod`](./src/behavioralPatterns/templateMethod) |
| 방문자 (Visitor) | [`src/behavioralPatterns/visitor`](./src/behavioralPatterns/visitor) |

## 진행 현황
- ✅ **구조 패턴**: 7개 패턴 모두 역할 주석 및 README 정리 완료
- ⏳ 생성 패턴 / 행위 패턴: 예제 작성 및 문서화 진행 중
