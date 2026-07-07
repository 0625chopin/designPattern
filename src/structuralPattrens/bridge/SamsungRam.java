package structuralPattrens.bridge;

// [브릿지 패턴 - ConcreteImplementor(구체적 구현자) 역할]
// Ram 구현 계층의 실제 구현체. load()의 세부 동작만 책임진다.
public class SamsungRam implements Ram {
    @Override
    public void load() {
        System.out.println("SANSUNG RAM 체크");
    }
}
