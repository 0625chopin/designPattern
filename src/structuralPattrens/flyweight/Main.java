package structuralPattrens.flyweight;

// [플라이웨이트 패턴 - 실행 예]
// darkElf 10개 + orc 7개를 생성하지만, 모델 객체는 타입별로 하나씩(총 2개)만 만들어져 공유된다.
// 신규 생성 로그가 타입당 한 번씩만 찍히는 것과 총 메모리 사용량으로 절약 효과를 확인할 수 있다.
public class Main {
    static void main() {
        // 지형 생성
        Terrain terrain = new Terrain();

        // 지형에 darkElf 몬스터 7개 생성
        for(int i = 0; i < 10; i++) {
            terrain.render(
                    "darkElf",
                    Math.random() * Terrain.CANVAS_SIZE,
                    Math.random() * Terrain.CANVAS_SIZE
            );
        }

        // 지형에 orc 몬스터 7개 생성
        for(int i = 0; i < 7; i++) {
            terrain.render(
                    "orc",
                    Math.random() * Terrain.CANVAS_SIZE,
                    Math.random() * Terrain.CANVAS_SIZE
            );
        }

        // 총 메모리 사용률 출력
        Memory.print();
    }
}
