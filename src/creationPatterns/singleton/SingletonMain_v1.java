package creationPatterns.singleton;

/**
 * 싱글톤 패턴
 * Thread-safe하지 않음.
 */
public class SingletonMain_v1 {
    static void main() {
        // private 생성으로 getInstance호출시 최초 1번만 생성된다.
        //SingletonInstance singletonInstance = new SingletonInstance();
        SingletonInstance_v1 instance1 = SingletonInstance_v1.getInstance();
        SingletonInstance_v1 instance2 = SingletonInstance_v1.getInstance();
        SingletonInstance_v1 instance3 = SingletonInstance_v1.getInstance();

        System.out.println("instance1 = " + instance1);
        System.out.println("instance2 = " + instance2);
        System.out.println("instance3 = " + instance3);

    }
}
