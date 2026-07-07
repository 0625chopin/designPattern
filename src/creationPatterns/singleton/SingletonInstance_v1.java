package creationPatterns.singleton;

// [싱글턴 패턴 - Singleton(단일 인스턴스) 역할 / 기본형(lazy)]
// 유일한 인스턴스를 자기 자신이 보관하고 getInstance()로만 제공하는 가장 단순한 형태.
// 최초 호출 시점에 생성하는 지연 초기화(lazy)이지만 동기화가 없어 thread-safe 하지 않다.
// 여러 스레드가 동시에 null 검사를 통과하면 인스턴스가 2개 이상 생성될 수 있다는 한계가 있다.
public class SingletonInstance_v1 {

    // 유일 인스턴스를 담는 정적 필드 (동기화 미보장)
    public static SingletonInstance_v1 singletonInstance;

    // 외부 new 를 막기 위한 private 생성자
    private SingletonInstance_v1() {}

    // 최초 1회만 생성하려는 의도이나, 동시 접근 시 중복 생성 위험이 있다.
    public static SingletonInstance_v1 getInstance() {
        if(singletonInstance == null) {
            singletonInstance = new SingletonInstance_v1();
        }
        return singletonInstance;
    }
}
