package structuralPattrens.facade;

// [파사드 패턴 - Facade(통합 창구) 역할]
// 여러 서브시스템(WeaponDamage, Attack)을 내부에 감추고,
// 클라이언트에게는 executeAttack() 하나의 단순한 메서드만 노출한다.
// 데미지 계산 -> 유효성 검사 -> 공격이라는 복잡한 호출 순서와 흐름을 파사드가 대신 처리한다.
public class HuntFacade {

    // 파사드가 조율하는 서브시스템들
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
