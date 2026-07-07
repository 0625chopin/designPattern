package structuralPattrens.flyweight;

// [보조 클래스] 메모리 사용량 측정용 유틸.
// 플라이웨이트로 모델을 공유했을 때 메모리가 얼마나 절약되는지 확인하기 위한 것으로,
// 패턴의 정식 구성 요소는 아니다.
public class Memory {
    public static long size = 0; // 메모리 사용량

    public static void print() {
        System.out.println("총 메모리 사용량 : " + Memory.size + "MB");
    }
}
