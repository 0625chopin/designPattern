package structuralPattrens.adaptor.type2;

/**
 *
 * ✔ Adapter(어댑터) 패턴이란?
 *  서로 호환되지 않는 인터페이스를 연결하여 기존 코드를 수정하지 않고 함께 사용할 수 있도록 하는 구조 패턴(Structural Pattern)이다.
 *
 * ✔ 새 프로그램만 사용하고 싶은데, 기존 프로그램을 재사용하고 싶다.
 *
 * ✔ 현재 상태
 *   MotorCycle만 사용하던 Legacy 시스템에
 *   MotorCycle을 재사용 해서 새로운 Car라는 시스템을 사용하고 싶다.
 *
 * ✔ 현재 역할
 *   Target → Car
 *   Adaptee → MotorCycle
 *   Concrete Adaptee → LegacyMove
 *   Adapter → AdaptorMove
 *   Client → MainMove
 */
public class MainMove {

    static void main() {
        MotorCycle legacy = new LegacyMove();
        legacy.setModelNo("A00000001");
        legacy.setModelNm("아우디");

        // 새로운 시스템은 Car만 사용
        Car car = new AdaptorMove(legacy);
        System.out.println(car.getCarModelNo());
        System.out.println(car.getCarModelNm());

        System.out.println("----------------");
        // Car 인터페이스로 수정
        car.setCarModelNm("BMW");

        // 실제 Legacy 객체도 함께 변경됨
        System.out.println(car.getCarModelNm());
        System.out.println(legacy.getModelNm());
    }
}
