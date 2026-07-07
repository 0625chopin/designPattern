package creationPatterns.builder;

// [빌더 패턴 - 제품(Product) 역할]
// 최종적으로 만들어지는 복잡한 객체이다. 모든 필드가 final이며 생성자는 private으로 감춰
// 오직 Builder를 통해서만 생성되도록 강제한다(불변 객체). 정적 진입점 builder(...)로 Builder를 반환한다.
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
    // [빌더 패턴 - 빌더(Builder) 역할]
    // 제품(Pc)의 생성 과정을 담당하는 정적 중첩 클래스이다. 필수값(pcOrderNo, pcNumber)은 생성자로 받고,
    // 선택값은 this를 반환하는 세터로 체이닝하여 설정한 뒤 build()로 최종 Pc 인스턴스를 조립해 반환한다.
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