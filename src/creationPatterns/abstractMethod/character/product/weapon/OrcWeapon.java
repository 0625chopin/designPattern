package creationPatterns.abstractMethod.character.product.weapon;

// [추상 팩토리 패턴 - 구체 제품 A(ConcreteProductA) 역할]
// 오크 무기 제품으로, AbstractProductA(Weapon)를 구현한 오크 계열 구체 제품이다.
public class OrcWeapon implements Weapon {
    @Override
    public void equipWepon() {
        System.out.println("오크는 대형도끼를 장착 했습니다.");
    }
}
