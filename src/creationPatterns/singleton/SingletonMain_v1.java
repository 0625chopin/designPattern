package creationPatterns.singleton;

// [싱글턴 패턴 - Client(사용 예) / v1 기본형 검증]
// getInstance()를 여러 번 호출해도 같은 인스턴스가 반환되는지(참조 주소 동일) 확인한다.
// 단일 스레드에서는 정상 동작하지만 v1은 thread-safe 하지 않다는 점을 전제로 한 예제이다.
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
