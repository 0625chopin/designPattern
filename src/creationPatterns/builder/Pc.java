package creationPatterns.builder;

public class Pc {

    private final int pcOrderNo;
    private final int pcNumber;

    private final String cpuBrand;
    private final String cpuModel;
    private final String ramBrand;
    private final String ramModel;

    private Pc(Builder builder) {
        this.pcOrderNo = builder.pcOrderNo;
        this.pcNumber = builder.pcNumber;
        this.cpuBrand = builder.cpuBrand;
        this.cpuModel = builder.cpuModel;
        this.ramBrand = builder.ramBrand;
        this.ramModel = builder.ramModel;
    }

    // ⭐ Builder 시작점
    public static Builder builder(int pcOrderNo, int pcNumber) {
        return new Builder(pcOrderNo, pcNumber);
    }

    // ===== Builder를 Pc 안에 넣음 =====
    public static class Builder {

        private final int pcOrderNo;
        private final int pcNumber;

        private String cpuBrand;
        private String cpuModel;
        private String ramBrand;
        private String ramModel;

        public Builder(int pcOrderNo, int pcNumber) {
            this.pcOrderNo = pcOrderNo;
            this.pcNumber = pcNumber;
        }

        public Builder cpuBrand(String cpuBrand) {
            this.cpuBrand = cpuBrand;
            return this;
        }

        public Builder cpuModel(String cpuModel) {
            this.cpuModel = cpuModel;
            return this;
        }

        public Builder ramBrand(String ramBrand) {
            this.ramBrand = ramBrand;
            return this;
        }

        public Builder ramModel(String ramModel) {
            this.ramModel = ramModel;
            return this;
        }

        public Pc build() {
            return new Pc(this);
        }
    }

    @Override
    public String toString() {
        return "Pc{" +
                "pcOrderNo=" + pcOrderNo +
                ", pcNumber=" + pcNumber +
                ", cpuBrand='" + cpuBrand + '\'' +
                ", cpuModel='" + cpuModel + '\'' +
                ", ramBrand='" + ramBrand + '\'' +
                ", ramModel='" + ramModel + '\'' +
                '}';
    }
}