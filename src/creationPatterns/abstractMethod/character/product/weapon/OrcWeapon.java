package creationPatterns.abstractMethod.character.product.weapon;

public class OrcWeapon implements Weapon {
    @Override
    public void equipWepon() {
        System.out.println("오크는 대형도끼를 장착 했습니다.");
    }
}
