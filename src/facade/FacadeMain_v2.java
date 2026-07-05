package facade;

/**
 * 파사드 패턴
 *
 * 파사드 등장 전에는
 * - 여러 서브시스템을 직접 호출해야 했음
 * - 호출 순서가 중요하고 중간 실패 처리도 직접 해야 했음
 * - 시스템 간 의존 관계가 복잡해짐
 * - 변경이 발생하면 클라이언트 코드까지 영향을 받음
 *
 * 이러한 문제를 해결하기 위해 파사드 패턴이 등장
 *
 * - 복잡한 서브시스템을 하나의 통합된 인터페이스로 감춤
 * - 클라이언트는 단순한 메서드 호출만으로 기능 사용 가능
 * - 내부 구조 변경이 외부에 영향을 덜 줌
 */
public class FacadeMain_v2 {
    static void main() {
        HuntFacade h = new HuntFacade();
        h.executeAttack(WeaponEnum.dagger);;
    }
}
