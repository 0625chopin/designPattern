package creationPatterns.abstractMethod.character.factory;

import creationPatterns.abstractMethod.character.product.ammor.Ammor;
import creationPatterns.abstractMethod.character.product.ammor.OrcAmmor;
import creationPatterns.abstractMethod.character.product.weapon.OrcWeapon;
import creationPatterns.abstractMethod.character.product.weapon.Weapon;

// [추상 팩토리 패턴 - 구체 팩토리(ConcreteFactory) 역할]
// 오크 종족의 제품군(OrcAmmor + OrcWeapon)을 일관되게 생성한다.
// AbstractFactory(CharacterFactory)를 구현하여 오크 계열 객체만 반환한다.
public class OrcFactory implements CharacterFactory {
    @Override
    public Ammor wearAmmor() {
        return new OrcAmmor();
    }

    @Override
    public Weapon equipWeapon() {
        return new OrcWeapon();
    }
}
