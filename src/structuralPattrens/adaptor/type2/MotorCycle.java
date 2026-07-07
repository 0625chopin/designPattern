package structuralPattrens.adaptor.type2;

// [어댑터 패턴 - Adaptee(기존 시스템) 역할]
// 재사용하고 싶은 기존 인터페이스. Target(Car)과 형태가 달라 직접 사용할 수 없다.
public interface MotorCycle {

    String getModelNo();
    String getModelNm();

    void setModelNo(String modelNo);
    void setModelNm(String modelNm);
}
