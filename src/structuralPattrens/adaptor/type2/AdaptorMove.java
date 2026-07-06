package structuralPattrens.adaptor.type2;

public class AdaptorMove implements Car {

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
