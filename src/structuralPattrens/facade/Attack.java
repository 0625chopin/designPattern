package structuralPattrens.facade;

// [파사드 패턴 - SubSystem(서브시스템) 역할]
// 실제 공격 수행을 담당하는 하위 기능. 파사드(HuntFacade)를 통해서만 사용된다.
public class Attack {
    public void attack(int damage) {
        System.out.println(damage + " 의 데미지를 입혔습니다.");
    }
}
