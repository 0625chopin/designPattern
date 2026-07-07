package structuralPattrens.decorator;

// [데코레이터 패턴 - Component(공통 인터페이스) 역할]
// 원본 객체(ConcreteComponent)와 장식자(Decorator)가 공통으로 구현하는 타입.
// 클라이언트는 이 타입만 알면 되고, 실제 객체가 몇 겹으로 장식됐는지 알 필요가 없다.
interface LoginProcess {
    void validationCheck_and_login();
}
