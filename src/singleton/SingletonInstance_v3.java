package singleton;

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
