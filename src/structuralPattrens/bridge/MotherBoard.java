package structuralPattrens.bridge;

// [브릿지 패턴 - Abstraction(추상화) 역할]
// 브릿지 패턴은 "추상화(기능 계층)"와 "구현(구현 계층)"을 분리하여
// 두 계층을 독립적으로 확장할 수 있게 하는 구조 패턴이다.
//
// MotherBoard는 추상화 계층으로, 구현체(Cpu, Ram)를 직접 상속하지 않고
// 필드로 참조(합성)하여 연결한다. 이 참조가 바로 두 계층을 잇는 "다리(Bridge)"다.
// 덕분에 메인보드 종류가 늘어나도, CPU/RAM 제조사가 늘어나도
// 서로에게 영향을 주지 않고 각각 독립적으로 확장할 수 있다.
// (상속으로 조합하면 메인보드 x CPU x RAM 만큼 클래스가 폭증하지만,
//  합성으로 연결하면 조합을 런타임에 자유롭게 구성할 수 있다.)
abstract class MotherBoard {
    protected Cpu cpu;  // 구현 계층에 대한 참조 (브릿지)
    protected Ram ram;  // 구현 계층에 대한 참조 (브릿지)

    public MotherBoard(Cpu cpu, Ram ram) {
        this.cpu = cpu;  // cpu 장착
        this.ram = ram;  // ram 장착
    }

    // 상위 수준 기능(부팅)은 구현 계층의 세부 동작에 위임한다.
    public void boot(){
        System.out.println("부팅 시작!");
        ram.load();      // 실제 동작은 주입된 Ram 구현체가 수행
        cpu.execute();   // 실제 동작은 주입된 Cpu 구현체가 수행
    }
}
