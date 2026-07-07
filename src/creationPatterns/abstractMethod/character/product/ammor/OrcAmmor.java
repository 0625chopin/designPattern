package creationPatterns.abstractMethod.character.product.ammor;

// [추상 팩토리 패턴 - 구체 제품 B(ConcreteProductB) 역할]
// 오크 갑옷 제품으로, AbstractProductB(Ammor)를 구현한 오크 계열 구체 제품이다.
public class OrcAmmor implements Ammor {
    @Override
    public void wearAmmor() {
        System.out.println("오크는 가죽 갑옷을 입었습니다.");
    }
}
