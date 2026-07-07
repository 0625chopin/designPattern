package creationPatterns.singleton;

// [싱글턴 패턴 - Singleton(단일 인스턴스) 역할 / 정적 내부 클래스 Holder Idiom]
// 인스턴스 생성을 정적 내부 클래스(Holder)에 위임한 형태.
// Holder는 getInstance()가 처음 호출되어 참조되는 순간에만 JVM이 초기화하므로 지연 초기화(lazy)이고,
// 클래스 초기화 과정 자체를 JVM이 단 한 번만, 스레드 안전하게 보장하므로 별도 synchronized 없이 thread-safe 하다.
// 즉 v2와 달리 락 비용 없이 lazy + thread-safe 를 동시에 만족하는 권장 방식이다.
public class SingletonInstance_v3 {

    private static SingletonInstance_v3 singletonInstance;

    private SingletonInstance_v3() {
    }

    // Holder 클래스는 최초 접근 시 JVM에 의해 초기화된다.
    // JVM은 클래스 초기화 과정에서 자동으로 동기화를 보장하며
    // 초기화는 단 한 번만 수행된다. (클래스가 초기화 되는동안 다른 holder접근 스레드들은 lock 상태)
    private static class Holder {
        private static final SingletonInstance_v3 singletonInstance = new SingletonInstance_v3();
    }

    public static SingletonInstance_v3 getInstance() {
        return Holder.singletonInstance;
    }
}
