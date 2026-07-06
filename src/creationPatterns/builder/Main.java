package creationPatterns.builder;

public class Main {
    static void main() {

        Pc pc1 = Pc.builder(1, 1)
                .cpuBrand("INTEG")
                .cpuModel("I9")
                .ramBrand("Hynix")
                .ramModel("32G")
                .build();

        System.out.println(pc1);
    }
}
