package structuralPattrens.bridge;

// [브릿지 패턴 - RefinedAbstraction(구체적 추상화) 역할]
// 추상화 계층(MotherBoard)을 확장한 구체 클래스.
// 이런 메인보드 종류가 아무리 늘어나도 CPU/RAM 구현 계층과는 무관하게
// 추가할 수 있는 것이 브릿지 패턴의 핵심 장점이다.
public class GigabyteMotherBoard extends MotherBoard {
    public GigabyteMotherBoard(Cpu cpu, Ram ram) {
        super(cpu, ram);
    }
}
