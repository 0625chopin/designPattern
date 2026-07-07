package creationPatterns.builder;

// [빌더 패턴 - 클라이언트(Client) 역할, 진입점]
// Builder를 사용하는 사용자 코드이다. Pc.builder(1, 1)로 빌더를 얻은 뒤 필요한 선택값만
// 메서드 체이닝으로 설정하고 build()를 호출해 원하는 형태의 Pc 객체를 조립한다.
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
