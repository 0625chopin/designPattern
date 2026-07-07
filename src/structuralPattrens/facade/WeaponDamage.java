package structuralPattrens.facade;

// [파사드 패턴 - SubSystem(서브시스템) 역할]
// 무기별 데미지 계산을 담당하는 하위 기능. 파사드(HuntFacade)를 통해서만 사용된다.
public class WeaponDamage {
    public int damage(WeaponEnum weapon) {
        if(weapon.equals(WeaponEnum.dagger)) {
            return 10;
        }
        return 1;
    }
}
