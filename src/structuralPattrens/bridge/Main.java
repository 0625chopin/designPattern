package structuralPattrens.bridge;

public class Main {
    static void main() {
        MotherBoard mb = new GigabyteMotherBoard(new IntelCup());
        mb.boot();
    }
}
