package creationPatterns.abstractMethod.character.factory;

import creationPatterns.abstractMethod.character.product.ammor.Ammor;
import creationPatterns.abstractMethod.character.product.weapon.Weapon;

// [추상 팩토리 패턴 - 추상 팩토리(AbstractFactory) 역할]
// 서로 연관된 제품군(갑옷 + 무기)을 생성하는 인터페이스를 선언한다.
// 구체적인 종족(인간/오크)에 상관없이 클라이언트는 이 타입에만 의존한다.
public interface CharacterFactory {
    Ammor wearAmmor();
    Weapon equipWeapon();
}
