package structuralPattrens.adaptor.type2;

// [어댑터 패턴 - Adapter(변환기) 역할]
// Target(Car)을 구현하면서 내부에 Adaptee(MotorCycle)를 참조(합성)한다.
// Car 인터페이스 호출을 MotorCycle 호출로 변환하여 기존 시스템을 새 시스템처럼 쓰게 한다.
// set 호출 시 실제 Legacy 객체의 상태도 함께 바뀌는 것이 이 합성 구조의 특징이다.
public class AdaptorMove implements Car {

    // 변환 대상인 기존 시스템(Adaptee)
    private MotorCycle legacy;

    public AdaptorMove(MotorCycle legacy) {
        this.legacy = legacy;
    }

    @Override
    public String getCarModelNo() {
        return legacy.getModelNo();
    }

    @Override
    public String getCarModelNm() {
        return legacy.getModelNm();
    }

    @Override
    public void setCarModelNo(String modelNo) {
        this.legacy.setModelNo(modelNo);
    }

    @Override
    public void setCarModelNm(String modelNm) {
        this.legacy.setModelNm(modelNm);
    }

}
