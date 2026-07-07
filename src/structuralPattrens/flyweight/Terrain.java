package structuralPattrens.flyweight;

// [플라이웨이트 패턴 - Client(사용 예)]
// 몬스터를 렌더링할 때 무거운 모델은 팩토리에서 공유본을 가져오고,
// 좌표 같은 개별 데이터만 새로 부여해 몬스터를 생성한다.
// 같은 타입의 몬스터를 여러 개 만들어도 모델 객체는 하나만 공유된다.
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
