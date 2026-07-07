package structuralPattrens.bridge;

public class SamsungRam implements Ram {
    @Override
    public void load() {
        System.out.println("SANSUNG RAM 체크");
    }
}
