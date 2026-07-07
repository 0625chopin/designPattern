package structuralPattrens.bridge;

// [브릿지 패턴 - Client(사용 예)]
// 추상화(메인보드)와 구현(CPU/RAM)을 런타임에 원하는 대로 조합한다.
// 새로운 메인보드/CPU/RAM이 추가돼도 이 조립 부분만 바꾸면 되고,
// 각 계층의 클래스는 서로 수정할 필요가 없다.
public class Main {
    static void main() {
        // 기가바이트 메인보드 + 인텔 CPU + 삼성 RAM 조합
        MotherBoard mb = new GigabyteMotherBoard(new IntelCup(), new SamsungRam());
        mb.boot();
    }
}
