package creationPatterns.abstractMethod.character.product.weapon;

// [추상 팩토리 패턴 - 구체 제품 A(ConcreteProductA) 역할]
// 인간 무기 제품으로, AbstractProductA(Weapon)를 구현한 인간 계열 구체 제품이다.
public class HumanWeapon implements Weapon {
    @Override
    public void equipWepon() {
        System.out.println("인간은 한손검을 장착 했습니다.");
    }
}
