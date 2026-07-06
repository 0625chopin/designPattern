package creationPatterns.abstractMethod.character.factory;

import creationPatterns.abstractMethod.character.product.ammor.Ammor;
import creationPatterns.abstractMethod.character.product.ammor.OrcAmmor;
import creationPatterns.abstractMethod.character.product.weapon.OrcWeapon;
import creationPatterns.abstractMethod.character.product.weapon.Weapon;

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
