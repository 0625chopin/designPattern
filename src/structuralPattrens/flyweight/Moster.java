package structuralPattrens.flyweight;

// [플라이웨이트 패턴 - Context(비공유 객체) 역할]
// 공유되지 않고 객체마다 달라지는 데이터(외재적 상태, extrinsic state)를 가진다.
// 몬스터마다 좌표는 제각각이므로 공유할 수 없고, 무거운 공통 데이터는 MosterModel을 참조해 공유한다.
// 즉 '가벼운 개별 정보(좌표) + 무거운 공유 모델 참조' 조합으로 메모리를 절약한다.
public class Moster {
    long objSize = 10; // 10MB

    // --- 외재적 상태(extrinsic state): 몬스터마다 다른 개별 데이터 ---
    double position_x;
    double position_y;

    // 공유되는 무거운 모델(Flyweight)을 참조만 한다
    MosterModel mosterModel;

    public Moster(MosterModel mosterModel, double position_x, double position_y) {
        this.mosterModel = mosterModel;
        this.position_x = position_x;
        this.position_y = position_y;

        // 몬스터 객체를 생성 후 메모리 크기 증가.
        Memory.size += this.objSize;
    }
}
