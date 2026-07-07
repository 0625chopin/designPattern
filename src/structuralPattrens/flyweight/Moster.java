package structuralPattrens.flyweight;

public class Moster {
    long objSize = 10; // 10MB

    // 위치변수
    double position_x;
    double position_y;

    // 몬스터 모델
    MosterModel mosterModel;

    public Moster(MosterModel mosterModel, double position_x, double position_y) {
        this.mosterModel = mosterModel;
        this.position_x = position_x;
        this.position_y = position_y;

        // 나무 객체를 생성 후 메모리 크기 증가.
        Memory.size += this.objSize;
    }
}
