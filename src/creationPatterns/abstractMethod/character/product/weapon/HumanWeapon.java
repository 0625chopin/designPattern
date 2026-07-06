package creationPatterns.abstractMethod.character.product.weapon;

public class HumanWeapon implements Weapon {
    @Override
    public void equipWepon() {
        System.out.println("인간은 한손검을 장착 했습니다.");
    }
}
