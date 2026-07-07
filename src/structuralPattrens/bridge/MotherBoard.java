package structuralPattrens.bridge;


// 컬러       모양    그림 (모양 그리다 컬러)
// 메인보드   시피유 제조사 장착
abstract class MotherBoard {
    Cpu cpu;

    public MotherBoard(Cpu cpu) {
        this.cpu = cpu;  // cpu 장착
    }

    public void boot(){
        System.out.println("부팅 시작!");
        cpu.execute();
    }
}
