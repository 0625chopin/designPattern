package creationPatterns.abstractMethod.character.factory;

import creationPatterns.abstractMethod.character.product.ammor.Ammor;
import creationPatterns.abstractMethod.character.product.ammor.HumanAmmor;
import creationPatterns.abstractMethod.character.product.weapon.HumanWeapon;
import creationPatterns.abstractMethod.character.product.weapon.Weapon;

// [추상 팩토리 패턴 - 구체 팩토리(ConcreteFactory) 역할]
// 인간 종족의 제품군(HumanAmmor + HumanWeapon)을 일관되게 생성한다.
// AbstractFactory(CharacterFactory)를 구현하여 인간 계열 객체만 반환한다.
public class HumanFacory implements CharacterFactory {
    @Override
    public Ammor wearAmmor() {
        return new HumanAmmor();
    }

    @Override
    public Weapon equipWeapon() {
        return new HumanWeapon();
    }
}
