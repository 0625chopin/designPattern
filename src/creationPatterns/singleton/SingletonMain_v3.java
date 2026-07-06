package creationPatterns.singleton;

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
