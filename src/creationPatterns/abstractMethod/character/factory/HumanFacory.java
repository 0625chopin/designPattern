package creationPatterns.abstractMethod.character.factory;

import creationPatterns.abstractMethod.character.product.ammor.Ammor;
import creationPatterns.abstractMethod.character.product.ammor.HumanAmmor;
import creationPatterns.abstractMethod.character.product.weapon.HumanWeapon;
import creationPatterns.abstractMethod.character.product.weapon.Weapon;

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
