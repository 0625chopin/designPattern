package facade;

public class WeaponDamage {
    public int damage(WeaponEnum weapon) {
        if(weapon.equals(WeaponEnum.dagger)) {
            return 10;
        }
        return 1;
    }
}
