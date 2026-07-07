package structuralPattrens.bridge;

public class IntelCup implements Cpu {
    @Override
    public void execute() {
        System.out.println("Integ Cpu 체크");
    }
}
