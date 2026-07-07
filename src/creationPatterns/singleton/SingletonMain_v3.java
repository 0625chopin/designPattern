package creationPatterns.singleton;

// [싱글턴 패턴 - Client(사용 예) / v3 Holder 방식 동시성 검증]
// 스레드 10개를 동시에 띄워 getInstance()를 호출하고, 출력되는 인스턴스 주소가 모두 같은지 확인한다.
// 정적 내부 클래스 Holder 방식인 v3는 락 없이도 동시 호출에서 하나의 인스턴스만 반환됨을 보여준다.
/**
 * 싱글톤 패턴
 */
public class SingletonMain_v3 {
    static void main() {
        // Thread-safe 하지 않다.
        // getInstance() 에서 초기화 전에 두번째가 들어갈수도 있다.
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                SingletonInstance_v1 instance = SingletonInstance_v1.getInstance();
//                System.out.println(instance);
//            }).start();
//        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SingletonInstance_v3 instance = SingletonInstance_v3.getInstance();
                System.out.println(instance);
            }).start();
        }
    }
}
