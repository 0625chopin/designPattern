package structuralPattrens.adaptor.type2;

// [어댑터 패턴 - Concrete Adaptee(구체적 기존 시스템) 역할]
// Adaptee(MotorCycle)의 실제 구현체. 어댑터가 최종적으로 위임하는 실제 기존 객체다.
public class LegacyMove implements MotorCycle {

    private String modelNo;
    private String modelNm;


    @Override
    public String getModelNo() {
        return modelNo;
    }

    @Override
    public String getModelNm() {
        return modelNm;
    }

    @Override
    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    @Override
    public void setModelNm(String modelNm) {
        this.modelNm = modelNm;
    }

}
