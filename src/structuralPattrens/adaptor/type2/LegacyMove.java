package structuralPattrens.adaptor.type2;

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
