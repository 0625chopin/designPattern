package structuralPattrens.adaptor.type2;

// [어댑터 패턴 - Target(원하는 형태) 역할]
// 새 시스템이 사용하고자 하는 인터페이스. 클라이언트는 이 Car 타입만 사용한다.
public interface Car {
    String getCarModelNo();
    String getCarModelNm();

    void setCarModelNo(String modelNo);
    void setCarModelNm(String modelNm);
}
