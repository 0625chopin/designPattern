package structuralPattrens.bridge;

// [브릿지 패턴 - Implementor(구현자) 역할]
// 구현 계층의 인터페이스. 추상화 계층(MotherBoard)은 이 인터페이스에만 의존하고,
// 실제 어떤 CPU가 장착되는지는 알지 못한다.
// 이 인터페이스를 구현하는 CPU 제조사를 자유롭게 늘릴 수 있다.
public interface Cpu {
    void execute();
}
