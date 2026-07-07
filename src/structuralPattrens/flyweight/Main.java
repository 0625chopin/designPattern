package structuralPattrens.flyweight;

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
