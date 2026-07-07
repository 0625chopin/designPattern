package creationPatterns.singleton;

// [싱글턴 패턴 - Client(사용 예) / v2 동기화형 동시성 검증]
// 스레드 10개를 동시에 띄워 getInstance()를 호출하고, 출력되는 인스턴스 주소가 모두 같은지 확인한다.
// synchronized 로 동기화된 v2는 동시 호출에서도 항상 하나의 인스턴스만 반환됨을 보여준다.
/**
 * 싱글톤패턴
 */
public class SingletonMain_v2 {
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
                SingletonInstance_v2 instance = SingletonInstance_v2.getInstance();
                System.out.println(instance);
            }).start();
        }
    }
}
