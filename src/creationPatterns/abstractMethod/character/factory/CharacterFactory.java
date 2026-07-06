package creationPatterns.abstractMethod.character.factory;

import creationPatterns.abstractMethod.character.product.ammor.Ammor;
import creationPatterns.abstractMethod.character.product.weapon.Weapon;

public interface CharacterFactory {
    Ammor wearAmmor();
    Weapon equipWeapon();
}
