package structuralPattrens.bridge;

// [브릿지 패턴 - ConcreteImplementor(구체적 구현자) 역할]
// Cpu 구현 계층의 실제 구현체. 상위 수준의 boot() 흐름과 무관하게
// execute()의 세부 동작만 책임진다.
public class IntelCup implements Cpu {
    @Override
    public void execute() {
        System.out.println("Integ Cpu 체크");
    }
}
