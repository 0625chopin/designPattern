package structuralPattrens.facade;

public class HuntFacade {

    private WeaponDamage weaponDamage = new WeaponDamage();
    private Attack attack = new Attack();

    public void executeAttack(WeaponEnum weapon) {
        int damage = weaponDamage.damage(weapon);
        if(!isValidDamage(damage)) return;
        attack.attack(damage);
    }

    private boolean isValidDamage(int damage) {
        return damage > 1;
    }
}
