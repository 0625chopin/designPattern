package creationPatterns.abstractMethod.character.product.ammor;

// [추상 팩토리 패턴 - 구체 제품 B(ConcreteProductB) 역할]
// 인간 갑옷 제품으로, AbstractProductB(Ammor)를 구현한 인간 계열 구체 제품이다.
public class HumanAmmor implements Ammor {
    @Override
    public void wearAmmor() {
        System.out.println("인간은 판금 갑옷을 입었습니다.");
    }
}
