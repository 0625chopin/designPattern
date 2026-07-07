package structuralPattrens.flyweight;

// [플라이웨이트 패턴 - Flyweight(공유 객체) 역할]
// 여러 객체가 공유하는 무거운 공통 데이터(내재적 상태, intrinsic state)를 담는다.
// 몬스터 타입/메쉬/텍스처처럼 같은 종류라면 어디서든 동일한 값이므로 하나만 만들어 공유한다.
// 공유되는 객체이므로 반드시 불변(immutable)이어야 한다. 변경되면 이를 공유하는 모든 몬스터에 영향을 주기 때문.
// (불변 보장을 위해 상속을 막는 final 클래스로 선언)
final class MosterModel {
    // 메쉬, 텍스처 총 사이즈
    long objSize = 30;  // 30MB

    // --- 내재적 상태(intrinsic state): 공유 가능한 불변 데이터 ---
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
