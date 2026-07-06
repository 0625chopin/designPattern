package creationPatterns.abstractMethod.character.client;

import creationPatterns.abstractMethod.character.factory.CharacterFactory;
import creationPatterns.abstractMethod.character.factory.HumanFacory;
import creationPatterns.abstractMethod.character.factory.OrcFactory;
import creationPatterns.abstractMethod.character.product.ammor.Ammor;
import creationPatterns.abstractMethod.character.product.weapon.Weapon;

/**
 * Abstract Factory Pattern은 서로 관련된 객체들의 집합(Product Family)을 생성하는 인터페이스를 제공하는 생성(Creational) 디자인 패턴
 *
 * "객체를 직접 new 하지 않고, 같은 계열의 객체들을 Factory를 통해 일관성 있게 생성하는 패턴"
 */
public class Main {
    static void main() {
        CharacterFactory factory;
        factory = new HumanFacory();

        Ammor wearAmmor = factory.wearAmmor();
        Weapon equipWeapon = factory.equipWeapon();
        wearAmmor.wearAmmor();
        equipWeapon.equipWepon();

        System.out.println("-------------------------------------");

        factory = new OrcFactory();
        wearAmmor = factory.wearAmmor();
        equipWeapon = factory.equipWeapon();
        wearAmmor.wearAmmor();
        equipWeapon.equipWepon();

    }
}
