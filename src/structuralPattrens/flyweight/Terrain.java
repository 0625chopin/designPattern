package structuralPattrens.flyweight;

public class Terrain {
    // 지형 크기
    static final int CANVAS_SIZE = 10000;

    // 몬스터 렌더링
    public void render(String monsterType, double position_x, double position_y) {
        // 1. 캐시 되어 있는 나무 모델 객체 가져오기
        MosterModel mosterModel = MosterModelFactory.getInstance(monsterType);

        // 2. 재사용한 몬스터 모델 객체와 변화 하는 속성인 좌표값으로 몬스터 생성.
        Moster moster = new Moster(mosterModel, position_x, position_y);
        System.out.println("x:" + moster.position_x + " y:" + moster.position_y + " 위치에 " + moster + " 몬스터 생성 완료");

    }

}
