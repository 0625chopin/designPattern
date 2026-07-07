package structuralPattrens.bridge;

// [브릿지 패턴 - Implementor(구현자) 역할]
// CPU와는 별개의 또 다른 구현 계층 인터페이스.
// 구현 계층을 여러 축(Cpu, Ram)으로 나눠 각각 독립적으로 확장할 수 있음을 보여준다.
public interface Ram {
    void load();
}
