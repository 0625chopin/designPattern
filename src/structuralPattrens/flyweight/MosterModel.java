package structuralPattrens.flyweight;

// ConcreteFlyweight - 플라이웨이트 객체는 불변성을 가져야한다. 변경되면 모든 것에 영향을 주기 때문
// 상속 반지를 위해 final 클래스 생성
final class MosterModel {
    // 메시, 텟스처 총 사이즈
    long objSize = 30;  // 30MB

    String monsterType;  // 몬스터 타입
    Object mesh; // 메쉬
    Object texture; // 색상, 옷 무늬 등

    public MosterModel(String monsterType, Object mesh, Object texture) {
        this.monsterType = monsterType;
        this.mesh = mesh;
        this.texture = texture;

        // 나무 객체를 생성시 메모리 사용량 증가
        Memory.size = this.objSize;
    }
}
